package bridge.exception;

public class BridgeException {
    private static final String REGEX_BRIDGE = "^[0-9]+$";
    private static final String REGEX_MOVING = "^U|D$";
    private static final String REGEX_RESTART = "^R|Q$";

    public void validateBridgeSizeFormat(String size) {
        if(!size.matches(REGEX_BRIDGE)) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_FORMAT_ERROR);
        }
    }

    public void validateBridgeSizeLange(String size) {
        if(Integer.parseInt(size) < 3 || Integer.parseInt(size) > 20){
            throw new IllegalArgumentException(ErrorMessage.SIZE_LANGE_ERROR);
        }
    }

    public void validateMove(String moving){
        if(!moving.matches(REGEX_MOVING)){
            throw new IllegalArgumentException(ErrorMessage.MOVING_ERROR);
        }
    }

    public void validateRestart(String restart){
        if(!restart.matches(REGEX_RESTART)){
            throw new IllegalArgumentException(ErrorMessage.RESTART_ERROR);
        }
    }
}
