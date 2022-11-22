package bridge.view;

import bridge.GameStatus;
import bridge.domain.BridgePassed;
import bridge.enumeration.GuideMessage;
import bridge.map.Map;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final List<String> upDownMark = List.of("U", "D");

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgePassed bridge) {
        for (String mark : upDownMark) {
            System.out.print(Map.BRIDGE_START.getMark());
            printRow(bridge, mark);
            System.out.println(Map.BRIDGE_END.getMark());
        }
    }

    public void printRow(BridgePassed bridge, String mark) {
        List<String> blocks = bridge.getBlocks();
        for (int i = 0; i < bridge.getBridgeSize(); i++) {
            printSection(i);
            if (i == bridge.getBridgeSize() - 1 && !bridge.canMove()) {
                printX(blocks.get(i), mark);
                continue;
            }
            printBlock(blocks.get(i), mark);
        }
    }

    private void printSection(int index) {
        if (index >= 1) {
            System.out.print(Map.BLOCK_SECTION.getMark());
        }
    }

    public void printBlock(String block, String mark) {
        if (block.equals(mark)) {
            System.out.print(Map.BLOCK_CAN_MOVE.getMark());
        }
        if (!block.equals(mark)) {
            System.out.print(Map.BLOCK_BLANK.getMark());
        }
    }

    public void printX(String block, String mark) {
        if (block.equals(mark)) {
            System.out.print(Map.BLOCK_BLANK.getMark());
        }
        if (!block.equals(mark)) {
            System.out.print(Map.BLOCK_CANT_MOVE.getMark());
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameStatus gameStatus) {
        String gameClearResult = "";
        if (gameStatus.isGameClear()) {
            gameClearResult = GuideMessage.SUCCESS.getMessage();
        }
        if (!gameStatus.isGameClear()) {
            gameClearResult = GuideMessage.FAIL.getMessage();
        }
        System.out.println(GuideMessage.SUCCESS_OR_FAIL.getMessage() + gameClearResult);
        System.out.println(GuideMessage.WHOLE_TRY.getMessage() + gameStatus.getGameCount());
    }

    public void printStart() {
        System.out.println(GuideMessage.START.getMessage());
    }

    public void printBridgeSize() {
        System.out.println(GuideMessage.INPUT_BRIDGE_SIZE.getMessage());
    }

    public void printMoving() {
        System.out.println(GuideMessage.INPUT_MOVING.getMessage());
    }

    public void printRetry() {
        System.out.println(GuideMessage.INPUT_RETRY.getMessage());
    }

    public void printFinalMap(BridgePassed bridgePassed) {
        System.out.println(GuideMessage.RESULT.getMessage());
        printMap(bridgePassed);
    }
}
