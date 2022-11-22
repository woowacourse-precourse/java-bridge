package bridge;

import static bridge.constant.BridgeConstant.GAME_RETRY_LETTER;

import bridge.domain.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int gamePlayCount = 1;
    private List<Result> crossResults;

    public BridgeGame() {
        crossResults = new ArrayList<>(List.of(new Result(), new Result()));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridges, int position) {
        BridgeMover bridgeMover = new BridgeMover();
        String direction = bridgeMover.getDirectionFromInput();
        boolean canMove = bridges.get(position).equals(direction);
        crossResults = bridgeMover.getCrossResults(crossResults, canMove, direction);
        bridgeMover.printCrossResults(crossResults);
        return canMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(int position) {
        boolean retry = getRetry();
        if (retry) {
            gamePlayCount++;
            crossResults.forEach(crossResult -> {
                crossResult.removeResult(position);
            });
        }
        return retry;
    }

    public boolean getRetry() {
        BridgeCommand bridgeCommand = new BridgeCommand();
        return bridgeCommand.getRetry().equals(GAME_RETRY_LETTER);
    }

    public void crossBridge(List<String> bridges, int size) {
        int position = 0;
        boolean canMove = true;
        while (position < size && canMove) {
            canMove = move(bridges, position);
            if (!canMove) {
                canMove = retry(position);
            }
            position++;
        }
    }
}
