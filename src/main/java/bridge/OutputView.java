package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void printStart() {
        System.out.println(View.START_GAME.message());
        insertLineBreak();
    }

    public void printRequestBridgeSize() {
        System.out.println(View.REQUEST_BRIDGE_SIZE.message());
    }

    public void printBridgeSize(int size) {
        System.out.println(size);
        insertLineBreak();
    }

    public void printRequestMove() {
        System.out.println(View.REQUEST_MOVE.message());
    }

    public void printUserPath(String path) {
        System.out.println(path);
    }

    public void printRequestRetryOrQuit() {
        System.out.println(View.REQUEST_RETRY_OR_QUIT.message());
    }

    public void printUserRetryOrQuit(String retryOrQuit) {
        System.out.println(retryOrQuit);
    }

    public void printFinalResult() {
        System.out.println(View.FINAL_RESULT.message());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upSide, List<String> downSide) {
        System.out.print("[ ");
        for (int i = 0; i < upSide.size(); i++) {
            System.out.print(upSide.get(i));
            if (i != upSide.size() - 1 && upSide.size() > 1) {
                System.out.print(" | ");
            }

        }
        System.out.println(" ]");

        System.out.print("[ ");
        for (int i = 0; i < downSide.size(); i++) {
            System.out.print(downSide.get(i));
            if (i != downSide.size() - 1 && upSide.size() > 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
        insertLineBreak();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> upSide, List<String> downSide, int countTryNumber) {
        printFinalResult();
        printMap(upSide, downSide);

        if (upSide.contains("X") || downSide.contains("X")) {
            System.out.print(View.WIN_FAIL_STATUS.message());
            System.out.println("실패");

            System.out.print(View.TOTAL_TRY_NUMBER.message());
            System.out.println(countTryNumber);
        }

        if (!upSide.contains("X") && !downSide.contains("X")) {
            System.out.print(View.WIN_FAIL_STATUS.message());
            System.out.print(View.BLANK.message());
            System.out.println("성공");

            System.out.print(View.TOTAL_TRY_NUMBER.message());
            System.out.print(View.BLANK.message());
            System.out.println(countTryNumber);
        }
    }

    public void insertLineBreak() {
        System.out.println();
    }
}
