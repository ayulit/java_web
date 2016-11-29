import java.io.PrintWriter;
 
public class WriterMessageRenderer implements MessageRenderer {
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;		
	}

    public void printMessage(PrintWriter writer) {
    	writer.println(message);
    }
}
