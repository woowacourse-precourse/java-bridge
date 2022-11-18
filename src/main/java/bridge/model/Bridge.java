package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private ArrayList<String> upBridge;
    private ArrayList<String> downBridge;

    public Bridge() {
        upBridge = new ArrayList<>(){{
            upBridge.add("[");
            upBridge.add("]");
        }};
        downBridge = new ArrayList<>(){{
            downBridge.add("[");
            downBridge.add("]");
        }};
    }

    public ArrayList<String> getUpBridge() {
        return upBridge;
    }

    public ArrayList<String> getDownBridge() {
        return downBridge;
    }

    public void setUpBridge(String mark) {
        if (Player.getCurrentLocation() == 0) {
            if (mark.equals("O")) {
                upBridge.add(1, "O");
                downBridge.add(1, " ");
            } else {
                upBridge.add(1, "X");
                downBridge.add(1, " ");
            }
        } else {
            if (mark.equals("O")) {
                upBridge.add(Player.getCurrentLocation() + 1, "|");
                upBridge.add(Player.getCurrentLocation() + 2, "O");
                downBridge.add(Player.getCurrentLocation() + 1, "|");
                downBridge.add(Player.getCurrentLocation() + 2, " ");
            } else {
                upBridge.add(Player.getCurrentLocation() + 1, "|");
                upBridge.add(Player.getCurrentLocation() + 2, "X");
                downBridge.add(Player.getCurrentLocation() + 1, "|");
                downBridge.add(Player.getCurrentLocation() + 2, " ");
            }
        }
    }

    public void setDownBridge(String mark) {
        if (Player.getCurrentLocation() == 0) {
            if (mark.equals("O")) {
                downBridge.add(1, "O");
                upBridge.add(1, " ");
            } else {
                downBridge.add(1, "X");
                upBridge.add(1, " ");
            }
        } else {
            if (mark.equals("O")) {
                downBridge.add(Player.getCurrentLocation() + 1, "|");
                downBridge.add(Player.getCurrentLocation() + 2, "O");
                upBridge.add(Player.getCurrentLocation() + 1, "|");
                upBridge.add(Player.getCurrentLocation() + 2, " ");
            } else {
                downBridge.add(Player.getCurrentLocation() + 1, "|");
                downBridge.add(Player.getCurrentLocation() + 2, "X");
                upBridge.add(Player.getCurrentLocation() + 1, "|");
                upBridge.add(Player.getCurrentLocation() + 2, " ");
            }
        }
    }
}
