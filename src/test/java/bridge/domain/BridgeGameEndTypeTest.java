package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static bridge.domain.BridgeGameEndType.END;
import static bridge.domain.BridgeGameEndType.RESTART;
import static bridge.exception.BridgeGameEndTypeExceptionMessage.NO_SUCH_BRIDGE_GAME_END_TYPE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BridgeGameEndTypeTest {

    @ParameterizedTest(name = "[{index}] gameEndType = {0}, bridgeGameEndType = {1}")
    @MethodSource("whenStringTypeSearchThenSuccessDummy")
    @DisplayName("입력된 String 타입의 입력값을 이용하여 다리 게임 종료 타입 검색을 성공한다.")
    void whenStringTypeSearchThenSuccessTest(String gameEndType, BridgeGameEndType bridgeGameEndType) {
        // given & when
        BridgeGameEndType findBridgeGameEndType = BridgeGameEndType.of(gameEndType);

        // then
        assertThat(findBridgeGameEndType).isEqualTo(bridgeGameEndType);
    }

    @ParameterizedTest(name = "[{index}] gameEndType = {0}")
    @ValueSource(strings = {"QQ", "RR", "QR", "RQ", "QRQ", "", " ", "q", "r", "A", "B", "!", "@", "#", "$", "%", "^"})
    @DisplayName("잘못 입력된 String 타입의 입력값을 이용한 다리 게임 종료 타입 검색에 실패하여 예외처리 된다.")
    void whenWrongStringTypeSearchThenExceptionTest(String gameEndType) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BridgeGameEndType.of(gameEndType))
                .withMessage(NO_SUCH_BRIDGE_GAME_END_TYPE_EXCEPTION.getMessage());
    }

    @ParameterizedTest(name = "[{index}] gameEndType = {0}")
    @ValueSource(strings = {"", " ", "1", "2", "3", "ㅁ", "ㅂ", "QWERT", "QQ"})
    @DisplayName("잘못 입력된 String 타입의 입력값을 확인하여 실패한다.")
    void whenWrongStringTypeExistsThenFailTest(String gameEndType) {
        boolean endTypeExists = BridgeGameEndType.isEndTypeExists(gameEndType);
        assertThat(endTypeExists).isFalse();
    }

    @Test
    @DisplayName("잘못 입력된 null를 이용한 다리 이동 타입 검색에 실패하여 예외처리 된다.")
    void whenNullSearchThenExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BridgeGameEndType.of(null))
                .withMessage(NO_SUCH_BRIDGE_GAME_END_TYPE_EXCEPTION.getMessage());
    }

    static Stream<Arguments> whenStringTypeSearchThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("Q", END),
                Arguments.arguments("R", RESTART)
        );
    }
}