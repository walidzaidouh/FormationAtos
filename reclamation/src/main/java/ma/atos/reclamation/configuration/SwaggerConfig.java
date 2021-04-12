package ma.atos.reclamation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


/**
 * The Swagger Config.
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {


    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("reclamations-api")
                .apiInfo(apiInfo()).select().build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("RECLAMATIONS API")
                .description("Gestion des réclamations et des agences bancaires")
                .termsOfServiceUrl("http://javainuse.com").license("RECLAMATIONS APP")
                .licenseUrl("apimanagementAtos@gmail.com").version("1.0").build();

    }

}

