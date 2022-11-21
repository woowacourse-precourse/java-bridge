package view;

import bridge.Direction;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printMoveChoiceMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public static void printMap(List<String> movingFloorDataSet, List<String> passDataSet, int dataSetSize) {
        System.out.println(movingFloorDataSet);
        System.out.println(passDataSet);
        System.out.println(dataSetSize);

        StringBuilder firstFloorBridge = new StringBuilder("[");
        StringBuilder secondFloorBridge = new StringBuilder("[");
        for(int stage = 0; stage < dataSetSize; stage++) {
            addBrinkBridge(firstFloorBridge,secondFloorBridge);
            addFirstFloorBridge(firstFloorBridge,movingFloorDataSet.get(stage), passDataSet.get(stage));
            addSecondFloorBridge(secondFloorBridge,movingFloorDataSet.get(stage), passDataSet.get(stage));
            if(stage != dataSetSize - 1) {
                addSeparatorBridge(firstFloorBridge,secondFloorBridge);
            }
        }
        addEndBridge(firstFloorBridge,secondFloorBridge);
        System.out.println("//////");
        System.out.println(firstFloorBridge);
        System.out.println(secondFloorBridge);

        System.out.println("//////");
    }

    private static void addBrinkBridge(StringBuilder firstFloorBridge, StringBuilder secondFloorBridge) {
        firstFloorBridge.append(" ");
        secondFloorBridge.append(" ");
    }

    private static void addFirstFloorBridge(StringBuilder firstFloorBridge, String movingFloorData, String passData) {
        if(movingFloorData.equals(Direction.UP.getFloor())) {
            firstFloorBridge.append(passData);
            return;
        }
        firstFloorBridge.append(" ");
    }

    private static void addSeparatorBridge(StringBuilder firstFloorBridge, StringBuilder secondFloorBridge) {
        firstFloorBridge.append(" |");
        secondFloorBridge.append(" |");
    }

    private static void addSecondFloorBridge(StringBuilder secondFloorBridge, String movingFloorData, String passData) {
        if(movingFloorData.equals(Direction.DOWN.getFloor())) {
            secondFloorBridge.append(passData);
            return;
        }
        secondFloorBridge.append(" ");
    }

    private static void addEndBridge(StringBuilder firstFloorBridge, StringBuilder secondFloorBridge) {
        firstFloorBridge.append(" ]");
        secondFloorBridge.append(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
