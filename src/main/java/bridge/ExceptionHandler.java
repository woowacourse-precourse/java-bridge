package bridge;

public class ExceptionHandler {
    private static final String ERROR_HEAD = "[ERROR] ";
    private static final String ERROR_SIZE = "다리 길이는 3부터 20 사이의 정수여야 합니다.";
    private static final String ERROR_MOVE = "이동 가능한 방향은 U 또는 D여야 합니다.";
    private static final String ERROR_COMMAND = "입력 값은 R(Restart) 또는 Q(Quit) 여야 합니다.";

    public static String ERROR_HEAD(){return ERROR_HEAD;}

    public Integer validBridgeSize(String size){
        int newSize = excParseInt(size);
        if(newSize < 3 || newSize > 20) throw new IllegalArgumentException(ERROR_SIZE);
        return newSize;
    }

    public String validMoving(String move){
        if(move != "U" && move != "D") throw new IllegalArgumentException(ERROR_MOVE);
        return move;
    }

    public String validGameCommand(String command){
        if(command != "R" && command != "Q") throw new IllegalArgumentException(ERROR_COMMAND);
        return command;
    }

    public static Integer excParseInt(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

}
