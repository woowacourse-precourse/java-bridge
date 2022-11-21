package bridge.View;

import java.util.ArrayList;
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
    public void printMap(List<String> bridge, boolean success, int position) {
        List<String> check = new ArrayList<>();
        check.add("U");
        check.add("D");

        for(int i=0; i<2; i++){
            String standard = check.get(i);
            System.out.print("[");
            for(int j=0; j<position; j++){
                if(standard.equals(bridge.get(j))){
                    System.out.print(" O ");
                }
                else{
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            if(success){
                if(standard.equals(bridge.get(position))){
                    System.out.print(" O ");
                }
                else{
                    System.out.print("   ");
                }
            }
            else{
                if(standard.equals(bridge.get(position))){
                    System.out.print(" X ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println("]");
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean gameSuccess, int gameTryCount) {
        if(gameSuccess)
            System.out.println("게임 성공 여부: 성공");
        else
            System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + gameTryCount);
    }
}
