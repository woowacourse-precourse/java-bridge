package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static String upSide = "";
    public static String downSide = "";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> mark) {
        startOfBridge();
        for (int i = 0; i < mark.size(); i++) {
            if (bridge.get(i).equals("U") && mark.get(i).equals("O")) {pickUpside(i, mark);}
            if (bridge.get(i).equals("U") && mark.get(i).equals("X")) {pickDownside(i, mark);}
            if (bridge.get(i).equals("D") && mark.get(i).equals("O")) {pickDownside(i, mark);}
            if (bridge.get(i).equals("D") && mark.get(i).equals("X")) {pickUpside(i, mark);}
        }
        endOfBridge();
        System.out.print(upSide + "\n" + downSide + "\n");
    }

    private void startOfBridge() {
        upSide = "[";
        downSide = "[";
    }

    private void endOfBridge() {
        upSide += "]";
        downSide += "]";
    }

    private void pickUpside(int index, List<String> mark) {
        if (index != 0) {
            upSide += "|";
            downSide += "|";
        }
        upSide += " " + mark.get(index) + " ";
        downSide += "   ";
    }

    private void pickDownside(int index, List<String> mark) {
        if (index != 0) {
            upSide += "|";
            downSide += "|";
        }
        upSide += "   ";
        downSide += " " + mark.get(index) + " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        Print.showFinalResult();
        System.out.println(upSide);
        System.out.println(downSide);
    }
}
