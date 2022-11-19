package bridge.model;

import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private ArrayList<String> upBridge;
    private ArrayList<String> downBridge;
    private int size;
    private GameStatistics gameStatistics;
    private BridgeMaker bridgeMaker;
    public Bridge(GameStatistics gameStatistics) {
        this.gameStatistics = gameStatistics;
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        initBridge();
    }

    public void initBridge() {
        upBridge = new ArrayList<>() {{
            add("[");
            add("]");
        }};
        downBridge = new ArrayList<>() {{
            add("[");
            add("]");
        }};
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

    public void resetBridge() {
        initBridge();
    }

    public void setSize(int size) {
        this.size = size - 1;
    }

    public boolean buildBridge() {
        boolean checkProcess;
        List<Boolean> checkRoad = gameStatistics.getCheckRoad();
        if (checkRoad.get(Player.currentLocation)) {
            checkProcess = true;
            if (gameStatistics.getAnswerRoad().get(Player.currentLocation).equals("D")) {
                setDownBridge("O");
            } else if (gameStatistics.getAnswerRoad().get(Player.currentLocation).equals("U")) {
                setUpBridge("O");
            }
        } else { //false
            checkProcess = false;
            if (gameStatistics.getAnswerRoad().get(Player.currentLocation).equals("D")) {
                setUpBridge("X");
            } else if (gameStatistics.getAnswerRoad().get(Player.currentLocation).equals("U")) {
                setDownBridge("X");
            }
        }
        return checkProcess;
    }

    public BridgeMaker getBridgeMaker() {
        return bridgeMaker;
    }

    public ArrayList<String> getUpBridge() {
        return upBridge;
    }

    public ArrayList<String> getDownBridge() {
        return downBridge;
    }

    public int getSize() {
        return size;
    }
}

