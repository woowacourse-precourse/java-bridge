package bridge.view;

import bridge.model.Tile;
import bridge.model.PlayerStatus;

import java.util.List;

public class OutputView {
    private final String NOTICE_START_GAME = "다리 건너기 게임을 시작합니다.";
    private final String MAP_PREFIX = "[ ";
    private final String MAP_SEPARATOR = " | ";
    private final String MAP_SUFFIX = " ]";
    private final String MAP_NOT_STEP = " ";
    private final String MAP_SUCCESS_STEP = "O";
    private final String MAP_FAIL_STEP = "X";
    private final String NOTICE_RESULT = "최종 게임 결과";
    private final String NOTICE_RESULT_VICTORY = "게임 성공 여부: ";
    private final String NOTICE_RESULT_TRY_COUNT = "총 시도한 횟수: ";
    private final String RESULT_SUCCESS = "성공";
    private final String RESULT_FAIL = "실패";

    private static final String UNEXPECTED_EXCEPTION = "예상치 못한 오류가 발생하여 프로그램 종료합니다.";

    public void printStart() {
        System.out.println(NOTICE_START_GAME);
        System.out.println();
    }

    public void printMap(boolean possibleNextStep, List<Tile> playerPath) {
        System.out.println(tracePathByTile(possibleNextStep, playerPath, Tile.UP_TILE));
        System.out.println(tracePathByTile(possibleNextStep, playerPath, Tile.DOWN_TILE));
        System.out.println();
    }

    private String tracePathByTile(boolean possibleNextStep, List<Tile> playerPath, Tile bridgeTile) {
        StringBuilder tileRecord = new StringBuilder(MAP_PREFIX);
        for (int pathIndex = 0; pathIndex < playerPath.size() - 1; pathIndex++) {
            tileRecord.append(getStringTile(playerPath.get(pathIndex), bridgeTile));
            tileRecord.append(MAP_SEPARATOR);
        }
        tileRecord.append(getLastTile(possibleNextStep, playerPath.get(playerPath.size() - 1), bridgeTile));
        tileRecord.append(MAP_SUFFIX);
        return tileRecord.toString();
    }

    private String getStringTile(Tile playerStep, Tile bridgeTile) {
        if (playerStep.equals(bridgeTile)) {
            return MAP_SUCCESS_STEP;
        }
        return MAP_NOT_STEP;
    }

    private String getLastTile(boolean possibleNextStep, Tile playerStep, Tile bridgeTile) {
        if (!playerStep.equals(bridgeTile)) {
            return MAP_NOT_STEP;
        }
        if (possibleNextStep) {
            return MAP_SUCCESS_STEP;
        }
        return MAP_FAIL_STEP;
    }

    public void printResult(PlayerStatus playerStatus, int tryCount, List<Tile> playerPath) {
        System.out.println(NOTICE_RESULT);
        boolean possibleNextStep = (playerStatus == PlayerStatus.COMPLETE_CROSSING_BRIDGE);
        printMap(possibleNextStep, playerPath);
        String successOrFail = RESULT_FAIL;
        if (playerStatus == PlayerStatus.COMPLETE_CROSSING_BRIDGE) {
            successOrFail = RESULT_SUCCESS;
        }
        System.out.println(NOTICE_RESULT_VICTORY + successOrFail);
        System.out.println(NOTICE_RESULT_TRY_COUNT + tryCount);
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printUnExpectedErrorMessage(Exception exception) {
        System.out.println(UNEXPECTED_EXCEPTION);
        System.out.println(exception.getMessage());
    }
}
