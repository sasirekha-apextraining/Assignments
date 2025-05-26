package assign.dbaccess;

 
/**
 * 
 * EMailValidationException
 *
 */

public class EMailValidationException extends Exception{


	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	/**
	 * No Argument Constructor
	 */
	public EMailValidationException(String inErrorMessage){
		errorMessage = inErrorMessage;
	}
	public void setErrorMessage(String inErrorMessage){
		errorMessage = inErrorMessage;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
}
 
