package bridge;

import bridge.domain.Result;
import bridge.util.Constants;
import bridge.util.SystemMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStartGame(){
        System.out.println(SystemMessage.START_GAME.print());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> result) {
        for(int i=0; i<result.size(); i++){
            printUpOrDownMap(result.get(i));
        }
    }
    public void printUpOrDownMap(List<String> result){
        System.out.print(SystemMessage.OUTPUT_BRIDGE_MAP_START.print());
        for(int i=0; i<result.size(); i++){
            System.out.printf(" %s ", result.get(i));
            if(i+1!=result.size()){
                System.out.print(SystemMessage.OUTPUT_BRIDGE_MAP_MIDDLE.print());
            }
        }
        System.out.println(SystemMessage.OUTPUT_BRIDGE_MAP_END.print());
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> result, boolean success, int tryCount) {
        System.out.println(SystemMessage.FINAL_RESULT.print());
        for(int i=0; i<result.size(); i++){
            printUpOrDownMap(result.get(i));
        }
        System.out.printf(SystemMessage.OUTPUT_GAME_SUCCESS_OR_NOT.print(), printSuccessOrNot(success));
        System.out.printf(SystemMessage.OUTPUT_TOTAL_ATTEMPT_COUNT.print(), tryCount);;
    }
    public String printSuccessOrNot(boolean success){
        if(success) return Constants.SUCCESS;
        return Constants.FAIL;
    }
}
