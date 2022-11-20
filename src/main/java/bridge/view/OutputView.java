package bridge.view;

import bridge.model.Plate;

import java.util.List;

public class OutputView {
    private final String NOTICE_START_GAME = "다리 건너기 게임을 시작합니다.";
    private final String MAP_PREFIX = "[ ";
    private final String MAP_SEPARATOR = " | ";
    private final String MAP_SUFFIX = " ]";
    private final String MAP_NOT_STEP = " ";
    private final String MAP_SUCCESS_STEP = "O";
    private final String MAP_FAIL_STEP ="X";

    public void printStart() {
        System.out.println(NOTICE_START_GAME);
    }

    public void printMap(boolean isSuccess, List<Plate> playerPath) {
        System.out.println(tracePathByPlate(isSuccess, playerPath, Plate.UP_PLATE));
        System.out.println(tracePathByPlate(isSuccess, playerPath, Plate.DOWN_PLATE));
    }

    private String tracePathByPlate(boolean isSuccess, List<Plate> playerPath, Plate bridgePlate) {
        StringBuilder plateRecord = new StringBuilder(MAP_PREFIX);
        for (int pathIndex = 0; pathIndex < playerPath.size() - 1; pathIndex++) {
            plateRecord.append(getStringPlate(playerPath.get(pathIndex), bridgePlate));
            plateRecord.append(MAP_SEPARATOR);
        }
        plateRecord.append(getLastPlate(isSuccess, playerPath.get(playerPath.size() - 1), bridgePlate));
        plateRecord.append(MAP_SUFFIX);
        return plateRecord.toString();
    }

    private String getStringPlate(Plate playerStep, Plate bridgePlate) {
        if (playerStep.equals(bridgePlate)) {
            return MAP_SUCCESS_STEP;
        }
        return MAP_NOT_STEP;
    }

    private String getLastPlate(boolean isSuccess, Plate playerStep, Plate bridgePlate) {
        if (!playerStep.equals(bridgePlate)) {
            return MAP_NOT_STEP;
        }
        if (isSuccess) {
            return MAP_SUCCESS_STEP;
        }
        return MAP_FAIL_STEP;
    }

    public void printResult() {
    }
}
