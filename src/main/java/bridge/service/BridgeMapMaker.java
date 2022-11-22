package bridge.service;

import bridge.domain.Constants;
import bridge.domain.RoundResult;

public class BridgeMapMaker {

    private final StringBuilder upperBridgeMap;
    private final StringBuilder lowerBridgeMap;

    public BridgeMapMaker() {
        this.upperBridgeMap = new StringBuilder(Constants.START_MAP);
        this.lowerBridgeMap = new StringBuilder(Constants.START_MAP);
    }

    public void renewBridgeMap(RoundResult roundResult) {
        if (roundResult.equals(RoundResult.SELECTED_UPPER_CASE_IF_CORRECT)
                || roundResult.equals(RoundResult.SELECTED_UPPER_CASE_IF_WRONG)) {
            renewBridgeMapUpperCase(roundResult);
            return;
        }

        renewBridgeMapLowerCase(roundResult);
    }

    private void renewBridgeMapUpperCase(RoundResult roundResult) {
        if (roundResult.equals(RoundResult.SELECTED_UPPER_CASE_IF_CORRECT))
            upperBridgeMap.append(Constants.SUCCESSFUL_CASE_MAP);

        if (roundResult.equals(RoundResult.SELECTED_UPPER_CASE_IF_WRONG))
            upperBridgeMap.append(Constants.FAILED_CASE_MAP);

        lowerBridgeMap.append(Constants.NON_ANSWER_CASE_MAP);
        startBridgeMapMake();
    }

    private void renewBridgeMapLowerCase(RoundResult roundResult) {
        if (roundResult.equals(RoundResult.SELECTED_LOWER_CASE_IF_CORRECT))
            lowerBridgeMap.append(Constants.SUCCESSFUL_CASE_MAP);

        if (roundResult.equals(RoundResult.SELECTED_LOWER_CASE_IF_WRONG))
            lowerBridgeMap.append(Constants.FAILED_CASE_MAP);

        upperBridgeMap.append(Constants.NON_ANSWER_CASE_MAP);
        startBridgeMapMake();
    }

    private void startBridgeMapMake() {
        upperBridgeMap.append(Constants.SEPARATOR);
        lowerBridgeMap.append(Constants.SEPARATOR);
    }

    public StringBuilder getUpperBridgeMap() {
        return upperBridgeMap;
    }

    public StringBuilder getLowerBridgeMap() {
        return lowerBridgeMap;
    }
}
