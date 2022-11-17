package view;

import java.util.List;

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

    public void printResult(List<String> upSide, List<String> downSide, int countTryNumber) {
        printFinalResult();
        printMap(upSide, downSide);

        if (upSide.contains("X") || downSide.contains("X")) {
            printFail(countTryNumber);
        }

        if (!upSide.contains("X") && !downSide.contains("X")) {
            printWin(countTryNumber);
        }
    }

    public void printFail(int countTryNumber) {
        System.out.print(View.WIN_FAIL_STATUS.message());
        System.out.println("실패");

        System.out.print(View.TOTAL_TRY_NUMBER.message());
        System.out.println(countTryNumber);
    }

    public void printWin(int countTryNumber) {
        System.out.print(View.WIN_FAIL_STATUS.message());
        System.out.print(View.BLANK.message());
        System.out.println("성공");

        System.out.print(View.TOTAL_TRY_NUMBER.message());
        System.out.print(View.BLANK.message());
        System.out.println(countTryNumber);
    }

    public void insertLineBreak() {
        System.out.println();
    }
}
