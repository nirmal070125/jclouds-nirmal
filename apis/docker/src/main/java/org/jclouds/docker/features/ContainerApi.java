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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.jclouds.docker.domain.Container;
import org.jclouds.docker.domain.ContainerConfig;
import org.jclouds.docker.domain.CreateContainerResponse;
import org.jclouds.docker.domain.HostConfig;
import org.jclouds.rest.annotations.BinderParam;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.binders.BindToJsonPayload;

import com.google.inject.name.Named;

/**
 * 
 * @author nirmal
 *
 */
@Consumes(MediaType.APPLICATION_JSON)
@Path("/containers")
public interface ContainerApi extends Closeable {

	/**
	 * Lists all existing Container.
	 * 
	 * @return The list of all existing Containers.
	 */
	@Named("containers:list")
	@GET
	@Path("/json")
	@QueryParams(keys = { "all" }, values = { "1" })
	List<Container> listContainers();

	/**
	 * Get a Container.
	 * 
	 * @return The Container with the given id.
	 */
	@Named("containers:get")
	@GET
	@Path("/{id}/json")
	Container getContainer(@PathParam("id") String id);

	/**
	 * Create Docker Container.
	 * 
	 * @return The Docker container.
	 */
	@Named("containers:create")
	@POST
	@Path("/create")
	CreateContainerResponse createContainer(
			@BinderParam(BindToJsonPayload.class) ContainerConfig container);

	/**
	 * Start a Docker Container.
	 * 
	 */
	@Named("containers:start")
	@POST
	@Path("/{id}/start")
	void startContainer(@PathParam("id") String id,
			@BinderParam(BindToJsonPayload.class) HostConfig hostConfig);

	/**
	 * Wait a Docker Container.
	 * 
	 */
	@Named("containers:wait")
	@POST
	@Path("/{id}/wait")
	void waitContainer(@PathParam("id") String id);

	/**
	 * Stop a Docker Container.
	 * 
	 */
	@Named("containers:stop")
	@POST
	@Path("/{id}/stop")
	@QueryParams(keys = { "t" }, values = { "5" })
	void stopContainer(@PathParam("id") String id);

}
