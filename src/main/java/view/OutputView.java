package view;

import constant.StringConstant;
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
        printStartSquareBracket();
        printSide(upSide);
        printEndSquareBracket();

        printStartSquareBracket();
        printSide(downSide);
        printEndSquareBracket();

        insertLineBreak();
    }

    public void printSide(List<String> side) {
        for (int index = 0; index < side.size(); index++) {
            System.out.print(side.get(index));
            if (index < lastIndex(side)) {
                printDelimeter();
            }
        }
    }

    public void printResult(List<String> upSide, List<String> downSide, int countTryNumber) {
        printFinalResult();
        printMap(upSide, downSide);

        if (isWin(upSide, downSide)) {
            printWin(countTryNumber);
        }
        if (isFail(upSide, downSide)) {
            printFail(countTryNumber);
        }
    }

    public int lastIndex(List<String> side) {
        return (side.size() - 1);
    }

    public void printStartSquareBracket() {
        System.out.print(StringConstant.START_SQUARE_BRACKET.getConstant());
    }

    public void printDelimeter() {
        System.out.print(StringConstant.DELIMETER.getConstant());
    }

    public void printEndSquareBracket() {
        System.out.println(StringConstant.END_SQUARE_BRACKET.getConstant());
    }

    public boolean isWin(List<String> upSide, List<String> downSide) {
        return !upSide.contains(StringConstant.WRONG_PATH.getConstant())
                && !downSide.contains(StringConstant.WRONG_PATH.getConstant());
    }

    public boolean isFail(List<String> upSide, List<String> downSide) {
        return upSide.contains(StringConstant.WRONG_PATH.getConstant())
                || downSide.contains(StringConstant.WRONG_PATH.getConstant());
    }

    public void printWin(int countTryNumber) {
        System.out.print(View.WIN_FAIL_STATUS.message());
        System.out.print(View.BLANK.message());
        System.out.println(StringConstant.WIN.getConstant());

        System.out.print(View.TOTAL_TRY_NUMBER.message());
        System.out.print(View.BLANK.message());
        System.out.println(countTryNumber);
    }

    public void printFail(int countTryNumber) {
        System.out.print(View.WIN_FAIL_STATUS.message());
        System.out.print(View.BLANK.message());
        System.out.println(StringConstant.FAIL.getConstant());

        System.out.print(View.TOTAL_TRY_NUMBER.message());
        System.out.print(View.BLANK.message());
        System.out.println(countTryNumber);
    }

    public void insertLineBreak() {
        System.out.println();
    }
}
