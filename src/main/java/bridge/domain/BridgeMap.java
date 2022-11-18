package bridge.domain;

import java.util.stream.IntStream;

import static bridge.domain.BridgeMapConstant.*;
import static bridge.ui.ViewConstant.LINE_FEED;


public class BridgeMap {
    private final Bridge bridge;
    private final int gameStage;
    private final boolean winning;

    public BridgeMap(Bridge bridge, int gameStage, boolean winning) {
        this.bridge = bridge;
        this.gameStage = gameStage;
        this.winning = winning;
    }

    public String getMap() {
        String bridgeMap = buildBridge(new StringBuilder(), new StringBuilder());
        return replaceDivisionMark(bridgeMap);
    }

    private String buildBridge(StringBuilder upBridge, StringBuilder downBridge) {
        IntStream.range(START_INDEX, this.gameStage)
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