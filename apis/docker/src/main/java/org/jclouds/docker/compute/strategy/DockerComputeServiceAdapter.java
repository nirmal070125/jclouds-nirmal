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
package org.jclouds.docker.compute.strategy;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Iterables.contains;
import static com.google.common.collect.Iterables.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.jclouds.compute.ComputeServiceAdapter;
import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.Processor;
import org.jclouds.compute.domain.Template;
import org.jclouds.compute.domain.Volume;
import org.jclouds.compute.domain.internal.HardwareImpl;
import org.jclouds.compute.reference.ComputeServiceConstants;
import org.jclouds.docker.DockerApi;
import org.jclouds.docker.domain.Container;
import org.jclouds.docker.domain.ContainerConfig;
import org.jclouds.docker.domain.CreateContainerResponse;
import org.jclouds.docker.domain.HostConfig;
import org.jclouds.docker.domain.Image;
import org.jclouds.domain.Location;
import org.jclouds.logging.Logger;

import com.google.common.base.Predicate;

/**
 * Implementation of the Compute Service for the Docker API.
 * @author nirmal
 */
public class DockerComputeServiceAdapter implements ComputeServiceAdapter<Container, Hardware, Image, Location> {

   @Resource
   @Named(ComputeServiceConstants.COMPUTE_LOGGER)
   protected Logger logger = Logger.NULL;

   private final DockerApi api;

   @Inject
   DockerComputeServiceAdapter(DockerApi api) {
      this.api = checkNotNull(api, "api cannot be null");
   }

   @Override
   public NodeAndInitialCredentials<Container> createNodeWithGroupEncodedIntoName(String group, String name,
         Template template) {
	   
	   checkNotNull(template, "template was null");
	   
	   ContainerConfig containerConfig = new ContainerConfig();
       containerConfig.setImage(template.getImage().getName());
       //FIXME for some reason while commands not working, should check on it
//       containerConfig.setCmd(new String[]{"/bin/sh", "-c", "while true;", "do echo Connecting to Docker via jclouds;", "sleep 1;", "done"});
//       containerConfig.setCmd(new String[]{"true", "/bin/sh -c echo Hello World"});
//       containerConfig.setCmd(new String[]{"/bin/sh", "while true; do echo \"Connecting to Docker via jclouds\"; sleep 3; done"});
//       containerConfig.setCmd(new String[]{"true", "/bin/sh -c while true; do echo \"Connecting to Docker via jclouds\"; sleep 10; done"});//; sleep 3; done"})
       
       String[] commands = new String[] {
    		   "sleep", "40"
//               "true",
//               "/bin/bash -c 'while true; do echo Connecting to Docker via jclouds; sleep 5; done'"
       };
       //FIXME use logger
       System.err.println("Spawning up new LXC ...");
       
       containerConfig.setCmd(commands);

       System.err.println("Creating a LXC Container ...");
       CreateContainerResponse containerResponse = api.getContainerApi().createContainer(containerConfig);
       
       String containerId = containerResponse.getId();
       checkNotNull(containerId, "Container id was null");
       
       System.err.println("Created LXC Container id: ["+containerId+"]");
       
       HostConfig hostConfig = new HostConfig(new String[]{});
       System.err.println("Staring the LXC Container id: ["+containerId+"]");
       api.getContainerApi().startContainer(containerId, hostConfig);
       
       Container container = api.getContainerApi().getContainer(containerId);
       
       System.err.println("Waiting till the LXC Container finishes its job. id: ["+containerId+"]");
       api.getContainerApi().waitContainer(containerId);
       
       return new NodeAndInitialCredentials<Container>(container, containerId, null);

   }

   @Override
   public Iterable<Image> listImages() {
      return api.getImageApi().listImages();
   }

   @Override
   public Iterable<Hardware> listHardwareProfiles() {
	   Iterable<? extends Processor> processorList = new ArrayList<Processor>();
	   Iterable<? extends Volume> vloumeList = new ArrayList<Volume>();
	   Hardware hardware = new HardwareImpl(
			   "docker","docker", "1234",
			   null,null,new HashMap<String, String>(),
			   new HashSet<String>(),processorList,512,vloumeList,null,null);
	   List<Hardware> list = new ArrayList<Hardware>();
	   list.add(hardware);
      return list;
   }

   @Override
   public Iterable<Location> listLocations() {
      return new ArrayList<Location>();
   }

   @Override
   public Iterable<Container> listNodes() {
	   //	   return new ArrayList<Container>();
      return api.getContainerApi().listContainers();
   }

   @Override
   public Iterable<Container> listNodesByIds(final Iterable<String> ids) {
      return filter(listNodes(), new Predicate<Container>() {
         @Override
         public boolean apply(Container container) {
            return contains(ids, container.getId());
         }
      });
   }

   @Override
   public Image getImage(String id) {
      return api.getImageApi().getImage(id);
   }

   @Override
   public Container getNode(String id) {
      return null;
   }

   @Override
   public void destroyNode(String id) {
	   // FIXME this doesn't get called.. why?
	   System.err.println("LXC Container abortion started. Waiting.... Id: ["+id+"]");
	   api.getContainerApi().stopContainer(id);
	   System.err.println("LXC Container is stopped. Id: ["+id+"]");
   }

   @Override
   public void rebootNode(String id) {
   }

   @Override
   public void resumeNode(String id) {

   }

   @Override
   public void suspendNode(String id) {

   }

}
