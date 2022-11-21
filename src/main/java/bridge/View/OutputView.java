package bridge.View;


import bridge.PassFail;
import bridge.UpDown;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.BridgeGame.down;
import static bridge.BridgeGame.up;
import static bridge.View.TemplateLetters.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(PassFail result, String input, int index) {

        if (Objects.equals(input, UpDown.UP.getValue())) {
            if (index == 0) { // 첫 칸
                up.add(START.getValue());
                up.add(result.getValue());
                down.add(START.getValue());
                down.add(BLANK.getValue());
            }
            if (index != 0) {
                up.add(MIDDLE.getValue()); // 중간과 마지막
                up.add(result.getValue());
                down.add(MIDDLE.getValue());
                down.add(BLANK.getValue());
            }
        }
        if (Objects.equals(input, UpDown.DOWN.getValue())) {
            if (index == 0) { // 첫 칸
                up.add(START.getValue());
                up.add(BLANK.getValue());
                down.add(START.getValue());
                down.add(result.getValue());
            }
            if (index != 0) {
                up.add(MIDDLE.getValue()); // 중간과 마지막
                up.add(BLANK.getValue());
                down.add(MIDDLE.getValue());
                down.add(result.getValue());
            }
        }
        String upJoin = String.join("", up);
        String downJoin = String.join("", down);

        //프린트 하는 기능은 이거 두개고, 위에는 리스트 형식에 맞게 만드는 기능이네.
        System.out.println(upJoin + END.getValue());
        System.out.println(downJoin + END.getValue());
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
