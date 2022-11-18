package bridge;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String RANGE_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public void bridgeLengthRange(int bridgeLength){
        if(bridgeLength<3||bridgeLength>20){
            throw new IllegalArgumentException(ERROR_MESSAGE+RANGE_MESSAGE);
        }
    }
}
