package bridge.utils;

public class GameCommandValidator {
    public static void checkGameCommand(String s){
        if(!s.equals("R")&&!s.equals("Q")){
            throw new IllegalArgumentException("[ERROR] R이나 Q를 입력해야합니다.");
        }
    }
}
