package bridge.exception;

public class CommandException {
    private final static String UP = "U";
    private final static String DOWN = "D";
    private final static String RETRY = "R";
    private final static String QUIT = "Q";
    private final static String ONLY_CHAR = "[a-z][A-Z]";
    private final static String ERROR = "[ERROR] ";

    public void isValidMove(String command){
        isSingle(command);
        isCharacter(command);
        isMove(command);
    }

    public void isValidDecision(String command){
        isNull(command);
        isSingle(command);
        isCharacter(command);
        isDecision(command);
    }

    public void isNull(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException(ERROR + "입력값이 비었습니다.");
        }
    }

    public static void isSingle(String command){
        if(command.length() != 1){
            throw new IllegalArgumentException(ERROR + "하나의 문자만 입력해주세요");
        }
    }

    public static void isCharacter(String command){
        if(!command.matches(ONLY_CHAR)){
            throw new IllegalArgumentException(ERROR + "문자를 입력해주세요.");
        }
    }

    public static void isMove(String command){
        if(!command.equals(UP) && !command.equals(DOWN)){
            throw new IllegalArgumentException(ERROR + "위: U, 아래: D");
        }
    }

    public static void isDecision(String command){
        if(!command.equals(RETRY) && !command.equals(QUIT)){
            throw new IllegalArgumentException(ERROR + "재시도: R, 종료: Q");
        }
    }


}
