package bridge.model;

import bridge.BridgeRandomNumberGenerator;
import bridge.view.MessageView;

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

    private void isFirstBridgeUpToDown(String mark) {
        upBridge.add(1, makeSpace(mark));
        downBridge.add(1, MessageView.SPACE.getMessage());
    }

    private void isFirstBridgeDownToUp(String mark) {
        downBridge.add(1, makeSpace(mark));
        upBridge.add(1, MessageView.SPACE.getMessage());
    }

    public void setUpBridge(String mark) {
        if (Player.currentLocation == 0) {
            isFirstBridgeUpToDown(mark);
            return;
        }
        isContains(mark);
        checkBridgeSequence(mark, upBridge, downBridge);
    }

    public void setDownBridge(String mark) {
        if (Player.currentLocation == 0) {
            isFirstBridgeDownToUp(mark);
            return;
        }
        isContains(mark);
        checkBridgeSequence(mark, downBridge, upBridge);
    }

    private void checkBridgeSequence(String mark, ArrayList<String> upBridge, ArrayList<String> downBridge) {
        moreThanFirstBridge(mark, upBridge);
        moreThanFirstBridgeSpace(downBridge);
    }

    private boolean isContains(String mark) {
        return mark.contains(MessageView.O.getMessage());
    }

    private void moreThanFirstBridgeSpace(ArrayList<String> bridge) {
        bridge.add(Player.currentLocation * 2, MessageView.INTERVAL.getMessage());
        bridge.add(Player.currentLocation * 2 + 1, MessageView.SPACE.getMessage());
    }

    private void moreThanFirstBridge(String markWithOX, ArrayList<String> bridge) {
        bridge.add(Player.currentLocation * 2, MessageView.INTERVAL.getMessage());
        bridge.add(Player.currentLocation * 2 + 1, makeSpace(markWithOX));
    }

    public void resetBridge() {
        initBridge();
    }

    public void setSize(int size) {
        this.size = size - 1;
    }

    public boolean buildBridge() {
        List<Boolean> checkRoad = gameStatistics.getCheckRoad();
        Boolean answer = checkRoad.get(Player.currentLocation);
        if (answer) {
            return checkAnswerRoadForO();
        } return checkAnswerRoadForX();
    }

    private Boolean checkAnswerRoadForO() {
        if (gameStatistics.getAnswerRoad().get(Player.currentLocation).equals(MessageView.DOWN.getMessage())) {
            setDownBridge(MessageView.O.getMessage());
        } else if (gameStatistics.getAnswerRoad().get(Player.currentLocation).equals(MessageView.UP.getMessage())) {
            setUpBridge(MessageView.O.getMessage());
        }
        return true;
    }

    private Boolean checkAnswerRoadForX() {
        if (gameStatistics.getAnswerRoad().get(Player.currentLocation).equals(MessageView.DOWN.getMessage())) {
            setUpBridge(MessageView.X.getMessage());
        } else if (gameStatistics.getAnswerRoad().get(Player.currentLocation).equals(MessageView.UP.getMessage())) {
            setDownBridge(MessageView.X.getMessage());
        }
        return false;
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

    private String makeSpace(String mark) {
        return " " + mark + " ";
    }
}

