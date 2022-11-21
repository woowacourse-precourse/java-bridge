package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";

    private final List<String> bridge;
    private StringBuilder up;
    private StringBuilder down;

    public OutputView(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param nowLocation 현재 출력해야할 다리 순서
     * @param isSucceed 성공여부
     * @param selectedMoving 이동한 칸 ("U" or "D")
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int nowLocation, boolean isSucceed, String selectedMoving) {
        up = new StringBuilder("[");
        down = new StringBuilder("[");

        printPreMap(nowLocation - 1);
        printNowMap(isSucceed, selectedMoving);

        System.out.println(up);
        System.out.println(down);
    }

    private void printPreMap(int nowLocation) {
        for (int i = 0; i < nowLocation; i++) {
            if (bridge.get(i).equals("U")) {
                up.append(" O |");
                down.append("   |");
            }
            if (bridge.get(i).equals("D")) {
                up.append("   |");
                down.append(" O |");
            }
        }
    }

    private void printNowMap(boolean isSucceed, String selectedMoving) {
        upSucceed(isSucceed, selectedMoving);
        upFailed(isSucceed, selectedMoving);
        downSucceed(isSucceed, selectedMoving);
        downFailed(isSucceed, selectedMoving);
    }

    private void upSucceed(boolean isSucceed, String selectedMoving) {
        if (selectedMoving.equals("U") && isSucceed) {
            up.append(" O ]");
            down.append("   ]");
        }
    }

    private void upFailed(boolean isSucceed, String selectedMoving) {
        if (selectedMoving.equals("U") && !isSucceed) {
            up.append(" X ]");
            down.append("   ]");
        }
    }

    private void downSucceed(boolean isSucceed, String selectedMoving) {
        if (selectedMoving.equals("D") && isSucceed) {
            up.append("   ]");
            down.append(" O ]");
        }
    }

    private void downFailed(boolean isSucceed, String selectedMoving) {
        if (selectedMoving.equals("D") && !isSucceed) {
            up.append("   ]");
            down.append(" X ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSucceed, int retryCount) {
        System.out.println("");
        System.out.println(GAME_RESULT);
        System.out.println(up);
        System.out.println(down);
        System.out.println("");

        printIsSucceed(isSucceed, retryCount);
    }

    private void printIsSucceed(boolean isSucceed, int retryCount) {
        if (isSucceed) {
            printSuccess(retryCount);
            return;
        }
        printFail(retryCount);
    }

    private void printSuccess(int retryCount) {
        System.out.println(SUCCESS_OR_FAILURE + SUCCESS);
        System.out.println(TOTAL_TRY_COUNT + (retryCount + 1));
    }

    private void printFail(int retryCount) {
        System.out.println(SUCCESS_OR_FAILURE + FAILURE);
        System.out.println(TOTAL_TRY_COUNT + retryCount);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
