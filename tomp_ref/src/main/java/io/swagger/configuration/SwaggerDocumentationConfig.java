package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-10T12:13:27.463Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.OAS_30).select().apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
				.build().directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class).apiInfo(apiInfo());
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfo("TOMP-API",
				"An API between MaaS providers and transport operators for booking trips and corresponding assets.\r\n"
						+ "<p>The documentation (examples, process flows and sequence diagrams) can be found at <a href=\"https://github.com/TOMP-WG/TOMP-API/\">github</a>.",
				"1.1.0", "", "", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html");
	}

	@Bean
	public OpenAPI configure() {
		return new OpenAPI().info(new Info().title("Transport Operator MaaS Provider API").description(
				"An API between MaaS providers and transport operators for booking trips and corresponding assets. <p>The documentation (examples, process flows and sequence diagrams) can be found at <a href=\"https://github.com/TOMP-WG/TOMP-API/\">github</a>.")
				.termsOfService("").version("1.1.0")
				.license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html")));
	}

}
