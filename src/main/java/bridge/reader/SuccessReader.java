package bridge.reader;

import bridge.domain.UserCharacters;

import java.util.List;

public class SuccessReader {

    public boolean isNotCrossBridgeSuccess(int bridgeSize, int footPrintSize) {
        if (footPrintSize == bridgeSize) return false;
        return true;
    }

    public boolean isUnitSuccess(UserCharacters userCharacters, List<String> bridge) {
        List<String> footprints = userCharacters.getFootprints();
        return bridge.get(userCharacters.getFootPrintLastIndex()).equals(footprints.get(userCharacters.getFootPrintLastIndex()));
    }

    public boolean isOverallSuccess(UserCharacters userCharacters, List<String> bridge) {
        return !isNotCrossBridgeSuccess(bridge.size(), userCharacters.getFootPrintSize()) && isUnitSuccess(userCharacters, bridge);
    }

}
