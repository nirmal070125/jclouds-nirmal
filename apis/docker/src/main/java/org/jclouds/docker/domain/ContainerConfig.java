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
import java.util.Arrays;
import java.util.Map;

import com.google.inject.name.Named;

/**
 * A Container is a representation of a node in the docker world.
 * 
 * http://docs.docker.io/en/latest/api/docker_remote_api_v1.8/#containers
 * 
 * @author nirmal
 */
public class ContainerConfig {
   
	@Named("Hostname")     private String    hostName = "";
	@Named("PortSpecs")    private String[]  portSpecs;
    @Named("User")         private String    user = "";
    @Named("Tty")          private boolean   tty = false;
    @Named("OpenStdin")    private boolean   stdinOpen = false;
    @Named("StdinOnce")    private boolean   stdInOnce = false;
    @Named("Memory")       private long      memoryLimit = 0;
    @Named("MemorySwap")   private long      memorySwap = 0;
    @Named("CpuShares")    private int       cpuShares = 0;
    @Named("AttachStdin")  private boolean   attachStdin = false;
    @Named("AttachStdout") private boolean   attachStdout = true;
    @Named("AttachStderr") private boolean   attachStderr = true;
    @Named("Env")          private String[]  env;
    @Named("Cmd")          private String[]  cmd;
    @Named("Dns")          private String[]  dns;
    @Named("Image")        private String    image;
    @Named("Volumes")      private Object    volumes;
    @Named("VolumesFrom")  private String    volumesFrom = "";
    @Named("Entrypoint")   private String[]  entrypoint = new String[]{};
    @Named("NetworkDisabled") private boolean networkDisabled = false;
    @Named("Privileged")   private boolean privileged = false;
    @Named("WorkingDir")   private String workingDir = "";
    @Named("Domainname")   private String domainName = "";
    // FIXME Is this the right type? 
    @Named("ExposedPorts")   private Map<String, String> exposedPorts;

    
    @ConstructorProperties({
    	"Hostname","PortSpecs",
    	"User","Tty", "OpenStdin", "StdinOnce", "Memory", "MemorySwap", "CpuShares", "AttachStdin", "AttachStdout", 
    	"AttachStderr", "Env", "Cmd", "Dns", "Image", "Volumes", "VolumesFrom", "Entrypoint", "NetworkDisabled",
    	"Privileged", "WorkingDir", "Domainname", "ExposedPorts"
    	
    })
    public ContainerConfig(String hostName, String[] portSpecs, String user,
			boolean tty, boolean stdinOpen, boolean stdInOnce,
			long memoryLimit, long memorySwap, int cpuShares,
			boolean attachStdin, boolean attachStdout, boolean attachStderr,
			String[] env, String[] cmd, String[] dns, String image,
			Object volumes, String volumesFrom, String[] entrypoint,
			boolean networkDisabled, boolean privileged, String workingDir,
			String domainName, Map<String, String> exposedPorts) {
		super();
		this.hostName = hostName;
		this.portSpecs = portSpecs;
		this.user = user;
		this.tty = tty;
		this.stdinOpen = stdinOpen;
		this.stdInOnce = stdInOnce;
		this.memoryLimit = memoryLimit;
		this.memorySwap = memorySwap;
		this.cpuShares = cpuShares;
		this.attachStdin = attachStdin;
		this.attachStdout = attachStdout;
		this.attachStderr = attachStderr;
		this.env = env;
		this.cmd = cmd;
		this.dns = dns;
		this.image = image;
		this.volumes = volumes;
		this.volumesFrom = volumesFrom;
		this.entrypoint = entrypoint;
		this.networkDisabled = networkDisabled;
		this.privileged = privileged;
		this.workingDir = workingDir;
		this.domainName = domainName;
		this.exposedPorts = exposedPorts;
	}

    public ContainerConfig() {
	}
    
	public Map<String, String> getExposedPorts() {
        return exposedPorts;
    }

    public boolean isNetworkDisabled() {
        return networkDisabled;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getWorkingDir() { return workingDir; }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public String getHostName() {
        return hostName;
    }

    public void setNetworkDisabled(boolean networkDisabled) {
        this.networkDisabled = networkDisabled;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String[] getPortSpecs() {
        return portSpecs;
    }

    public void setPortSpecs(String[] portSpecs) {
        this.portSpecs = portSpecs;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isTty() {
        return tty;
    }

    public void setTty(boolean tty) {
        this.tty = tty;
    }

    public boolean isStdinOpen() {
        return stdinOpen;
    }

    public void setStdinOpen(boolean stdinOpen) {
        this.stdinOpen = stdinOpen;
    }

    public boolean isStdInOnce() {
        return stdInOnce;
    }

    public void setStdInOnce(boolean stdInOnce) {
        this.stdInOnce = stdInOnce;
    }

    public long getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(long memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public long getMemorySwap() {
        return memorySwap;
    }

    public void setMemorySwap(long memorySwap) {
        this.memorySwap = memorySwap;
    }

    public int getCpuShares() {
        return cpuShares;
    }

    public void setCpuShares(int cpuShares) {
        this.cpuShares = cpuShares;
    }

    public boolean isAttachStdin() {
        return attachStdin;
    }

    public void setAttachStdin(boolean attachStdin) {
        this.attachStdin = attachStdin;
    }

    public boolean isAttachStdout() {
        return attachStdout;
    }

    public void setAttachStdout(boolean attachStdout) {
        this.attachStdout = attachStdout;
    }

    public boolean isAttachStderr() {
        return attachStderr;
    }

    public void setAttachStderr(boolean attachStderr) {
        this.attachStderr = attachStderr;
    }

    public String[] getEnv() {
        return env;
    }

    public void setEnv(String[] env) {
        this.env = env;
    }

    public String[] getCmd() {
        return cmd;
    }

    public void setCmd(String[] cmd) {
        this.cmd = cmd;
    }

    public String[] getDns() {
        return dns;
    }

    public void setDns(String[] dns) {
        this.dns = dns;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getVolumes() {
        return volumes;
    }

    public void setVolumes(Object volumes) {
        this.volumes = volumes;
    }

    public String getVolumesFrom() {
        return volumesFrom;
    }

    public void setVolumesFrom(String volumesFrom) {
        this.volumesFrom = volumesFrom;
    }

    public String[] getEntrypoint() {
        return entrypoint;
    }

    public void setEntrypoint(String[] entrypoint) {
        this.entrypoint = entrypoint;
    }

    @Override
    public String toString() {
        return "ContainerConfig{" +
                "hostName='" + hostName + '\'' +
                ", portSpecs=" + Arrays.toString(portSpecs) +
                ", user='" + user + '\'' +
                ", tty=" + tty +
                ", stdinOpen=" + stdinOpen +
                ", stdInOnce=" + stdInOnce +
                ", memoryLimit=" + memoryLimit +
                ", memorySwap=" + memorySwap +
                ", cpuShares=" + cpuShares +
                ", attachStdin=" + attachStdin +
                ", attachStdout=" + attachStdout +
                ", attachStderr=" + attachStderr +
                ", env=" + Arrays.toString(env) +
                ", cmd=" + Arrays.toString(cmd) +
                ", dns=" + Arrays.toString(dns) +
                ", image='" + image + '\'' +
                ", volumes=" + volumes +
                ", volumesFrom='" + volumesFrom + '\'' +
                ", entrypoint=" + Arrays.toString(entrypoint) +
                ", networkDisabled=" + networkDisabled +
                ", privileged=" + privileged +
                ", workingDir='" + workingDir + '\'' +
                ", domainName='" + domainName + '\'' +
                '}';
    }

  
}
