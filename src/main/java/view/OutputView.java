package view;

import constant.BothSideConstant;
import constant.NumberConstant;
import constant.PrintConstant;
import java.util.List;
import util.validator.BridgeGameValidator;

public class OutputView {
    private static final OutputView outputView = new OutputView();

    private static final int FIRST_INDEX = NumberConstant.FIRST_INDEX.getConstant();
    private static final int UP_SIDE_INDEX = BothSideConstant.UP_SIDE_INDEX.getConstant();
    private static final int DOWN_SIDE_INDEX = BothSideConstant.DOWN_SIDE_INDEX.getConstant();
    private static final String START_GAME = View.START_GAME.message();
    private static final String REQUEST_BRIDGE_SIZE = View.REQUEST_BRIDGE_SIZE.message();
    private static final String REQUEST_MOVE = View.REQUEST_MOVE.message();
    private static final String REQUEST_RETRY_OR_QUIT = View.REQUEST_RETRY_OR_QUIT.message();
    private static final String FINAL_RESULT = View.FINAL_RESULT.message();
    private static final String WIN_FAIL_STATUS = View.WIN_FAIL_STATUS.message();
    private static final String TOTAL_TRY_NUMBER = View.TOTAL_TRY_NUMBER.message();
    private static final String BLANK = View.BLANK.message();
    private static final String WIN = PrintConstant.WIN.getConstant();
    private static final String FAIL = PrintConstant.FAIL.getConstant();
    private static final String START_SQUARE_BRACKET = PrintConstant.START_SQUARE_BRACKET.getConstant();
    private static final String END_SQUARE_BRACKET = PrintConstant.END_SQUARE_BRACKET.getConstant();
    private static final String DELIMETER = PrintConstant.DELIMETER.getConstant();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public static void printStart() {
        System.out.println(START_GAME);
        insertLineBreak();
    }

    public void printRequestBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE);
    }

    public void printBridgeSize(int size) {
        System.out.println(size);
        insertLineBreak();
    }

    public void printRequestMove() {
        System.out.println(REQUEST_MOVE);
    }

    public void printUserPath(String path) {
        System.out.println(path);
    }

    public void printRequestRetryOrQuit() {
        System.out.println(REQUEST_RETRY_OR_QUIT);
    }

    public void printUserRetryOrQuit(String retryOrQuit) {
        System.out.println(retryOrQuit);
    }

    private void printFinalResult() {
        System.out.println(FINAL_RESULT);
    }

    public void printMap(List<List<String>> bothSide) {
        printStartSquareBracket();
        printSide(bothSide.get(UP_SIDE_INDEX));
        printEndSquareBracket();

        printStartSquareBracket();
        printSide(bothSide.get(DOWN_SIDE_INDEX));
        printEndSquareBracket();

        insertLineBreak();
    }

    private void printSide(List<String> side) {
        for (int index = FIRST_INDEX; index < side.size(); index++) {
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
        System.out.print(START_SQUARE_BRACKET);
    }

    private void printDelimeter() {
        System.out.print(DELIMETER);
    }

    private void printEndSquareBracket() {
        System.out.println(END_SQUARE_BRACKET);
    }

    private boolean isWin(List<List<String>> bothSide) {
        return !BridgeGameValidator.isContainsWrongPath(bothSide);
    }

    private boolean isFail(List<List<String>> bothSide) {
        return BridgeGameValidator.isContainsWrongPath(bothSide);
    }

    private void printWin() {
        System.out.print(WIN_FAIL_STATUS);
        System.out.print(BLANK);
        System.out.println(WIN);
    }

    private void printFail() {
        System.out.print(WIN_FAIL_STATUS);
        System.out.print(BLANK);
        System.out.println(FAIL);
    }

    public void printTryNumber(int tryNumber) {
        System.out.print(TOTAL_TRY_NUMBER);
        System.out.print(BLANK);
        System.out.println(tryNumber);
    }

    private static void insertLineBreak() {
        System.out.println();
    }
}
