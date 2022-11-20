package bridge.exception;

public class GameCommandException extends Exceptions{
    public String validate(String input){
        return null;
    }

    private boolean isNotRestart(String input){
        return false;
    }

    private boolean notGivenOpinionException(String input){
        return false;
    }

    private void notBridgeLengthException(){

    }
}
