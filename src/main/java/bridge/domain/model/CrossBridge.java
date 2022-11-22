package bridge.domain.model;

import bridge.constants.ValidMessage;
import java.util.ArrayList;
import java.util.List;

public class CrossBridge {

    private static final String UP = "U";
    private static final String DOWN = "D";

    private static final List<String> crossBridgeUp = new ArrayList<>();
    private static final List<String> crossBridgeDown = new ArrayList<>();
    private static int totalTry = 0;
    private static boolean success = false;

    Bridge bridge = new Bridge();

    public CrossBridge() {

    }

    public void setNewGame() {
        CrossBridge.totalTry++;
        CrossBridge.success = false;
        crossBridgeUp.clear();
        crossBridgeDown.clear();
    }

    public void addCrossBridge(String where) {
        int goIndex = getCrossBridgeSize();
        for (ValidMessage validMessage : ValidMessage.values()) {
            if (validMessage.getIsValid() == bridge.isValid(goIndex, where)) {
                addCrossBridgeWhereMessage(where, validMessage.getPrintOX());
            }
        }
        setSuccess(where);
    }

    public void addCrossBridgeWhereMessage(String where, String validMessage) {
        if (where.equals(UP)) {
            crossBridgeUp.add(validMessage);
            crossBridgeDown.add(" ");
            return;
        }
        crossBridgeUp.add(" ");
        crossBridgeDown.add(validMessage);
    }

    public void addCrossBridgeDown(String where) {

    }

    public List<String> getCrossBridgeUp() {
        return crossBridgeUp;
    }

    public List<String> getCrossBridgeDown() {
        return crossBridgeDown;
    }

    public String getCrossBridgeIndex(String where, int index) {
        if (crossBridgeUp.get(index).isEmpty() || crossBridgeDown.get(index).isEmpty()) {
            throw new IllegalArgumentException("[ERROR] this index is null");
        }
        if (where.equals(UP)) {
            return crossBridgeUp.get(index);
        }
        return crossBridgeDown.get(index);

    }

    public int getCrossBridgeSize() {
        if (crossBridgeUp.size() != crossBridgeDown.size()) {
            throw new IllegalArgumentException("[ERROR] not equal size upBridge and downBridge");
        }
        return crossBridgeUp.size();
    }

    public int getTotalTry() {
        return totalTry;
    }

    public String getSuccess() {
        if (success) {
            return "성공";
        }
        return "실패";
    }

    public void setSuccess(String where) {
        if (isEnd()) {
            if (isCurrentValid(where)) {
                CrossBridge.success = true;
            }
        }
    }

    public boolean isCurrentValid(String where) {
        return bridge.isValid(getCrossBridgeSize() - 1, where);
    }

    public boolean isEnd() {
        return (getCrossBridgeSize() == bridge.getSize());
    }
}
