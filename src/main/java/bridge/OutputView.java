package bridge;

import java.util.ArrayList;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void printMapOneLine(String string){
        System.out.println("[ ");
        for (int i = 0; i < string.length()-1; i++) {
            System.out.print(string.charAt(i));
            System.out.print(" | ");
        }
        System.out.println(string.charAt(string.length())+" ]");
    }

    public void printMap(MapArray map) {
        printMapOneLine(map.getUpBridge());
        printMapOneLine(map.getDownBridge());
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MapArray map,boolean success) {
        String result = "성공";
        if(!success){
            result = "실패";
        }
        System.out.println("최종 게임 결과");
        printMap(map);
        System.out.println("게임 성공 여부: "+result);
    }
}
