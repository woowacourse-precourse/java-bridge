package view;

import inMemoryDB.GameData;
import utils.Direction;
import utils.GameResult;
import java.util.List;

public class OutputView {

    public static void printStartMessage() {
        PrintMessage.START_MESSAGE.printMessage();
        PrintMessage.NEW_LINE.printMessage();
        PrintMessage.INPUT_LENGTH_MESSAGE.printMessage();
    }

    public static void printMoveChoiceMessage() {
        PrintMessage.INPUT_MOVING_FLOOR_MESSAGE.printMessage();
    }

    public static void printRestartStatusMessage() {
        PrintMessage.INPUT_RESTART_STATUS_MESSAGE.printMessage();
    }

    public static void printFinalResultMessage() {
        PrintMessage.FINAL_MESSAGE.printMessage();
    }

    public static void printMap(List<String> movingFloorDataSet, List<String> passDataSet, int dataSetSize) {
        StringBuilder firstFloorBridge = new StringBuilder("[");
        StringBuilder secondFloorBridge = new StringBuilder("[");
        for (int stage = 0; stage < dataSetSize; stage++) {
            addBrinkBridge(firstFloorBridge, secondFloorBridge);
            addFirstFloorBridge(firstFloorBridge, movingFloorDataSet.get(stage), passDataSet.get(stage));
            addSecondFloorBridge(secondFloorBridge, movingFloorDataSet.get(stage), passDataSet.get(stage));
            if (stage != dataSetSize - 1) addSeparatorBridge(firstFloorBridge, secondFloorBridge);
        }
        endWork(firstFloorBridge, secondFloorBridge);
    }


    private static void endWork(StringBuilder firstFloorBridge, StringBuilder secondFloorBridge) {
        addEndBridge(firstFloorBridge, secondFloorBridge);
        printFloor(firstFloorBridge, secondFloorBridge);
    }


    private static void printFloor(StringBuilder firstFloorBridge, StringBuilder secondFloorBridge) {
        System.out.println(firstFloorBridge);
        System.out.println(secondFloorBridge);
        System.out.println();
    }

    private static void addBrinkBridge(StringBuilder firstFloorBridge, StringBuilder secondFloorBridge) {
        firstFloorBridge.append(" ");
        secondFloorBridge.append(" ");
    }

    private static void addFirstFloorBridge(StringBuilder firstFloorBridge, String movingFloorData, String passData) {
        if (movingFloorData.equals(Direction.UP.getFloor())) {
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
        if (movingFloorData.equals(Direction.DOWN.getFloor())) {
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
    public static void printResult(GameData gameData, int count) {
        OutputView.printMap(gameData.getMovingFloorDataSet(), gameData.getPassDataSet(), gameData.getDataSetSize());
        System.out.println("게임 성공 여부: " + resultGameSuccess(gameData));
        System.out.println("총 시도한 횟수: " + count);
    }

    private static String resultGameSuccess(GameData gameData) {
        if (gameData.getPassDataSet().contains(GameResult.WRONG_FLOOR.getResultMessage())) {
            return "실패";
        }
        return "성공";
    }
}
