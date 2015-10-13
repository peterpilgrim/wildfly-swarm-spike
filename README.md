# Spike project

Peter Pilgrim, 2015
Research Spike Project for WILDFLY SWARM

How does development work for front-end and server side?

In particular, verify that WildFly Swarm development can work seamlessly. 

Front end developer do NOT want to restart the Spring Boot service every time that dynamically change the HTML, CSS or graphic resources. 
So we need to find how Spring Boot handles this situation?

Project [https://github.com/peterpilgrim/wildfly-swarm-spike](https://github.com/peterpilgrim/wildfly-swarm-spike)

# Goals

Establish the fast development lifecycle?

* The solution must allow engineers get started quickly 
  (a new starter Java developer or front-end developer should able get a development environment within a day (5 hours))

* The solution should support iterative and experimental development. 
    Whilst server is still running, if a single HTML or CSS is changed, then the solution should reflect the change at runtime. 
    We should be avoiding tedious cycle. Edit a page. Stop and restart a server in order to see a change.  

* The solution should be relative free from encumbrances.

    * Open source preferred
    * Widely supported with the Java (or JavaScript) community
    * Embrace standards
    * Avoid vendor-lock for the large part
    * Relatively mature by at least 12 months
    * Be designed well
    * Extensible architecture (not lead to falling off the cliff in the near-future)

# Requirement

* Java SE 8 or better
* Maven 3 


    > mvn clean 
    > mvn package
    > mvn wildfly-swarm:run


# Process 

    
Navigate the [http://localhost:8080/](http://localhost:8080/) to see the first page.



# Results

## Pros

We see these advantages:

TBC

## Cons

We also see these disadvantages:

TBC

## Time

TBC



# Issue

We are unable to even start Wildfly Swarm because it fails to launch the container. 

This is the current stacktrace:

    Connected to the target VM, address: '127.0.0.1:59226', transport: 'socket'
    org.jboss.modules.ModuleLoadException: Error loading module from modules/org/jboss/msc/main/module.xml
        at org.jboss.modules.ModuleXmlParser.parseModuleXml(ModuleXmlParser.java:150)
        at org.jboss.modules.ModuleXmlParserBridge.parseModuleXml(ModuleXmlParserBridge.java:17)
        at org.wildfly.swarm.bootstrap.modules.BootstrapClasspathModuleFinder.findModule(BootstrapClasspathModuleFinder.java:35)
        at org.jboss.modules.ModuleLoader.findModule(ModuleLoader.java:452)
        at org.jboss.modules.ModuleLoader.loadModuleLocal(ModuleLoader.java:355)
        at org.jboss.modules.ModuleLoader.preloadModule(ModuleLoader.java:302)
        at org.jboss.modules.Module.addExportedPaths(Module.java:1179)
        at org.jboss.modules.Module.addPaths(Module.java:1071)
        at org.jboss.modules.Module.link(Module.java:1398)
        at org.jboss.modules.Module.relinkIfNecessary(Module.java:1426)
        at org.jboss.modules.ModuleLoader.loadModule(ModuleLoader.java:238)
        at org.wildfly.swarm.container.Container.createServer(Container.java:127)
        at org.wildfly.swarm.container.Container.<init>(Container.java:97)
        at org.wildfly.swarm.container.Container.<init>(Container.java:85)
        at com.acme.example.Main.main(Main.java:16)
    Caused by: org.jboss.modules.xml.XmlPullParserException: Failed to resolve artifact 'org.jboss.msc:jboss-msc:1.2.6.Final' (position: END_TAG seen ...es>\n        <artifact name="org.jboss.msc:jboss-msc:1.2.6.Final"/>... @34:63) 
        at org.jboss.modules.ModuleXmlParser.parseArtifact(ModuleXmlParser.java:756)
        at org.jboss.modules.ModuleXmlParser.parseResources(ModuleXmlParser.java:650)
        at org.jboss.modules.ModuleXmlParser.parseModuleContents(ModuleXmlParser.java:446)
        at org.jboss.modules.ModuleXmlParser.parseDocument(ModuleXmlParser.java:261)
        at org.jboss.modules.ModuleXmlParser.parseModuleXml(ModuleXmlParser.java:148)
        ... 14 more
    Exception in thread "main" org.jboss.modules.ModuleLoadException: Error loading module from modules/org/jboss/msc/main/module.xml
        at org.jboss.modules.ModuleXmlParser.parseModuleXml(ModuleXmlParser.java:150)
        at org.jboss.modules.ModuleXmlParserBridge.parseModuleXml(ModuleXmlParserBridge.java:17)
        at org.wildfly.swarm.bootstrap.modules.BootstrapClasspathModuleFinder.findModule(BootstrapClasspathModuleFinder.java:35)
        at org.jboss.modules.ModuleLoader.findModule(ModuleLoader.java:452)
        at org.jboss.modules.ModuleLoader.loadModuleLocal(ModuleLoader.java:355)
        at org.jboss.modules.ModuleLoader.preloadModule(ModuleLoader.java:302)
        at org.jboss.modules.Module.addExportedPaths(Module.java:1179)
        at org.jboss.modules.Module.addPaths(Module.java:1071)
        at org.jboss.modules.Module.link(Module.java:1398)
        at org.jboss.modules.Module.relinkIfNecessary(Module.java:1426)
        at org.jboss.modules.ModuleLoader.loadModule(ModuleLoader.java:238)
        at org.wildfly.swarm.container.Container.createServer(Container.java:127)
        at org.wildfly.swarm.container.Container.<init>(Container.java:97)
        at org.wildfly.swarm.container.Container.<init>(Container.java:85)
        at com.acme.example.Main.main(Main.java:16)
    Caused by: org.jboss.modules.xml.XmlPullParserException: Failed to resolve artifact 'org.jboss.msc:jboss-msc:1.2.6.Final' (position: END_TAG seen ...es>\n        <artifact name="org.jboss.msc:jboss-msc:1.2.6.Final"/>... @34:63) 
        at org.jboss.modules.ModuleXmlParser.parseArtifact(ModuleXmlParser.java:756)
        at org.jboss.modules.ModuleXmlParser.parseResources(ModuleXmlParser.java:650)
        at org.jboss.modules.ModuleXmlParser.parseModuleContents(ModuleXmlParser.java:446)
        at org.jboss.modules.ModuleXmlParser.parseDocument(ModuleXmlParser.java:261)
    Disconnected from the target VM, address: '127.0.0.1:59226', transport: 'socket'
        at org.jboss.modules.ModuleXmlParser.parseModuleXml(ModuleXmlParser.java:148)
        ... 14 more
    
    Process finished with exit code 1


