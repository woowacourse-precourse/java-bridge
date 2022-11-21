package view;

import constant.PrintConstant;
import java.util.List;

public class OutputView {
    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public static void printStart() {
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

    private void printFinalResult() {
        System.out.println(View.FINAL_RESULT.message());
    }

    public void printMap(List<List<String>> bothSide) {
        printStartSquareBracket();
        printSide(bothSide.get(1));
        printEndSquareBracket();

        printStartSquareBracket();
        printSide(bothSide.get(0));
        printEndSquareBracket();

        insertLineBreak();
    }

    private void printSide(List<String> side) {
        for (int index = 0; index < side.size(); index++) {
            System.out.print(side.get(index));
            if (index < lastIndex(side)) {
                printDelimeter();
            }
        }
    }

    public void printResult(List<List<String>> bothSide) {
        printFinalResult();
        printMap(bothSide);

        if (isWin(bothSide)) {
            printWin();
        }
        if (isFail(bothSide)) {
            printFail();
        }
    }

    private int lastIndex(List<String> side) {
        return (side.size() - 1);
    }

    private void printStartSquareBracket() {
        System.out.print(PrintConstant.START_SQUARE_BRACKET.getConstant());
    }

    private void printDelimeter() {
        System.out.print(PrintConstant.DELIMETER.getConstant());
    }

    private void printEndSquareBracket() {
        System.out.println(PrintConstant.END_SQUARE_BRACKET.getConstant());
    }

    private boolean isWin(List<List<String>> bothSide) {
        return !bothSide.get(0).contains(PrintConstant.WRONG_PATH.getConstant())
                && !bothSide.get(1).contains(PrintConstant.WRONG_PATH.getConstant());
    }

    private boolean isFail(List<List<String>> bothSide) {
        return bothSide.get(0).contains(PrintConstant.WRONG_PATH.getConstant())
                || bothSide.get(1).contains(PrintConstant.WRONG_PATH.getConstant());
    }

    private void printWin() {
        System.out.print(View.WIN_FAIL_STATUS.message());
        System.out.print(View.BLANK.message());
        System.out.println(PrintConstant.WIN.getConstant());
    }

    private void printFail() {
        System.out.print(View.WIN_FAIL_STATUS.message());
        System.out.print(View.BLANK.message());
        System.out.println(PrintConstant.FAIL.getConstant());
    }

    public void printTryNumber(int tryNumber) {
        System.out.print(View.TOTAL_TRY_NUMBER.message());
        System.out.print(View.BLANK.message());
        System.out.println(tryNumber);
    }

    private static void insertLineBreak() {
        System.out.println();
    }
}
