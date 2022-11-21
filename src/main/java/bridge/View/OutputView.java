package bridge.View;

import bridge.GameMapMaker;
import bridge.PassOrNot;

import java.util.List;

import static bridge.View.TemplateLetters.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final int UP_LIST = 0;
    private static final int DOWN_LIST = 1;

    GameMapMaker gameMapMaker = new GameMapMaker();
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(PassOrNot result, String input, int index) {
        List<String> list = gameMapMaker.makeMap(result, input, index);
        String upList = list.get(UP_LIST);
        String downList = list.get(DOWN_LIST);

        System.out.println(upList);
        System.out.println(downList);
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> up, List<String> down) {
        String upJoin = String.join("", up);
        String downJoin = String.join("", down);

        System.out.println(upJoin + END.getValue());
        System.out.println(downJoin + END.getValue());
    }
}
