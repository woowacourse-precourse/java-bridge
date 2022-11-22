package bridge.view;

import bridge.controller.BridgeController;
import bridge.model.CompareBridge;

public class OutputView {

    // 게임 시작 선언
    public static void printGameStart() {
        System.out.println(BridgeConstant.GAME_START.getValue());
        System.out.println();
    }

    // 다리 길이 입력 선언
    public static void printBridgeSize() {
        System.out.println(BridgeConstant.INPUT_BRIDGE_SIZE.getValue());
    }

    // 다리 선택 U or D
    public static void printSelectBlock() {
        System.out.println(BridgeConstant.INPUT_MOVEMENT.getValue());
    }

    // 게임 재시작 선택 R or Q
    public static void printGameRestart() {
        System.out.println(BridgeConstant.RESTART.getValue());
    }

    // 다리 출력하기
    public static void printMap() {
        if (CompareBridge.udCount == 1 || BridgeController.compareBridgeNum == 0) {
            CompareBridge.sbUp.deleteCharAt(0);
            CompareBridge.sbDown.deleteCharAt(0);
        }
        System.out.println("[" + CompareBridge.sbUp + "]");
        System.out.println("[" + CompareBridge.sbDown + "]");
        System.out.println();
    }

    // 결과 출력하기
    public static void printResult(String input) {
        if(input.equals("Q")){
            System.out.println(BridgeConstant.END_GAME_RESULT.getValue());
            System.out.println("[" + CompareBridge.sbUp + "]");
            System.out.println("[" + CompareBridge.sbDown + "]");
            System.out.println();
            System.out.println(BridgeConstant.GAME_NOT_SUCCESS.getValue());
            System.out.println(BridgeConstant.TOTAL_GAME_PLAYS.getValue() +BridgeController.howManyGame);
            BridgeController.compareBridgeNum = BridgeController.randomBridge.size();
        }
    }
}
