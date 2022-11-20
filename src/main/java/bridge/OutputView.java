package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 // * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 // * OutputView의 패키지는 변경할 수 있다.
 // * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 // * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    static List<String> upByPrintMap = new ArrayList<>();
    static List<String> downByPrintMap = new ArrayList<>();


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String upAndDown) {
        trueCalculation(upAndDown);     // 성공시 입력값에 따라 O 삽입
        System.out.println(upByPrintMap.stream().collect(Collectors.joining("|","[","]")));
        System.out.println(downByPrintMap.stream().collect(Collectors.joining("|","[","]")));
    }

    //11줄
    public void falsePrintMap(String upAndDown){
        falseCalculation(upAndDown);    // 실패시 입력값에 따라 X 삽입
        System.out.println(upByPrintMap.stream().collect(Collectors.joining("|","[","]")));
        System.out.println(downByPrintMap.stream().collect(Collectors.joining("|","[","]")));

    }

    static void trueCalculation(String upAndDown){
        if(upAndDown.equals("U")){
            upByPrintMap.add(" O ");
            downByPrintMap.add("   ");
        }
        if(upAndDown.equals("D")){
            upByPrintMap.add("   ");
            downByPrintMap.add(" O ");
        }
    }
    static void falseCalculation(String upAndDown){
        if(upAndDown.equals("U")){
            upByPrintMap.add(" X ");
            downByPrintMap.add("   ");
        }
        if(upAndDown.equals("D")){
            upByPrintMap.add("   ");
            downByPrintMap.add(" X ");
        }
    }
    static void init(){
        upByPrintMap.clear();
        downByPrintMap.clear();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int count) {
        System.out.println("\n" + "최종 게임 결과");
        System.out.println(upByPrintMap.stream().collect(Collectors.joining("|","[","]")) + "\n" + downByPrintMap.stream().collect(Collectors.joining("|","[","]")));
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + count);
    }
}
