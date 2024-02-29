package com.mlinyun.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringBoot启动类
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
@EnableAsync
@EnableScheduling
public class InsuranceApplication {

    public static void main(String[] args) {
        System.out.println("健康护航保盾管理系统启动中......");
        SpringApplication.run(InsuranceApplication.class, args);
        System.out.println("健康护航保盾管理系统启动成功！正在运行......");
    }

}
