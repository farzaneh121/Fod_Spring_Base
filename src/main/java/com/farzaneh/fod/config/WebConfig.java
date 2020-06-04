package com.farzaneh.fod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class WebConfig {

	@Bean
	public TilesConfigurer configTile() {
		final TilesConfigurer tileConfigurer = new TilesConfigurer();
		tileConfigurer.setCheckRefresh(true);
		tileConfigurer.setDefinitions("WEB-INF/jsps/tiles/tiles.xml");
		return tileConfigurer;
	}

	@Bean
	public TilesViewResolver viewResolver() {
		final TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		tilesViewResolver.setOrder(1);
		return tilesViewResolver;

	}

}
