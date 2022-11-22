package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}