package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.constant.Direction;

class PlayerChoiceTest {
    private PlayerChoice playerChoice;

    @BeforeEach
    void setUp() {
        playerChoice = new PlayerChoice();
    }

    @DisplayName("위쪽 다리일 경우 문자열 변환 테스트")
    @Test
    void toStringWith_위쪽_다리_테스트() {
        this.playerChoice.add(Direction.UP);
        this.playerChoice.add(Direction.DOWN);
        assertThat(playerChoice.toStringWith(List.of("U","D"), Direction.UP)).isEqualTo("[ O |   ]");
    }
    
    @DisplayName("도착하지 않은 상태 테스트")
    @Test
    void isArrived_도착하지_않은_상태_테스트() {
        this.playerChoice.add(Direction.UP);
        this.playerChoice.add(Direction.UP);
        assertThat(playerChoice.isArrived(List.of("U", "D"))).isEqualTo(false);
        assertThat(playerChoice.isArrived(List.of("U", "U", "U"))).isEqualTo(false);
    }
    
    @DisplayName("isValid_테스트")
    @ValueSource(strings = { "U", "D" })
    @ParameterizedTest
    void isValid_테스트(String input) {
        this.playerChoice.add(Direction.UP);
        this.playerChoice.add(Direction.UP);
        assertThat(playerChoice.isValid(List.of("U", "U"))).isEqualTo(true);
        assertThat(playerChoice.isValid(List.of("U", "U", input))).isEqualTo(true);
        assertThat(playerChoice.isValid(List.of("D", "D"))).isEqualTo(false);
    }
}