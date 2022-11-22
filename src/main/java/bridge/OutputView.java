package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMessage(String message){
        System.out.println(message);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void upPrintMapIncorrect(int i, int location, List<String> moveRecord){
        if (i == 0 && moveRecord.get(i).equals("U") && location == 0){
            System.out.print("X");
        }
        else if (i == 0 && moveRecord.get(i).equals("U") && location != 0){
            System.out.print("0");
        }
        else if (i == 0 && moveRecord.get(i).equals("D")){
            System.out.print(" ");
        }
    }

    public void upPrintMapIncorrectTwo(int i, int location, List<String> moveRecord){
        if (i != 0 && moveRecord.get(i).equals("U") && location == i){
            System.out.print(" | X");
        }
        else if (i != 0 && moveRecord.get(i).equals("U") && location != i){
            System.out.print(" | 0");
        }
        else if (i != 0 && moveRecord.get(i).equals("D")){
            System.out.print(" |  ");
        }
    }

    public void downPrintMapIncorrect(int i, int location, List<String> moveRecord){
        if (i == 0 && moveRecord.get(i).equals("D") && location == 0){
            System.out.print("X");
        }
        else if (i == 0 && moveRecord.get(i).equals("D") && location != 0){
            System.out.print("0");
        }
        else if (i == 0 && moveRecord.get(i).equals("U")){
            System.out.print(" ");
        }
    }

    public void downPrintMapIncorrectTwo(int i, int location, List<String> moveRecord){
        if (i != 0 && moveRecord.get(i).equals("D") && location == i){
            System.out.print(" | X");
        }
        else if (i != 0 && moveRecord.get(i).equals("D") && location != i){
            System.out.print(" | 0");
        }
        else if (i != 0 && moveRecord.get(i).equals("U")){
            System.out.print(" |  ");
        }
    }
    public void printMapIncorrect(int location, List<String> moveRecord){
        System.out.print("[ ");
        for (int i = 0; i < moveRecord.size(); i++){
            upPrintMapIncorrect(i, location, moveRecord);
            upPrintMapIncorrectTwo(i, location, moveRecord);
        }
        System.out.println(" ]");
        System.out.print("[ ");
        for (int i = 0; i < moveRecord.size(); i++){
            downPrintMapIncorrect(i, location, moveRecord);
            downPrintMapIncorrectTwo(i, location, moveRecord);
        }
        System.out.println(" ]");
    }
    public void upStartMapPrint(int i, List<String> moveRecord){
        if (i == 0 && moveRecord.get(i).equals("U")){
            System.out.print("O");
        }
        else if (i == 0 && moveRecord.get(i).equals("D")){
            System.out.print(" ");
        }
    }
    public void upMapPrintend(int i, List<String> moveRecord){
        if (i != 0 && moveRecord.get(i).equals("U")){
            System.out.print(" | O");
        }
        else if (i != 0 && moveRecord.get(i).equals("D")){
            System.out.print(" |  ");
        }
    }

    public void downStartMapPrint(int i, List<String> moveRecord){
        if (i == 0 && moveRecord.get(i).equals("D")){
            System.out.print("O");
        }
        else if (i == 0 && moveRecord.get(i).equals("U")){
            System.out.print(" ");
        }
    }

    public void downMapPrintend(int i, List<String> moveRecord){
        if (i != 0 && moveRecord.get(i).equals("D")){
            System.out.print(" | O");
        }
        else if (i != 0 && moveRecord.get(i).equals("U")){
            System.out.print(" |  ");
        }
    }
    public void printMapCorrect(List<String> moveRecord) {
        System.out.print("[ ");
        for (int i = 0; i < moveRecord.size(); i++){
            upStartMapPrint(i, moveRecord);
            upMapPrintend(i, moveRecord);
        }
        System.out.println(" ]");
        System.out.print("[ ");
        for (int i = 0; i < moveRecord.size(); i++){
            downStartMapPrint(i, moveRecord);
            downMapPrintend(i, moveRecord);
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, String regame) {
        if (regame.equals("")){
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + count);
        }
        else if (regame.equals("Q")){
            System.out.println("게임 성공 여부: 실패");
            System.out.println("총 시도한 횟수: " + count);
        }
    }

    public void printFianlMap(int location, List<String> moveRecord, String regame){
        if (regame.equals("")){
            printMapCorrect(moveRecord);
        }
        else if (regame.equals("Q")){
            printMapIncorrect(location, moveRecord);
        }
    }
}
