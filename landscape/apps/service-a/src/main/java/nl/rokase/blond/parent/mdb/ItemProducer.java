package nl.rokase.blond.parent.mdb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

@ApplicationScoped
public class ItemProducer {

    public static final String TOPIC_NAME = "items";

    @Inject
    @JMSConnectionFactory("java:/jms/remote-mq")
    private JMSContext context;

    public void sendEvent(String name) {
        Topic topic = context.createTopic(TOPIC_NAME);
        context.createProducer().send(topic, "Hello "+name+"!");
    }
}
