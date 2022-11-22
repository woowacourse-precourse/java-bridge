package bridge;

public class Exception {
    public static final int ZERO_ASCII = 48;
    public static final int NINE_ASCII = 57;

    public static final String INPUT_IS_NOT_NUM_EXCEPTION_MESSAGE = "[ERROR] 다리 길이는 숫자여야 합니다.";
    public static final String BRIDGE_SIZE_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String MOVING_STRING_EXCEPTION_MESSAGE = "[ERROR] 이동 시 위 칸은 대문자 U, 아래 칸은 대문자 D여야 합니다.";
    public static final String GAME_COMMAND_STRING_EXCEPTION_MESSAGE = "[ERROR] 재시작은 대문자 R, 종료는 대문자 Q여야 합니다.";

    public static OutputView outputView = new OutputView();

    public static void checkInputIsNum(String input){
        for(int index = 0; index < input.length(); ++index)
            if(input.charAt(index) > NINE_ASCII || input.charAt(index) < ZERO_ASCII){
                outputView.printExceptionMessage(INPUT_IS_NOT_NUM_EXCEPTION_MESSAGE);
                throw new IllegalArgumentException(INPUT_IS_NOT_NUM_EXCEPTION_MESSAGE);
            }
    }

    public static void checkBridgeSizeRange(int number){
        if(number < 3 || number > 20){
            outputView.printExceptionMessage(BRIDGE_SIZE_OUT_OF_RANGE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public static void checkMovingString(String moving){
        if(!moving.equals("U") && !moving.equals("D")){
            outputView.printExceptionMessage(MOVING_STRING_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(MOVING_STRING_EXCEPTION_MESSAGE);
        }
    }

    public static void checkGameCommandString(String gameCommand){
        if(!gameCommand.equals("R") && !gameCommand.equals("Q")){
            outputView.printExceptionMessage(GAME_COMMAND_STRING_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException(GAME_COMMAND_STRING_EXCEPTION_MESSAGE);
        }
    }
}
