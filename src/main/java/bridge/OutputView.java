package bridge;

import java.util.List;

import static bridge.BridgeGame.numberOfTry;
import static bridge.BridgeGame.round;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    MapMaker mapMaker = new MapMaker();
    BridgeGame bridgeGame = new BridgeGame();
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, boolean match, String inputMove) {
        if (!match) {
            printFailMap(bridge,inputMove);
        }
        printSuccessMap(bridge,match);
    }

    public void printSuccessMap(List<String> bridge, boolean match) {
        if (match) {
            System.out.printf("[%s]\n", mapMaker.makeUpperMap(bridge, round));
            System.out.printf("[%s]\n", mapMaker.makeLowerMap(bridge, round));
        }
    }

    public void printFailMap(List<String> bridge, String inputMove) {
        List<String> FailMap = mapMaker.makeWrongPassMap(bridge,round,inputMove);
        System.out.printf("[%s]\n",FailMap.get(0)); // 실패한 경우의 상층부 맵 출력
        System.out.printf("[%s]\n",FailMap.get(1)); // 실패한 경우의 하층부 맵 출력
    }

    public void printFinalMap(List<String> bridge,String inputMove) {
        boolean success = bridgeGame.judgeSuccess(bridge);
        if (!success){
            printFailMap(bridge,inputMove);
        }
        printSuccessMap(bridge,success);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge,String inputMove) {
        String successOrFail = bridgeGame.judgeSuccessOrFail(bridge);
        System.out.println("최종 게임 결과");
        printFinalMap(bridge,inputMove);
        System.out.printf("게임 성공 여부: %s\n",successOrFail);
        System.out.printf("총 시도한 횟수: %d\n", numberOfTry);
    }

    public void printGameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
