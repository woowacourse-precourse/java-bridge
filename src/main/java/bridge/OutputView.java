package bridge;

import java.util.ArrayList;
import java.util.List;
//TODO 리팩토링 하면서 다리 리스트 설계 파트 BridgeGame 으로 옮기기
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {



    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> finalResult){
        int size = finalResult.size();
        System.out.printf("[");
        for (int index = 0; index < size / 2; index++) {
            System.out.printf(finalResult.get(index));
            if(index<size/2-1){
                System.out.printf("|");
            }
        }
        System.out.println("]");


        System.out.printf("[");
        for (int index = size / 2; index < size; index++) {
            System.out.printf(finalResult.get(index));
            if(index<size-1){
                System.out.printf("|");
            }
        }
        System.out.println("]");
    }

    public void designBridgeMap(List<String> bridgeAnswer, List<String> currentResult, boolean userChoice, int stage) {
        BridgeGame bridgeGame = new BridgeGame();
        if (userChoice) {
            currentResult = bridgeGame.printMapCorrect(bridgeAnswer, currentResult, stage);
        }
        if (!userChoice) {
            currentResult = bridgeGame.printMapWrong(bridgeAnswer, currentResult, stage);
        }
        printMap(currentResult);
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeAnswer, List<String> currentResult, int stage,int count) {

        System.out.println("최종 게임 결과");
        printMap(currentResult);
        if(bridgeAnswer.size() == stage){
            System.out.println("게임 성공 여부: 성공");
        }
        if(stage<bridgeAnswer.size()){
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: "+count);

    }
}
