package com.acme.example;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.jaxrs.JAXRSFraction;
import org.wildfly.swarm.messaging.MessagingFraction;
import org.wildfly.swarm.messaging.MessagingServer;

/**
 * Created by ppilgrim on 13-Oct-2015.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Container container = new Container();

        container.subsystem(new MessagingFraction()
                .server(
                    new MessagingServer()
                        .enableInVMConnector()
                        .topic("my-topic")
                        .queue("my-queue")
                )
        );

        // Start the container
        container.start();

        JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);
        archive.addResource(MyResource.class);
        archive.addResource(MyApplication.class);

        // Deploy your JAX-RS app
        container.deploy(archive);
    }
}
