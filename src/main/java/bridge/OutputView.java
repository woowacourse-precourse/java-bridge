package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    int cur;
    List<String> bridge;
    public OutputView(int c,List<String> b){
        cur = c;
        bridge = b;
    }
    public String selectLetter(String letter, int i, int last){
        if(bridge.get(i).equals(letter)) {
            if(i != cur) return "O";
            if(last == 1) return "X";
            return "O";
        }
        else return " ";
    }
    public void printMap(String letter, int last) {
        System.out.print("[");
        for(int i = 0; i < cur; i++){
            System.out.print(" ");
            System.out.print(selectLetter(letter,i, last));
            System.out.print(" ");
            if(i != cur - 1) System.out.print("|");
        }
        System.out.print("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
