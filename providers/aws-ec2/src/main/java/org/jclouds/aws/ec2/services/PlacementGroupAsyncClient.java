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
package org.jclouds.aws.ec2.services;

import static org.jclouds.aws.reference.FormParameters.ACTION;

import java.util.Set;

import javax.inject.Named;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jclouds.Fallbacks.EmptySetOnNotFoundOr404;
import org.jclouds.Fallbacks.VoidOnNotFoundOr404;
import org.jclouds.aws.ec2.domain.PlacementGroup;
import org.jclouds.aws.ec2.xml.DescribePlacementGroupsResponseHandler;
import org.jclouds.aws.filters.FormSigner;
import org.jclouds.ec2.binders.BindGroupNamesToIndexedFormParams;
import org.jclouds.javax.annotation.Nullable;
import org.jclouds.location.functions.RegionToEndpointOrProviderIfNull;
import org.jclouds.rest.annotations.BinderParam;
import org.jclouds.rest.annotations.EndpointParam;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.FormParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;
import org.jclouds.rest.annotations.XMLResponseParser;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * Provides access to EC2 Placement Groups via their REST API.
 * <p/>
 * 
 * @deprecated Async interfaces are being removed in 1.7.
 *          Please use PlacementGroupApi via AWSEC2Api instead.
 * @author Adrian Cole
 */
@Deprecated
@RequestFilters(FormSigner.class)
@VirtualHost
public interface PlacementGroupAsyncClient {

   /**
    * @see PlacementGroupClient#createPlacementGroupInRegion(String,String,String)
    */
   @Named("CreatePlacementGroup")
   @POST
   @Path("/")
   @FormParams(keys = ACTION, values = "CreatePlacementGroup")
   ListenableFuture<Void> createPlacementGroupInRegion(
            @EndpointParam(parser = RegionToEndpointOrProviderIfNull.class) @Nullable String region,
            @FormParam("GroupName") String name, @FormParam("Strategy") String strategy);

   /**
    * @see PlacementGroupClient#createPlacementGroupInRegion(String,String)
    */
   @Named("CreatePlacementGroup")
   @POST
   @Path("/")
   @FormParams(keys = { ACTION, "Strategy" }, values = { "CreatePlacementGroup", "cluster" })
   ListenableFuture<Void> createPlacementGroupInRegion(
            @EndpointParam(parser = RegionToEndpointOrProviderIfNull.class) @Nullable String region, @FormParam("GroupName") String name);

   /**
    * @see PlacementGroupClient#deletePlacementGroupInRegion
    */
   @Named("DeletePlacementGroup")
   @POST
   @Path("/")
   @FormParams(keys = ACTION, values = "DeletePlacementGroup")
   @Fallback(VoidOnNotFoundOr404.class)
   ListenableFuture<Void> deletePlacementGroupInRegion(
            @EndpointParam(parser = RegionToEndpointOrProviderIfNull.class) @Nullable String region, @FormParam("GroupName") String name);

   /**
    * @see PlacementGroupClient#describePlacementGroupsInRegion
    */
   @Named("DescribePlacementGroups")
   @POST
   @Path("/")
   @FormParams(keys = ACTION, values = "DescribePlacementGroups")
   @XMLResponseParser(DescribePlacementGroupsResponseHandler.class)
   @Fallback(EmptySetOnNotFoundOr404.class)
   ListenableFuture<? extends Set<PlacementGroup>> describePlacementGroupsInRegion(
            @EndpointParam(parser = RegionToEndpointOrProviderIfNull.class) @Nullable String region,
            @BinderParam(BindGroupNamesToIndexedFormParams.class) String... placementGroupIds);

}
