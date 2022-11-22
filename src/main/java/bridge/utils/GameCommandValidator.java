package bridge.utils;

import static bridge.utils.ErrorEnum.GAME_COMMAND_NOT_Q_OR_R;

public class GameCommandValidator {
    private final static String reGame="R";
    private final static String quiteGame="Q";

    public static void checkGameCommand(String s){
        if(!s.equals(reGame)&&!s.equals(quiteGame)){
            throw new IllegalArgumentException(GAME_COMMAND_NOT_Q_OR_R.getMessage());
        }
    }
}
