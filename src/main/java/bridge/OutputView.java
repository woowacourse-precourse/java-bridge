package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */

import java.util.ArrayList;
import java.util.List;
public class OutputView {

    private static final String EMPTY = " ";
    private static final List<String> RESULT_MESSAGE =
            new ArrayList<String>(List.of("최종 게임 결과",  "게임 성공 여부: ","총 시도한 횟수: "));
    private static final List<String> BRIDGE_MESSAGE = new ArrayList<String>(List.of("[ "," | ", " ]"));
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Glass> history, State lastState) {
        System.out.println(drawMap(history, lastState));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Glass> history, State lastState, int play) {
        System.out.println(drawResult(history, lastState, play));
    }

    public String drawMap(List<Glass> history, State lastState){
        List<String> map= new ArrayList<String>(List.of(BRIDGE_MESSAGE.get(0),BRIDGE_MESSAGE.get(0)));

        for(int hIdx = 0; hIdx < history.size(); hIdx++){
            int dir = getDirection(history, hIdx, lastState);
            State state = getState(hIdx, history.size(), lastState);

            updateMap(map, dir, state);
        }
        return map.get(0) + System.lineSeparator() + map.get(1) + System.lineSeparator() ;
    }

    public State getState(int historyIdx, int historySize, State lastState){
        if(historyIdx == historySize -1){
            return lastState;
        }
        return State.SAFE;
    }

    public Integer getDirection(List<Glass> history, int historyIdx, State lastState){
        int direction = history.get(historyIdx).DIRECTION();
        if(historyIdx == history.size() - 1 && !lastState.ALIVE()){
            return 1 - direction;
        }
        return direction;
    }

    public void updateMap(List<String> map, int dir, State state){
        map.set(dir, map.get(dir) + state.OX() + BRIDGE_MESSAGE.get(1));
        map.set(1-dir, map.get(1-dir) + EMPTY + BRIDGE_MESSAGE.get(1));
    }


    public String drawResult(List<Glass> history, State lastState, int play){
        String message = "";
        message += RESULT_MESSAGE.get(0) + System.lineSeparator();
        message += drawMap(history, lastState) + System.lineSeparator();
        message += RESULT_MESSAGE.get(1) + lastState.RESULT() + System.lineSeparator();
        message += RESULT_MESSAGE.get(2) + play;

        return message;
    }
}
