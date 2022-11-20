package bridge.exceptions;

public class CustomInternalOperationError extends InternalError {
    public CustomInternalOperationError(String message){
        super(CustomExceptionMessageFormat.apply(message));
    }
}
