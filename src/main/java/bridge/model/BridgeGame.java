package bridge.model;

import java.util.List;

import static bridge.controller.BridgeController.upAndDown;

public class BridgeGame {

    public int move(List<String> bridges, int count, String inputMoving) {

        if (inputMoving.equals("U") && bridges.get(count).equals("U")) {
            isUAndU();
            return count;
        }
        return getCountNotUAndU(bridges, count, inputMoving);
    }

    private int getCountNotUAndU(List<String> bridges, int count, String inputMoving) {
        if (inputMoving.equals("U") && bridges.get(count).equals("D")) {
            isUAndD();
            return 21;
        }
        return getCountNotUAndD(bridges, count, inputMoving);
    }

    private int getCountNotUAndD(List<String> bridges, int count, String inputMoving) {
        if (inputMoving.equals("D") && bridges.get(count).equals("D")) {
            isDAndD();
        }
        if (inputMoving.equals("D") && bridges.get(count).equals("U")) {
            isDAndU();
            count = 21;
        }
        return count;
    }

    private void isDAndU() {
        upAndDown.get(0).add("   ");
        upAndDown.get(0).add("|");
        upAndDown.get(1).add(" X ");
        upAndDown.get(1).add("|");
    }

    private void isDAndD() {
        upAndDown.get(0).add("   ");
        upAndDown.get(0).add("|");
        upAndDown.get(1).add(" O ");
        upAndDown.get(1).add("|");
    }

    private void isUAndD() {
        upAndDown.get(0).add(" X ");
        upAndDown.get(0).add("|");
        upAndDown.get(1).add("   ");
        upAndDown.get(1).add("|");
    }

    private void isUAndU() {
        upAndDown.get(0).add(" O ");
        upAndDown.get(0).add("|");
        upAndDown.get(1).add("   ");
        upAndDown.get(1).add("|");
    }

        /**
         * 사용자가 게임을 다시 시도할 때 사용하는 메서드
         * <p>
         * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
         */
    public void retry() {
    }
}
