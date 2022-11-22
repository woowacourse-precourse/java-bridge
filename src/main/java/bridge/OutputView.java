package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    InputView inputView = new InputView();
    public static String upResult = "";
    public static String downResult = "";
    public static String tempUpResult = "";
    public static String tempDownResult = "";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String alphabet, List<String> bridge, int bridgeCount) {
        insertLeftBracket(bridgeCount);
        correctOrWrongResult(alphabet, bridge, bridgeCount);
        makeTempResult();
        printResult();
    }

    public void correctOrWrongResult(String alphabet, List<String> bridge, int bridgeCount) {
        if (bridgeCount != 0) {
            insertLineShape();
        }
        insertCorrect(alphabet, bridgeCount, bridge);
        insertWrong(alphabet, bridgeCount, bridge);
    }

    public void insertLeftBracket(int bridgeCount){
        if (bridgeCount == 0){
            upResult += "[";
            downResult += "[";
        }
    }

    public void makeTempResult(){
        tempUpResult = upResult + "]";
        tempDownResult = downResult + "]";
    }

    public void insertCorrect(String alphabet, int index, List<String> bridge) {
        if (alphabet.equals("U") && alphabet.equals(bridge.get(index))) {
            upResult += " O ";
            downResult += "   ";}
        if (alphabet.equals("D") && alphabet.equals(bridge.get(index))) {
            upResult += "   ";
            downResult += " O ";}
    }

    public void insertWrong(String alphabet, int index, List<String> bridge) {
        if (alphabet.equals("U") && !alphabet.equals(bridge.get(index))) {
            upResult += " X ";
            downResult += "   ";}
        if (alphabet.equals("D") && !alphabet.equals(bridge.get(index))) {
            upResult += "   ";
            downResult += " X ";}
    }

    public void insertLineShape() {
        upResult += "|";
        downResult += "|";
    }

    public void printResult() {
        System.out.println(tempUpResult);
        System.out.println(tempDownResult);
    }

    public void clearResult() {
        upResult = "";
        downResult = "";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean wrongMovement, int count) {
        if (wrongMovement == true) {
            printFail(count);
        }
        if (wrongMovement == false) {
            printSuccess(count);
        }
    }

    public void printFail(int count) {
        System.out.println("게임 성공 여부: 실패");
        System.out.println(String.format("총 시도한 횟수: %d", count));
    }

    public void printSuccess(int count) {
        System.out.println("게임 성공 여부: 성공");
        System.out.println(String.format("총 시도한 횟수: %d", count));
    }

    public void printFinal() {
        System.out.println("최종 게임 결과");
    }
}
