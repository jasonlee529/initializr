package io.spring.initializr.generator.spring.configuration;

import io.spring.initializr.generator.project.contributor.SingleResourceProjectContributor;

/**
 * @Title: Log4jdbcPropertiesContributor
 * @Description:
 * @author: libo
 * @date: 2021/3/3 14:45
 * @Version: 1.0
 */
public class Log4jdbcPropertiesContributor extends SingleResourceProjectContributor {
	public Log4jdbcPropertiesContributor() {
		this("classpath:configuration/log4jdbc.log4j2.properties");
	}

	public Log4jdbcPropertiesContributor(String resourcePattern) {
		super("src/main/resources/log4jdbc.log4j2.properties", resourcePattern);
	}
}
