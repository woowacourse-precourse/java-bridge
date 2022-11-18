package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private ArrayList<String> upBridge;
    private ArrayList<String> downBridge;
    private int size;
    public Bridge() {
        upBridge = new ArrayList<>(){{
            add("[");
            add("]");
        }};
        downBridge = new ArrayList<>(){{
            add("[");
            add("]");
        }};
    }

    public ArrayList<String> getUpBridge() {
        return upBridge;
    }

    public ArrayList<String> getDownBridge() {
        return downBridge;
    }

    public void setUpBridge(String mark) {
        if (Player.currentLocation == 0) {
            if (mark.equals("O")) {
                upBridge.add(1, " O ");
                downBridge.add(1, "   ");
            } else {
                upBridge.add(1, " X ");
                downBridge.add(1, "   ");
            }
        } else {
            if (mark.equals("O")) {
                upBridge.add(Player.currentLocation * 2, "|");
                upBridge.add(Player.currentLocation * 2 + 1, " O ");
                downBridge.add(Player.currentLocation * 2, "|");
                downBridge.add(Player.currentLocation * 2 + 1, "   ");
            } else {
                upBridge.add(Player.currentLocation * 2, "|");
                upBridge.add(Player.currentLocation * 2 + 1, " X ");
                downBridge.add(Player.currentLocation * 2, "|");
                downBridge.add(Player.currentLocation * 2 + 1, "   ");
            }
        }
    }

    public void setDownBridge(String mark) {
        if (Player.currentLocation == 0) {
            if (mark.equals("O")) {
                downBridge.add(1, " O ");
                upBridge.add(1, "   ");
            } else {
                downBridge.add(1, " X ");
                upBridge.add(1, "   ");
            }
        } else {
            if (mark.equals("O")) {
                downBridge.add(Player.currentLocation * 2, "|");
                downBridge.add(Player.currentLocation * 2 + 1, " O ");
                upBridge.add(Player.currentLocation * 2, "|");
                upBridge.add(Player.currentLocation * 2 + 1, "   ");
            } else {
                downBridge.add(Player.currentLocation * 2, "|");
                downBridge.add(Player.currentLocation * 2 + 1, " X ");
                upBridge.add(Player.currentLocation * 2, "|");
                upBridge.add(Player.currentLocation * 2 + 1, "   ");
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size - 1;
    }
}
