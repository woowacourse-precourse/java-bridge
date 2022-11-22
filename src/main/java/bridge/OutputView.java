package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    InputView inputView = new InputView();
    String upResult = "";
    String downResult = "";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String alphabet, List<String> bridge, int bridgeCount) {
        if (bridgeCount == 0) {
            firstResult(alphabet);
        }
        if (bridgeCount > 0) {
            otherResult(bridge, bridgeCount);
        }
        printResult();
    }

    public void firstResult(String alphabet){
        if (alphabet.equals("U")) {
            upResult += "[ O ]";
            downResult += "[   ]";}
        if (alphabet.equals("D")) {
            upResult += "[   ]";
            downResult += "[ O ]";}
    }

    public void otherResult(List<String> bridge, int bridgeCount) {
        insertLeftBracket();
        for (int i = 0; i < bridgeCount + 1; i++) {
            insertAlphabet(bridge.get(i));
            if (i != bridgeCount) {
                insertLineShape();
            }
        }
        insertRightBracket();
    }

    public void insertLeftBracket(){
        upResult = "[";
        downResult = "[";
    }

    public void insertRightBracket(){
        upResult += "]";
        downResult += "]";
    }

    public void insertAlphabet(String alphabet) {
        if (alphabet.equals("U")) {
            upResult += " O ";
            downResult += "   ";}
        if (alphabet.equals("D")) {
            upResult += "   ";
            downResult += " O ";}
    }

    public void insertLineShape() {
        upResult += "|";
        downResult += "|";
    }

    public void printResult() {
        System.out.println(upResult);
        System.out.println(downResult);
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
            System.out.println("게임 성공 여부: 실패");
            System.out.println(String.format("총 시도한 횟수: %d", count));
        }
        if (wrongMovement == false) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println(String.format("총 시도한 횟수: %d", count));
        }
    }
}
