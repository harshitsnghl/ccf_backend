package com.harshit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.harshit.*" })
@EntityScan(basePackages = "com.harshit.entity")
public class CcfApplication  extends SpringBootServletInitializer {

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(CcfApplication.class);
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(CcfApplication.class, args);
	}

//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setAllowedOrigins(Collections.singletonList(SiteConstants.SITE_ROOT_FRONTEND));
//		corsConfiguration.setAllowedHeaders(List.of(
//				"Origins", "Accept-Control-Allow-Origin", "Content-Type",
//				"Accept", "Jwt-Token", "Authorization", "Origin, Accept",
//				"X-Requested-With", "Access-Control-Request-Method",
//				"Access-Control-Request-Headers"
//		));
//		corsConfiguration.setExposedHeaders(List.of(
//				"Origins", "Accept-Control-Allow-Origin", "Content-Type",
//				"Accept", "Jwt-Token", "Authorization", "Origin, Accept",
//				"X-Requested-With", "Access-Control-Request-Method",
//				"Access-Control-Request-Headers"
//		));
//		corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//		corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//		return new CorsFilter(corsConfigurationSource);
//	}

}
