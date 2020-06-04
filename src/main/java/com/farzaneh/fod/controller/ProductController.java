package com.farzaneh.fod.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.farzaneh.fod.model.Product;
import com.farzaneh.fod.repository.CategoryRepository;
import com.farzaneh.fod.repository.ProductRepository;
import com.farzaneh.fod.service.ProcessException;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductRepository productRepository;
	private Product product;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	public ProductController(ProductRepository productRepository, Product product) {
		this.productRepository = productRepository;
		this.product = product;
	}

	@GetMapping("/showProduct")
	public String goProductPage(ModelMap modelMap) {
		modelMap.addAttribute("categoryList", categoryRepository.findAllCategory());
		modelMap.addAttribute("productList", productRepository.findAll());
		return "product/showProduct";
	}

	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable Long id, ModelMap modelMap, HttpSession session) throws ProcessException {
		if (session.getAttribute("member") == null) {
			throw new ProcessException("you must Login for adding a product to cart");
		}
		List<Product> productList = new ArrayList<>();
		Product selectedProduct = productRepository.findProductById(id)
				.orElseThrow(() -> new ProcessException("sorry, we can not find this product"));
		List<Product> sessionProductList = (List<Product>) session.getAttribute("cartsList");
		if (sessionProductList != null) {
			sessionProductList.add(selectedProduct);
			session.setAttribute("cartsList", sessionProductList);
		} else {
			productList.add(selectedProduct);
			session.setAttribute("cartsList", productList);
		}

		return "redirect:/product/showProduct";
	}

	@GetMapping("/shoppingCart")
	public String shoppingCart(ModelMap modelMap, HttpSession session) throws ProcessException {
		if (session.getAttribute("member") == null) {
			throw new ProcessException("you must Login for go to cart");
		}
		double sumCosts = 0;
		List<Product> cartproductList = (List<Product>) session.getAttribute("cartsList");
		if (cartproductList != null) {
			for (Product productItem : cartproductList) {
				sumCosts = productItem.getCostPrice() + sumCosts;
			}
		}
		modelMap.addAttribute("sumCost", sumCosts);
		modelMap.addAttribute("products", cartproductList);
		return "product/shoppingCart";
	}

	@GetMapping("/deleteFromCart/{id}")
	public String deleteFromCart(@PathVariable Long id, ModelMap modelMap, HttpSession session)
			throws ProcessException {
		Product selectedProduct = productRepository.findProductById(id)
				.orElseThrow(() -> new ProcessException("sorry, we can not find this product"));
		List<Product> cartproductList = (List<Product>) session.getAttribute("cartsList");
		cartproductList.remove(selectedProduct);
		session.setAttribute("cartsList", cartproductList);

		return "redirect:/product/shoppingCart";
	}

	@GetMapping("/search")
	public String searchProduct(String productName, Long categoryId, ModelMap modelMap) {
		List<Product> searchedProduct;
		if (productName != null && categoryId != null && !productName.trim().equals("")) {
			searchedProduct = productRepository.findBaseProductAndCategory(productName, categoryId);
		} else if ((productName == null || productName.trim().equals("")) && categoryId != null) {
			searchedProduct = productRepository.findBaseCategory(categoryId);
		} else if (productName != null && categoryId == null && !productName.trim().equals("")) {
			searchedProduct = productRepository.findByProductName(productName);
		} else {
			searchedProduct = productRepository.findAllProduct();
		}
		if (searchedProduct == null) {
			modelMap.addAttribute("message", "this serach has no result");
		}
		modelMap.addAttribute("productList", searchedProduct);
		modelMap.addAttribute("categoryList", categoryRepository.findAllCategory());
		return "product/showProduct";
	}

	@ExceptionHandler()
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ModelAndView exceptionController(HttpServletRequest req, Exception ex) {
		ModelAndView modelAndView = new ModelAndView("errorPage");
		modelAndView.addObject("exception", ex);
		modelAndView.addObject("url", req.getRequestURL());
		return modelAndView;
	}
}
