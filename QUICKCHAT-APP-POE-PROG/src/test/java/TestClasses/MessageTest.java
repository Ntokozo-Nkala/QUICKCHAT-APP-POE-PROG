package TestClasses;
import com.mycompany.quickchat.app.poe.prog.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    @Test
    public void testSentMessagesArrayCorrectlyPopulated(){
        Message message = new Message();
        String expected = "Message successfully sent.";
        String Actual = message.sendMessage("+2783455786", "Did you get the cake?", "Send");
        assertEquals(expected, Actual, "Message successfully sent.");
    }

    @Test
    public void testSentMessagesArrayCorrectlyPopulatedButFail(){
        Message message = new Message();
        String expected = "Message disregarded";
        String Actual = message.sendMessage("+2783455786", "Did you get the cake?", "Send");
        assertNotEquals(expected, Actual, "Message successfully sent.");
    }

    @Test
    public void testDisplayTheLongestMessage(){
        Message message = new Message();
        String expected = "Message is successfully stored";
        String Actual = message.sendMessage("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Store");
        assertEquals(expected, Actual, "Message is successfully stored");
    }

    @Test
    public void testDisplayTheLongestMessageButFail(){
        Message message = new Message();
        String expected = "Message is successfully stored";
        String Actual = message.sendMessage("+2783455786", "Did you get the cake?", "Discard");
        assertNotEquals(expected, Actual, "Message is successfully stored");
    }

    @Test
    public void testSearchForMessageID(){
        Message message = new Message();
        String expected = "Message successfully sent.";
        String Actual = message.sendMessage("+27834484567", "It is dinner time !", "Send");
        assertEquals(expected, Actual, "Message successfully sent.");
    }

    @Test
    public void testSearchForMessageIDButFail(){
        Message message = new Message();
        String expected = "Invalid action";
        String Actual = message.sendMessage("+27834484567", "It is dinner time !", "Send");
        assertNotEquals(expected, Actual, "Invalid action");
    }

    @Test
    public void testSearchRecipient(){
        Message message = new Message();
        String expected = "Message is successfully stored";
        String Actual = message.sendMessage("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Store");
        assertEquals(expected, Actual, "Message is successfully stored");
    }

    @Test
    public void testSearchRecipientButFail() {
        Message message = new Message();
        String expected = "Message successfully sent.";
        String Actual = message.sendMessage("+2783455786", "Did you get the cake?", "Store");
        assertNotEquals(expected, Actual, "Message successfully sent.");
    }

    @Test
    public void testDeleteMessageUsingMessageHash(){
        Message message = new Message();
        String expected = "Invalid action";
        String Actual = message.sendMessage("+27838884567", "Where are you?", "Diregard");
        assertEquals(expected, Actual, "Invalid action");
    }

    @Test
    public void testDeleteMessageUsingMessageHashButFail(){
        Message message = new Message();
        String expected = "Message successfully sent.";
        String Actual = message.sendMessage("+27838884567", "Where are you?", "Disregard");
        assertNotEquals(expected, Actual, "Message successfully sent.");
    }

    @Test
    public void testDisplayReport(){
        Message message = new Message();
        String expected = "Message successfully sent.";
        String Actual = message.sendMessage("+2783455786", "Did you get the cake?", "Send");
        assertEquals(expected, Actual, "Message successfully sent.");
    }

    @Test
    public void testCheckMessageLength(){
        Message message = new Message();
        String expected = "Message ready to send.";
        String Actual = message.checkMessageLength("It is dinner time !");
        assertEquals(expected, Actual, "Message ready to send.");
    }

    @Test
    public void testCheckMessageLengthButFail(){
        Message message = new Message();
        String expected = "Message cannot be empty.";
        String Actual = message.checkMessageLength("It is dinner time !");
        assertNotEquals(expected, Actual, "Message cannot be empty.");
    }
}
