package com.liwncy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages = { "com.liwncy" })
@MapperScan(basePackages = {"com.liwncy.**.dao"})
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class LiwncyApplication  extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源处理
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations("/view/");
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/view/");

        super.addResourceHandlers(registry);
    }

    public static void main(String[] args) {
        SpringApplication.run(LiwncyApplication.class, args);
    }

}
