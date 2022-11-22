package bridge;

import bridge.game.BridgeDraw;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public Boolean canMove(String direction, int position) {
        if (direction.equals(BridgeValue.UPPER_BRIDGE.getDirection())) {
            return checkUpper(position);
        }
        if (direction.equals(BridgeValue.LOWER_BRIDGE.getDirection())) {
            return checkLower(position);
        }
        return null;
    }

    private boolean checkUpper(int position) {
        return bridge.get(position).equals(BridgeValue.UPPER_BRIDGE.getDirection());
    }

    private boolean checkLower(int position) {
        return bridge.get(position).equals(BridgeValue.LOWER_BRIDGE.getDirection());
    }

    public List<Bridge> drawInitialBridge() {
        List<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<String> bridge = new ArrayList<>();
            bridge.add(BridgeDraw.START.getLetter());
            bridges.add(new Bridge(bridge));
        }
        return bridges;
    }

    /**
     * [ O |   ]
     * [   | O ]
     */
    public List<Bridge> drawSuccessLowerBridge(List<Bridge> bridges) {
        List<String> bridge1 = bridges.get(0).getBridge();
        List<String> bridge2 = bridges.get(1).getBridge();

        bridge1.add(BridgeDraw.EMPTY.getLetter() + BridgeDraw.EMPTY.getLetter() + BridgeDraw.EMPTY.getLetter());
        bridge1.add(BridgeDraw.FINISH.getLetter());
        bridge2.add(BridgeDraw.EMPTY.getLetter() + BridgeDraw.SUCCESS.getLetter() + BridgeDraw.EMPTY.getLetter());
        bridge2.add(BridgeDraw.FINISH.getLetter());
        return bridges;
    }

    /**
     * [ O | O ]
     * [   |   ]
     */
    public List<Bridge> drawSuccessUpperBridge(List<Bridge> bridges) {
        List<String> bridge1 = bridges.get(0).getBridge();
        List<String> bridge2 = bridges.get(1).getBridge();

        bridge1.add(BridgeDraw.EMPTY.getLetter() + BridgeDraw.SUCCESS.getLetter() + BridgeDraw.EMPTY.getLetter());
        bridge1.add(BridgeDraw.FINISH.getLetter());
        bridge2.add(BridgeDraw.EMPTY.getLetter() + BridgeDraw.EMPTY.getLetter() + BridgeDraw.EMPTY.getLetter());
        bridge2.add(BridgeDraw.FINISH.getLetter());
        return bridges;
    }

    /**
     * [ O |   ]
     * [   | X ]
     */
    public List<Bridge> drawFailLowerBridge(List<Bridge> bridges) {
        List<String> bridge1 = bridges.get(0).getBridge();
        List<String> bridge2 = bridges.get(1).getBridge();

        bridge1.add(BridgeDraw.EMPTY.getLetter() + BridgeDraw.EMPTY.getLetter() + BridgeDraw.EMPTY.getLetter());
        bridge1.add(BridgeDraw.FINISH.getLetter());
        bridge2.add(BridgeDraw.EMPTY.getLetter() + BridgeDraw.FAIL.getLetter() + BridgeDraw.EMPTY.getLetter());
        bridge2.add(BridgeDraw.FINISH.getLetter());
        return bridges;
    }

    /**
     * [ O | X ]
     * [   |   ]
     */
    public List<Bridge> drawFailUpperBridge(List<Bridge> bridges) {
        List<String> bridge1 = bridges.get(0).getBridge();
        List<String> bridge2 = bridges.get(1).getBridge();

        bridge1.add(BridgeDraw.EMPTY.getLetter() + BridgeDraw.FAIL.getLetter() + BridgeDraw.EMPTY.getLetter());
        bridge1.add(BridgeDraw.FINISH.getLetter());
        bridge2.add(BridgeDraw.EMPTY.getLetter() + BridgeDraw.EMPTY.getLetter() + BridgeDraw.EMPTY.getLetter());
        bridge2.add(BridgeDraw.FINISH.getLetter());
        return bridges;
    }
}
