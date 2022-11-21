package bridge.view;

import bridge.domain.game.BridgeGame;
import bridge.domain.bridge.BridgeUnit;
import bridge.domain.game.GameStatus;
import bridge.domain.game.GameProgress;
import bridge.dto.MapDto;
import bridge.dto.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
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

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MapDto mapDto) {
        System.out.println(mapDto.getMap());
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
