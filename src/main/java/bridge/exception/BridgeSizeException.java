package bridge.exception;

public class BridgeSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR]다리길이는 3보다 작거나 20보다 클 수 없습니다. : %d ";

    public BridgeSizeException(int size){
        super(String.format(ERROR_MESSAGE,size));
    }
}
