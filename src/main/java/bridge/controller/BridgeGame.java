package bridge.controller;

import static global.advice.InputValidator.RETRY_SIGNAL;

import bridge.dto.InputRequestDto;
import bridge.dto.StepResponseDto;
import bridge.model.Bridge;
import bridge.model.Score;
import global.config.AppConfig;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Score score;

    public BridgeGame(final InputRequestDto sizeDto) {
        AppConfig appConfig = new AppConfig();
        this.bridge = new Bridge(appConfig.bridgeFactory(), sizeDto.getInput());
        this.score = new Score();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public StepResponseDto move(final InputRequestDto movingDto) {
        if (!score.goOneStep(this.bridge, movingDto.getInput())) {
            return new StepResponseDto(score, false);
        }
        if (score.isCrossing(this.bridge)) {
            return new StepResponseDto(score);
        }
        return new StepResponseDto(score, true);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(final InputRequestDto retryWhetherDto) {
        return RETRY_SIGNAL.equals(score.judgeRetry(retryWhetherDto.getInput()));
    }
}
