package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("사용자의 index번째에 입력한 이동할 칸 값과 index번째 다리의 정답이 일치할때 참을 반환하는지 테스트")
    @Test
    void moveTrue() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        String moving = "U";
        int index = 2;

        BridgeGame bridgeGame = new BridgeGame();
        //when
        boolean isMove = bridgeGame.move(bridge, moving, index);
        //then
        assertThat(isMove)
                .isTrue();
    }

    @DisplayName("사용자의 index번째에 입력한 이동할 칸 값과 index번째 다리의 정답이 일치하지 않을 때 거짓을 반환하는지 테스트")
    @Test
    void moveFalse() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        String moving = "D";
        int index = 2;

        BridgeGame bridgeGame = new BridgeGame();
        //when
        boolean isMove = bridgeGame.move(bridge, moving, index);
        //then
        assertThat(isMove)
                .isFalse();
    }
}