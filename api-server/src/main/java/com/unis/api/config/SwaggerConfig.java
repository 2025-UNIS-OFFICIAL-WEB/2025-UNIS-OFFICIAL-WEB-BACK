package com.unis.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "UNIS API 문서",
        description = "UNIS 공식 API 스펙입니다.",
        version = "v1.0"
    )
)
public class SwaggerConfig {

    @Bean
    public OpenAPI publicApiOpenAPI() {
        return new OpenAPI()
            .servers(List.of(new Server().url("https://api-unis.com")));
    }
}
