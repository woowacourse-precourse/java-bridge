package bridge.view;

import bridge.model.BridgeBlock;
import bridge.model.BridgeGame;
import bridge.model.Direction;
import bridge.model.MoveResult;
import bridge.model.Player;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String SURVIVE = " O |";
    private static final String SKIP = "   |";
    private static final String FALL = " X |";

    private StringBuilder upFloor;
    private StringBuilder downFloor;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, MoveResult result) {
        initFloor();
        Player player = bridgeGame.getPlayer();
        appendHistory(player);
        appendCurrentMoveResult(player.currentBridgeBlock(), result);
        System.out.println(appendLastBracket(upFloor) + appendLastBracket(downFloor));
    }

    private String appendLastBracket(StringBuilder floor) {
        return floor.substring(0, floor.length() - 1) + "]\n";
    }

    private void appendCurrentMoveResult(BridgeBlock block, MoveResult result) {
        if (result.isFailed()) {
            append(block, FALL);
            return;
        }
        append(block, SURVIVE);
    }

    private void append(BridgeBlock block, String result) {
        Direction direction = block.getDirection();
        if (direction == Direction.U) {
            upFloor.append(result);
            downFloor.append(SKIP);
            return;
        }
        upFloor.append(SKIP);
        downFloor.append(result);
    }

    private void appendHistory(Player player) {
        List<BridgeBlock> history = player.getHistory();
        for (int position = 0; position < history.size() - 1; position++) {
            BridgeBlock block = history.get(position);
            append(block, SURVIVE);
        }
    }

    private void initFloor() {
        upFloor = new StringBuilder("[");
        downFloor = new StringBuilder("[");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, MoveResult moveResult) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame, moveResult);
        String gameResult = "성공";
        if (moveResult.isFailed()) {
            gameResult = "실패";
        }
        System.out.println("게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + bridgeGame.getPlayCount());
    }
}
