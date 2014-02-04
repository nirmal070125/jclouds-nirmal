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
 * Represents an host configuration of a Docker Container.
 * @author nirmal
 *
 */
public class HostConfig {

	@Named("Binds")
    private String[] binds;

    @Named("ContainerIDFile")
    private String containerIDFile;

    @Named("LxcConf")
    private LxcConf[] lxcConf;
    
    @Named("PortBindings")
    private PortBindings[] portBindings; 

    @ConstructorProperties({"Binds","ContainerIDFile", "LxcConf", "PortBindings" })
    public HostConfig(String[] binds, String containerIDFile, LxcConf[] lxcConf,PortBindings[] portBindings ) {
		super();
		this.binds = binds;
		this.containerIDFile = containerIDFile;
		this.lxcConf = lxcConf;
		this.portBindings = portBindings;
	}

	public HostConfig(String[] binds) {
        this.binds = binds;
    }

    public String[] getBinds() {
        return binds;
    }

    public void setBinds(String[] binds) {
        this.binds = binds;
    }

    public String getContainerIDFile() {
        return containerIDFile;
    }

    public void setContainerIDFile(String containerIDFile) {
        this.containerIDFile = containerIDFile;
    }

    public LxcConf[] getLxcConf() {
        return lxcConf;
    }

    public void setLxcConf(LxcConf[] lxcConf) {
        this.lxcConf = lxcConf;
    }
    
    public class LxcConf {
        @Named("Key")
        public String key;

        @Named("Value")
        public String value;
        
        @ConstructorProperties({"Key", "Value"})
        public LxcConf(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

    public class PortBindings {
        @Named("Key")
        public String key;

        @Named("Value")
        public String value;
        
        @ConstructorProperties({"Key", "Value"})
        public PortBindings(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}