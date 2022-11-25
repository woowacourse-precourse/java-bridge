package view;

import util.Constants;

public class OutputView {
    public static void printStartBridgeGame() {
        System.out.println(Constants.PRINT_START_BRIDGEGAME);
    }

    public static void printBridgeSize() {
        System.out.println(Constants.PRINT_BRIDGESIZE);
    }

    public static void printToChoicePlace() {
        System.out.println(Constants.PRINT_TO_CHOICE_PLACE);
    }

    public static void printMap(String upBridge, String downBridge) {
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    public static void printChoiceRetry() {
        System.out.println(Constants.PRINT_CHOICE_RETRY);
    }

    public static void printResult(String bridge, String failOrPass, int count) {
        System.out.println(Constants.FINAL_RESULT);
        System.out.println(bridge);
        System.out.println(Constants.SUCCESS_OR_FAILURE + failOrPass);
        System.out.println(Constants.TOTAL_RESULT + String.valueOf(count));
    }
}