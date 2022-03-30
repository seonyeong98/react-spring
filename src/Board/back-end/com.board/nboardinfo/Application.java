package com.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync(proxyTargetClass = true)
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "")
@EntityScan(basePackages = "")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {

    public static void main(String[] args) {
        log.info("---Application Start---");
        SpringApplication.run(Application.class, args);
    }
}
