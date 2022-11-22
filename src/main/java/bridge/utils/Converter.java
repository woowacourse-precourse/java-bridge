package bridge.utils;

import bridge.domain.exception.WrongBridgeValueException;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<String> getSituationThrough(List<Integer> bridgeValues) {
        List<String> bridge = new ArrayList<>();

        for (Integer bridgeValue : bridgeValues) {
            convertValueToSituation(bridge, bridgeValue);
        }
        if (bridgeValues.size() != bridge.size()) {
            throw new WrongBridgeValueException();
        }
        return bridge;
    }

    private static void convertValueToSituation(List<String> bridge, Integer bridgeValue) {
        if (bridgeValue == Constants.UP_VALUE) {
            bridge.add(Constants.UP_SITUATION);
        }
        if (bridgeValue == Constants.DOWN_VALUE) {
            bridge.add(Constants.DOWN_SITUATION);
        }
    }
}
