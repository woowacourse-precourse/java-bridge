package bridge.utils;

import bridge.MODEnum;

import static bridge.MODEnum.QUIT_GAME;
import static bridge.MODEnum.RE_GAME;
import static bridge.utils.ErrorEnum.GAME_COMMAND_NOT_Q_OR_R;

public class GameCommandValidator {
    public static void checkGameCommand(String s){
        if(!s.equals(RE_GAME.getMessage())&&!s.equals(QUIT_GAME.getMessage())){
            throw new IllegalArgumentException(GAME_COMMAND_NOT_Q_OR_R.getMessage());
        }
    }
}
