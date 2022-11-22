package bridge.reader;

import bridge.domain.UserCharacters;

import java.util.List;

public class SuccessReader {

    public boolean isSuccess(String user, String bridge) {
        return user.equals(bridge);
    }

    public boolean isNotCrossBridgeSuccess(int bridgeSize, int footPrintSize) {
        if (footPrintSize == bridgeSize) return false;
        return true;
    }


    public boolean isOverallSuccess(List<String> userCharacters, List<String> bridge) {
        return !isNotCrossBridgeSuccess(bridge.size(), userCharacters.size())
                && isSuccess(userCharacters.get(userCharacters.size() - 1), bridge.get(bridge.size() - 1));
    }
}
