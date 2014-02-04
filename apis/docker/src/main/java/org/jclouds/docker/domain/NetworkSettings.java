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
 * Represents network settings of a Container of Docker.
 * @author nirmal
 *
 */
public class NetworkSettings {

    @Named("IPAddress") public String ipAddress;
    @Named("IPPrefixLen") public int ipPrefixLen;
    @Named("Gateway") public String gateway;
    @Named("Bridge") public String bridge;
    // FIXME Is this the right type? 
    @Named("Ports") public Map<String, ?> ports;
    
    @ConstructorProperties({
    		"IPAddress", "IPPrefixLen", "Gateway", "Bridge", "Ports"
    })
    public NetworkSettings(String ipAddress, int ipPrefixLen,
			String gateway, String bridge, Map<String, ?> ports) {
		super();
		this.ipAddress = ipAddress;
		this.ipPrefixLen = ipPrefixLen;
		this.gateway = gateway;
		this.bridge = bridge;
		this.ports = ports;
	}
    
    public NetworkSettings() {
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public int getIpPrefixLen() {
		return ipPrefixLen;
	}

	public String getGateway() {
		return gateway;
	}

	public String getBridge() {
		return bridge;
	}

	public Map<String, ?> getPorts() {
		return ports;
	}

	@Override
    public String toString() {
        return "NetworkSettings{" +
                "ipAddress='" + ipAddress + '\'' +
                ", ipPrefixLen=" + ipPrefixLen +
                ", gateway='" + gateway + '\'' +
                ", bridge='" + bridge + '\'' +
                ", ports=" + ports +
                '}';
    }
}
