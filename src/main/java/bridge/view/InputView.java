package bridge.view;

import bridge.utils.BridgeSizeValidator;
import bridge.utils.GameCommandValidator;
import bridge.utils.MoveValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.view.ViewEnum.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int getBridgeSize(){
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE.getMessage());
        return readBridgeSize(Console.readLine());
    }

    private static int readBridgeSize(String strBridgeSize){
        try {
            BridgeSizeValidator.checkBridgeSize(strBridgeSize);
            return Integer.parseInt(strBridgeSize);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSize(Console.readLine());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String getMoving() {
        System.out.println(INPUT_USER_MOVE_BRIDGE_MESSAGE.getMessage());
        return readMoving(Console.readLine());
    }

    private static String readMoving(String strMove){
        try {
            MoveValidator.checkMove(strMove);
            return strMove;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMoving(Console.readLine());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String getGameCommand() {
        System.out.println(INPUT_WANT_RE_GAME_MESSAGE.getMessage());
        return readGameCommand(Console.readLine());
    }

    private static String readGameCommand(String gameCommand){
        try{
            GameCommandValidator.checkGameCommand(gameCommand);
            return gameCommand;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readGameCommand(Console.readLine());
        }
    }
}
