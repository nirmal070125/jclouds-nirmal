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

import static org.jclouds.compute.config.ComputeServiceProperties.TEMPLATE;

import java.net.URI;
import java.util.Properties;

import org.jclouds.apis.ApiMetadata;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.docker.compute.config.DockerComputeServiceContextModule;
import org.jclouds.docker.config.DockerHttpApiModule;
import org.jclouds.rest.internal.BaseHttpApiMetadata;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;

/**
 * Implementation of {@link BaseHttpApiMetadata} for the Docker API.
 * @author nirmal
 */
public class DockerApiMetadata extends BaseHttpApiMetadata<DockerApi> {

   @Override
   public Builder toBuilder() {
      return new Builder().fromApiMetadata(this);
   }

   public DockerApiMetadata() {
      this(new Builder());
   }

   protected DockerApiMetadata(Builder builder) {
      super(builder);
   }

   public static Properties defaultProperties() {
      Properties properties = BaseHttpApiMetadata.defaultProperties();
      //FIXME do we need following props?
      // passwords are set post-boot, so auth failures are possible
      // from a race condition applying the password set script
      properties.setProperty("jclouds.ssh.max-retries", "7");
      properties.setProperty("jclouds.ssh.retry-auth", "true");
      properties.setProperty(TEMPLATE, "osFamily=UBUNTU,imageNameMatches=.*[Aa]utomated SSH Access.*,os64Bit=true");
      return properties;
   }

   public static class Builder extends BaseHttpApiMetadata.Builder<DockerApi, Builder> {

		protected Builder() {
			super(DockerApi.class);
			id("docker")
					.name("Docker API")
					.defaultIdentity("email")
					.identityName("Email")
					.defaultCredential("Password")
					.credentialName("Password")
					.documentation(URI.create("http://localhost:4243"))
					.version("1.8")
					.defaultEndpoint("http://localhost:4243")
					.defaultProperties(DockerApiMetadata.defaultProperties())
					.view(ComputeServiceContext.class)
					.defaultModules(
							ImmutableSet.<Class<? extends Module>> of(
									DockerHttpApiModule.class,
									DockerComputeServiceContextModule.class));
		}

      @Override
      public DockerApiMetadata build() {
         return new DockerApiMetadata(this);
      }

      @Override
      protected Builder self() {
         return this;
      }

      @Override
      public Builder fromApiMetadata(ApiMetadata in) {
         return this;
      }
   }
}
