package bridge.view;

import static bridge.constant.message.InputMessage.ENTER_LENGTH_OF_BRIDGE;
import static bridge.constant.message.InputMessage.RETRY_OR_QUIT;
import static bridge.constant.message.InputMessage.SELECT_WHERE_TO_MOVE;
import static bridge.constant.message.OutputMessage.START_OF_GAME;

import bridge.Map;
import java.util.List;

public class OutputView {

    public void printMap(List<String> upSide, List<String> downSide, Map map) {
        System.out.println(map.format(upSide));
        System.out.println(map.format(downSide));
        System.out.println();
    }

    public void printStartOfGame() {
        System.out.println(START_OF_GAME.getMessage());
    }

    public void printBridgeSizeInput() {
        System.out.println();
        System.out.println(ENTER_LENGTH_OF_BRIDGE.getMessage());
    }

    public void printMovingInput() {
        System.out.println(SELECT_WHERE_TO_MOVE.getMessage());
    }

    public void printGameCommandInput() {
        System.out.println(RETRY_OR_QUIT.getMessage());
    }
}
