package com.zzp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * message
 *
 * @author: zzp
 * @date: 2020/04/30/17:16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@Slf4j
public class Application {

    public static void main(String[] args) throws UnknownHostException {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Environment env = context.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        path = "/".equals(path) ? "" : path;
        log.info("Swagger UI: \thttp://" + ip + ":" + port + "/swagger-ui.html");
    }
}
