package bridge.domain;

import java.util.stream.IntStream;

import static bridge.domain.BridgeMapConstant.*;
import static bridge.ui.ViewConstant.LINE_FEED;

public class BridgeMap {
    private final Bridge bridge;
    private final int mapCoordinate;
    private final boolean winning;

    public BridgeMap(Bridge bridge, int mapCoordinate, boolean winning) {
        this.bridge = bridge;
        this.mapCoordinate = mapCoordinate;
        this.winning = winning;
    }

    public String getMap() {
        String bridgeMap = makeBridgeMap(new StringBuilder(), new StringBuilder());
        return replaceDivisionMark(bridgeMap);
    }

    private String makeBridgeMap(StringBuilder upBridge, StringBuilder downBridge) {
        IntStream.range(START_INDEX, this.mapCoordinate)
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
        return bridge.length() - EXCHANGE_LOCATION_INDEX;
    }

    private void convertBridgeToMap(String bridgeStatus, StringBuilder upBridge, StringBuilder downBridge) {
        if (bridgeStatus.equals(UP)) {
            appendBridgeContext(upBridge, downBridge);
        }
        if (!bridgeStatus.equals(UP)) {
            appendBridgeContext(downBridge, upBridge);
        }
    }

    private void appendBridgeContext(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.append(SUCCESS_BRIDGE);
        downBridge.append(BLANK_BRIDGE);
    }

    private String replaceDivisionMark(String bridge) {
        return bridge.replace(DIVISION, REPLACE);
    }
}