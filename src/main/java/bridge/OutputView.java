package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.InputView.Down_Enter;
import static bridge.InputView.Up_Enter;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String Correct = "O";
    private static final String Wrong = "X";
    private static final String Blank = " ";
    private static final String Stick = "|";
    private static final String EndingPrint = "최종 게임 결과";
    private static final String SuccessCountPrint = "게임 성공 여부: ";
    private static final String CountPrint = "총 시도한 횟수: ";


    private static List<String> Map_Up = new ArrayList<>();
    private static List<String> Map_Down = new ArrayList<>();

    public OutputView() {
        Map_Up.add("");
        Map_Down.add("");
    }

    public void printMap() {
        String UP = Map_Up.toString();
        String Down = Map_Down.toString();
        UP = UP.replaceAll(",", "");
        UP = UP.substring(0, UP.length() - 2);
        Down = Down.replaceAll(",", "");
        Down = Down.substring(0, Down.length() - 2);
        System.out.println(UP + "]");
        System.out.println(Down + "]");
    }

    public void Area_Division(List<String> Bridge, String Command, int Location) {
        if (Command.equals(Up_Enter)) {
            Print_Up(Bridge.get(Location));
            Print_Middle();
            return;
        }
        if (Command.equals(Down_Enter)) {
            Print_Down(Bridge.get(Location));
            Print_Middle();
        }

    }

    private void Print_Up(String Bridge) {
        if (Bridge.equals(Up_Enter)) {
            Map_Up.add(Correct);
            Map_Down.add(Blank);
            return;
        }
        if (Bridge.equals(Down_Enter)) {
            Map_Up.add(Wrong);
            Map_Down.add(Blank);
        }
    }

    private void Print_Down(String Bridge) {
        if (Bridge.equals(Up_Enter)) {
            Map_Up.add(Blank);
            Map_Down.add(Wrong);
            return;
        }
        if (Bridge.equals(Down_Enter)) {
            Map_Up.add(Blank);
            Map_Down.add(Correct);
        }
    }

    private void Print_Middle() {
        Map_Up.add(Stick);
        Map_Down.add(Stick);
    }

    public void Delete_Bridge() {
        Map_Up.remove(Map_Up.size() - 1);
        Map_Up.remove(Map_Up.size() - 1);
        Map_Down.remove(Map_Down.size() - 1);
        Map_Down.remove(Map_Down.size() - 1);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int TryNumber, String Answer) {
        System.out.println(EndingPrint);
        printMap();
        System.out.println(SuccessCountPrint + Answer);
        System.out.println(CountPrint + TryNumber);
    }
}
