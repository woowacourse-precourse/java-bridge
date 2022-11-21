package bridge.view;

import bridge.controller.BridgeController;
import bridge.model.CompareBridge;

public class OutputView {

    public static final String START_GAME = "다리 건너기 게임을 시작합니다";
    public static final String SELECT_BRIDGE_SIZE = "다리 길이를 입력해주세요.";
    public static final String SELECT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String SELECT_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    // 게임 시작 선언
    public static void printGameStart() {
        System.out.println(START_GAME);
        System.out.println();
    }

    // 다리 길이 입력 선언
    public static void printBridgeSize() {
        System.out.println(SELECT_BRIDGE_SIZE);
    }
    public static void printSelectBlock() {
        System.out.println(SELECT_MOVE);
    }

    public static void printGameRestart() {
        System.out.println(SELECT_RESTART);
    }

    public static void printMap() {
        if (CompareBridge.udCount == 1 || BridgeController.compareBridgeNum == 0) {
            CompareBridge.sbUp.deleteCharAt(0);
            CompareBridge.sbDown.deleteCharAt(0);
        }
        System.out.println("[" + CompareBridge.sbUp + "]");
        System.out.println("[" + CompareBridge.sbDown + "]");
        System.out.println();
    }

    public static void printResult(String input) {
        if(input.equals("Q")){
            System.out.println("최종 게임 결과");
            System.out.println("[" + CompareBridge.sbUp + "]");
            System.out.println("[" + CompareBridge.sbDown + "]");
            System.out.println();
            System.out.println("게임 성공 여부 : " + "실패");
            System.out.println("총 시도한 횟수: " +BridgeController.howManyGame);
            BridgeController.compareBridgeNum = BridgeController.randomBridge.size();
        }
    }
}
