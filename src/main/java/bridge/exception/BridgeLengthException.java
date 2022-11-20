package bridge.exception;

public class BridgeLengthException extends Exceptions{
    public int validate(String input){
        return 1;
    }

    private boolean isNotNumber(String input){
        return false;
    }

    private boolean isOutOfRange(String input){
        return false;
    }

    private void notBridgeLengthException(){

    }
}
