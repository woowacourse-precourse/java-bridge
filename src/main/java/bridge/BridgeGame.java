package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private  InputView inputView = new InputView();
    private  OutputView outputView = new OutputView();

    private int trial = 1;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(List<String> bridge, int stage) {
        //0이면 성공 1이면 실패
        String direction = inputView.readMoving();
        if (!bridge.get(stage-1).equals(direction)){
            return 1;
        }
        return 0;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }


    public List<String> createUpperBridge(List<String> bridge){
        List<String> upperBridge = new ArrayList<>(Arrays.asList("["));
        for (String direction: bridge){
            if (direction.equals("U")){
                upperBridge.add(" O ");
                upperBridge.add("|");
            } else {
                upperBridge.add("   ");
                upperBridge.add("|");
            }
        }
        upperBridge.set(upperBridge.size()-1,"]");
        return upperBridge;
    }

    public List<String> createBottomBridge(List<String> bridge){
        List<String> bottomBridge = new ArrayList<>(Arrays.asList("["));
        for (String direction: bridge){
            if (direction.equals("D")){
                bottomBridge.add(" O ");
                bottomBridge.add("|");
            } else {
                bottomBridge.add("   ");
                bottomBridge.add("|");
            }
        }
        bottomBridge.set(bottomBridge.size()-1,"]");
        return bottomBridge;
    }
    public void gameOver(){

    }

    public void finalResult(){

    }

    public void gamePass(){

    }

    public void gameEnd(){

    }

    public void trialAmount(){

    }

}
