import java.io.PrintWriter;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.i18n.LocaleContextHolder;
 
public class WriterMessageRenderer implements MessageRenderer, MessageSourceAware {
		
	private MessageSource  messageSource;
	
	public void setMessageSource(MessageSource  messageSource) {
		this.messageSource = messageSource;		
	}

    public void printMessage(PrintWriter writer) {
    	writer.println(messageSource.getMessage("msg", null, LocaleContextHolder.getLocale()));
    }
}
