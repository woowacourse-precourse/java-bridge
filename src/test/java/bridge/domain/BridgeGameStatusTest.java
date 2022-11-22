package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BridgeGameStatus Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameStatusTest {

    @ParameterizedTest
    @CsvSource({"PLAY, true", "STOP, false"})
    void isPlayable_메서드는_게임의_진행가능여부를_반환한다(BridgeGameStatus bridgeGameStatus, boolean result) {
        assertThat(bridgeGameStatus.isPlayable()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"PLAY, false", "STOP, true"})
    void isNotPlayable_메서드는_게임의_진행_불가능여부를_반환한다(BridgeGameStatus bridgeGameStatus, boolean result) {
        assertThat(bridgeGameStatus.isNotPlayable()).isEqualTo(result);
    }

    @Test
    void gameStart_메서드는_PLAY를_반환한다() {
        assertThat(BridgeGameStatus.gameStart()).isEqualTo(BridgeGameStatus.PLAY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "q", "r", "C"})
    void toEnum_메서드는_올바르지_않은_입력값을_받는경우_IllegalArgumentException을_던진다(String command) {
        assertThatThrownBy(() -> BridgeGameStatus.getEnum(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("R과 Q 중 하나의 값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource({"R, PLAY", "Q, STOP"})
    void toEnum_메서드는_올바른_입력값을_받는경우_BridgeGameStatus를_반환한다(String command, BridgeGameStatus result) {
        assertThat(BridgeGameStatus.getEnum(command)).isEqualTo(result);
    }
}
