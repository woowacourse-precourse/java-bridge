package bridge.view;

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
}
