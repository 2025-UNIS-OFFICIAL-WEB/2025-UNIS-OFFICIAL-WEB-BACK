package com.example.unis_web_server_back.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "UNIS 공식 웹사이트 API 문서",
        description = "UNIS 백엔드 API 스펙입니다.",
        version = "v1.0"
    )
)
public class SwaggerConfig {
}
