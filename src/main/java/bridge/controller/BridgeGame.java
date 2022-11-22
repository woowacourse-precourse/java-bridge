package bridge.controller;

import bridge.model.Bridge;
import bridge.model.CrossBridgeType;
import bridge.utils.Validator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    boolean isCross;
    int round;
    private int attemptCount = 0;

    Bridge bridge;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int round, String moveKey) {
        String crossablePosition = bridge.crossablePosition(round);
        if (moveKey.equals(CrossBridgeType.UPPER_BRIDGE.getStringKey()) && crossablePosition.equals(
            CrossBridgeType.UPPER_BRIDGE.getStringKey()))
            return true;
        if (moveKey.equals(CrossBridgeType.DOWN_BRIDGE.getStringKey()) && crossablePosition.equals(
            CrossBridgeType.DOWN_BRIDGE.getStringKey()))
            return true;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        while (true) {
            try {
                return equalStringCommand("R", Validator.readGameCommand());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean equalStringCommand(String command, String inputValue) {
        if (command.equals(inputValue))
            return true;
        return false;
    }

    public void playGame(Bridge bridge) {
        this.bridge = bridge;
        while (true) {
            attemptCount++;
            if (!moveBridge())
                break;
            if (!retry())
                break;
        }
        bridge.printResult(attemptCount, round, isCross);
    }

    public boolean moveBridge() {
        for (round = 0; round != bridge.getBridgeSize(); round++) {
            isCross = move(round, Validator.readBridgeMove());
            bridge.printMap(round, isCross);
            if (!isCross)
                break;
        }
        if (round == bridge.getBridgeSize())
            return false;
        return true;
    }

}
