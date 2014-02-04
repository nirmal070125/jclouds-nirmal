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
import java.util.Map;

import com.google.inject.name.Named;

/**
 * Represents a Container of Docker.
 * @author nirmal
 *
 */
public class Container {

	@Named("ID")
    private String id;

    @Named("Created")
    private String created;

    @Named("Path")
    private String path;

    @Named("Args")
    private String[] args;

    @Named("Config")
    public ContainerConfig config;

    @Named("State")
    private ContainerState state;

    @Named("Image")
    private String image;

    @Named("NetworkSettings")
    private NetworkSettings networkSettings;

    @Named("SysInitPath")
    private String sysInitPath;

    @Named("ResolvConfPath")
    private String resolvConfPath;

    @Named("Volumes")
    private Map<String, String> volumes;

    @Named("VolumesRW")
    private Map<String, String> volumesRW;

    @Named("HostnamePath")
    private String hostnamePath;

    @Named("HostsPath")
    private String hostsPath;

    @Named("Name")
    private String name;

    @Named("Driver")
    private String driver;

    @ConstructorProperties({
    		"ID", "Created", "Path", "Args", "Config", "State", "Image", "NetworkSettings", 
    		"SysInitPath", "ResolvConfPath", "Volumes", "VolumesRW", "HostnamePath", "HostsPath", 
    		"Name", "Driver"
    })
    public Container(String id, String created, String path, String[] args,
    		ContainerConfig config, ContainerState state, String image,
    		NetworkSettings networkSettings, String sysInitPath,
    		String resolvConfPath, Map<String, String> volumes,
    		Map<String, String> volumesRW, String hostnamePath,
    		String hostsPath, String name, String driver) {
    	super();
    	this.id = id;
    	this.created = created;
    	this.path = path;
    	this.args = args;
    	this.config = config;
    	this.state = state;
    	this.image = image;
    	this.networkSettings = networkSettings;
    	this.sysInitPath = sysInitPath;
    	this.resolvConfPath = resolvConfPath;
    	this.volumes = volumes;
    	this.volumesRW = volumesRW;
    	this.hostnamePath = hostnamePath;
    	this.hostsPath = hostsPath;
    	this.name = name;
    	this.driver = driver;
    }
    
    public Container() {
	}

	
	public String getId() {
		return id;
	}

	public String getCreated() {
		return created;
	}

	public String getPath() {
		return path;
	}

	public String[] getArgs() {
		return args;
	}

	public ContainerConfig getConfig() {
		return config;
	}

	public ContainerState getState() {
		return state;
	}

	public String getImage() {
		return image;
	}

	public NetworkSettings getNetworkSettings() {
		return networkSettings;
	}

	public String getSysInitPath() {
		return sysInitPath;
	}

	public String getResolvConfPath() {
		return resolvConfPath;
	}

	public Map<String, String> getVolumes() {
		return volumes;
	}

	public Map<String, String> getVolumesRW() {
		return volumesRW;
	}

	public String getHostnamePath() {
		return hostnamePath;
	}

	public String getHostsPath() {
		return hostsPath;
	}

	public String getName() {
		return name;
	}

	public String getDriver() {
		return driver;
	}


}