package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void gameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }

    public void printRequestSize(){
        System.out.println(GameMessage.REQUEST_BRIDGE_LENGTH_MESSAGE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map);
        System.out.println("");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, BridgeGame bridgeGame) {
        printEndGame();
        String s = bridgeGame.printFinalBridge(bridge);
        System.out.println(s);
        printSuccess(bridge, bridgeGame.getSize(), s);
        printTryCount(bridgeGame.getTryCount());
    }

    public void printRequestUpDownMessage(){
        System.out.println(GameMessage.REQUEST_MOVE_MESSAGE.getMessage());
    }


    public void printSuccess(List<String> bridge, int step, String str){
        System.out.println("");
        if(bridge.size() == step && !str.contains(Variable.FAIL.getStr())){
            System.out.println(GameMessage.GAME_SUCCESS_MESSAGE.getMessage());
        }
        if(bridge.size() != step || str.contains(Variable.FAIL.getStr())){
            System.out.println(GameMessage.GAME_FAIL_MESSAGE.getMessage());
        }
    }

    public void printRequestRetry(){
        System.out.println(GameMessage.REQUEST_RETRY_MESSAGE.getMessage());
    }

    public void printEndGame(){
        System.out.println(GameMessage.FINAL_RESULT_MESSAGE.getMessage());
    }

    public void printTryCount(int count){
        System.out.println(GameMessage.TOTAL_COUNT_MESSAGE.getMessage() + count);
    }
}
