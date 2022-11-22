package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.service.BridgeGame;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    List<String> bridge;

    BridgeGame bridgeGame;

    @BeforeEach
    void setBridgeGame() {
        bridgeGame = new BridgeGame();
        bridge = bridgeGame.makeBridge(3);
    }

    @Nested
    class makeBridgeTest {
        @DisplayName("다리길이 입력시 생성된 다리 사이즈 확인")
        @Test
        void bridgeSizeTest() {
            int checkSize = 3;
            Assertions.assertThat(bridge.size()).isEqualTo(checkSize);
        }

        @DisplayName("생성된 다리 U,D 이외의 값 확인")
        @ParameterizedTest
        @CsvSource(value = {"1 : false", "u : false", "d : false", "아 : false", "-1 : false",
                "10 : false"}, delimiter = ':')
        void bridgeContainsTest(String element, boolean expected) {
            assertThat(bridge.contains(element)).isEqualTo(expected);
        }
    }
}
