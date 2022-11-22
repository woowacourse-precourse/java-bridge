package bridge.view;

import bridge.status.PassOrNot;

import java.util.List;

import static bridge.game.BridgeGame.down;
import static bridge.game.BridgeGame.up;
import static bridge.view.TemplateLetters.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final int UP_LIST = 0;
    private static final int DOWN_LIST = 1;
    GameMapMaker gameMapMaker = new GameMapMaker();

    public void printMap(PassOrNot result, String input, int index) {
        List<String> list = gameMapMaker.makeMap(result, input, index);
        String upList = list.get(UP_LIST);
        String downList = list.get(DOWN_LIST);

        System.out.println(upList);
        System.out.println(downList);
    }

    public void printResult() {
        String upJoin = String.join("", up);
        String downJoin = String.join("", down);

        System.out.println(upJoin + END.getValue());
        System.out.println(downJoin + END.getValue());
    }
}
