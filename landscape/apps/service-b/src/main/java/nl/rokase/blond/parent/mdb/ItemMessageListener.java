package nl.rokase.blond.parent.mdb;

import org.jboss.ejb3.annotation.ResourceAdapter;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@ResourceAdapter("remote-connection-factory")
@MessageDriven(name = "MyItemMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = ItemMessageListener.TOPIC_NAME),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
})
public class ItemMessageListener implements javax.jms.MessageListener {

    public static final String TOPIC_NAME = "items";

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("received: " + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
