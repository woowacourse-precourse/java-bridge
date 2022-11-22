package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<BridgeSpace> bridgeSpaces = new ArrayList<>();

    public Bridge(List<String> bridgeStrs) {
        setBridge(bridgeStrs);
    }

    private void setBridge(List<String> bridgeStrs) {
        bridgeStrs.forEach(str -> {
            bridgeSpaces.add(new BridgeSpace(str));
        });
    }

    public List<BridgeSpace> getBridgeSpaces() {
        return bridgeSpaces;
    }

    public void getMapfromBridge(List<String> upList, List<String> downList) {
        bridgeSpaces.forEach(space -> {
            if ((space.getMyMoved() == Moved.NOTYET)) {
                return;
            }
            if ((space.getUpOrDown().equals("U") && space.getMyMoved() == Moved.CAN) || (space.getUpOrDown().equals("D") && space.getMyMoved() == Moved.CANT)) {
                upList.add(space.getMyMoved().getoOrX());
                downList.add(" ");
                return;
            }
            upList.add(" ");
            downList.add(space.getMyMoved().getoOrX());
        });
    }

}
