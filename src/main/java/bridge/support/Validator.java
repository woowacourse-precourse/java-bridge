package bridge.support;

import java.util.List;

public class Validator {
    private static final int START_RANGE=3;
    private static final int END_RANGE=20;
    private static final List<String> MOVE_TYPE=List.of("U","D") ;
    private static final List<String> COMMAND_TYPE=List.of("R","Q") ;
    private static final String COMMON_ERROR_MESSAGE="[ERROR] ";
    public static void checkInteger(String target){
        if(!target.matches("[0-9]+")){
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE+"숫자를 입력해야 합니다.");
        }
    }
    public static void checkRange(String target){
        int temp=Integer.parseInt(target);
        if(temp<START_RANGE||temp>END_RANGE){
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE+"3부터 20사이의 숫자여야 합니다.");
        }
    }
    public static void checkMoveAlphabet(String target){
        if(!MOVE_TYPE.contains(target)){
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE+MOVE_TYPE.get(0)+", "
            +MOVE_TYPE.get(1)+" 중 하나를 입력해야 합니다.");
        }
    }
    public static void checkCommandAlphabet(String target){
        if(!COMMAND_TYPE.contains(target)){
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE+COMMAND_TYPE.get(0)+", "
                    +COMMAND_TYPE.get(1)+" 중 하나를 입력해야 합니다.");
        }
    }
}
