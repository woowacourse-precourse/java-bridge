package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridgeWin;
    private final List<String> bridgeNow;
    private int countTotal = 1;

    public Bridge(List<String> bridge) {
        this.bridgeWin = bridge;
        this.bridgeNow = new ArrayList<>();
    }

    public boolean applyMove(String moveTo) {
        bridgeNow.add(moveTo);
        if(!checkSucces()) {
            OutputView.printMap(bridgeNow, false, moveTo);
            return false;
        }
        OutputView.printMap(bridgeNow, true, moveTo);
        return true;
    }

    public void clearBridgeNow() {
        bridgeNow.clear();
        increaseCount();
    }

    private boolean checkSucces() {
        for (int i=0; i<bridgeNow.size(); i++) {
            if(!bridgeNow.get(i).equals(bridgeWin.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkFinish() {
        return bridgeWin.equals(bridgeNow);
    }

    public List<String> getBridgeNow() {
        return bridgeNow;
    }

    private void increaseCount() {
        this.countTotal += 1;
    }

    int getCountTotal() {
        return countTotal;
    }
}
