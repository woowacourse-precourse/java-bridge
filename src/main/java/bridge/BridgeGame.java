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

    int status = 0;
    int stage = 1;
    int trial = 1;
    int success = 0;


    public void game(List<String> bridge){
        while (status == 0) {
            if (stage == bridge.size() + 1) {
                success = 1;
                break;
            }
            this.move(bridge, stage);
            stage++;
            checkRetry(bridge);
        }
    }

    public void checkRetry(List<String> bridge){
        if (status == 1){
            retry(inputView, bridge);
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge, int stage) {
        String direction = inputView.readMoving();
        if (!bridge.get(stage-1).equals(direction)){
            status = 1;
            outputView.printMap(bridge, stage, status);
        }
        if(bridge.get(stage-1).equals(direction)){
            status = 0;
            outputView.printMap(bridge, stage, status);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(InputView inputView, List<String>bridge) {
        String input = inputView.readGameCommand();
        inputR(input);
        inputQ(input);
    }


    public void inputR(String input) {
        if (input.equals("R")) {
            outputView.printGameOver();
            stage = 1;
            status = 0;
            trial++;
        }
    }
    public void inputQ(String input) {
        if (input.equals("Q")) {
            stage--;
            status = 1;
        }
    }

    public List<String> createUpperBridge(List<String> bridge){
        List<String> upperBridge = new ArrayList<>(Arrays.asList("["));
        for (String direction: bridge){
            upperBridgeMap(upperBridge, direction);
        }
        upperBridge.set(upperBridge.size()-1,"]");
        return upperBridge;
    }

    public List<String> upperBridgeMap(List<String> bridge, String direction){
        if (direction.equals("U")){
            bridge.add(" O ");
        }
        if (!direction.equals("U")){
            bridge.add("   ");
        }
        bridge.add("|");
        return bridge;
    }

    public List<String> createBottomBridge(List<String> bridge){
        List<String> bottomBridge = new ArrayList<>(Arrays.asList("["));
        for (String direction: bridge){
            bottomBridgeMap(bottomBridge, direction);
        }
        bottomBridge.set(bottomBridge.size()-1,"]");
        return bottomBridge;
    }

    public List<String> bottomBridgeMap(List<String> bridge, String direction){
        if (direction.equals("D")){
            bridge.add(" O ");
        }
        if (!direction.equals("D")){
            bridge.add("   ");
        }
        bridge.add("|");
        return bridge;
    }

    public void finalResult(List<String> bridge){
        outputView.printResult();
        outputView.printMap(bridge, stage-1, status);
        outputView.printSuccess(success);
        outputView.printFailure(success);
        outputView.printTrialAmount(trial);
    }


    public List<List<String>> createBridges(List<String> bridge, int stageIndex){
        List<String> upperBridge = createUpperBridge(bridge);
        List<String> bottomBridge = createBottomBridge(bridge);
        upperBridge.set(stageIndex, "]");
        bottomBridge.set(stageIndex, "]");
        List<List<String>> bothBridges = new ArrayList<>(Arrays.asList(upperBridge,bottomBridge));
        return bothBridges;
    }

    public void moveSuccess(List<List<String>> bothBridges, int stageIndex){
        if (bothBridges.get(0).get(stageIndex - 1).equals(" O ")) {
            bothBridges.get(0).set((stageIndex-1), "   ");
            bothBridges.get(1).set((stageIndex-1), " X ");
        }
        if (bothBridges.get(1).get(stageIndex - 1).equals(" O ")) {
            bothBridges.get(1).set((stageIndex-1), "   ");
            bothBridges.get(0).set((stageIndex-1), " X ");
        }
    }

}
