package bridge;
import java.util.*;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder printUp;
    private StringBuilder printDown;
    private static String isDraw_true = " O ";
    private static String isDraw_false = " X ";
    private static String isDraw_Blank = "   ";
    private static String isDraw_SquareBracket_Right = "]";
    private static String isDraw_SquareBracket_Left = "[";
    private static String isDraw_Middle = "|";
    OutputView(){
        this.printUp = new StringBuilder();
        this.printDown = new StringBuilder();
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String user, boolean isDraw, int index) {
        printUp.append(printFirstMap(index));
        printDown.append(printFirstMap(index));
        printUp.append(printUpMap(user,isDraw));
        printDown.append(printDownMap(user,isDraw));
        System.out.println(printUp.toString()+isDraw_SquareBracket_Right);
        System.out.println(printDown.toString()+isDraw_SquareBracket_Right);
    }
    public String printUpMap(String user, boolean isDraw){
        if(!user.equals("U")) return isDraw_Blank;
        return printUserMap(isDraw);
    }
    public String printDownMap(String user, boolean isDraw){
        if(!user.equals("D")) return isDraw_Blank;
        return printUserMap(isDraw);

    }
    public String printFirstMap(int index){
        if(index ==0) return isDraw_SquareBracket_Left;
        return isDraw_Middle;
    }
    public String printUserMap(boolean isDraw){
        if(isDraw) return isDraw_true;
        return isDraw_false;
    }
    public void removePrintMap(){
        this.printUp = new StringBuilder();
        this.printDown = new StringBuilder();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
        System.out.println(printUp.toString()+isDraw_SquareBracket_Right);
        System.out.println(printDown.toString()+isDraw_SquareBracket_Right);
    }
    public void printSuccessOrFailure() {
        System.out.println("게임 성공 여부 :");
        System.out.println("총 시도한 횟수: ");
    }
}
