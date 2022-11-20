package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static bridge.domain.BridgeGameEndType.END;
import static bridge.domain.BridgeGameEndType.RESTART;
import static org.assertj.core.api.Assertions.assertThat;

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

    static Stream<Arguments> whenStringTypeSearchThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("Q", END),
                Arguments.arguments("R", RESTART)
        );
    }
}