package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    List<String> first_Line_Bridge = new ArrayList<>();
    List<String> second_Line_Bridge = new ArrayList<>();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void startGuidance(){
        System.out.println("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.");
    }

    public void moveGuidance(){
        System.out.println("\n이동할 칸을 선택해주세요");
    }

    public void printMap(List<String> result, int num) {
        first_Line_Bridge.add(result.get(result.size()-2));
        second_Line_Bridge.add(result.get(result.size()-1));
        Map(first_Line_Bridge, second_Line_Bridge, num);
    }

    public void Map(List<String> first_Line_Bridge, List<String> second_Line_Bridge, int num){
        mapping(first_Line_Bridge, num);
        mapping(second_Line_Bridge, num);
    }

    public void mapping(List<String> bridge, int num){
        for(int i=0; i<=num; i++){
            if(i==0) System.out.print("[ ");
            if(i!=0) System.out.print(" | ");
            System.out.print(bridge.get(i));
            if(i==num) System.out.println(" ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
