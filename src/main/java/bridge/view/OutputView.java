package bridge.view;

import bridge.service.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String UPPER_BRIDGE = "U";
    private final String DOWNER_BRIDGE = "D";
    public void printStartGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> result, String bridgeSelection) {
        System.out.print("[");
        for(int index=0; index<result.get(0).size(); index++){
            printMoveOrBlank(result, index, bridgeSelection);
            printVerticalBar(result.get(0).size(), index);
        }
        System.out.println("]");
    }

    private void printMoveOrBlank(List<List<String>> result, int index, String bridgeSelection){
        List<String> userBridge = result.get(0);
        List<String> bridgeLog = result.get(1);
        if(userBridge.get(index).equals(bridgeSelection)){
            System.out.printf(" %s ",bridgeLog.get(index));
            return;
        }
        System.out.print("   ");
    }

    private void printVerticalBar(int bridgeSize, int index){
        if(index != bridgeSize-1){
            System.out.print("|");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getRoundResult(), UPPER_BRIDGE);
        printMap(bridgeGame.getRoundResult(), DOWNER_BRIDGE);
        printIsGameCompleted(bridgeGame.isGameCompleted());
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTotalAttempt());
    }

    private void printIsGameCompleted(boolean isGameCompleted){
        if(isGameCompleted){
            System.out.println("\n게임 성공 여부: 성공");
            return;
        }
        System.out.println("\n게임 성공 여부: 실패");
    }
}