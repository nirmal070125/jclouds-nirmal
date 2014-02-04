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
package org.jclouds.docker.domain;

import java.beans.ConstructorProperties;

import com.google.inject.name.Named;

/**
 * Represents an image of Docker.
 * @author nirmal
 *
 */
public class Image {

	@Named("Repository")
    private String repository;

    @Named("Tag")
    private String tag;

    @Named("Id")
    private String id;

    @Named("Created")
    private long created;

    @Named("Size")
    private long size;

    @Named("VirtualSize")
    private long virtualSize;

    @ConstructorProperties({
    		"Repository", "Tag", "Id", "Created", "Size", "VirtualSize"
    })
	public Image(String repository, String tag, String id, long created,
			long size, long virtualSize) {
		super();
		this.repository = repository;
		this.tag = tag;
		this.id = id;
		this.created = created;
		this.size = size;
		this.virtualSize = virtualSize;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getVirtualSize() {
		return virtualSize;
	}

	public void setVirtualSize(long virtualSize) {
		this.virtualSize = virtualSize;
	}
    
    

}