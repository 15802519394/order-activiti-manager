package com;


import org.activiti.app.conf.ApplicationConfiguration;
import org.activiti.app.servlet.ApiDispatcherServletConfiguration;
import org.activiti.app.servlet.AppDispatcherServletConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.context.emery.EnableDiscoveryClient;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@EnableDiscoveryClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Import({ApplicationConfiguration.class})
@EnableJpaRepositories(basePackages = "com.zlst")
@EntityScan(basePackages = "com.zlst")
public class OrderActivitiManagerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OrderActivitiManagerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OrderActivitiManagerApplication.class);
	}

	/**
	 *  registry apiDispatchServlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean apiDisptcher() {
		DispatcherServlet api = new DispatcherServlet();
		api.setContextClass(AnnotationConfigWebApplicationContext.class);
		api.setContextConfigLocation(ApiDispatcherServletConfiguration.class.getName());
		ServletRegistrationBean registrationBean = new ServletRegistrationBean();
		registrationBean.setServlet(api);
		registrationBean.addUrlMappings("/api/*");
		registrationBean.setLoadOnStartup(1);
		registrationBean.setAsyncSupported(true);
		registrationBean.setName("api");

		return registrationBean;
	}

	/**
	 * registry appDispatchServlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean appDisptcher() {
		DispatcherServlet app = new DispatcherServlet();
		app.setContextClass(AnnotationConfigWebApplicationContext.class);
		app.setContextConfigLocation(AppDispatcherServletConfiguration.class.getName());
		ServletRegistrationBean registrationBean = new ServletRegistrationBean();
		registrationBean.setServlet(app);
		registrationBean.addUrlMappings("/app/*");
		registrationBean.setLoadOnStartup(1);
		registrationBean.setAsyncSupported(true);
		registrationBean.setName("app");

		return registrationBean;
	}

}
