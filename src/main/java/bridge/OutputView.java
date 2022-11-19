package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final List<String> bridge;

    public OutputView(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int nowLocation, boolean isSucceed, String selectedMoving) {
        StringBuilder up = new StringBuilder("[");
        StringBuilder down = new StringBuilder("[");
        for (int i = 0; i < nowLocation; i++) {
            // 최근
            if (nowLocation -1 == i) {
                if (selectedMoving.equals("U")) {
                    if (isSucceed) {
                        up.append(" O ]");
                        down.append("   ]");
                    } else {
                        up.append(" X ]");
                        down.append("   ]");
                    }
                } else {
                    if (isSucceed) {
                        up.append("   ]");
                        down.append(" O ]");
                    } else {
                        up.append("   ]");
                        down.append(" X ]");
                    }
                }
            } else {
                if (bridge.get(i).equals("U")) {
                    up.append(" O |");
                    down.append("   |");
                } else {
                    up.append("   |");
                    down.append(" O |");
                }
            }
        }
        System.out.println(up);
        System.out.println(down);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
