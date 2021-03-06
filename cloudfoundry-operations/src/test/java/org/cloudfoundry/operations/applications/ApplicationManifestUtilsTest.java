/*
 * Copyright 2013-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.operations.applications;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.cloudfoundry.operations.applications.ApplicationHealthCheck.NONE;
import static org.cloudfoundry.operations.applications.ApplicationHealthCheck.PORT;

public final class ApplicationManifestUtilsTest {

    @Test
    public void read() throws IOException {
        List<ApplicationManifest> expected = Arrays.asList(
            ApplicationManifest.builder()
                .name("alpha-application-1")
                .buildpack("alpha-buildpack")
                .command("alpha-command")
                .disk(-1)
                .healthCheckHttpEndpoint("alpha-health-check-http-endpoint")
                .healthCheckType(NONE)
                .instances(-1)
                .memory(1)
                .noRoute(true)
                .path(Paths.get("/alpha-path"))
                .randomRoute(true)
                .route(Route.builder()
                    .route("alpha-route-1")
                    .build())
                .route(Route.builder()
                    .route("alpha-route-2")
                    .build())
                .stack("alpha-stack")
                .timeout(-1)
                .environmentVariable("ALPHA_KEY_1", "alpha-value-1")
                .environmentVariable("ALPHA_KEY_2", "alpha-value-2")
                .service("alpha-instance-1")
                .service("alpha-instance-2")
                .build(),
            ApplicationManifest.builder()
                .name("alpha-application-2")
                .buildpack("alpha-buildpack")
                .command("alpha-command")
                .disk(-1)
                .domain("alpha-domain")
                .domain("alpha-domains-1")
                .domain("alpha-domains-2")
                .healthCheckHttpEndpoint("alpha-health-check-http-endpoint")
                .healthCheckType(PORT)
                .host("alpha-host")
                .host("alpha-hosts-1")
                .host("alpha-hosts-2")
                .instances(-1)
                .memory(1024)
                .noHostname(true)
                .noRoute(true)
                .path(Paths.get("/alpha-path"))
                .randomRoute(true)
                .stack("alpha-stack")
                .timeout(-1)
                .environmentVariable("ALPHA_KEY_1", "alpha-value-1")
                .environmentVariable("ALPHA_KEY_2", "alpha-value-2")
                .service("alpha-instance-1")
                .service("alpha-instance-2")
                .build());

        List<ApplicationManifest> actual = ApplicationManifestUtils.read(new ClassPathResource("fixtures/manifest-alpha.yml").getFile().toPath());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void readCommon() throws IOException {
        List<ApplicationManifest> expected = Arrays.asList(
            ApplicationManifest.builder()
                .name("charlie-application-1")
                .buildpack("charlie-buildpack")
                .command("charlie-command")
                .disk(-1)
                .healthCheckHttpEndpoint("charlie-health-check-http-endpoint")
                .healthCheckType(NONE)
                .instances(-1)
                .memory(-1)
                .noRoute(true)
                .path(Paths.get("/charlie-path"))
                .randomRoute(true)
                .route(Route.builder()
                    .route("charlie-route-1")
                    .build())
                .route(Route.builder()
                    .route("charlie-route-2")
                    .build())
                .stack("charlie-stack")
                .timeout(-1)
                .environmentVariable("CHARLIE_KEY_1", "charlie-value-1")
                .environmentVariable("CHARLIE_KEY_2", "charlie-value-2")
                .service("charlie-instance-1")
                .service("charlie-instance-2")
                .build(),
            ApplicationManifest.builder()
                .name("charlie-application-2")
                .buildpack("alternate-buildpack")
                .command("alternate-command")
                .disk(-2)
                .healthCheckHttpEndpoint("alternate-health-check-http-endpoint")
                .healthCheckType(PORT)
                .instances(-2)
                .memory(-2)
                .noRoute(false)
                .path(Paths.get("/alternate-path"))
                .randomRoute(false)
                .route(Route.builder()
                    .route("charlie-route-1")
                    .build())
                .route(Route.builder()
                    .route("charlie-route-2")
                    .build())
                .route(Route.builder()
                    .route("alternate-route-1")
                    .build())
                .route(Route.builder()
                    .route("alternate-route-2")
                    .build())
                .stack("alternate-stack")
                .timeout(-2)
                .environmentVariable("CHARLIE_KEY_1", "charlie-value-1")
                .environmentVariable("CHARLIE_KEY_2", "charlie-value-2")
                .environmentVariable("ALTERNATE_KEY_1", "alternate-value-1")
                .environmentVariable("ALTERNATE_KEY_2", "alternate-value-2")
                .service("charlie-instance-1")
                .service("charlie-instance-2")
                .service("alternate-instance-1")
                .service("alternate-instance-2")
                .build());

        List<ApplicationManifest> actual = ApplicationManifestUtils.read(new ClassPathResource("fixtures/manifest-charlie.yml").getFile().toPath());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void readCommonAndInherit() throws IOException {
        List<ApplicationManifest> expected = Arrays.asList(
            ApplicationManifest.builder()
                .name("charlie-application-1")
                .buildpack("delta-buildpack")
                .command("delta-command")
                .disk(-3)
                .healthCheckHttpEndpoint("delta-health-check-http-endpoint")
                .healthCheckType(NONE)
                .instances(-3)
                .memory(-3)
                .noRoute(true)
                .path(Paths.get("/delta-path"))
                .randomRoute(true)
                .route(Route.builder()
                    .route("charlie-route-1")
                    .build())
                .route(Route.builder()
                    .route("charlie-route-2")
                    .build())
                .route(Route.builder()
                    .route("delta-route-1")
                    .build())
                .route(Route.builder()
                    .route("delta-route-2")
                    .build())
                .stack("delta-stack")
                .timeout(-3)
                .environmentVariable("CHARLIE_KEY_1", "charlie-value-1")
                .environmentVariable("CHARLIE_KEY_2", "charlie-value-2")
                .environmentVariable("DELTA_KEY_1", "delta-value-1")
                .environmentVariable("DELTA_KEY_2", "delta-value-2")
                .service("charlie-instance-1")
                .service("charlie-instance-2")
                .service("delta-instance-1")
                .service("delta-instance-2")
                .build(),
            ApplicationManifest.builder()
                .name("charlie-application-2")
                .buildpack("delta-buildpack")
                .command("delta-command")
                .disk(-3)
                .healthCheckHttpEndpoint("delta-health-check-http-endpoint")
                .healthCheckType(NONE)
                .instances(-3)
                .memory(-3)
                .noRoute(true)
                .path(Paths.get("/delta-path"))
                .randomRoute(true)
                .route(Route.builder()
                    .route("charlie-route-1")
                    .build())
                .route(Route.builder()
                    .route("charlie-route-2")
                    .build())
                .route(Route.builder()
                    .route("alternate-route-1")
                    .build())
                .route(Route.builder()
                    .route("alternate-route-2")
                    .build())
                .route(Route.builder()
                    .route("delta-route-1")
                    .build())
                .route(Route.builder()
                    .route("delta-route-2")
                    .build())
                .stack("delta-stack")
                .timeout(-3)
                .environmentVariable("CHARLIE_KEY_1", "charlie-value-1")
                .environmentVariable("CHARLIE_KEY_2", "charlie-value-2")
                .environmentVariable("ALTERNATE_KEY_1", "alternate-value-1")
                .environmentVariable("ALTERNATE_KEY_2", "alternate-value-2")
                .environmentVariable("DELTA_KEY_1", "delta-value-1")
                .environmentVariable("DELTA_KEY_2", "delta-value-2")
                .service("charlie-instance-1")
                .service("charlie-instance-2")
                .service("alternate-instance-1")
                .service("alternate-instance-2")
                .service("delta-instance-1")
                .service("delta-instance-2")
                .build());

        List<ApplicationManifest> actual = ApplicationManifestUtils.read(new ClassPathResource("fixtures/manifest-delta.yml").getFile().toPath());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void readInherit() throws IOException {
        List<ApplicationManifest> expected = Arrays.asList(
            ApplicationManifest.builder()
                .name("alpha-application-1")
                .buildpack("beta-buildpack")
                .command("beta-command")
                .disk(-2)
                .healthCheckHttpEndpoint("beta-health-check-http-endpoint")
                .healthCheckType(NONE)
                .instances(-2)
                .memory(2)
                .noRoute(false)
                .path(Paths.get("/beta-path"))
                .randomRoute(false)
                .route(Route.builder()
                    .route("alpha-route-1")
                    .build())
                .route(Route.builder()
                    .route("alpha-route-2")
                    .build())
                .route(Route.builder()
                    .route("beta-route-1")
                    .build())
                .route(Route.builder()
                    .route("beta-route-2")
                    .build())
                .stack("beta-stack")
                .timeout(-2)
                .environmentVariable("ALPHA_KEY_1", "alpha-value-1")
                .environmentVariable("ALPHA_KEY_2", "alpha-value-2")
                .environmentVariable("BETA_KEY_1", "beta-value-1")
                .environmentVariable("BETA_KEY_2", "beta-value-2")
                .service("alpha-instance-1")
                .service("alpha-instance-2")
                .service("beta-instance-1")
                .service("beta-instance-2")
                .build(),
            ApplicationManifest.builder()
                .name("alpha-application-2")
                .buildpack("alpha-buildpack")
                .command("alpha-command")
                .disk(-1)
                .domain("alpha-domain")
                .domain("alpha-domains-1")
                .domain("alpha-domains-2")
                .healthCheckHttpEndpoint("alpha-health-check-http-endpoint")
                .healthCheckType(PORT)
                .host("alpha-host")
                .host("alpha-hosts-1")
                .host("alpha-hosts-2")
                .instances(-1)
                .memory(1024)
                .noHostname(true)
                .noRoute(true)
                .path(Paths.get("/alpha-path"))
                .randomRoute(true)
                .stack("alpha-stack")
                .timeout(-1)
                .environmentVariable("ALPHA_KEY_1", "alpha-value-1")
                .environmentVariable("ALPHA_KEY_2", "alpha-value-2")
                .service("alpha-instance-1")
                .service("alpha-instance-2")
                .build(),
            ApplicationManifest.builder()
                .name("beta-application-1")
                .buildpack("beta-buildpack")
                .command("beta-command")
                .disk(-1)
                .healthCheckHttpEndpoint("beta-health-check-http-endpoint")
                .healthCheckType(NONE)
                .instances(-1)
                .memory(2048)
                .noRoute(true)
                .path(Paths.get("/beta-path"))
                .randomRoute(true)
                .route(Route.builder()
                    .route("beta-route-1")
                    .build())
                .route(Route.builder()
                    .route("beta-route-2")
                    .build())
                .stack("beta-stack")
                .timeout(-1)
                .environmentVariable("BETA_KEY_1", "beta-value-1")
                .environmentVariable("BETA_KEY_2", "beta-value-2")
                .service("beta-instance-1")
                .service("beta-instance-2")
                .build(),
            ApplicationManifest.builder()
                .name("beta-application-2")
                .buildpack("beta-buildpack")
                .command("beta-command")
                .disk(-1)
                .domain("beta-domain")
                .domain("beta-domains-1")
                .domain("beta-domains-2")
                .healthCheckHttpEndpoint("beta-health-check-http-endpoint")
                .healthCheckType(NONE)
                .host("beta-host")
                .host("beta-hosts-1")
                .host("beta-hosts-2")
                .instances(-1)
                .memory(2)
                .noHostname(true)
                .noRoute(true)
                .path(Paths.get("/beta-path"))
                .randomRoute(true)
                .stack("beta-stack")
                .timeout(-1)
                .environmentVariable("BETA_KEY_1", "beta-value-1")
                .environmentVariable("BETA_KEY_2", "beta-value-2")
                .service("beta-instance-1")
                .service("beta-instance-2")
                .build());

        List<ApplicationManifest> actual = ApplicationManifestUtils.read(new ClassPathResource("fixtures/manifest-beta.yml").getFile().toPath());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void write() throws IOException {
        Path out = Files.createTempFile("test-manifest-", ".yml");

        ApplicationManifestUtils.write(out, Arrays.asList(
            ApplicationManifest.builder()
                .name("alpha-application-1")
                .buildpack("alpha-buildpack")
                .command("alpha-command")
                .disk(-1)
                .healthCheckHttpEndpoint("alpha-health-check-http-endpoint")
                .healthCheckType(NONE)
                .instances(-1)
                .memory(-1)
                .noRoute(true)
                .randomRoute(true)
                .route(Route.builder()
                    .route("alpha-route-1")
                    .build())
                .route(Route.builder()
                    .route("alpha-route-2")
                    .build())
                .stack("alpha-stack")
                .timeout(-1)
                .environmentVariable("ALPHA_KEY_1", "alpha-value-1")
                .environmentVariable("ALPHA_KEY_2", "alpha-value-2")
                .service("alpha-instance-1")
                .service("alpha-instance-2")
                .build(),
            ApplicationManifest.builder()
                .name("alpha-application-2")
                .buildpack("alpha-buildpack")
                .command("alpha-command")
                .disk(-1)
                .domain("alpha-domain")
                .domain("alpha-domains-1")
                .domain("alpha-domains-2")
                .healthCheckHttpEndpoint("alpha-health-check-http-endpoint")
                .healthCheckType(PORT)
                .host("alpha-host")
                .host("alpha-hosts-1")
                .host("alpha-hosts-2")
                .instances(-1)
                .memory(-1)
                .noHostname(true)
                .noRoute(true)
                .randomRoute(true)
                .stack("alpha-stack")
                .timeout(-1)
                .environmentVariable("ALPHA_KEY_1", "alpha-value-1")
                .environmentVariable("ALPHA_KEY_2", "alpha-value-2")
                .service("alpha-instance-1")
                .service("alpha-instance-2")
                .build()));

        List<String> expected = Files.readAllLines(new ClassPathResource("fixtures/manifest-echo.yml").getFile().toPath());
        List<String> actual = Files.readAllLines(out);

        assertThat(actual).isEqualTo(expected);
    }

}
