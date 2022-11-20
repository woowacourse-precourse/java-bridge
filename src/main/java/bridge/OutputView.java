package bridge;

import java.util.List;

import static Constant.BridgeMakerConstant.BRIDGE_ROUTE;
import static Constant.PrintText.*;
import static Constant.GameCondition.ENDING;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge) {
        List<List<String>> stepMemory = bridge.getStepMemory();
        for(int i=0; i<BRIDGE_ROUTE.getBranchNum(); i++){
            String outputString = String.join(" | ", stepMemory.get(i));
            System.out.println("[ "+outputString+" ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge, boolean cond) {
        System.out.println(RESULT.getText());
        printMap(bridge);
        System.out.println(ENDING_MESSAGE.getText()+ENDING.getEnding(cond));
    }
    public void printTryCount(int cnt){
        System.out.println(TRY_COUNT.getText()+String.valueOf(cnt));
    }
}
