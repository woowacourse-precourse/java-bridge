package bridge.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PlayerSettingTest {

    private final PlayerSetting playerSetting = new PlayerSetting();

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("플레이어의 다리 크기 입력받은 뒤 저장")
    class setReadBridgeSizeToPlayerTest {
        @ParameterizedTest
        @MethodSource("data")
        void test(String readBridgeSize, int validate) {
            playerSetting.setBridgeSizeToPlayer(readBridgeSize);
            int playerBridgeSize = playerSetting.getPlayerBridgeSize();
            Assertions.assertThat(playerBridgeSize).isEqualTo(validate);
        }

        Stream<Arguments> data() {
            return Stream.of(
                    Arguments.of("3", 3),
                    Arguments.of("10", 10),
                    Arguments.of("20", 20)
            );
        }
    }

    @Nested
    @DisplayName("숫자가 아닌 다리의 크기를 입력 받을시 예외를 던짐")
    class setReadBridgeSizeToPlayerNotDigitTest {
        @ParameterizedTest
        @CsvSource({
                "ab", ".!"
        })
        void test(String readBridgeSize) {
            Assertions.assertThatThrownBy(() -> playerSetting.setBridgeSizeToPlayer(readBridgeSize))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
