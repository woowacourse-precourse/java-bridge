package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeBlock;
import bridge.resource.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int location;
    CrossingResult crossingResult;
    Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.location = 0;
        this.crossingResult = new CrossingResult();
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String block) {
        validateBlock(block);

        if (bridge.isSameBlock(location, block)) {
            crossingResult.add(CrossOver.SUCCESS, block);
            location++;
            return true;
        }
        crossingResult.add(CrossOver.FAIL, block);
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private void validateBlock(String block) {
        if (!block.equals(BridgeBlock.UP.getDirection()) &&
                !block.equals(BridgeBlock.DOWN.getDirection())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_U_OR_D_INPUT.getValue());
        }
    }

    public String getCrossingResult() {
        return crossingResult.toString();
    }

    static class CrossingResult {

        private final List<String> upside;
        private final List<String> downside;

        private CrossingResult() {
            upside = new ArrayList<>();
            downside = new ArrayList<>();
        }

        private void add(CrossOver crossOver, String block) {
            if (block.equals(BridgeBlock.UP.getDirection())) {
                upside.add(crossOver.value);
                downside.add(" ");
                return;
            }
            upside.add(" ");
            downside.add(crossOver.value);
        }

        private boolean isFail() {
            return upside.get(upside.size() - 1).equals(CrossOver.FAIL.value) &&
                    downside.get(downside.size() - 1).equals(CrossOver.FAIL.value);
        }

        @Override
        public String toString() {
            String up = "[ " + String.join(" | ", upside) + " ]";
            String down = "[ " + String.join(" | ", downside) + " ]";

            return up + "\n" + down;
        }
    }
}
