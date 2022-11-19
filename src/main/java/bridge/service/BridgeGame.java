package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    static String WIN = "성공";
    static String LOSE = "실패";

    public static void wholeGame(List<String> generatedBridge) {
        List<String> nowBridge = new ArrayList<>();
        int count = 0;
        do {
            oneGame(nowBridge, generatedBridge);
            count++;
            if (isGameWin(nowBridge, generatedBridge).equals(WIN)) {
                break;
            }
        } while (retry(nowBridge));
        OutputView.printResult(count, nowBridge, generatedBridge);
    }

    public static void oneGame(List<String> nowBridge, List<String> generatedBridge) {
        boolean gameSuccess;
        do {
            move(chooseBridge(), nowBridge);
            System.out.println(OutputView.printMap(nowBridge, generatedBridge));
            gameSuccess = compareBridge(nowBridge, generatedBridge);
            if (nowBridge.size() == generatedBridge.size()) {
                break;
            }
        } while (gameSuccess);
    }

    private static String chooseBridge() {
        String pick;
        while (true) {
            try {
                pick = InputView.readMoving();
                return pick;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public static String isGameWin(List<String> generatedBridge, List<String> nowBridge) {
        if (nowBridge.size() == generatedBridge.size() &&
                nowBridge.get(nowBridge.size() - 1).equals(generatedBridge.get(generatedBridge.size() - 1))) {
            return WIN;
        }
        return LOSE;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void move(String input, List<String> nowBridge) {
        nowBridge.add(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry(List<String> nowBridge) {
        nowBridge.clear();
        if (InputView.readGameCommand().equals("R")) {
            return true;
        }
        return false;
    }

    public static boolean compareBridge(List<String> nowBridge, List<String> generatedBridge) {
        int index = nowBridge.size() - 1;
        if (nowBridge.get(index).equals(generatedBridge.get(index))) {
            return true;
        }
        return false;
    }

    public static int inputBridgeSize() {
        int size;
        while (true) {
            try {
                size = InputView.readBridgeSize();
                return size;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}
