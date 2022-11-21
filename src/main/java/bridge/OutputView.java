package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printBridgeMap(List<List<String>> bridgeMap){
        for (int i = 0; i < bridgeMap.size(); i++) {
            System.out.println("[ " + String.join(" | ", bridgeMap.get(i)) + " ]");
        }
    }

    public void printResult(List<List<String>> bridgeMap,String successOrNot,int gameRepeatCount) {
        System.out.println("최종 게임 결과");
        printBridgeMap(bridgeMap);
        printSuccessOrNot(successOrNot);
        printGameRepeatCount(gameRepeatCount);
    }
    public void printSuccessOrNot(String successOrNot){
        System.out.println("게임 성공 여부: " + successOrNot);
    }
    public void printGameRepeatCount(int gameRepeatCount){
        System.out.println("총 시도한 횟수: " + gameRepeatCount);
    }

    public void printGameStart() {
        System.out.print("다리 건너기 게임을 시작합니다.\n\n");
    }
}
