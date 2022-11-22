package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String MOVE_POSSIBLE = " O ";
    private final String MOVE_IMPOSSIBLE = " X ";
    private final String NOT_SELECTED = "   ";
    private final String BRIDGE_START = "[";
    private final String BRIDGE_END = "]";
    private final String BRIDGE_MIDDLE = "|";

    private StringBuilder upperBridge = new StringBuilder();
    private StringBuilder lowerBridge = new StringBuilder();
    private int acrossBridge = 0;

    private int count = 1;


    public List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }



    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> makeBridge, int acrossBridge, String moving) {
        isStart(acrossBridge);
        isUpperCollectOrWrong(makeBridge, acrossBridge, moving);
        isLowerCollectOrWrong(makeBridge, acrossBridge, moving);
        isEnd(makeBridge, acrossBridge);

        String upperResult = upperBridge.substring(0, upperBridge.length() - 1) + BRIDGE_END;
        String lowerResult = lowerBridge.substring(0, lowerBridge.length() - 1) + BRIDGE_END;
        return upperResult + System.lineSeparator() + lowerResult;
    }

    public void isStart(int acrossBridge) {
        if (acrossBridge == 0) {
            upperBridge.append(BRIDGE_START);
            lowerBridge.append(BRIDGE_START);
        }
    }

    public void isUpperCollectOrWrong(List<String> makeBridge, int acrossBridge, String moving) {
        if (moving.equals("U")) {
            if (makeBridge.get(acrossBridge).equals(moving)) {
                upperBridge.append(MOVE_POSSIBLE);
            }
            if (!(makeBridge.get(acrossBridge).equals(moving))) {
                upperBridge.append(MOVE_IMPOSSIBLE);
            }
            lowerBridge.append(NOT_SELECTED);
        }
    }

    public void isLowerCollectOrWrong(List<String> makeBridge, int acrossBridge, String moving) {
        if (moving.equals("D")) {
            if (makeBridge.get(acrossBridge).equals(moving)) {
                lowerBridge.append(MOVE_POSSIBLE);
            }
            if (!(makeBridge.get(acrossBridge).equals(moving))) {
                lowerBridge.append(MOVE_IMPOSSIBLE);
            }
            upperBridge.append(NOT_SELECTED);
        }
    }

    public void isEnd(List<String> makeBridge, int acrossBridge) {
        if (makeBridge.size() - 1 == acrossBridge) {
            upperBridge.append(BRIDGE_END);
            lowerBridge.append(BRIDGE_END);
        }
        if (makeBridge.size() - 1 != acrossBridge) {
            upperBridge.append(BRIDGE_MIDDLE);
            lowerBridge.append(BRIDGE_MIDDLE);
        }
    }

    public void isSuccess(List<String> bridge, int acrossBridge) {
        if (acrossBridge == bridge.size()) {
            System.out.println(printOutput.IS_SUCCESS_SUCCESS.getGameOutput());
        }
        if (acrossBridge != bridge.size()) {
            System.out.println(printOutput.IS_SUCCESS_FAIL.getGameOutput());
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        countPlus();
        this.acrossBridge = 0;
        this.upperBridge = new StringBuilder();
        this.lowerBridge = new StringBuilder();
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(printOutput.GAME_RESULT.getGameOutput());
    }

    public String InstanceMap(int bridgeSize) {
        String result = upperBridge + "\n" + lowerBridge;
        if (acrossBridge != bridgeSize) {
            result = upperBridge.deleteCharAt(upperBridge.length()-1)+BRIDGE_END + "\n" + lowerBridge.deleteCharAt(lowerBridge.length()-1)+BRIDGE_END;
        }

        return result;
    }

    public int accrosBridgePlus() {
        return this.acrossBridge = acrossBridge + 1;
    }

    public int getAcrossBridge() {
        return acrossBridge;
    }

    public int getCount() {
        return count;
    }

    public int countPlus() {
        return this.count = count + 1;
    }

    public StringBuilder getLowerBridge() {
        return lowerBridge;
    }

    public StringBuilder getUpperBridge() {
        return upperBridge;
    }
}
