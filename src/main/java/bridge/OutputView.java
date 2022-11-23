package bridge;

import java.util.List;


public class OutputView {

    public void printGameStartMessage() {
        System.out.print("다리 건너기 게임을 시작합니다.\n\n");
    }

    public void printResult(List<List<String>> bridgeMap,String successOrNot,int gameRepeatCount) {
        System.out.println("최종 게임 결과");
        printBridgeMap(bridgeMap);
        printSuccessOrNot(successOrNot);
        printGameRepeatCount(gameRepeatCount);
    }

    public void printBridgeMap(List<List<String>> bridgeMap){
        for (int i = 0; i < bridgeMap.size(); i++) {
            System.out.println("[ " + String.join(" | ", bridgeMap.get(i)) + " ]");
        }
    }

    private void printSuccessOrNot(String successOrNot){
        System.out.println("게임 성공 여부: " + successOrNot);
    }

    private void printGameRepeatCount(int gameRepeatCount){
        System.out.println("총 시도한 횟수: " + gameRepeatCount);
    }


}
