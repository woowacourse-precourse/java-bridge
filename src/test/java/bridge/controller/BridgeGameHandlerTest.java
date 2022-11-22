package bridge.controller;

import bridge.core.BridgeGame;
import bridge.core.exception.Error;
import bridge.type.GameStatus;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class BridgeGameHandlerTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("다리 길이 입력 테스트")
    class InputBridgeLengthTest extends NsTest {

        BridgeGameHandler bridgeGameHandler;

        @Override
        protected void runMain() {
            bridgeGameHandler = new BridgeGameHandler();
            bridgeGameHandler.initGame();
        }

        @DisplayName("다리 길이에 대한 잘못된 입력이 주어질 경우 예외가 발생한다.")
        @ParameterizedTest
        @MethodSource("providePlayerInputForInvalidBridgeLength")
        void inputInvalidBridgeLength(String playerInput, String errorMessage) {
            assertSimpleTest(() -> {
                runException(playerInput);
                assertThat(output()).contains(errorMessage);
            });
        }

        private Stream<Arguments> providePlayerInputForInvalidBridgeLength() {
            return Stream.of(
                    Arguments.of("a", Error.NON_NUMERIC_ERROR.getMessage()),
                    Arguments.of("@", Error.NON_NUMERIC_ERROR.getMessage()),
                    Arguments.of(" ", Error.NON_NUMERIC_ERROR.getMessage()),
                    Arguments.of("\n", Error.NON_NUMERIC_ERROR.getMessage()),
                    Arguments.of("1", Error.OUT_OF_RANGE_ERROR.getMessage()),
                    Arguments.of("30", Error.OUT_OF_RANGE_ERROR.getMessage())
            );
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("이동할 칸 입력 테스트")
    class InputBridgeBlockTest extends NsTest {

        BridgeGameHandler bridgeGameHandler;

        @Override
        protected void runMain() {
            bridgeGameHandler = new BridgeGameHandler();
            BridgeGame bridgeGame = bridgeGameHandler.initGame();
            bridgeGameHandler.executeGame(GameStatus.START, bridgeGame);
        }

        @DisplayName("이동할 칸을 잘못 입력할 경우 예외가 발생한다.")
        @ParameterizedTest
        @MethodSource("providePlayerInputForInvalidBridgeBlock")
        void inputInvalidBridgeBlock(String bridgeLength, String selectBlock) {
            assertSimpleTest(() -> {
                runException(bridgeLength, selectBlock);
                assertThat(output()).contains(Error.SELECT_BLOCK_ERROR.getMessage());
            });
        }

        private Stream<Arguments> providePlayerInputForInvalidBridgeBlock() {
            return Stream.of(
                    Arguments.of("3", "u"),
                    Arguments.of("3", "up"),
                    Arguments.of("3", "down"),
                    Arguments.of("3", " "),
                    Arguments.of("3", "\n"),
                    Arguments.of("3", "5"),
                    Arguments.of("3", "@")
            );
        }
    }
}