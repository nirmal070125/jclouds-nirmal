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
import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.FirewallRule;
import org.jclouds.cloudstack.domain.PortForwardingRule;
import org.jclouds.cloudstack.options.CreateFirewallRuleOptions;
import org.jclouds.cloudstack.options.ListFirewallRulesOptions;
import org.jclouds.cloudstack.options.ListPortForwardingRulesOptions;

/**
 * Provides synchronous access to CloudStack PortForwardingRule features.
 * <p/>
 * 
 * @deprecated  The *Client classes will be replaced with the *Api classes in jclouds 1.7.
 * @see PortForwardingRuleAsyncClient
 * @see <a href="http://download.cloud.com/releases/2.2.0/api_2.2.12/TOC_User.html" />
 * @author Adrian Cole
 */
@Deprecated
public interface FirewallClient {

   /**
    * List the firewall rules
    *
    * @param options
    *          if present, how to constrain the list.
    * @return
    *          set of firewall rules or empty set if no rules are found
    */
   Set<FirewallRule> listFirewallRules(ListFirewallRulesOptions... options);

   /**
    * Get a firewall rule by ID
    *
    * @param id
    *          the ID of the firewall rule
    * @return
    *          firewall rule instance or null
    */
   FirewallRule getFirewallRule(String id);

   /**
    * Create new firewall rule for a specific IP address
    *
    * @param ipAddressId
    *          the IP address id of the port forwarding rule
    * @param protocol
    *          the protocol for the firewall rule. Valid values are TCP/UDP/ICMP
    * @param options
    *          optional arguments for firewall rule creation
    * @return
    */
   AsyncCreateResponse createFirewallRuleForIpAndProtocol(String ipAddressId,
         FirewallRule.Protocol protocol, CreateFirewallRuleOptions... options);

    
    AsyncCreateResponse createFirewallRuleForIpProtocolAndPort(String ipAddressId,
                                                           FirewallRule.Protocol protocol,
                                                           int startPort,
                                                               int endPort);


   /**
    * Deletes a firewall rule
    *
    * @param id
    *       the ID of the firewall rule
    */
   Void deleteFirewallRule(String id);

   /**
    * List the port forwarding rules
    * 
    * @param options
    *           if present, how to constrain the list.
    * @return PortForwardingRules matching query, or empty set, if no
    *         PortForwardingRules are found
    */
   Set<PortForwardingRule> listPortForwardingRules(ListPortForwardingRulesOptions... options);

   /**
    * Get a port forwarding rule by ID
    *
    * @param id
    *       port forwarding rule ID
    * @return
    *       rule instance or null
    */
   PortForwardingRule getPortForwardingRule(String id);

   /**
    * Creates an port forwarding rule
    * 
    *
    * @param ipAddressId
    * @param protocol
    *           the protocol for the rule. Valid values are TCP or UDP.
    * @param publicPort
    *           the public port of the port forwarding rule
    * @param virtualMachineId
    *           the ID of the virtual machine for the port forwarding rule
    * @param privatePort
    *           the private port of the port forwarding rule
    * @return response used to track creation
    */
   AsyncCreateResponse createPortForwardingRuleForVirtualMachine(String ipAddressId,
      PortForwardingRule.Protocol protocol, int publicPort, String virtualMachineId, int privatePort);

   /**
    * Deletes an port forwarding rule
    * 
    * @param id
    *           the id of the forwarding rule
    */
   Void deletePortForwardingRule(String id);

   /**
    * List the egress firewall rules
    *
    * @param options
    *          if present, how to constrain the list.
    * @return
    *          set of egress firewall rules or empty set if no rules are found
    */
   Set<FirewallRule> listEgressFirewallRules(ListFirewallRulesOptions... options);

   /**
    * Get an egress firewall rule by ID
    *
    * @param id
    *          the ID of the egress firewall rule
    * @return
    *          egress firewall rule instance or null
    */
   FirewallRule getEgressFirewallRule(String id);

   /**
    * Create new egress firewall rule for a specific IP address
    *
    * @param ipAddressId
    *          the IP address id of the egress firewall rule
    * @param protocol
    *          the protocol for the egress firewall rule. Valid values are TCP/UDP/ICMP
    * @param options
    *          optional arguments for egress firewall rule creation
    * @return
    */
   AsyncCreateResponse createEgressFirewallRuleForIpAndProtocol(String ipAddressId,
                                                                FirewallRule.Protocol protocol,
                                                                CreateFirewallRuleOptions... options);


   AsyncCreateResponse createEgressFirewallRuleForIpProtocolAndPort(String ipAddressId,
                                                                    FirewallRule.Protocol protocol,
                                                                    int startPort,
                                                                    int endPort);


   /**
    * Deletes an egress firewall rule
    *
    * @param id
    *       the ID of the egress firewall rule
    */
   Void deleteEgressFirewallRule(String id);

}
