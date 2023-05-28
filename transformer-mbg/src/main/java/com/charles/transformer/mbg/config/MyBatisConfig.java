package com.charles.transformer.mbg.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author charles
 * @date 5/28/2023 8:43 PM
 */
@Configuration
@MapperScan("com.charles.transformer.mbg.mapper")
public class MyBatisConfig {
}
