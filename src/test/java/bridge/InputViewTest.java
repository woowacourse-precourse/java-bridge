package bridge;

import bridge.controller.InputViewException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static bridge.controller.InputViewException.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private final InputViewException inputViewException = new InputViewException();


    @DisplayName("다리 길이 입력에 대한 예외 테스트")
    @ParameterizedTest
    @MethodSource("readBridgeSizeParam")
    void readBridgeSize(String bridgeSize, String exception) {
        assertThatThrownBy(() -> inputViewException.readBridgeSizeException(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exception);
    }

    static Stream<Arguments> readBridgeSizeParam() {
        return Stream.of(
                Arguments.of("", error01),
                Arguments.of("5d", error02),
                Arguments.of("2", error03),
                Arguments.of("21", error03)
        );
    }




    @DisplayName("이동할 칸 입력에 대한 예외 테스트")
    @ParameterizedTest
    @MethodSource("readMovingParam")
    void readMoving(String playerMove, String exception) {
        assertThatThrownBy(() -> inputViewException.readMovingException(playerMove))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exception);
    }

    static Stream<Arguments> readMovingParam() {
        return Stream.of(
                Arguments.of("", error01),
                Arguments.of("R", error04),
                Arguments.of("Q", error04),
                Arguments.of("DU", error04),
                Arguments.of("u", error04)
        );
    }


    @DisplayName("게임 재시작/종료 입력에 대한 예외 테스트")
    @ParameterizedTest
    @MethodSource("readGameCommandParam")
    void readGameCommand(String playerCommand, String exception) {
        assertThatThrownBy(() -> inputViewException.readGameCommandException(playerCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exception);
    }

    static Stream<Arguments> readGameCommandParam() {
        return Stream.of(
                Arguments.of("", error01),
                Arguments.of("D", error05),
                Arguments.of("U", error05),
                Arguments.of("r", error05)
        );
    }
}