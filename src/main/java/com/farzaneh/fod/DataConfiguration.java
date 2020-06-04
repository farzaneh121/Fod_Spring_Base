package com.farzaneh.fod;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.farzaneh.fod.repository")
public class DataConfiguration {

}
