package nl.rokase.blond.parent;

import nl.rokase.blond.parent.mdb.ItemProducer;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @Inject
    private ItemProducer producer;

    @GET
    public String sayHello() {
        producer.sendEvent("Message driven bean");
        return "Hello World";
    }
}
