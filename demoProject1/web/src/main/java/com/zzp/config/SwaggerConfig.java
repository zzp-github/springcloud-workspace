package com.zzp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * message
 *
 * @author: zzp
 * @date: 2020/04/30/17:22
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger-open", havingValue = "true")
public class SwaggerConfig {
    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springcloud个人项目")
                .description("存放代码和工具")
                .termsOfServiceUrl("https://github.com/")
                .license("github")
                .licenseUrl("github地址")
                .version("1.0")
                .build();
    }

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzp.application.controller.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 字符串工具
     * @return
     */
    @Bean
    public Docket createStringApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("string")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzp.application.controller.string"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 数据库相关
     * @return
     */
    @Bean
    public Docket createDaoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzp.application.controller.api"))
                .paths(PathSelectors.any())
                .build();
    }
}
