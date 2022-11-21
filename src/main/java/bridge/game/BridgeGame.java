package bridge.game;

/*
* BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
* BridgeGame의 패키지는 변경할 수 있다.
* Bridge의 메서드 이름은 변경할 수 없고, 인자와 반환타입은 필요에 따라 추가하거나 변경할 수 있다.
* 게임 진행을 위해 필요한 메서드를 추가하거나 변경할 수 있다.
*  */

import bridge.BridgeRandomNumberGenerator;
import bridge.model.Model;

import java.util.List;

import static bridge.model.Model.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final int GAME_ON_PROCESS = 0;
    public static final int GAME_OVER = 1;
    public static final int GAME_CLEAR = 2;

    public int indexOfBridge;
    public static int tryCount;

    public BridgeGame(int bridgeSize) {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        indexOfBridge = 0;
        tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(String moveCommand) {
        String bridgeStateAtIndex = bridge.get(indexOfBridge);
        addBridgeMapForTrue(bridgeStateAtIndex, moveCommand);
        addBridgeMapForFalse(bridgeStateAtIndex, moveCommand);
        indexOfBridge++;
        return gameState();
    }
    private void addBridgeMapForTrue(String bridgeEachRound, String moveCommand) {
        if (moveCommand.equals("U") && bridgeEachRound.equals(moveCommand)) {
            upperBridgeMap.add("O");
            lowerBridgeMap.add(" ");
        }
        if (moveCommand.equals("D") && bridgeEachRound.equals(moveCommand)) {
            upperBridgeMap.add(" ");
            lowerBridgeMap.add("O");
        }
    }
    private void addBridgeMapForFalse(String bridgeEachRound, String moveCommand) {
        if (moveCommand.equals("U") && !bridgeEachRound.equals(moveCommand)) {
            upperBridgeMap.add("X");
            lowerBridgeMap.add(" ");
        }
        if (moveCommand.equals("D") && !bridgeEachRound.equals(moveCommand)) {
            upperBridgeMap.add(" ");
            lowerBridgeMap.add("X");
        }
    }
    // 게임의 결과를 반환
    public int gameState() {
        String upperLastElement = lastElementOfList(upperBridgeMap);
        String lowerLastElement = lastElementOfList(lowerBridgeMap);
        if (upperLastElement.equals("X") || lowerLastElement.equals("X")) {
            return GAME_OVER;
        }
        if ((upperLastElement.equals("O") || lowerLastElement.equals("O")) && indexOfBridge == bridge.size()) {
            return GAME_CLEAR;
        }
        return GAME_ON_PROCESS;
    }
    public String lastElementOfList(List<String> list) {
        return list.get(list.size()-1);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            operateRetry();
            return 0;
        }
        return 2;
    }

    private void operateRetry() {
        indexOfBridge = 0;
        tryCount++;
        clearBridgeMap();
    }
}
