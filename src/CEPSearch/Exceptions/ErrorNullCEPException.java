package CEPSearch.Exceptions;

public class ErrorNullCEPException extends RuntimeException{
    private String message;

    public ErrorNullCEPException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
