package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */

import static bridge.enums.Message.BRIDGE_END;
import static bridge.enums.Message.BRIDGE_MIDDLE;
import static bridge.enums.Message.BRIDGE_START;
import static bridge.enums.Message.COMMAND;
import static bridge.enums.Message.EMPTY;
import static bridge.enums.Message.MOVE;
import static bridge.enums.Message.RESULT;
import static bridge.enums.Message.SIZE;
import static bridge.enums.Message.START;
import static bridge.enums.Message.SUCCESS;
import static bridge.enums.Message.TRY;

import bridge.enums.Glass;
import bridge.enums.State;
import java.util.ArrayList;
import java.util.List;
public class OutputView {



    public void printStartMessage(){
        System.out.println(START.OF());
    }
    public void printSizeMessage(){
        System.out.println(SIZE.OF());
    }
    public void printMoveMessage(){
        System.out.println(MOVE.OF());
    }
    public void printCommandMessage(){
        System.out.println(COMMAND.OF());
    }
    public void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }


    public void printResult(List<Glass> history, State lastState, int play) {
        System.out.println(drawResult(history, lastState, play));
    }
    public void printMap(List<Glass> history, State lastState) {
        System.out.println(drawMap(history, lastState));
    }


    public String drawMap(List<Glass> history, State lastState){
        List<String> map= new ArrayList<String>(List.of(BRIDGE_START.OF(),BRIDGE_START.OF()));

        for(int hIdx = 0; hIdx < history.size(); hIdx++){
            int dir = isLastGlass(history, hIdx, lastState);
            State state = isLastState(hIdx, history.size(), lastState);

            updateMap(map, dir, state);
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

    public State isLastState(int historyIdx, int historySize, State lastState){
        if(historyIdx == historySize -1){
            return lastState;
        }
        return State.SAFE;
    }

    public Integer isLastGlass(List<Glass> history, int historyIdx, State lastState){
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


    public String drawResult(List<Glass> history, State lastState, int play){
        String message = "";
        message += RESULT.OF() + System.lineSeparator();
        message += drawMap(history, lastState) + System.lineSeparator();
        message += SUCCESS.OF() + lastState.RESULT() + System.lineSeparator();
        message += TRY.OF() + play;

        return message;
    }
}
