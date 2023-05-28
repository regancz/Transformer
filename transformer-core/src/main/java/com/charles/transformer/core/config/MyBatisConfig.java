package com.charles.transformer.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author charles
 * @date 5/28/2023 9:15 PM
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.charles.transformer.mbg.mapper"})
public class MyBatisConfig {
}
