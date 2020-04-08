package ch.course223.helloworldIvo.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
@Import({BeanValidatorPluginsConfiguration.class})
public class SpringFoxConfig {

    // The actual docket on which swagger is initialized
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select().apis(RequestHandlerSelectors.basePackage("ch.noseryoung.uk")).paths(PathSelectors.any())
                .build().apiInfo(apiInfo());

    }

    // This method provides basic information for the automatically generated swagger documentation
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API documentation").description("API documentation")
                .termsOfServiceUrl("").contact(new Contact("Ivo Gurtner", "Kontakt", "ivo.gurtner@noseryoung.ch")).license("")
                .licenseUrl("").version("1.0").build();
    }

    // This method handles basic UI configurations
    @Bean
    public UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder.builder()
                .operationsSorter(OperationsSorter.METHOD)
                .build();
    }

    // This method reads in the hand-made file and creates the hand-made version of the swagger documentation
    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        return () -> {
            SwaggerResource wsResource = new SwaggerResource();
            wsResource.setName("Hand-Made");
            wsResource.setSwaggerVersion("2.0");
            wsResource.setLocation("/swagger.yaml");

            List<SwaggerResource> resources = defaultResourcesProvider.get();
            resources.add(wsResource);
            return resources;
        };
    }
}