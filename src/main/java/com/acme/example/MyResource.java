package com.acme.example;

import javax.security.auth.login.LoginException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Date;

/**
 * Created by ppilgrim on 13-Oct-2015.
 */
public class MyResource {

    @Path("/hello")
    @Produces("text/plain")
    public String hello() {
        return "Hello WildFly Swarm "+new Date()+"  JDK class: "+ LoginException.class.getName();
    }
}
