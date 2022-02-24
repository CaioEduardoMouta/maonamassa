import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;



@Named
@ViewScoped
public class IndexBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "Woooooorking";
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
