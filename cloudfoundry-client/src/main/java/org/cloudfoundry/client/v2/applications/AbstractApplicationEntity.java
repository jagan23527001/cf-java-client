/*
 * Copyright 2013-2015 the original author or authors.
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

package org.cloudfoundry.client.v2.applications;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * The core entity response payload for Application resources
 *
 * <p><b>This class is NOT threadsafe.</b>
 * @param <E> the "self" type.  Used to ensure the appropriate type is returned from chainable APIs.
 */
public abstract class AbstractApplicationEntity<E extends AbstractApplicationEntity<E>> {

    private volatile String buildpack;

    private volatile String command;

    private volatile Boolean console;

    private volatile Boolean debug;

    private volatile String detectedBuildpack;

    private volatile String detectedStartCommand;

    private volatile Boolean diego;

    private volatile Integer diskQuota;

    private volatile Map<String, Object> dockerCredentialsJson; // can be redacted

    private volatile String dockerImage;

    private volatile Boolean enableSsh;

    private volatile Map<String, String> environmentJson;

    private volatile Integer healthCheckTimeout;

    private volatile String healthCheckType;

    private volatile Integer instances;

    private volatile Integer memory;

    private volatile String name;

    private volatile String packageState;

    private volatile String packageUpdatedAt;

    private volatile Boolean production;

    private volatile String spaceId; //guid

    private volatile String stackId; //guid

    private volatile String stagingFailedDescription;

    private volatile String stagingFailedReason;

    private volatile String stagingTaskId;

    private volatile String state;

    private volatile String version;

    /**
     * Returns the buildpack
     *
     * @return the buildpack
     */
    public String getBuildpack() {
        return buildpack;
    }

    /**
     * Configure the buildpack
     *
     * @param buildpack the buildpack
     * @return {@code this}
     */
    @JsonProperty("buildpack")
    public final E withBuildpack(String buildpack) {
        this.buildpack = buildpack;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the command
     *
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Configure the command
     *
     * @param command the command
     * @return {@code this}
     */
    @JsonProperty("command")
    public final E withCommand(String command) {
        this.command = command;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns whether to open the console port
     *
     * @return whether to open the console port
     */
    @Deprecated
    public Boolean getConsole() {
        return console;
    }

    /**
     * Configure whether to open the console port
     *
     * @param console whether to open the console port
     * @return {@code this}
     */
    @Deprecated
    @JsonProperty("console")
    public final E console(Boolean console) {
        this.console = console;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns whether to open the debug port
     *
     * @return whether to open the debug port
     */
    @Deprecated
    public Boolean getDebug() {
        return debug;
    }

    /**
     * Configure whether to open the debug port
     *
     * @param debug whether to open the debug port
     * @return {@code this}
     */
    @Deprecated
    @JsonProperty("debug")
    public final E debug(Boolean debug) {
        this.debug = debug;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the autodetected buildpack that staged the application
     *
     * @return the autodetected buildpack that staged the application
     */
    public String getDetectedBuildpack() {
        return detectedBuildpack;
    }

    /**
     * Configure the autodetected buildpack that staged the application
     *
     * @param detectedBuildpack the autodetected buildpack that staged the application
     * @return {@code this}
     */
    @JsonProperty("detected_buildpack")
    public final E withDetectedBuildpack(String detectedBuildpack) {
        this.detectedBuildpack = detectedBuildpack;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the command detected by the buildpack during staging
     *
     * @return the command detected by the buildpack during staging
     */
    public String getDetectedStartCommand() {
        return detectedStartCommand;
    }

    /**
     * Configure the command detected by the buildpack during staging
     *
     * @param detectedStartCommand the command detected by the buildpack during staging
     * @return {@code this}
     */
    @JsonProperty("detected_start_command")
    public final E withDetectedStartCommand(String detectedStartCommand) {
        this.detectedStartCommand = detectedStartCommand;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns whether to use diego to stage and to run when available
     *
     * @return whether to use diego to stage and to run when available
     */
    public Boolean getDiego() {
        return diego;
    }

    /**
     * Configure whether to use diego to stage and to run when available
     *
     * @param diego whether to use diego to stage and to run when available
     * @return {@code this}
     */
    @JsonProperty("diego")
    public final E diego(Boolean diego) {
        this.diego = diego;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the maximum amount of disk available to an instance of an application in megabytes
     *
     * @return the maximum amount of disk available to an instance of an application in megabytes
     */
    public Integer getDiskQuota() {
        return diskQuota;
    }

    /**
     * Configure the maximum amount of disk available to an instance of an application in megabytes
     *
     * @param diskQuota the maximum amount of disk available to an instance of an application in megabytes
     * @return {@code this}
     */
    @JsonProperty("disk_quota")
    public final E withDiskQuota(Integer diskQuota) {
        this.diskQuota = diskQuota;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the Docker credentials for pulling docker image
     *
     * @return the Docker credentials for pulling docker image
     */
    public Map<String, Object> getDockerCredentialsJson() {
        return dockerCredentialsJson;
    }

    /**
     * Configure the Docker credentials for pulling docker image
     *
     * @param dockerCredentialsJson the Docker credentials for pulling docker image
     * @return {@code this}
     */
    @JsonProperty("docker_credentials_json")
    public final E withDockerCredentialsJson(Map<String, Object> dockerCredentialsJson) {
        this.dockerCredentialsJson = dockerCredentialsJson;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the name of the Docker image containing the application
     *
     * @return the name of the Docker image containing the application
     */
    public String getDockerImage() {
        return dockerImage;
    }

    /**
     * Configure the name of the Docker image containing the application
     *
     * @param dockerImage the name of the Docker image containing the application
     * @return {@code this}
     */
    @JsonProperty("docker_image")
    public final E withDockerImage(String dockerImage) {
        this.dockerImage = dockerImage;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns whether to enable ssh
     *
     * @return whether to enable ssh
     */
    public Boolean getEnableSsh() {
        return enableSsh;
    }

    /**
     * Configure whether to enable ssh
     *
     * @param enableSsh whether to enable ssh
     * @return {@code this}
     */
    @JsonProperty("enable_ssh")
    public final E enableSsh(Boolean enableSsh) {
        this.enableSsh = enableSsh;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the application environment variables
     *
     * @return the application environment variables
     */
    public Map<String, String> getEnvironmentJson() {
        return environmentJson;
    }

    /**
     * Configure the application environment variables
     *
     * @param environmentJson the application environment variables
     * @return {@code this}
     */
    @JsonProperty("environment_json")
    public final E withEnvironmentJson(Map<String, String> environmentJson) {
        this.environmentJson = environmentJson;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the health check timeout
     *
     * @return the health check timeout
     */
    public Integer getHealthCheckTimeout() {
        return healthCheckTimeout;
    }

    /**
     * Configure the health check timeout
     *
     * @param healthCheckTimeout the health check timeout
     * @return {@code this}
     */
    @JsonProperty("health_check_timeout")
    public final E withHealthCheckTimeout(Integer healthCheckTimeout) {
        this.healthCheckTimeout = healthCheckTimeout;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the health check type
     *
     * @return the health check type
     */
    public String getHealthCheckType() {
        return healthCheckType;
    }

    /**
     * Configure health check type
     *
     * @param healthCheckType health check type
     * @return {@code this}
     */
    @JsonProperty("health_check_type")
    public final E withHealthCheckType(String healthCheckType) {
        this.healthCheckType = healthCheckType;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the number of instances
     *
     * @return the number of instances
     */
    public Integer getInstances() {
        return instances;
    }

    /**
     * Configure the number of instances
     *
     * @param instances the number of instances
     * @return {@code this}
     */
    @JsonProperty("instances")
    public final E withInstances(Integer instances) {
        this.instances = instances;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the memory allocated to each instance in megabytes
     *
     * @return the memory allocated to each instance in megabytes
     */
    public Integer getMemory() {
        return memory;
    }

    /**
     * Configure the memory allocated to each instance in megabytes
     *
     * @param memory the memory allocated to each instance in megabytes
     * @return {@code this}
     */
    @JsonProperty("memory")
    public final E withMemory(Integer memory) {
        this.memory = memory;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Configure the name
     *
     * @param name the name
     * @return {@code this}
     */
    @JsonProperty("name")
    public final E withName(String name) {
        this.name = name;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the current state of the package
     *
     * @return the current state of the package
     */
    public String getPackageState() {
        return packageState;
    }

    /**
     * Configure the current state of the package
     *
     * @param packageState the current state of the package
     * @return {@code this}
     */
    @JsonProperty("package_state")
    public final E withPackageState(String packageState) {
        this.packageState = packageState;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns the time package was last updated
     *
     * @return the time package was last updated
     */
    public String getPackageUpdatedAt() {
        return packageUpdatedAt;
    }

    /**
     * Configure the time package was last updated
     *
     * @param packageUpdatedAt the time package was last updated
     * @return {@code this}
     */
    @JsonProperty("package_updated_at")
    public final E withPackageUpdatedAt(String packageUpdatedAt) {
        this.packageUpdatedAt = packageUpdatedAt;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns whether production
     *
     * @return whether production
     */
    @Deprecated
    public Boolean getProduction() {
        return production;
    }

    /**
     * Configure whether production
     *
     * @param production whether production
     * @return {@code this}
     */
    @Deprecated
    @JsonProperty("production")
    public final E production(Boolean production) {
        this.production = production;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns space id
     *
     * @return space id
     */
    public String getSpaceId() {
        return spaceId;
    }

    /**
     * Configure space id
     *
     * @param spaceId space id
     * @return {@code this}
     */
    @JsonProperty("space_guid")
    public final E withSpaceId(String spaceId) {
        this.spaceId = spaceId;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns stack id
     *
     * @return stack id
     */
    public String getStackId() {
        return stackId;
    }

    /**
     * Configure stack id
     *
     * @param stackId stack id
     * @return {@code this}
     */
    @JsonProperty("stack_guid")
    public final E withStackId(String stackId) {
        this.stackId = stackId;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns staging failed description
     *
     * @return staging failed description
     */
    public String getStagingFailedDescription() {
        return stagingFailedDescription;
    }

    /**
     * Configure staging failed description
     *
     * @param stagingFailedDescription staging failed description
     * @return {@code this}
     */
    @JsonProperty("staging_failed_description")
    public final E withStagingFailedDescription(String stagingFailedDescription) {
        this.stagingFailedDescription = stagingFailedDescription;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns staging failed reason
     *
     * @return staging failed reason
     */
    public String getStagingFailedReason() {
        return stagingFailedReason;
    }

    /**
     * Configure staging failed reason
     *
     * @param stagingFailedReason staging failed reason
     * @return {@code this}
     */
    @JsonProperty("staging_failed_reason")
    public final E withStagingFailedReason(String stagingFailedReason) {
        this.stagingFailedReason = stagingFailedReason;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns staging task id
     *
     * @return staging task id
     */
    public String getStagingTaskId() {
        return stagingTaskId;
    }

    /**
     * Configure staging task id
     *
     * @param stagingTaskId staging task id
     * @return {@code this}
     */
    @JsonProperty("staging_task_id")
    public final E withStagingTaskId(String stagingTaskId) {
        this.stagingTaskId = stagingTaskId;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns state
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Configure state
     *
     * @param state state
     * @return {@code this}
     */
    @JsonProperty("state")
    public final E withState(String state) {
        this.state = state;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }

    /**
     * Returns version
     *
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Configure version
     *
     * @param version version
     * @return {@code this}
     */
    @JsonProperty("version")
    public final E withVersion(String version) {
        this.version = version;
        @SuppressWarnings("unchecked") E thisE = (E) this;
        return thisE;
    }
}

