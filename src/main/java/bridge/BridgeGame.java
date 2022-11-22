package bridge;

import java.util.ArrayList;
import java.util.List;


public class BridgeGame {


    private final List<Glass> BRIDGE;
    private static Integer step;
    private static Integer playTime;


    public List<Glass> history() {
        return BRIDGE.subList(0, step);
    }

    public Integer playTime() { return playTime;    }

    public boolean isClear(){
        return step == BRIDGE.size();
    }
    public State move(Glass user) {
        return State.stateOf(user == BRIDGE.get(step++));
    }

    public void retry() {
        playTime++;
        step = 0;
    }

    public List<Glass> buildBridge(List<String> bridge){
        List<Glass> newBridge= new ArrayList<Glass>();

        for(String move: bridge){
            newBridge.add(Glass.glassOf(move));
        }
        return newBridge;
    }

    BridgeGame(List<String> bridge){
        step = 0;
        playTime = 1;
        BRIDGE = buildBridge(bridge);
    }
}
