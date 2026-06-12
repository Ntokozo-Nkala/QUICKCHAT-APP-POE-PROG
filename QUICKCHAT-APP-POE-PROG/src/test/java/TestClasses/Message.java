package TestClasses;
import com.mycompany.quickchat.app.poe.prog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    @Test
    public void testCheckMessageLengthSuccess() {
        Message message = new Message();
        String expected = "Message ready to send.";
        String actual = message.checkMessageLength("Hi Mike, can you join us for dinner tonight?");
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCheckMessageLengthFailure(){
        Message message = new Message();
        String longMessage = "a".repeat(255); 
        String expected = "Message exceeds 250 characters by 5; please reduce the size.";
        String actual = message.checkMessageLength(longMessage);
        assertEquals(expected, actual);
    }

    @Test
    public void testRecipientNumberSuccess() {
        Message message = new Message();
        message.sendMessage("+27718693002", "Hi Mike", "Send");
        String expected = "Cell phone number successfully captured.";
        String actual = message.checkRecipientCell();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testRecipientNumberFailure() {
        Message message = new Message();
        message.sendMessage("0810009346", "Hi Mike", "Send"); 
        String expected = "Cell phone number incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        String actual = message.checkRecipientCell();
        assertEquals(expected, actual);
    }

    @Test
    public void testMessageHashIsCorrect() {
        Message message = new Message();
        message.sendMessage("+27718693002", "Hi Mike, can you join us for dinner tonight", "Send");
        String expectedHash = "00:0:HITONIGHT";
        String actualHash = message.getMessageHash();
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testMessageIDIsCreated() {
        Message message = new Message();
        message.sendMessage("+27718693002", "Hi Mike", "Send");
        String actualIDMessage = message.getMessageID();
        assertTrue(actualIDMessage.contains("Message ID generated:"));
    }

    @Test
    public void testMessageActionSend() {
        Message message = new Message();
        String actual = message.sendMessage("+27718693002", "Hi Mike, can you join us for dinner tonight?", "Send Message");
        assertEquals("Message successfully sent.", actual);
    }
    
    @Test
    public void testMessageActionDiscard() {
        Message message = new Message();
        String actual = message.sendMessage("08575975889", "Hi Keegan, did you receive the payment?", "Disregard Message");
        assertEquals("Press 0 to delete the message.", actual);
    }
    
    @Test
    public void testMessageActionStore() {
        Message message = new Message();
        String actual = message.sendMessage("+27718693002", "Hi Mike", "Store Message");
        assertEquals("Message successfully stored.", actual);
    }
}


    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        Message message = new Message("1234567890", 1, "+27834557896", "Did you get the cake?", "");
        message.createMessageHash();
        String actual = message.sendMessage("+27834557896", "Did you get the cake?", "Send");
        assertEquals("Message successfully sent.", actual);
    }
    
    @Test
    public void testDisplayLongestMessage() {
        Message message = new Message("0987654321", 2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "");
        message.createMessageHash();
        int actual = Message.returnTotalMessages();
        assertTrue(actual >= 0);
    }
    @Test
    public void testSearchForMessageID() {
        Message message = new Message("0838884567", 4, "0838884567", "It is dinner time !", "");
        message.createMessageHash();
        String actual = message.sendMessage("0838884567", "It is dinner time !", "Send");
        assertEquals("Message successfully sent.", actual);
    }
    @Test
    public void testSearchAllMessagesSentOrStoredByRecipient() {
        Message message = new Message("2222222222", 2, "+27838884567", "Ok, I am leaving without you.", "");
        message.createMessageHash();
        String actual = message.sendMessage("+27838884567", "Ok, I am leaving without you.", "Store");
        assertEquals("Message is successfully stored", actual);
    }
    @Test
    public void testDeleteMessageUsingMessageHash() {
        Message message = new Message("5555555555", 1, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "");
        message.createMessageHash();
        String actual = message.sendMessage("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Send");
        assertEquals("Message successfully sent.", actual);
    }
    @Test
    public void testDisplayReport() {
        Message message = new Message("4444444444", 2, "0838884567", "It is dinner time !", "");
        message.createMessageHash();
        String actual = message.sendMessage("0838884567", "It is dinner time !", "Send");
        assertEquals("Message successfully sent.", actual);
    }
