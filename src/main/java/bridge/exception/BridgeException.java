package bridge.exception;

public class BridgeException {
    private static final String REGEX = "^[0-9]+";
    public static final String SIZE_FORMAT_ERROR = "[ERROR] 다리 길이는 숫자만 입력 가능합니다.";
    public static final String SIZE_LANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String MOVING_ERROR = "[ERROR] 이동할 칸은 대문자 U와 대문자 D만 입력 가능합니다.";
    public static final String RESTART_ERROR = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자만 입력가능 합니다.";

    public void validateBridgeSizeFormat(String size) {
        if(!size.matches(REGEX)) {
            throw new IllegalArgumentException(SIZE_FORMAT_ERROR);
        }
    }
    public void validateBridgeSizeLange(String size) {
        if(Integer.parseInt(size) < 3 || Integer.parseInt(size) > 20){
            throw new IllegalArgumentException(SIZE_LANGE_ERROR);
        }
    }

    public void validateMove(String moving){
        if(!moving.equals("U")&&!moving.equals("D")){
            throw new IllegalArgumentException(MOVING_ERROR);
        }
    }
    public void validateRestart(String restart){
        if(!restart.equals("R") && !restart.equals("Q")){
            throw new IllegalArgumentException(RESTART_ERROR);
        }
    }
}
