package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    Bridge bridge;
    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U"));
    }

    @DisplayName("사용자의 index번째에 입력한 이동할 칸 값과 index번째 다리의 정답이 일치할때 참을 반환하는지 테스트")
    @Test
    void moveTrue() {
        //given
        MoveDirection direction = new MoveDirection("U");
        int index = 2;

        BridgeGame bridgeGame = new BridgeGame(bridge);
        //when
        boolean isMove = bridgeGame.move(direction, index);
        //then
        assertThat(isMove)
                .isTrue();
    }

    @DisplayName("사용자의 index번째에 입력한 이동할 칸 값과 index번째 다리의 정답이 일치하지 않을 때 거짓을 반환하는지 테스트")
    @Test
    void moveFalse() {
        //given
        MoveDirection direction = new MoveDirection("D");
        int index = 2;

        BridgeGame bridgeGame = new BridgeGame(bridge);
        //when
        boolean isMove = bridgeGame.move(direction, index);
        //then
        assertThat(isMove)
                .isFalse();
    }
}