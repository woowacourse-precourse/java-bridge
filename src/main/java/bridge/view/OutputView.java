package bridge.view;

import bridge.domain.Player;
import bridge.domain.Result;
import bridge.util.MessageConstant;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(Result result) {
        System.out.println(result.makeUpStairsMessage());
        System.out.println(result.makeDownStairsMessage());
    }
    
    public void printResult(Player player, Result result, String message) {
        System.out.println(MessageConstant.TOTAL_RESULT.getValue());
        printMap(result);
        System.out.println(MessageConstant.SUCCESS_OR_NOT.getValue() + message);
        System.out.println(MessageConstant.TRY_COUNT.getValue() + player.getTryGameCount());
    }

    public void printStartMessage() {
        System.out.println(MessageConstant.START_GAME.getValue());
    }

    public void printInputLengthMessage() {
        System.out.println(MessageConstant.INPUT_BRIDGE_LENGTH.getValue());
    }

    public void printSelectDirectionMessage() {
        System.out.println(MessageConstant.SELECT_DIRECTION.getValue());
    }

    public void printSelectAgainMessage() {
        System.out.println(MessageConstant.ERROR_INPUT_GAME_CONTINUOUS.getValue());
    }
}
