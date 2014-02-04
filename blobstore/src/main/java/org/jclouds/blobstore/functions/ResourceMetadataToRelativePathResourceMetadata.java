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
package org.jclouds.blobstore.functions;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Singleton;

import org.jclouds.blobstore.domain.StorageMetadata;
import org.jclouds.blobstore.domain.StorageType;
import org.jclouds.blobstore.domain.internal.StorageMetadataImpl;
import org.jclouds.blobstore.reference.BlobStoreConstants;

import com.google.common.base.Function;

/**
 * @author Adrian Cole
 */
@Singleton
public class ResourceMetadataToRelativePathResourceMetadata implements Function<StorageMetadata, StorageMetadata> {

   public StorageMetadata apply(StorageMetadata md) {
      checkNotNull(md, "metadata");
      String name = checkNotNull(md.getName(), "metadata.name");
      for (String suffix : BlobStoreConstants.DIRECTORY_SUFFIXES) {
         if (name.endsWith(suffix))
            name = name.substring(0, name.length() - suffix.length());
      }
      return new StorageMetadataImpl(StorageType.RELATIVE_PATH, md.getProviderId(), name, md.getLocation(),
            md.getUri(), md.getETag(), md.getCreationDate(), md.getLastModified(), md.getUserMetadata());
   }

}