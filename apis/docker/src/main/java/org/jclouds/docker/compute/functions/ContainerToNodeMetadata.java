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
package org.jclouds.docker.compute.functions;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Iterables.find;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jclouds.collect.Memoized;
import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.Image;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.NodeMetadata.Status;
import org.jclouds.compute.domain.NodeMetadataBuilder;
import org.jclouds.docker.domain.Container;
import org.jclouds.docker.domain.ContainerState;
import org.jclouds.domain.Location;
import org.jclouds.location.predicates.LocationPredicates;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableSet;

/**
 * Transforms an {@link Container} to the jclouds portable model.
 * @author nirmal
 */
@Singleton
public class ContainerToNodeMetadata implements Function<Container, NodeMetadata> {

   private final Supplier<Map<String, ? extends Image>> images;
   private final Supplier<Map<String, ? extends Hardware>> hardwares;
   private final Supplier<Set<? extends Location>> locations;
   private final Function<ContainerState, Status> toPortableStatus;

   @Inject
   ContainerToNodeMetadata(Supplier<Map<String, ? extends Image>> images,
         Supplier<Map<String, ? extends Hardware>> hardwares, @Memoized Supplier<Set<? extends Location>> locations,
         Function<ContainerState, Status> toPortableStatus) {
      this.images = checkNotNull(images, "images cannot be null");
      this.hardwares = checkNotNull(hardwares, "hardwares cannot be null");
      this.locations = checkNotNull(locations, "locations cannot be null");
      this.toPortableStatus = checkNotNull(toPortableStatus, "toPortableStatus cannot be null");
   }

   @Override
	public NodeMetadata apply(Container input) {
		NodeMetadataBuilder builder = new NodeMetadataBuilder();
		builder.ids(String.valueOf(input.getId()));
		builder.name(String.valueOf(input.getId()));
		// FIXME need to build NodeBuilder
		// builder.hardware(hardwares.get().get(String.valueOf(input.getConfig().getCpuShares())));
		// builder.location(find(locations.get(),
		// LocationPredicates.idEquals(String.valueOf(input.getId()))));

		// Image image = images.get().get(String.valueOf(input.getImage()));
		// builder.imageId(image.getId());
		// builder.operatingSystem(image.getOperatingSystem());

		builder.status(toPortableStatus.apply(input.getState()));
		// builder.backendStatus(input.getState().toString());

		// builder.publicAddresses(ImmutableSet.of(input.getNetworkSettings().getIpAddress()));

		// TODO: builder.hostname
		// TODO: builder.loginport
		// TODO: builder.group
		// TODO: builder.credentials

		return builder.build();
	}
}
