package com.unis.admin.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("admin")
@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "UNIS 관리자 API 문서",
        description = "UNIS Admin 백엔드 API 스펙입니다.",
        version = "v1.0"
    ),
    servers = {
        @io.swagger.v3.oas.annotations.servers.Server(url = "https://admin-unis.com")
    }
)public class SwaggerConfig {

}
