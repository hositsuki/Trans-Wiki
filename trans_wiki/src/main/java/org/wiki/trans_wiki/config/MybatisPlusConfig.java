package org.wiki.trans_wiki.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.wiki.trans_wiki.mapper")
public class MybatisPlusConfig {

}
