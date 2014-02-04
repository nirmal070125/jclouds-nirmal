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
package org.jclouds.ec2.services;

import static org.jclouds.aws.reference.FormParameters.ACTION;

import java.net.URI;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jclouds.Fallbacks.EmptySetOnNotFoundOr404;
import org.jclouds.aws.filters.FormSigner;
import org.jclouds.ec2.domain.AvailabilityZoneInfo;
import org.jclouds.ec2.options.DescribeAvailabilityZonesOptions;
import org.jclouds.ec2.options.DescribeRegionsOptions;
import org.jclouds.ec2.xml.DescribeAvailabilityZonesResponseHandler;
import org.jclouds.ec2.xml.DescribeRegionsResponseHandler;
import org.jclouds.javax.annotation.Nullable;
import org.jclouds.location.functions.RegionToEndpointOrProviderIfNull;
import org.jclouds.rest.annotations.EndpointParam;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.FormParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;
import org.jclouds.rest.annotations.XMLResponseParser;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * Provides access to EC2 Availability Zones and Regions via their REST API.
 * <p/>
 * 
 * @deprecated Async interfaces are being removed in 1.7.
 *          Please use AvailabilityZoneAndRegionApi via EC2Api instead.
 * @author Adrian Cole
 */
@Deprecated
@RequestFilters(FormSigner.class)
@VirtualHost
public interface AvailabilityZoneAndRegionAsyncClient {

   /**
    * @see AvailabilityZoneAndRegionClient#describeAvailabilityZonesInRegion
    */
   @Named("DescribeAvailabilityZones")
   @POST
   @Path("/")
   @FormParams(keys = ACTION, values = "DescribeAvailabilityZones")
   @XMLResponseParser(DescribeAvailabilityZonesResponseHandler.class)
   @Fallback(EmptySetOnNotFoundOr404.class)
   ListenableFuture<? extends Set<AvailabilityZoneInfo>> describeAvailabilityZonesInRegion(
            @EndpointParam(parser = RegionToEndpointOrProviderIfNull.class) @Nullable String region,
            DescribeAvailabilityZonesOptions... options);

   /**
    * @see AvailabilityZoneAndRegionClient#describeRegions
    */
   @Named("DescribeRegions")
   @POST
   @Path("/")
   @FormParams(keys = ACTION, values = "DescribeRegions")
   @XMLResponseParser(DescribeRegionsResponseHandler.class)
   ListenableFuture<? extends Map<String, URI>> describeRegions(DescribeRegionsOptions... options);

}
