/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.docker.domain;

import java.beans.ConstructorProperties;

import com.google.inject.name.Named;

/**
 * A Version
 * @author nirmal
 *
 */
public class Version {
	
	@Named("Version") private final String version;
	@Named("GitCommit") private final String gitCommit;
	@Named("GoVersion") private final String goVersion;
	
	@ConstructorProperties({ "Version", "GitCommit", "GoVersion" })
	public Version(String version, String gitCommit, String goVersion) {
		this.version = version;
		this.gitCommit = gitCommit;
		this.goVersion = goVersion;
	}

	public String getVersion() {
		return version;
	}

	public String getGitCommit() {
		return gitCommit;
	}

	public String getGoVersion() {
		return goVersion;
	}
	

}