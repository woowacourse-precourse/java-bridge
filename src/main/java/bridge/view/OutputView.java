package bridge.view;

import bridge.domain.*;
import bridge.dto.GameResultDto;
import bridge.dto.MovingResultsDto;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.utils.MessageFormat.*;
import static bridge.utils.ViewMessages.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printGameStart() {
        System.out.println(GAME_START);
        printNewLine();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MovingResultsDto movingResultsDto) {
        for (List<MovingResult> movingResults : movingResultsDto.getResult()) {
            System.out.println(getBridgeMap(movingResults));
        }
        printNewLine();
    }

    private String getBridgeMap(List<MovingResult> movingResults) {
        return movingResults.stream()
            .map(MovingResult::getResult)
            .collect(Collectors.joining(BRIDGE_SPACE_DIVISION, BRIDGE_START, BRIDGE_END));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    // TODO: GameStatus, GameCount enum의 값 뽑아서 출력해야됨
    public void printResult(GameResultDto gameResultDto) {
        System.out.println(GAME_RESULT);
        printMap(gameResultDto.getMovingResultsDto());
        System.out.println(GAME_SUCCESS_OR_FAIL + gameResultDto.getGameStatus());
        System.out.println(GAME_COUNT + gameResultDto.getBridgeGameCount());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
