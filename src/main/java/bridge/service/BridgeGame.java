package bridge.service;

import bridge.enums.ControlKey;
import bridge.enums.InGameMessage;
import bridge.model.Bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private Bridge bridge;
    private MapMaker mapMaker;
    private int gameCount = 1;
    private boolean crossed = true;
    private List<String> directions = new ArrayList<>();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.mapMaker = new MapMaker();
    }

    public void play(String input) {
        move(input);
    }

    private void move(String inputKey) {
        directions.add(inputKey);
        int index = directions.size() - 1;
        mapMaker.updateMap(bridge, index, inputKey);
    }

    public boolean canCross() {
        if(directions.isEmpty()) return true;
        int index = directions.size() - 1;
        return bridge.canCross(directions.get(index), index);
    }

    public boolean isWin() {
        if (directions.isEmpty()) return false;
        int lastIndex = directions.size() - 1;
        return (directions.size() == bridge.getBridgeSize()) && bridge.isSame(lastIndex, directions.get(lastIndex));
    }

    public void retry(String inputKey) {
        if(inputKey.equals(ControlKey.RETRY.getKey())){
            initMap();
            directions.clear();
            gameCount++;
            return;
        }
        crossed = false;
    }

    public String getMap() {
        return mapMaker.getMap();
    }

    public String getResultMap() {
        return mapMaker.makeResultMap();
    }

    private void initMap() {
        mapMaker.initBridge();
    }

    public String getResult() {
        return InGameMessage.SUCCESS_OR_FAILURE.getMessage()+ InGameMessage.findMessageBySuccessOrNot(crossed)
                + "\n" + InGameMessage.TRY_COUNT.getMessage() + gameCount;
    }
}
