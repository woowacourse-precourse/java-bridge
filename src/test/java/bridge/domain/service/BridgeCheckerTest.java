package bridge.domain.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import bridge.constant.Message.InputExceptionMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeCheckerTest {

    private final BridgeChecker bridgeChecker = BridgeChecker.getInstance();

    @DisplayName("다리 길이 입력으로 문자가 포함됐을 때")
    @ValueSource(strings = {"100j", "sdfsd", "100 0"})
    @ParameterizedTest
    public void 다리_길이_문자포함_예외테스트(final String size) {
        다리_길이_예외테스트(size);
    }

    @DisplayName("다리 길이 입력이 범위를 벗어났을 때")
    @ValueSource(strings = {"-1", "2", "100"})
    @ParameterizedTest
    public void 다리_길이_범위_예외테스트(final String size) {
        다리_길이_예외테스트(size);
    }

    @DisplayName("이동 방향 입력이 숫자를 포함했을 때")
    @ValueSource(strings = {"-1", "100", "U1", "0D"})
    @ParameterizedTest
    public void 이동_방향_숫자_예외테스트(final String moving) {
        이동_방향_예외테스트(moving);
    }

    @DisplayName("이동 방향 입력이 다른 문자열일 때")
    @ValueSource(strings = {"UP", "DOWN", "asd"})
    @ParameterizedTest
    public void 이동_방향_잘못된_문자_예외테스트(final String moving) {
        이동_방향_예외테스트(moving);
    }

    @DisplayName("이동 방향 입력이 소문자일 때 때")
    @ValueSource(strings = {"u", "d"})
    @ParameterizedTest
    public void 이동_방향_소문자_예외테스트(final String moving) {
        이동_방향_예외테스트(moving);
    }

    @DisplayName("재시작 입력이 숫자를 포함했을 때")
    @ValueSource(strings = {"-1", "100", "R1", "0Q"})
    @ParameterizedTest
    public void 재시도_여부_숫자_예외테스트(final String gameCommand) {
        재시도_여부_예외테스트(gameCommand);
    }

    @DisplayName("재시작 입력이 다른 문자열일 때")
    @ValueSource(strings = {"Quit", "Retry", "asd"})
    @ParameterizedTest
    public void 재시도_여부_잘못된_문자_예외테스트(final String gameCommand) {
        재시도_여부_예외테스트(gameCommand);
    }
    @DisplayName("재시작 입력이 소문자일 때 때")
    @ValueSource(strings = {"r", "q"})
    @ParameterizedTest
    public void 재시작_여부_소문자_예외테스트(final String gameCommand) {
        재시도_여부_예외테스트(gameCommand);
    }

    private void 재시도_여부_예외테스트(final String gameCommand) {
        assertThatThrownBy(() -> bridgeChecker.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputExceptionMessage.WRONG_GAME_COMMAND);
    }

    private void 이동_방향_예외테스트(final String moving) {
        assertThatThrownBy(() -> bridgeChecker.validateMoving(moving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputExceptionMessage.WRONG_MOVING);
    }

    private void 다리_길이_예외테스트(final String size) {
        assertThatThrownBy(() -> bridgeChecker.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputExceptionMessage.WRONG_BRIDGE_SIZE);
    }
}
