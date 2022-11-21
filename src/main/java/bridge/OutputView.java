package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> tryAnswer,List<String> makeBridge) {
        printOneBridge(1, tryAnswer,makeBridge);
        printOneBridge(2, tryAnswer,makeBridge);
    }

    public void printOneBridge(int order,List<String> tryAnswer,List<String> makeBridge){
        for(int j=0;j<= tryAnswer.size();j++){
            if(j == 0) System.out.print("[");
            if(j>0&&j< tryAnswer.size()) System.out.print("|");
            if(j != tryAnswer.size())   printNullOrO(tryAnswer.get(j),order,makeBridge.get(j));
            if(j == tryAnswer.size()) System.out.println("]");
        }
    }

    public void printNullOrO(String UorD,int order,String makeBridge){
        if(order==1){
            if (Objects.equals(UorD, "U") && Objects.equals(makeBridge, UorD)) System.out.print(" O ");
            if (Objects.equals(UorD, "U") && !Objects.equals(makeBridge, UorD)) System.out.print(" X ");
            if(Objects.equals(UorD, "D"))  System.out.print("   ");
        }
        if(order==2){
            if (Objects.equals(UorD, "D") && Objects.equals(makeBridge, UorD)) System.out.print(" O ");
            if (Objects.equals(UorD, "D") && !Objects.equals(makeBridge, UorD)) System.out.print(" X ");
            if(Objects.equals(UorD, "U"))  System.out.print("   ");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count,int sOrf,List<String> tryAnswer,List<String> makeBridge) {
        System.out.println("최종 게임 결과");
        printMap(tryAnswer,makeBridge);
        if (sOrf == 0) System.out.println("게임 성공 여부: 성공");
        if (sOrf == 1) System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: "+count);
    }
}
