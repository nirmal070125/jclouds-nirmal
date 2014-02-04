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
package org.jclouds.docker;

import java.io.Closeable;

import org.jclouds.docker.features.ContainerApi;
import org.jclouds.docker.features.ImageApi;
import org.jclouds.docker.features.VersionApi;
import org.jclouds.rest.annotations.Delegate;
import org.jclouds.rest.annotations.SkipEncoding;

import javax.ws.rs.Consumes;

/**
* Provides synchronous access to Docker API.
* @author nirmal
*/
//@RequestFilters(BasicAuthentication.class)
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@SkipEncoding({'?', '/', '='})
public interface DockerApi extends Closeable {

	@Delegate
	VersionApi getVersionApi();
	
	@Delegate
	ImageApi getImageApi();
	
	@Delegate
	ContainerApi getContainerApi();

}
