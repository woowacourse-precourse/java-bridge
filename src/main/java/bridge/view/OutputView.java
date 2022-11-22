package bridge.view;


import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private List<String> upBridge;
    private List<String> downBridge;

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(List<String> bridge, List<Boolean> gameResult) {
        initBridge();
        convertBridge(bridge, gameResult);
        printBridge(upBridge);
        printBridge(downBridge);
    }

    private void initBridge() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    private void convertBridge(List<String> bridge, List<Boolean> gameResult) {
        for (int index = 0; index < gameResult.size(); index++) {
            addCorrectResult(bridge, gameResult, index);
            addMissResult(bridge, gameResult, index);
        }
    }

    private void addCorrectResult(List<String> bridge, List<Boolean> gameResult, int index) {
        if (gameResult.get(index)) {
            if (bridge.get(index).equals("U")) {
                upBridge.add("O");
                downBridge.add(" ");
            }
            if (bridge.get(index).equals("D")) {
                upBridge.add(" ");
                downBridge.add("O");
            }
        }
    }

    private void addMissResult(List<String> bridge, List<Boolean> gameResult, int index) {
        if (!gameResult.get(index)) {
            if (bridge.get(index).equals("U")) {
                upBridge.add(" ");
                downBridge.add("X");
            }
            if (bridge.get(index).equals("D")) {
                upBridge.add("X");
                downBridge.add(" ");
            }
        }
    }

    private void printBridge(List<String> bridge) {
        System.out.println("[ " + String.join(" | ", bridge) + " ]");
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
