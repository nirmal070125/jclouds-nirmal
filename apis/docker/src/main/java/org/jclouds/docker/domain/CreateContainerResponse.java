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
import java.util.Arrays;
import java.util.Map;

import com.google.inject.name.Named;

/**
 * A Container is a representation of a node in the docker world.
 * 
 * http://docs.docker.io/en/latest/api/docker_remote_api_v1.8/#containers
 * 
 * @author nirmal
 */
public class CreateContainerResponse {
   
	@Named("Id")
    private String id;

	@Named("Warnings")
    private String[] warnings;

	@ConstructorProperties({"Id", "Warnings"})
    public CreateContainerResponse(String id, String[] warnings) {
		super();
		this.id = id;
		this.warnings = warnings;
	}

	public String getId() {
        return id;
    }

    public String[] getWarnings() {
        return warnings;
    }
  
}
