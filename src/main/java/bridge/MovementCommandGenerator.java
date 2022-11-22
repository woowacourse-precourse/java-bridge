package bridge;

public class MovementCommandGenerator {

    private static final String CODE_FORMAT_ERRER_MSG = " 허용 입력은 (위: U, 아래: D) 입니다";

    public static String generate(String movement_command){
        validate(movement_command);
        return movement_command;
    }

    private static void validate(String movement_command){
        if(Site.UP.isSameCommand(movement_command) || Site.DOWN.isSameCommand(movement_command)) return;
        throw new IllegalArgumentException(CODE_FORMAT_ERRER_MSG);
    }
}
