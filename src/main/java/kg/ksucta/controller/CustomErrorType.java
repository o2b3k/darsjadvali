package kg.ksucta.controller;

/**
 * Created by o2b3k on 5/25/17.
 */
public class CustomErrorType {
    private String errorMessage;

    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
