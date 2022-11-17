package view;

import java.util.HashMap;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printRunGameText(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }

    public void printResultText(){
        System.out.println("최종 게임 결과");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String[][] userMap,int distance) {
        for(int row = 1; row >=0; row--){
            System.out.print("[ ");
            for(int column = 0; column<distance; column++){
                System.out.print(String.format("%s | ",userMap[row][column]));
            }
            System.out.println(String.format("%s ]",userMap[row][distance]));
        }
        System.out.println("");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int result,int countOfAttempt) {
        Map<Integer,String> resultTable = new HashMap<>();
        resultTable.put(1,"성공");
        resultTable.put(-1,"실패");

        System.out.println(String.format("게임 성공 여부: %s",resultTable.get(result)));
        System.out.print(String.format("총 시도한 횟수: %,d",countOfAttempt));
    }
}
