package bridge.service;

import bridge.domain.Constants;

public class BridgeMapMaker {

    private final StringBuilder upperBridgeMap;
    private final StringBuilder lowerBridgeMap;

    public BridgeMapMaker() {
        this.upperBridgeMap = new StringBuilder(Constants.START_MAP);
        this.lowerBridgeMap = new StringBuilder(Constants.START_MAP);
    }

    public void renewBridgeMap(String cell) {
        startBridgeMapMake();

        if (cell.equals(Constants.UP_COMMAND)) {
            renewBridgeMapUpperCase();
            return;
        }

        renewBridgeMapLowerCase();
    }

    private void startBridgeMapMake() {
        upperBridgeMap.append(Constants.SEPARATOR);
        lowerBridgeMap.append(Constants.SEPARATOR);
    }

    private void renewBridgeMapUpperCase() {
        upperBridgeMap.append(Constants.SUCCESSFUL_CASE_MAP);
        lowerBridgeMap.append(Constants.NON_ANSWER_CASE_MAP);
    }

    private void renewBridgeMapLowerCase() {
        upperBridgeMap.append(Constants.NON_ANSWER_CASE_MAP);
        lowerBridgeMap.append(Constants.SUCCESSFUL_CASE_MAP);
    }

    public StringBuilder getUpperBridgeMap() {
        return upperBridgeMap;
    }

    public StringBuilder getLowerBridgeMap() {
        return lowerBridgeMap;
    }
}
