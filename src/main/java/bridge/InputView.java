package bridge;

import bridge.ErrorResource;
import bridge.UserCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        String bridgeSize = Console.readLine();
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String userMove = Console.readLine();
        validateUserMove(userMove);
        return userMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String replayGame = Console.readLine();
        validateGameCommand(replayGame);
        return replayGame;
    }
    public static void validateUserMove(String userMove){
        if(!userMove.equals(UserCommand.MOVE_UP.getCommand())&&
                !userMove.equals(UserCommand.MOVE_DOWN.getCommand())){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.INPUT_MOVE_WRONG_FRONT+
                    UserCommand.MOVE_UP.getCommand()+ErrorResource.OR+UserCommand.MOVE_DOWN.getCommand()+
                    ErrorResource.INPUT_SHOULD_BACK);
        }
    }
    public static void validateGameCommand(String replayGame){
        if(!replayGame.equals(UserCommand.REPLAY.getCommand())&&
                !replayGame.equals(UserCommand.END.getCommand())){
            throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.INPUT_REPLAY_FRONT+
                    UserCommand.REPLAY.getCommand()+ErrorResource.OR+UserCommand.END.getCommand()+
                    ErrorResource.INPUT_SHOULD_BACK);
        }
    }
}
