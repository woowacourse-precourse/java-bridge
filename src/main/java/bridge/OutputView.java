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
    public void printShortMap(List<String> userInput, List<Boolean> result) {
        System.out.print("[");
        printByLine(userInput.get(0), result.get(0), "U");
        System.out.println(" ]");
        System.out.print("[");
        printByLine(userInput.get(0), result.get(0), "D");
        System.out.println(" ]");
    }

    public void printLongMap(List<String> userInput, List<Boolean> result){
        printUpLineMap(userInput, result);
        printDownLineMap(userInput, result);
    }

    public void printUpLineMap(List<String> userInput, List<Boolean> result) {
        System.out.print("[");
        for (int i = 0; i < userInput.size() - 1; i++) {
            printByLine(userInput.get(i), result.get(i), "U");
            System.out.print(" |");
        }
        printByLine(userInput.get(userInput.size() - 1), result.get(userInput.size() - 1), "U");
        System.out.println(" ]");


    }
    public void printDownLineMap(List<String> userInput,List<Boolean> result) {
        System.out.print("[");
        for(int i=0;i<userInput.size()-1;i++){
            printByLine(userInput.get(i),result.get(i),"D");
            System.out.print(" |");
        }
        printByLine(userInput.get(userInput.size()-1),result.get(userInput.size()-1),"D");
        System.out.println(" ]");


    }

    public void printByLine(String userInput,boolean result, String lineCode){
        if(userInput.equals(lineCode)&&result){
            System.out.print(" O");
        }
        if(userInput.equals(lineCode)&&!result){
            System.out.print(" X");
        }
        if(!userInput.equals(lineCode)){
            System.out.print("  ");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess,int total) {

        System.out.print("게임 성공 여부: ");
        if(isSuccess){
            System.out.println("성공");
        }
        if(!isSuccess){
            System.out.println("실패");
        }
        System.out.print("총 시도한 횟수: ");
        System.out.println(total);

    }
    public void printTotalResult(List<String>userInput,List<Boolean> result){
        System.out.println("최종 게임 결과");
        printLongMap(userInput, result);
    }


}
