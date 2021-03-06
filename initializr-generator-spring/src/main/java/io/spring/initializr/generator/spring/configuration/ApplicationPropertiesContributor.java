/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.initializr.generator.spring.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import io.spring.initializr.generator.buildsystem.Build;
import io.spring.initializr.generator.project.contributor.SingleResourceProjectContributor;
import io.spring.initializr.generator.spring.build.BuildMetadataResolver;
import io.spring.initializr.metadata.InitializrMetadata;

import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

/**
 * A {@link SingleResourceProjectContributor} that contributes a
 * {@code application.properties} file to a project.
 *
 * @author Stephane Nicoll
 */
public class ApplicationPropertiesContributor extends SingleResourceProjectContributor {
	private final Build build;

	private final BuildMetadataResolver buildMetadataResolver;

	public ApplicationPropertiesContributor(Build build, InitializrMetadata metadata) {
		this("classpath:configuration/application.properties", build, metadata);
	}

	public ApplicationPropertiesContributor(String resourcePattern, Build build, InitializrMetadata metadata) {
		super("src/main/resources/application.properties", resourcePattern);
		this.build = build;
		this.buildMetadataResolver = new BuildMetadataResolver(metadata);
	}

	@Override
	public void contribute(Path projectRoot) throws IOException {
		String artifactId = this.build.getSettings().getArtifact();

		Path output = projectRoot.resolve(this.relativePath);
		if (!Files.exists(output)) {
			Files.createDirectories(output.getParent());
			Files.createFile(output);
		}
		Resource resource = this.resolver.getResource(this.resourcePattern);
		FileCopyUtils.copy(resource.getInputStream(), Files.newOutputStream(output, StandardOpenOption.APPEND));
	}
}
