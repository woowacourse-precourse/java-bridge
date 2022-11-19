package bridge;

import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private BridgeGame bridgeGame;

    OutputView(BridgeGame bridgeGame){
        this.bridgeGame = bridgeGame;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String input) {
        Map<String, List<String>> bridge = bridgeGame.move(input);
        List<String> upBridge = bridge.get("up");
        List<String> downBridge = bridge.get("down");
        printSubBridge(upBridge);
        printSubBridge(downBridge);
    }

    private void printSubBridge(List<String> subBridge){
        System.out.print("[ ");
        int size = subBridge.size();
        for(int i = 0; i < size-1 ; i++ ){
            System.out.print(subBridge.get(i)+" | ");
        }
        System.out.println(subBridge.get(size-1)+" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
        Map<String, List<String>> bridge = bridgeGame.getResult();
        List<String> upBridge = bridge.get("up");
        List<String> downBridge = bridge.get("down");
        printSubBridge(upBridge);
        printSubBridge(downBridge);
    }

    public void printgetInfo(){
        boolean success = bridgeGame.getSuccess();
        int retryCount = bridgeGame.getRetryCount();
        printSucces(success);
        System.out.println("총 시도한 횟수: "+retryCount);
    }

    private void printSucces(boolean success){
        if(success){
            System.out.println("게임 성공 여부: 성공");
        }
        if(!success){
            System.out.println("게임 성공 여부: 실패");
        }
    }
}
