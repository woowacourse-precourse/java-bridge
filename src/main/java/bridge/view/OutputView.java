package bridge.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private List<String> mapStatus = new ArrayList<>();
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String inputMove, boolean correct) {
        System.out.println('[');
        printDetail();
        if (inputMove=="U"){
            printDetailUP(inputMove, correct);
        }
        if (inputMove=="D"){
            printDetailDOWN(inputMove, correct);
        }
        System.out.println(']');
        mapStatus.add(inputMove);
    }

    public void printDetail(){
        for (int i=0; i<mapStatus.size(); i++){
            printDetailUP(mapStatus.get(i), true);
            System.out.println('|');
        }
        for (int i=0; i<mapStatus.size(); i++){
            printDetailDOWN(mapStatus.get(i), true);
            System.out.println('|');
        }
    }

    public void printDetailUP(String str, boolean correct){
        if (str=="U"){
            printCorrect(correct);
        }
        if (str=="D"){
            System.out.println(" ");
        }
    }

    public void printDetailDOWN(String str, boolean correct){
        if (str=="U"){
            System.out.println(" ");
        }
        if (str=="D"){
            printCorrect(correct);
        }
    }
    public void printCorrect(boolean correct){
        if (correct){
            System.out.println("O");
        }
        if (!correct){
            System.out.println("X");
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
