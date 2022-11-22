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
    List<String> mov;
    public OutputView(int c,List<String> b,List<String> m){
        cur = c;
        bridge = b;
        mov = m;
    }
    public String selectLetter(String letter, int i, int last){
        if(bridge.get(i).equals(mov.get(i))){
            if(bridge.get(i).equals(letter)) return "O";
            else return " ";
        } else {
            if(bridge.get(i).equals(letter)) return " ";
            return "X";
        }
    }
    public void printMap(String letter, int last) {
        System.out.print("[");
        for(int i = 0; i < mov.size(); i++){
            System.out.print(" ");
            System.out.print(selectLetter(letter,i, last));
            System.out.print(" ");
            if(i < mov.size() - 1) System.out.print("|");
        }
        System.out.print("]\n");
    }
    public void printMaps(int last){
        printMap("U",last);
        printMap("D",last);
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int last, int cnt) {
        System.out.print("최종 게임 결과\n");
        System.out.println(cur);
        cur--;
        printMap("U",last);
        printMap("D",last);
        System.out.println();
        System.out.print("게임 성공 여부: ");
        if(last == 0) System.out.println("성공");
        else System.out.println("실패");
        System.out.printf("총 시도한 횟수: %d\n",cnt);
    }
}
