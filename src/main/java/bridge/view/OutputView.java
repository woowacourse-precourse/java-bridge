package bridge.view;

import bridge.enums.GameStatus;
import bridge.dto.GameResultDto;

import static bridge.dto.GameResultDto.GameRecordDto;
import static bridge.view.BridgeMapViewCreator.BridgeMap;

public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GAME_END_MESSAGE = "최종 게임 결과";
    public static final String GAME_RESULT_MESSAGE = "게임 성공 여부: %s\n";
    public static final String GAME_RESULT_ATTEMPT_MESSAGE = "총 시도한 횟수: %d\n";
    public static final String GAME_RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
        printBlank();
    }

    public static void printBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public static void printMove() {
        System.out.println(INPUT_MOVE_MESSAGE);
    }

    public static void printMap(GameResultDto gameResult) {
        GameStatus gameStatus = gameResult.getGameStatus();
        GameRecordDto gameRecord = gameResult.getGameRecord();

        BridgeMap bridgeMap = BridgeMapViewCreator.create(gameStatus, gameRecord.getRecord());
        System.out.println(bridgeMap.getUpBridge());
        System.out.println(bridgeMap.getDownBridge());
        printBlank();
    }

    public static void printResult(GameResultDto gameResult) {
        System.out.println(GAME_END_MESSAGE);
        printMap(gameResult);
        printBlank();

        GameStatus gameStatus = gameResult.getGameStatus();
        GameRecordDto gameRecord = gameResult.getGameRecord();
        System.out.printf(GAME_RESULT_MESSAGE, gameStatus.getMessage());
        System.out.printf(GAME_RESULT_ATTEMPT_MESSAGE, gameRecord.getAttempt());
    }

    public static void printRestart() {
        System.out.println(GAME_RESTART_MESSAGE);
    }

    public static void printBlank() {
        System.out.println();
    }

    public static void printExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
