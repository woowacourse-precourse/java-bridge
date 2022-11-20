package bridge.view;

import bridge.constant.BridgeMark;
import bridge.constant.GameStatus;

import java.util.List;

public class BridgeMapViewCreator {

    private static final String BRIDGE_START_PREFIX = "[";
    private static final String BRIDGE_ROUND_SUFFIX = "|";
    private static final String BRIDGE_END_SUFFIX = "]";
    private static final String BRIDGE_SUCCESS_MARK = " O ";
    private static final String BRIDGE_BLANK_MARK = "   ";
    private static final String BRIDGE_FAIL_MARK = "X";
    public static final int PREFIX_IDX_VALUE = 1;
    public static final int SUFFIX_IDX_VALUE = 2;

    private BridgeMapViewCreator() {
    }

    public static class BridgeMap{

        private final StringBuilder upBridge;
        private final StringBuilder downBridge;

        public BridgeMap(StringBuilder upBridge, StringBuilder downBridge) {
            this.upBridge = upBridge;
            this.downBridge = downBridge;
        }

        public StringBuilder getUpBridge() {
            return upBridge;
        }

        public StringBuilder getDownBridge() {
            return downBridge;
        }
    }

    public static BridgeMap create(GameStatus gameStatus, List<BridgeMark> records) {
        StringBuilder upBridge = new StringBuilder();
        StringBuilder downBridge = new StringBuilder();

        appendStartPrefix(upBridge, downBridge);
        for (BridgeMark record : records) {
            appendUpRound(record, upBridge);
            appendDownRound(record, downBridge);
        }
        performEndSuffix(gameStatus, upBridge, downBridge);
        return new BridgeMap(upBridge, downBridge);
    }

    private static void appendStartPrefix(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.append(BRIDGE_START_PREFIX);
        downBridge.append(BRIDGE_START_PREFIX);
    }

    private static void appendUpRound(BridgeMark record, StringBuilder upBridge) {
        if (record.isUp()) {
            appendSuccessRound(upBridge);
        }
        if (record.isDown()) {
            appendBlankRound(upBridge);
        }
        appendRoundSuffix(upBridge);
    }

    private static void appendDownRound(BridgeMark record, StringBuilder downBridge) {
        if (record.isUp()) {
            appendBlankRound(downBridge);
        }
        if (record.isDown()) {
            appendSuccessRound(downBridge);
        }
        appendRoundSuffix(downBridge);
    }

    private static void appendSuccessRound(StringBuilder bridge) {
        bridge.append(BRIDGE_SUCCESS_MARK);
    }

    private static void appendBlankRound(StringBuilder bridge) {
        bridge.append(BRIDGE_BLANK_MARK);
    }

    private static void appendRoundSuffix(StringBuilder bridge) {
        bridge.append(BRIDGE_ROUND_SUFFIX);
    }

    private static void performEndSuffix(GameStatus gameStatus, StringBuilder upBridge, StringBuilder downBridge) {
        if (gameStatus.isFail()) {
            changeLastMark(upBridge, downBridge);
        }
        deleteLastRoundSuffix(upBridge, downBridge);
        performEndSuffix(upBridge, downBridge);
    }

    private static void changeLastMark(StringBuilder upBridge, StringBuilder downBridge) {
        int upLastIdx = upBridge.lastIndexOf(BRIDGE_SUCCESS_MARK);
        int downLastIdx = downBridge.lastIndexOf(BRIDGE_SUCCESS_MARK);

        if (upLastIdx > downLastIdx) {
            upBridge.replace(upLastIdx + PREFIX_IDX_VALUE, upLastIdx + SUFFIX_IDX_VALUE, BRIDGE_FAIL_MARK);
        }
        if (upLastIdx < downLastIdx) {
            downBridge.replace(downLastIdx + PREFIX_IDX_VALUE, downLastIdx + SUFFIX_IDX_VALUE, BRIDGE_FAIL_MARK);
        }
    }

    private static void deleteLastRoundSuffix(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.deleteCharAt(upBridge.lastIndexOf(BRIDGE_ROUND_SUFFIX));
        downBridge.deleteCharAt(downBridge.lastIndexOf(BRIDGE_ROUND_SUFFIX));
    }

    private static void performEndSuffix(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.append(BRIDGE_END_SUFFIX);
        downBridge.append(BRIDGE_END_SUFFIX);
    }
}
