package bridge.domain;

import bridge.model.Bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int index = 0;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getIndex() {
        return index;
    }

    public List<String> getBridge() {
        return bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        index++;
    }

    public void initIndex() {
        index = 0;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean checkRetry(String retryOrQuit) {
        boolean retry = false;
        if(retryOrQuit.equals("R")) {
            retry = true;
        }
        return retry;
    }

    public boolean checkStatus(List<String> bridge, String input, int index) {
        boolean result = false;
        if(bridge.get(index).equals(input)) {
            result = true;
        }
        return result;
    }

    public void writeInitUpperBridge(StringBuilder upperBridge, StringBuilder lowerBridge, boolean success) {
        if(success) {
            upperBridge.append("[ ").append("O").append(" ]");
            lowerBridge.append("[ ").append(" ").append(" ]");
        }
        if(!success) {
            upperBridge.append("[ ").append("X").append(" ]");
            lowerBridge.append("[ ").append(" ").append(" ]");
        }
    }

    public void writeInitLowerBridge(StringBuilder upperBridge, StringBuilder lowerBridge, boolean success) {
        if(success) {
            upperBridge.append("[ ").append(" ").append(" ]");
            lowerBridge.append("[ ").append("O").append(" ]");
        }
        if(!success) {
            upperBridge.append("[ ").append(" ").append(" ]");
            lowerBridge.append("[ ").append("X").append(" ]");
        }
    }

    public void writeUpperBridge(StringBuilder upperBridge, StringBuilder lowerBridge, boolean success) {
        bridgeLastCharRemove(upperBridge, lowerBridge);
        if(success) {
            upperBridge.append("| ").append("O").append(" ]");
            lowerBridge.append("| ").append(" ").append(" ]");
        }
        if(!success) {
            upperBridge.append("| ").append("X").append(" ]");
            lowerBridge.append("| ").append(" ").append(" ]");
        }
    }

    public void writeLowerBridge(StringBuilder upperBridge, StringBuilder lowerBridge, boolean success) {
        bridgeLastCharRemove(upperBridge, lowerBridge);
        if(success) {
            upperBridge.append("| ").append(" ").append(" ]");
            lowerBridge.append("| ").append("O").append(" ]");
        }
        if(!success) {
            upperBridge.append("| ").append(" ").append(" ]");
            lowerBridge.append("| ").append("X").append(" ]");
        }
    }

    private void bridgeLastCharRemove(StringBuilder upperBridge, StringBuilder lowerBridge) {
        upperBridge.deleteCharAt(upperBridge.length()-1);
        lowerBridge.deleteCharAt(lowerBridge.length()-1);
    }

    public boolean moveBridge(BridgeGame bridgeGame, String inputMove, Bridge bridge) {
        List<String> bridgeList = bridgeGame.getBridge();
        int bridgeGameIndex = bridgeGame.getIndex();
        if (bridgeGame.checkStatus(bridgeList, inputMove, bridgeGameIndex)) {
            writeBridgeTrueValue(bridgeGame, inputMove, bridge);
            return true;
        }
        writeBridgeFalseValue(inputMove, bridge);
        return false;
    }

    private void writeBridgeFalseValue(String inputMove, Bridge bridge) {
        if (inputMove.equals("U")) {
            writeUpperBridge(bridge.getUpperBridge(), bridge.getLowerBridge(), false);
        }
        if (inputMove.equals("D")) {
            writeLowerBridge(bridge.getUpperBridge(), bridge.getLowerBridge(), false);
        }
    }

    private void writeBridgeTrueValue(BridgeGame bridgeGame, String inputMove, Bridge bridge) {
        if (inputMove.equals("U")) {
            writeUpperBridge(bridge.getUpperBridge(), bridge.getLowerBridge(), true);
            bridgeGame.move();
        }
        if (inputMove.equals("D")) {
            writeLowerBridge(bridge.getUpperBridge(), bridge.getLowerBridge(), true);
            bridgeGame.move();
        }
    }

    public boolean moveBridgeInit(BridgeGame bridgeGame, String inputMove, Bridge bridge) {
        List<String> bridgeList = bridgeGame.getBridge();
        if (bridgeGame.checkStatus(bridgeList, inputMove, 0)) {
            writeInitBridgeTrueValue(bridgeGame, inputMove, bridge);
            return true;
        }
        writeInitBridgeFalseValue(inputMove, bridge);
        return false;
    }

    private void writeInitBridgeFalseValue(String inputMove, Bridge bridge) {
        if (inputMove.equals("U")) {
            writeInitUpperBridge(bridge.getUpperBridge(), bridge.getLowerBridge(), false);
        }
        if (inputMove.equals("D")) {
            writeInitLowerBridge(bridge.getUpperBridge(), bridge.getLowerBridge(), false);
        }
    }

    private void writeInitBridgeTrueValue(BridgeGame bridgeGame, String inputMove, Bridge bridge) {
        if (inputMove.equals("U")) {
            writeInitUpperBridge(bridge.getUpperBridge(), bridge.getLowerBridge(), true);
            bridgeGame.move();
        }
        if (inputMove.equals("D")) {
            writeInitLowerBridge(bridge.getUpperBridge(), bridge.getLowerBridge(), true);
            bridgeGame.move();
        }
    }
}
