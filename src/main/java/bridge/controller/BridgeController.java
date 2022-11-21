package bridge.controller;

import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.CompareBridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    // 랜덤한 다리 생성
    public static List<String> randomBridge = new ArrayList<>();
    private static BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
    public static int compareBridgeNum = 0;
    public static int howManyGame = 1;
    public static void BridgeGameStart() {
        //게임 시작 선언
        OutputView.printGameStart();
        //다리 길이 입력
        int bridgeSize = InputView.readBridgeSize();

        //입력받은 길이대로 랜덤한 다리 생성
        randomBridge = bm.getRandomBridge(bridgeSize);

        // 비교하기
        compareBridge();

    }

    public static void compareBridge() {
        for (compareBridgeNum = 0; compareBridgeNum < CompareBridge.ranBridge.size(); ) {
            String compare = InputView.readMoving();
            CompareBridge.udCount++;

            CompareBridge.compareUp(compareBridgeNum, compare);
            CompareBridge.compareDown(compareBridgeNum, compare);

        }
        completeMap();
    }

    public static void retryGame() {
        OutputView.printGameRestart();
        String retry = Console.readLine();
        restartMap(retry);
        finishMap(retry);
    }

    // R 입력시 게임 재시작
    public static void restartMap(String input) {
        CompareBridge.udCount = 0;
        compareBridgeNum = 0;
        howManyGame++;
        if (input.equals("R")) {
            CompareBridge.sbUp.delete(0, CompareBridge.sbUp.length());
            CompareBridge.sbDown.delete(0, CompareBridge.sbDown.length());
        }
    }


    // Q 입력 시 종료
    public static void finishMap(String input) {
        if (input.equals("Q")) {
            System.out.println("최종 게임 결과");
            System.out.println("[" + CompareBridge.sbUp + "]");
            System.out.println("[" + CompareBridge.sbDown + "]");
            System.out.println();
            System.out.println("게임 성공 여부: " + "실패");
            System.out.println("총 시도한 횟수: " + howManyGame);
        }
    }

    public static void completeMap() {
        System.out.println("최종 게임 결과");
        System.out.println("[" + CompareBridge.sbUp + "]");
        System.out.println("[" + CompareBridge.sbDown + "]");
        System.out.println();
        System.out.println("게임 성공 여부: " + "성공");
        System.out.println("총 시도한 횟수: " + howManyGame);
    }
}

