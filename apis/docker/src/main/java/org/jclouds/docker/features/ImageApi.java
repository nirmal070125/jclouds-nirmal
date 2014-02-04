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
package org.jclouds.docker.features;

import java.io.Closeable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.jclouds.docker.domain.Image;
import org.jclouds.rest.annotations.QueryParams;
import com.google.inject.name.Named;

/**
 * 
 * @author nirmal
 *
 */
@Consumes(MediaType.APPLICATION_JSON)
@Path("/images")
public interface ImageApi extends Closeable {

	/**
	 * Lists all available images.
	 * 
	 * @return The list of all available images.
	 */
	@Named("image:list")
	@GET
	@QueryParams(keys = { "all" }, values = { "1" })
	@Path("/json")
	List<Image> listImages();

	/**
	 * Get Docker version.
	 * 
	 * @return The Docker version.
	 */
	@Named("image")
	@GET
	@Path("/{name}/json")
	Image getImage(@PathParam("name") String name);

}
