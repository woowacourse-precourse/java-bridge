package bridge.service;

import bridge.controller.BridgeController;

import java.util.List;

import static bridge.domain.BridgeCommand.RETRY;
import static bridge.domain.BridgeMap.LOSE;
import static bridge.domain.BridgeMap.WIN;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeController bridgeController = new BridgeController();

    public int gameManagement(List<String> nowBridge, List<String> generatedBridge) {
        int count = 0;
        do {
            gameService(nowBridge, generatedBridge);
            count++;
            if (isGameWin(nowBridge, generatedBridge).equals(WIN.getElement())) {
                break;
            }
        } while (retry(nowBridge));
        return count;
    }

    public void gameService(List<String> nowBridge, List<String> generatedBridge) {
        boolean gameSuccess;
        do {
            move(bridgeController.readMovingController(), nowBridge);
            System.out.println(bridgeController.printMapController(nowBridge, generatedBridge));
            gameSuccess = compareBridge(nowBridge, generatedBridge);
            if (nowBridge.size() == generatedBridge.size()) {
                break;
            }
        } while (gameSuccess);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input, List<String> nowBridge) {
        nowBridge.add(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(List<String> nowBridge) {
        nowBridge.clear();
        if (bridgeController.readGameCommandController().equals(RETRY.getElement())) {
            return true;
        }
        return false;
    }

    public String isGameWin(List<String> generatedBridge, List<String> nowBridge) {
        if (nowBridge.size() == generatedBridge.size() &&
                nowBridge.get(nowBridge.size() - 1).equals(generatedBridge.get(generatedBridge.size() - 1))) {
            return WIN.getElement();
        }
        return LOSE.getElement();
    }

    public boolean compareBridge(List<String> nowBridge, List<String> generatedBridge) {
        int index = nowBridge.size() - 1;
        if (nowBridge.get(index).equals(generatedBridge.get(index))) {
            return true;
        }
        return false;
    }

    public void printResultService(int count, List<String> nowBridge, List<String> generatedBridge) {
        StringBuffer bridgeScreen = bridgeController.printMapController(nowBridge, generatedBridge);
        String gameSuccess = isGameWin(nowBridge, generatedBridge);
        bridgeController.printResultController(count, bridgeScreen, gameSuccess);
    }

    public int readBridgeSizeService() {
        return bridgeController.readBridgeSizeController();
    }
}
