package com.sugarzhangnotes.http.api.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;
/**
 * @author sugarzhangnotes
 * @date 2023/4/13  2:57 PM
 * @project 第三方saas api 管理平台
 * @Since 1.8
 */
@Configuration
public class SwaggerConfig {

    @Value("${swagger.enable:true}")
    private Boolean enable;

    @Bean
    public Docket createOpenApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .groupName("api平台")
                .select()
                .build().useDefaultResponseMessages(false).apiInfo(apiInfo())
                .protocols(newHashSet("https", "http"))
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }


    private ApiInfo apiInfo()
    {
        return new ApiInfo("接口文档",
                "接口文档",
                "1.0",
                "sugarzhangnotes@sensetim.com",
                new Contact("sugarzhangnotes@sensetim.com","sugarzhangnotes@sensetim.com","sugarzhangnotes@sensetim.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
    /**
     * 设置接口单独的授权信息
     */
    private List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(new ApiKey("BASE_TOKEN", "Authorization", "header"));
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(
                                Collections.singletonList(new SecurityReference("BASE_TOKEN",
                                        new AuthorizationScope[]{new AuthorizationScope("global", "")}
                                )))
                        .build()
        );
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return new LinkedHashSet<>();
    }
}