package io.spring.initializr.generator.spring.configuration;

import java.io.IOException;
import java.nio.file.Path;

import io.spring.initializr.generator.buildsystem.Build;
import io.spring.initializr.generator.project.contributor.SingleResourceProjectContributor;
import io.spring.initializr.generator.spring.build.BuildMetadataResolver;
import io.spring.initializr.metadata.InitializrMetadata;

/**
 * @Title: Sfl4jContributor
 * @Description:
 * @author: libo
 * @date: 2021/3/3 15:27
 * @Version: 1.0
 */
public class Sfl4jContributor extends SingleResourceProjectContributor {

	private final Build build;

	private final BuildMetadataResolver buildMetadataResolver;

	public Sfl4jContributor(Build build, InitializrMetadata metadata) {
		super("src/main/resources/logback-spring.xml", "classpath:configuration/logback-spring.xml");
		this.build = build;
		this.buildMetadataResolver = new BuildMetadataResolver(metadata);
	}

	@Override
	public void contribute(Path projectRoot) throws IOException {
		super.contribute(projectRoot);
	}
}
