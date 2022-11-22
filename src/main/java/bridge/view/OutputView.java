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
        System.out.println("최종 게임 결과");
        System.out.print("[ ");
        printDetail("UP");
        System.out.println(printDetailUP(inputMove, correct)+" ]");
        System.out.print("[ ");
        printDetail("DOWN");
        System.out.println(printDetailDOWN(inputMove, correct)+" ]");
        mapStatus.add(inputMove);
    }

    public void printDetail(String status){
        if (status.equals("UP")){
            for (int i=0; i<mapStatus.size(); i++){
                System.out.print(printDetailUP(mapStatus.get(i), mapStatus.get(i).equals("U"))+" | ");
            }
        }
        if (status.equals("DOWN")){
            for (int i=0; i<mapStatus.size(); i++){
                System.out.print(printDetailDOWN(mapStatus.get(i), mapStatus.get(i).equals("D"))+" | ");
            }
        }
    }

    public String printDetailUP(String str, boolean correct){
        if (str.equals("U")){
            return printCorrect(correct);
        }
        return(" ");
    }

    public String printDetailDOWN(String str, boolean correct){
        if (str.equals("D")){
            return printCorrect(correct);
        }
        return(" ");
    }

    public String printCorrect(boolean correct){
        if (correct){
            return ("O");
        }
        return ("X");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int gameNum, boolean correct) {
        if (correct){
            System.out.println("게임 성공 여부: 성공");
        }
        if (!correct){
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: "+gameNum);
    }

    public static void askRetry(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
