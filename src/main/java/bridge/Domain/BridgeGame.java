package bridge.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 */
public class BridgeGame {

    Answer answer;
    RestartOrStop restartOrStop;
    private final Map<TryCount, MoveResult> result = new HashMap<>();

    public BridgeGame() {
    }

    public BridgeGame(Answer answer) {
        this(answer, RestartOrStop.restartGame());
    }

    public BridgeGame(Answer answer, RestartOrStop restartOrStop) {
        this.answer = answer;
        this.restartOrStop = restartOrStop;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(TryCount tryCount, DirectionCommand directionCommand) {
        GameResult gameResult = answer.choiceResult(tryCount, directionCommand);
        progressCheck(tryCount, gameResult);
        return gameResult;
    }

    public void addMove(TryCount tryCount, MoveResult moveResult) {
        result.put(tryCount, moveResult);
    }

    public void progressCheck(TryCount tryCount, GameResult gameResult) {
        if (answer.countCheck(tryCount) || gameResult.fail()) {
            restartOrStop = RestartOrStop.STOP;
        }
    }

    public FinalGameResult checkPass() {
        long failCount = TryCount.countWithBridgeSize(result.size())
                .stream()
                .map(result::get)
                .filter(MoveResult::failCheck)
                .count();
        return FinalGameResult.resultMessage(failCount);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.restartOrStop = RestartOrStop.RESTART;

    }

    public void reset() {
        result.clear();
    }


    public List<List<GameResult>> getResult() {
        if (result.isEmpty()) {
            return List.of();
        }
        return List.of(getTotalGameResult(DirectionCommand.UPPERPASS), getTotalGameResult(DirectionCommand.LOWERPASS));
    }

    private List<GameResult> getTotalGameResult(DirectionCommand directionCommand) {
        return TryCount.countWithBridgeSize(result.size())
                .stream()
                .map(count -> getGameResult(count, directionCommand))
                .collect(toList());
    }

    private GameResult getGameResult(TryCount tryCount, DirectionCommand directionCommand) {
        MoveResult moveResult = result.get(tryCount);
        if (moveResult.notSameAfterDirection(directionCommand)) {
            return GameResult.NOTCHOICE;
        }
        return moveResult.getGameResult();
    }

    public boolean continueGame() {
        return restartOrStop.continueGame();
    }
}
