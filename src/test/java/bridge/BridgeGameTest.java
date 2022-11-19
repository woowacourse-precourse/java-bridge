package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import dto.BridgeGameDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    public static final String VALID_DIRECTION = "유효한 방향은 U 또는 D 입니다.";

    @Test
    @DisplayName("이동 함수 기능테스트")
    void move_기능_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        BridgeGameDto bridgeGameDto = bridgeGame.sendDto();
        assertThat(bridgeGameDto.currentPosition)
                .isEqualTo(2);
        assertThat(bridgeGameDto.totalTrial)
                .isEqualTo(3);
    }

    @Test
    @DisplayName("이동 함수 잘못된 입력 예외처리")
    void move_예외_테스트() {
        assertThatThrownBy(() -> {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.move("A");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALID_DIRECTION);
    }

}
