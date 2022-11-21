package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String UP = "U";
    private static final String DOWN = "D";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int location, boolean isSuccess) {
        List<String> up = getBridgeShape(bridge, UP, location);
        List<String> down = getBridgeShape(bridge, DOWN, location);

        if (isSuccess) {
            foward(up, down, bridge.get(location));
        }
        if (!isSuccess) {
            wrongFoward(up, down, bridge.get(location));
        }
        System.out.println(up);
        System.out.println(down);
    }

    private void wrongFoward(List<String> up, List<String> down, String location) {
        if (location.equals(UP)) {
            up.add("X");
            down.add(" ");
            return;
        }
        if (location.equals(DOWN)) {
            down.add("X");
            up.add(" ");
            return;
        }
    }

    private void foward(List<String> up, List<String> down, String location) {
        if (location.equals(UP)) {
            up.add("O");
            down.add(" ");
            return;
        }
        if (location.equals(DOWN)) {
            down.add("O");
            up.add(" ");
            return;
        }
    }

    private List<String> getBridgeShape(List<String> bridge, String direction, int location) {
        List<String> bridgeShape = new ArrayList<>();
        for (int i = 0; i <location; i++) {
            if (bridge.get(i).equals(direction)) {
                bridgeShape.add("O");
            }
            if(bridge.get(i).equals(direction)) {
                bridgeShape.add(" ");
            }
        }
        return bridgeShape;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
