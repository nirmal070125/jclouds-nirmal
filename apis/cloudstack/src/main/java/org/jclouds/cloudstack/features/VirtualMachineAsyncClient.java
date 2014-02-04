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
package org.jclouds.cloudstack.features;

import java.util.Set;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.EmptySetOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.VirtualMachine;
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.options.AssignVirtualMachineOptions;
import org.jclouds.cloudstack.options.DeployVirtualMachineOptions;
import org.jclouds.cloudstack.options.ListVirtualMachinesOptions;
import org.jclouds.cloudstack.options.StopVirtualMachineOptions;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.OnlyElement;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * Provides asynchronous access to cloudstack via their REST API.
 * <p/>
 * 
 * @deprecated  The async interface will be removed in jclouds 1.7.
 * @see VirtualMachineClient
 * @see <a href="http://download.cloud.com/releases/2.2.0/api_2.2.12/TOC_User.html" />
 * @author Adrian Cole
 */
@Deprecated
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface VirtualMachineAsyncClient {

   /**
    * @see VirtualMachineClient#listVirtualMachines
    */
   @Named("listVirtualMachines")
   @GET
   @QueryParams(keys = { "command", "listAll" }, values = { "listVirtualMachines", "true" })
   @SelectJson("virtualmachine")
   @Consumes(MediaType.APPLICATION_JSON)
   @Fallback(EmptySetOnNotFoundOr404.class)
   ListenableFuture<Set<VirtualMachine>> listVirtualMachines(ListVirtualMachinesOptions... options);

   /**
    * @see VirtualMachineClient#getVirtualMachine
    */
   @Named("listVirtualMachines")
   @GET
   @QueryParams(keys = { "command", "listAll" }, values = { "listVirtualMachines", "true" })
   @SelectJson("virtualmachine")
   @OnlyElement
   @Consumes(MediaType.APPLICATION_JSON)
   @Fallback(NullOnNotFoundOr404.class)
   ListenableFuture<VirtualMachine> getVirtualMachine(@QueryParam("id") String id);

   /**
    * @see VirtualMachineClient#deployVirtualMachineInZone
    */
   @Named("deployVirtualMachine")
   @GET
   @QueryParams(keys = "command", values = "deployVirtualMachine")
   @SelectJson({ "deployvirtualmachine", "deployvirtualmachineresponse" })
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<AsyncCreateResponse> deployVirtualMachineInZone(@QueryParam("zoneid") String zoneId,
         @QueryParam("serviceofferingid") String serviceOfferingId, @QueryParam("templateid") String templateId,
         DeployVirtualMachineOptions... options);

   /**
    * @see VirtualMachineClient#rebootVirtualMachine
    */
   @Named("rebootVirtualMachine")
   @GET
   @QueryParams(keys = "command", values = "rebootVirtualMachine")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<String> rebootVirtualMachine(@QueryParam("id") String id);

   /**
    * @see VirtualMachineClient#startVirtualMachine
    */
   @Named("startVirtualMachine")
   @GET
   @QueryParams(keys = "command", values = "startVirtualMachine")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<String> startVirtualMachine(@QueryParam("id") String id);

   /**
    * @see VirtualMachineClient#stopVirtualMachine
    */
   @Named("stopVirtualMachine")
   @GET
   @QueryParams(keys = "command", values = "stopVirtualMachine")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<String> stopVirtualMachine(@QueryParam("id") String id);

   /**
    * @see VirtualMachineClient#stopVirtualMachine
    */
   @GET
   @QueryParams(keys = "command", values = "stopVirtualMachine")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<String> stopVirtualMachine(@QueryParam("id") String id,
                                               StopVirtualMachineOptions options);

   /**
    * @see VirtualMachineClient#resetPasswordForVirtualMachine
    */
   @Named("resetPasswordForVirtualMachine")
   @GET
   @QueryParams(keys = "command", values = "resetPasswordForVirtualMachine")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<String> resetPasswordForVirtualMachine(@QueryParam("id") String id);

   /**
    * @see VirtualMachineClient#getEncryptedPasswordForVirtualMachine
    */
   @Named("getVMPassword")
   @GET
   @QueryParams(keys = "command", values = "getVMPassword")
   @SelectJson("encryptedpassword")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<String> getEncryptedPasswordForVirtualMachine(@QueryParam("id") String id);

   /**
    * @see VirtualMachineClient#changeServiceForVirtualMachine
    */
   @Named("changeServiceForVirtualMachine")
   @GET
   @QueryParams(keys = "command", values = "changeServiceForVirtualMachine")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<String> changeServiceForVirtualMachine(@QueryParam("id") String id);

   /**
    * @see VirtualMachineClient#updateVirtualMachine
    */
   @Named("updateVirtualMachine")
   @GET
   @QueryParams(keys = "command", values = "updateVirtualMachine")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<String> updateVirtualMachine(@QueryParam("id") String id);

   /**
    * @see VirtualMachineClient#destroyVirtualMachine
    */
   @Named("destroyVirtualMachine")
   @GET
   @QueryParams(keys = "command", values = "destroyVirtualMachine")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   @Fallback(NullOnNotFoundOr404.class)
   ListenableFuture<String> destroyVirtualMachine(@QueryParam("id") String id);

   /**
    * @see VirtualMachineClient#assinVirtualMachine
    */
   @Named("assignVirtualMachine")
   @GET
   @QueryParams(keys = "command", values = "assignVirtualMachine")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   ListenableFuture<VirtualMachine> assignVirtualMachine(@QueryParam("virtualmachineid") String virtualMachineId,
                                                         AssignVirtualMachineOptions... options);

}