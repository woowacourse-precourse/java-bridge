package bridge.exception;

public class BridgeIllegalArgumentException extends IllegalArgumentException{

    private final static String ERROR_PREFIX = "[ERROR] ";

    public BridgeIllegalArgumentException(String errorMessage){
        super(ERROR_PREFIX + errorMessage);
        System.out.println(super.getMessage());
    }

}
