#
# The jclouds API for LXC Docker (http://www.docker.io/).
#
# A YouTube video on the initial version of the API is demonstrated here:
# http://www.youtube.com/watch?v=TD9V_sNir7o
#
# TODO: Implementation status.
# TODO: Supported features.
# Usage example:
# 	Note that DockerIaas class is an abstraction of jclouds APIs.
#
# 			DockerIaas iaas = new DockerIaas();
#	        IaasProvider iaasProvider = new IaasProvider();
#	        iaasProvider.setType("docker");
#	        iaasProvider.setProvider("docker");
#	        iaasProvider.setIdentity("docker");
#	        iaasProvider.setImage("b750fe79269d2ec9a3c593ef05b4332b1d1a02a62b4accb2c21d589ff2f5f2dc");
#	        iaasProvider.setProperty("docker.credential", "nirmal");
#	        iaasProvider.setProperty("jclouds.endpoint", "http://192.168.1.3:4243");
#	        iaas.buildComputeServiceAndTemplate(iaasProvider);
#	        iaasProvider.setIaas(iaas);
#	        
#	        System.err.println("Starting to spawn an LXC container.");
#	        Set<? extends NodeMetadata> nodes =
#                   iaasProvider.getComputeService().createNodesInGroup("nir", 1,
#                                                      iaasProvider.getTemplate());
#	        
#	        NodeMetadata node = nodes.iterator().next();
#	        
#	        String containerId = node.getId();
#	        iaasProvider.getComputeService().destroyNode(containerId);
#	        System.err.println("Terminated the LXC container.");
#	        System.exit(0);
#