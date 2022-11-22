package bridge.service;

import bridge.util.Command;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/22
 */
public class BridgeMapService {
    private static final String START = "[";
    private static final String END = "]";
    private static final String DIVISION = "|";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String NONE = "   ";
    private static final String NEW_LINE = "\n";

    private static final BridgeService bridgeService = new BridgeService();
    private static final MovedBridgeService movedBridgeService = new MovedBridgeService();
    private static List<String> bridgeAnswer;
    private static List<String> moveBridge;
    private static StringBuilder upBridge;
    private static StringBuilder downBridge;

    public static String printMap() {
        init();
        getBridgeMap();
        getBridgeMapLastIndex();
        return upBridge.toString() + NEW_LINE + downBridge.toString() + NEW_LINE;
    }

    private static void init() {
        bridgeAnswer = bridgeService.find().getBridge();
        moveBridge = movedBridgeService.find().getBridge();
        upBridge = new StringBuilder(START);
        downBridge = new StringBuilder(START);
    }

    private static void getBridgeMap() {
        for (int i = 0; i < moveBridge.size() - 1; i++) {
            if (moveBridge.get(i).equals(bridgeAnswer.get(i))) {
                addBridgeMap(i, CORRECT, DIVISION);
            }
        }
    }

    private static void addBridgeMap(int index, String symbolBlock, String symbolDivision) {
        if (moveBridge.get(index).equals(Command.MOVE_UPPER_LETTER.getCommand())) {
            upBridge.append(symbolBlock).append(symbolDivision);
            downBridge.append(NONE).append(symbolDivision);
        } else if (moveBridge.get(index).equals(Command.MOVE_LOWER_LETTER.getCommand())) {
            upBridge.append(NONE).append(symbolDivision);
            downBridge.append(symbolBlock).append(symbolDivision);
        }
    }

    private static void getBridgeMapLastIndex() {
        int lastIndex = moveBridge.size() - 1;
        if (moveBridge.get(lastIndex).equals(bridgeAnswer.get(lastIndex))) {
            addBridgeMap(lastIndex, CORRECT, END);
        } else {
            addBridgeMap(lastIndex, WRONG, END);
        }
    }
}
