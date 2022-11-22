package bridge.view;

import bridge.enums.BridgeMark;
import bridge.enums.GameStatus;

import java.util.List;

import static bridge.view.BridgeMapConstant.BLANK_MARK;
import static bridge.view.BridgeMapConstant.END_SUFFIX;
import static bridge.view.BridgeMapConstant.FAIL_MARK;
import static bridge.view.BridgeMapConstant.PREFIX_IDX_VALUE;
import static bridge.view.BridgeMapConstant.ROUND_SUFFIX;
import static bridge.view.BridgeMapConstant.START_PREFIX;
import static bridge.view.BridgeMapConstant.SUCCESS_MARK;
import static bridge.view.BridgeMapConstant.SUFFIX_IDX_VALUE;

public class BridgeMapViewCreator {

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

    private BridgeMapViewCreator() {
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
        upBridge.append(START_PREFIX);
        downBridge.append(START_PREFIX);
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
        bridge.append(SUCCESS_MARK);
    }

    private static void appendBlankRound(StringBuilder bridge) {
        bridge.append(BLANK_MARK);
    }

    private static void appendRoundSuffix(StringBuilder bridge) {
        bridge.append(ROUND_SUFFIX);
    }

    private static void performEndSuffix(GameStatus gameStatus, StringBuilder upBridge, StringBuilder downBridge) {
        if (gameStatus.isFail()) {
            changeLastMark(upBridge, downBridge);
        }
        deleteLastRoundSuffix(upBridge, downBridge);
        performEndSuffix(upBridge, downBridge);
    }

    private static void changeLastMark(StringBuilder upBridge, StringBuilder downBridge) {
        int upLastIdx = upBridge.lastIndexOf(SUCCESS_MARK);
        int downLastIdx = downBridge.lastIndexOf(SUCCESS_MARK);

        if (upLastIdx > downLastIdx) {
            upBridge.replace(upLastIdx + PREFIX_IDX_VALUE, upLastIdx + SUFFIX_IDX_VALUE, FAIL_MARK);
        }
        if (upLastIdx < downLastIdx) {
            downBridge.replace(downLastIdx + PREFIX_IDX_VALUE, downLastIdx + SUFFIX_IDX_VALUE, FAIL_MARK);
        }
    }

    private static void deleteLastRoundSuffix(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.deleteCharAt(upBridge.lastIndexOf(ROUND_SUFFIX));
        downBridge.deleteCharAt(downBridge.lastIndexOf(ROUND_SUFFIX));
    }

    private static void performEndSuffix(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.append(END_SUFFIX);
        downBridge.append(END_SUFFIX);
    }
}
