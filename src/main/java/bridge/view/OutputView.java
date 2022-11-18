package bridge.view;

import bridge.model.Bridge;
import bridge.model.User;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String UPPER ="U";
    private static final String LOWER ="D";
    private static OutputLogic outputLogic;
    public OutputView(List<String> bridgeList){
        this.outputLogic = new OutputLogic(bridgeList);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Boolean userResult,int userPosition) {
        outputLogic.printMapLogic(UPPER,userPosition,userResult);
        changeLine();
        outputLogic.printMapLogic(LOWER,userPosition,userResult);
        changeLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Boolean result) {
    }
    private void changeLine(){
        System.out.println();
    }
}
