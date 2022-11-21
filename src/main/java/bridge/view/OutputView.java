package bridge.view;

import bridge.dto.MapDto;
import bridge.dto.ResultDto;

public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String RESULT_WHETHER_SUCCESS = "게임 성공 여부: %s";
    private static final String TOTAL_ATTEMPT = "총 시도한 횟수: %d";
    private static final String ERROR_FORMAT = "[ERROR] %s";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public void printMap(MapDto mapDto) {
        System.out.println(mapDto.getMap());
        System.out.println();
    }

    public void printResult(ResultDto resultDto) {
        System.out.println(GAME_RESULT);
        printMap(resultDto.getMapDto());
        System.out.println(String.format(RESULT_WHETHER_SUCCESS, resultDto.getStatus()));
        System.out.println(String.format(TOTAL_ATTEMPT, resultDto.getAttempts()));
    }

    public static void printError(String errorMessage) {
        System.out.println(String.format(ERROR_FORMAT, errorMessage));
    }
}
