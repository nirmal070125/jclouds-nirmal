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

import javax.inject.Singleton;

import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.NodeMetadata.Status;
import org.jclouds.docker.domain.ContainerState;
import com.google.common.base.Function;

/**
 * Transforms an {@link ContainerState} to the jclouds portable model.
 * @author nirmal
 */
@Singleton
public class ContainerStateToStatus implements Function<ContainerState, Status> {

   @Override
   public Status apply(final ContainerState input) {
	  if(input != null && input.isRunning()) {
		  return NodeMetadata.Status.RUNNING;
	  } else {
		  return Status.UNRECOGNIZED;
	  }
   }
}
