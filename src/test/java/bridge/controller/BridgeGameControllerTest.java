package bridge.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameControllerTest extends NsTest {

    @DisplayName("다리 건너기 게임 한번에 성공")
    @Test
    void When_SuccessGameOneTry_Expect_TryCountOneAndGameSuccess() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[ O | O ]",
                    "[ O | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
            assertThat(output().contains("[ X ]")).isFalse();
        }, 1, 1, 1);
    }

    @DisplayName("다리 건너기 게임 실패후 종료")
    @Test
    void When_FalseGameAndGameQuit_Expect_TryCountOneAndGameFalse() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "Q");
            assertThat(output()).contains(
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            assertThat(output().contains("[ O ]")).isFalse();
        }, 1, 1, 1);
    }

    @DisplayName("다리 건너기 재시도 후 클리어")
    @Test
    void When_GameRetryAndSuccess_Expect_TryCountTwoAndGameClear() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R","U","U","U");
            assertThat(output()).contains(
                    "[ X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 1, 1);
    }


    @DisplayName("잘못된 다리 길이를 입력하면 입력값을 다시 받는다.")
    @ValueSource(strings = {"2","21"})
    @ParameterizedTest
    void When_InputWrongBridgeSize_Expect_ReInputBridgeSize(String wrongBridgeSize) {
        assertRandomNumberInRangeTest(() -> {
            run(wrongBridgeSize, "3", "U", "U", "U");
            assertThat(output()).contains(
                    "[ERROR] 다리 길이는 3 이상, 20 이하여야 합니다.",
                    "입력값 : " + wrongBridgeSize,
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 1);
    }

    @DisplayName("잘못된 이동 명령를 입력하면 입력값을 다시 받는다.")
    @ValueSource(strings = {"A","B"})
    @ParameterizedTest
    void When_InputWrongMoveCommand_Expect_ReInputMoveCommand(String wrongMoveCommand) {
        assertRandomNumberInRangeTest(() -> {
            run( "3", wrongMoveCommand, "U", "U", "U");
            assertThat(output()).contains(
                    "[ERROR] U,D 이외의 값은 허용되지 않습니다.",
                    "입력값 : " + wrongMoveCommand,
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 1);
    }

    @DisplayName("잘못된 재시작 명령를 입력하면 입력값을 다시 받는다.")
    @ValueSource(strings = {"A","B"})
    @ParameterizedTest
    void When_InputWrongRetryCommand_Expect_ReInputRetryCommand(String wrongRetryCommand) {
        assertRandomNumberInRangeTest(() -> {
            run( "3", "D", wrongRetryCommand, "Q");
            assertThat(output()).contains(
                    "[ERROR] R,Q 이외의 값은 허용되지 않습니다.",
                    "입력값 : " + wrongRetryCommand,
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}