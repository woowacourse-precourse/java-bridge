package bridge;

public interface Exception {
    public final int ZERO_ASCII = 48;
    public final int NINE_ASCII = 57;

    public final String INPUT_IS_NOT_NUM_EXCEPTION_MESSAGE = "[ERROR] 다리 길이는 숫자여야 합니다.";
    public final String BRIDGE_SIZE_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    
    public static void checkInputIsNum(String input){
        for(int index = 0; index < input.length(); ++index)
            if(input.charAt(index) > NINE_ASCII || input.charAt(index) < ZERO_ASCII)
                throw new IllegalArgumentException(INPUT_IS_NOT_NUM_EXCEPTION_MESSAGE);
    }

    public static void checkBridgeSizeRange(int number){
        if(number < 3 || number > 20)
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE_EXCEPTION_MESSAGE);
    }
}
