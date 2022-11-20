package bridge.view;

import bridge.model.Bridge;
import bridge.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int position, boolean success, Bridge bridge) {
        List<String> upSide = new ArrayList<>();
        List<String> down = new ArrayList<>();
        for (int index = 0; index < position; index++) {
            if (bridge.getShape(index).equals("U")) {
                upSide.add(Constant.SUCCESS);
                down.add(Constant.BLANK);
            }
            if (bridge.getShape(index).equals("D")) {
                upSide.add(Constant.BLANK);
                down.add(Constant.SUCCESS);
            }
        }
        if (success) {
            if (bridge.getShape(position).equals("U")) {
                upSide.add(Constant.SUCCESS);
                down.add(Constant.BLANK);
            }
            if (bridge.getShape(position).equals("D")) {
                upSide.add(Constant.BLANK);
                down.add(Constant.SUCCESS);
            }
        }
        if (!success) {
            if (bridge.getShape(position).equals("U")) {
                upSide.add(Constant.BLANK);
                down.add(Constant.FAIL);
            }
            if (bridge.getShape(position).equals("D")) {
                upSide.add(Constant.FAIL);
                down.add(Constant.BLANK);
            }
        }
        String upSideRepresentation = upSide.toString().replace(", ", "|");
        String downRepresentation = down.toString().replace(", ", "|");

        System.out.println(upSideRepresentation);
        System.out.println(downRepresentation);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
