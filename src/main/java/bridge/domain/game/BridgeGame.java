package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeBlock;
import bridge.domain.game.dto.BridgeGameDto;
import bridge.resource.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeGameDto bridgeGameDto;
    CrossingResult crossingResult;
    Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridgeGameDto = new BridgeGameDto();
        this.crossingResult = new CrossingResult();
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        validateBlock(input);

        if (bridge.isSameBlock(bridgeGameDto.getLocation(), input)) {
            crossingResult.add(Crossing.SUCCESS, input);
            bridgeGameDto.addLocation();
            return true;
        }
        crossingResult.add(Crossing.FAIL, input);
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        validateRetry(input);

        boolean isRetry = input.equals(Retry.RETRY.value);
        if (isRetry) {
            bridgeGameDto.resetLocation();
            this.crossingResult = new CrossingResult();
        }
        bridgeGameDto.addAttempt();

        return isRetry;
    }

    private void validateRetry(String input) {
        if (!input.equals(Retry.RETRY.value) && !input.equals(Retry.QUIT.value)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_Q_OR_R_INPUT.getValue());
        }
    }

    private void validateBlock(String input) {
        if (!input.equals(BridgeBlock.UP.getDirection()) && !input.equals(BridgeBlock.DOWN.getDirection())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_U_OR_D_INPUT.getValue());
        }
    }

    public String getCrossingResult() {
        return crossingResult.toString();
    }

    public int getAttempt() {
        return bridgeGameDto.getAttempt();
    }

    public String getSuccess() {
        if (crossingResult.isFail()) {
            return Crossing.FAIL.success;
        }
        return Crossing.SUCCESS.success;
    }

    static class CrossingResult {

        private static final String BLANK = " ";

        private final List<String> upside;
        private final List<String> downside;

        private CrossingResult() {
            upside = new ArrayList<>();
            downside = new ArrayList<>();
        }

        private void add(Crossing crossing, String block) {
            if (block.equals(BridgeBlock.UP.getDirection())) {
                addCrossOverAndBlank(crossing, upside, downside);
                return;
            }
            addCrossOverAndBlank(crossing, downside, upside);
        }

        private void addCrossOverAndBlank(Crossing crossing, List<String> crossingSide, List<String> blankSide) {
            crossingSide.add(crossing.value);
            blankSide.add(BLANK);
        }

        private boolean isFail() {
            return upside.get(upside.size() - 1).equals(Crossing.FAIL.value) ||
                    downside.get(downside.size() - 1).equals(Crossing.FAIL.value);
        }

        @Override
        public String toString() {
            String up = "[ " + String.join(" | ", upside) + " ]";
            String down = "[ " + String.join(" | ", downside) + " ]";

            return up + "\n" + down;
        }
    }
}
