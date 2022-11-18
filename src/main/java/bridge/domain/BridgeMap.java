package bridge.domain;

import java.util.stream.IntStream;

public class BridgeMap {
    private static final String COVERT_STAND_WORD = "U";
    private static final String LINE_FEED = "\n";
    private static final int START_INDEX = 0;
    private static final String DIVISION = "][";
    private static final String REPLACE = "|";
    private static final String SUCCESS_BRIDGE = "[ O ]";
    private static final String BLANK_BRIDGE = "[   ]";
    private static final String INCLUDE_END_WITH = "O ]";
    private static final char BLANK_SPACE = ' ';
    private static final char FAIL_MARK = 'X';
    private static final int EXCHANGE_LENGTH = 3;

    private final Bridge bridge;
    private final int count;
    private final boolean winning;

    public BridgeMap(Bridge bridge, int count, boolean winning) {
        this.bridge = bridge;
        this.count = count;
        this.winning = winning;
    }

    public String getMap() {
        String bridgeMap = buildBridge(new StringBuilder(), new StringBuilder());
        return replaceDivisionMark(bridgeMap);
    }

    private String buildBridge(StringBuilder upBridge, StringBuilder downBridge) {
        IntStream.range(START_INDEX, this.count)
                .forEach(value -> convertBridgeToMap(this.bridge.getBridge().get(value), upBridge, downBridge));
        checkWinningAndExchangeFailMap(upBridge, downBridge);
        return upBridge + LINE_FEED + downBridge;
    }

    private void checkWinningAndExchangeFailMap(StringBuilder upBridge, StringBuilder downBridge) {
        if (!this.winning) {
            exchangeToFailMap(upBridge, downBridge);
            exchangeToFailMap(downBridge, upBridge);
        }
    }

    private void exchangeToFailMap(StringBuilder firstBridge, StringBuilder secondBridge) {
        if (firstBridge.toString().endsWith(INCLUDE_END_WITH)) {
            firstBridge.setCharAt(getExchangeIndex(firstBridge), BLANK_SPACE);
            secondBridge.setCharAt(getExchangeIndex(secondBridge), FAIL_MARK);
        }
    }

    private int getExchangeIndex(StringBuilder bridge) {
        return bridge.length() - EXCHANGE_LENGTH;
    }

    private void convertBridgeToMap(String bridgeStatus, StringBuilder upBridge, StringBuilder downBridge) {
        if (bridgeStatus.equals(COVERT_STAND_WORD)) {
            appendSuccessBridgeContext(upBridge, downBridge);
        }
        if (!bridgeStatus.equals(COVERT_STAND_WORD)) {
            appendSuccessBridgeContext(downBridge, upBridge);
        }
    }

    private void appendSuccessBridgeContext(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.append(SUCCESS_BRIDGE);
        downBridge.append(BLANK_BRIDGE);
    }

    private String replaceDivisionMark(String bridge) {
        return bridge.replace(DIVISION, REPLACE);
    }
}
