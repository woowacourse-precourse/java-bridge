package bridge.model;

import static bridge.enums.Message.BRIDGE_END;
import static bridge.enums.Message.BRIDGE_MIDDLE;
import static bridge.enums.Message.BRIDGE_START;
import static bridge.enums.Message.EMPTY;
import static bridge.enums.Message.RESULT;
import static bridge.enums.Message.SUCCESS;
import static bridge.enums.Message.TRY;

import bridge.enums.Glass;
import bridge.enums.State;
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

    public String drawMap(State lastState){
        List<Glass> history = history();
        List<String> map= new ArrayList<String>(List.of(BRIDGE_START.OF(),BRIDGE_START.OF()));

        for(int hIdx = 0; hIdx < history.size(); hIdx++){

            updateMap(map, isLastGlass(hIdx, lastState), isLastState(hIdx,lastState));
        }
        return combineMap(map);
    }

    public String combineMap(List<String> map){
        int popLen = BRIDGE_MIDDLE.OF().length();
        String upSide = map.get(1);
        String downSide = map.get(0);

        upSide = upSide.substring(0, upSide.length()-popLen) + BRIDGE_END.OF();
        downSide = downSide.substring(0, downSide.length()-popLen) + BRIDGE_END.OF();

        return upSide + System.lineSeparator() + downSide + System.lineSeparator();
    }

    public State isLastState(int historyIdx, State lastState){
        if(historyIdx == history().size() -1){
            return lastState;
        }
        return State.SAFE;
    }

    public Integer isLastGlass(int historyIdx, State lastState){
        List<Glass> history = history();
        int direction = history.get(historyIdx).DIRECTION();
        if(historyIdx == history.size() - 1 && !lastState.ALIVE()){
            return 1 - direction;
        }
        return direction;
    }

    public void updateMap(List<String> map, int dir, State state){
        map.set(dir, map.get(dir) + state.OX() + BRIDGE_MIDDLE.OF());
        map.set(1-dir, map.get(1-dir) + EMPTY.OF() + BRIDGE_MIDDLE.OF());
    }


    public String drawResult(State lastState){
        String message = new String();
        message += RESULT.OF() + System.lineSeparator();
        message += drawMap(lastState) + System.lineSeparator();
        message += SUCCESS.OF() + lastState.RESULT() + System.lineSeparator();
        message += TRY.OF() + playTime;

        return message;
    }

    public BridgeGame(List<String> bridge){
        step = 0;
        playTime = 1;
        BRIDGE = buildBridge(bridge);
    }
}
