package org.ps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

/**
 * Web MVC configurations.
 * Created by vepa on 27/9/17.
 */
@Configuration
@EnableWebMvc
@ComponentScan
@EnableConfigurationProperties({ResourceProperties.class})
public class WebMvcConfig extends WebMvcConfigurerAdapter{

  @Autowired
  ResourceProperties resourceProperties = new ResourceProperties();

//  @Override
//  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/").setViewName("forward:/index.html");
//  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    Integer cachePeriod = resourceProperties.getCachePeriod();

    registry.addResourceHandler(
            "/**/*.css",
            "/**/*.html",
            "/**/*.js",
            "/**/*.json",
            "/**/*.bmp",
            "/**/*.jpeg",
            "/**/*.jpg",
            "/**/*.png",
            "/**/*.ttf",
            "/**/*.svg")
            .setCachePeriod(cachePeriod)
            .addResourceLocations("classpath:/static/");

    registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/index.html")
            .setCachePeriod(cachePeriod)
            .resourceChain(true)
            .addResolver(new PathResourceResolver() {
              @Override protected Resource getResource(String resourcePath, Resource location) throws IOException {
                return location.exists() && location.isReadable() ? location : null;
              }
            });
  }
}
