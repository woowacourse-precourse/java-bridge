package bridge;

/*
* BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
* BridgeGame의 패키지는 변경할 수 있다.
* Bridge의 메서드 이름은 변경할 수 없고, 인자와 반환타입은 필요에 따라 추가하거나 변경할 수 있다.
* 게임 진행을 위해 필요한 메서드를 추가하거나 변경할 수 있다.
*  */

import bridge.model.Model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public int indexOfBridgePosition;
    public static int tryCount;

    public BridgeGame(int bridgeSize) {
        Model.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        indexOfBridgePosition = 0;
        tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveCommand) {
        String valueOfBridgePosition = Model.bridge.get(indexOfBridgePosition);
        addBridgeMapForTrue(valueOfBridgePosition, moveCommand);
        addBridgeMapForFalse(valueOfBridgePosition, moveCommand);
        indexOfBridgePosition++;
        return roundResult();
    }

    public void addBridgeMapForTrue(String bridgeEachRound, String moveCommand) {
        if (moveCommand.equals("U") && bridgeEachRound.equals(moveCommand)) {
            Model.upperBridgeMap.add("O");
            Model.lowerBridgeMap.add(" ");
        }
        if (moveCommand.equals("D") && bridgeEachRound.equals(moveCommand)) {
            Model.upperBridgeMap.add(" ");
            Model.lowerBridgeMap.add("O");
        }
    }
    public void addBridgeMapForFalse(String bridgeEachRound, String moveCommand) {
        if (moveCommand.equals("U") && !bridgeEachRound.equals(moveCommand)) {
            Model.upperBridgeMap.add("X");
            Model.lowerBridgeMap.add(" ");
        }
        if (moveCommand.equals("D") && !bridgeEachRound.equals(moveCommand)) {
            Model.upperBridgeMap.add(" ");
            Model.lowerBridgeMap.add("X");
        }
    }

    public boolean roundResult() {
        List<String> upperBridge = Model.upperBridgeMap;
        List<String> lowerBridge = Model.lowerBridgeMap;
        if (lastElementOfList(upperBridge).equals("X") || indexOfBridgePosition == Model.bridge.size()) {
            return false;
        }
        if (lastElementOfList(lowerBridge).equals("X")) {
            return false;
        }
        return true;
    }
    public String lastElementOfList(List<String> list) {
        return list.get(list.size()-1);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            operateRetry();
            return true;
        }
        return false;
    }

    private void operateRetry() {
        indexOfBridgePosition = 0;
        tryCount++;
        Model.clearBridgeMap();
    }
}
