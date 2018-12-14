package swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

//@WebAppConfiguration
//@EnableWebMvc
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "controller")
public class SwaggerConfig {

	@Bean
	public Docket api() throws IOException {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() throws IOException {
    	
		Properties properties=new Properties();
		properties.load(new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("swagger.properties"),"UTF-8")));
		String description = properties.getProperty("description");
		
        return new ApiInfoBuilder()
                .title("WebLab项目接口文档")
                .description(description)
                .version("v1")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build();
    }
}
