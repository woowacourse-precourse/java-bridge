package bridge.domain;

import java.util.List;

public class BridgeGame {
    private int index;

    public BridgeGame(int index){
        this.index = index;
    }

    public boolean move(List<String> bridge, String readMoving) {
        if (bridge.get(index).equals(readMoving)){
            return (true);
        }
        return (false);
    }

    public void retry(List<String> bridge, int bridgeSize) {
        Game reGame = new Game(bridge, bridgeSize);
        reGame.start();
    }

    public MapString makeMap(String input, boolean move, MapString mapString){
        index++;
        if (move){
            mapString.makeMapStringWhenSuccess(input);
            return (mapString);
        }
        mapString.makeMapStringWhenFail(input);
        return (mapString);
    }

    public int getIndex(){
        return (this.index);
    }
}
