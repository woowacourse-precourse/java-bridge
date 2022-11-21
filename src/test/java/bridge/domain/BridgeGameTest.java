package bridge.domain;

import bridge.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    Bridge bridge;
    Result result;
    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U"));
        result = new Result();
    }

    @DisplayName("사용자의 index번째에 입력한 이동할 칸 값과 index번째 다리의 정답이 일치할때 결과에 참이 반영 되는지 테스트")
    @Test
    void moveTrue() {
        //given
        MoveDirection direction = new MoveDirection("U");
        int index = 0;

        BridgeGame bridgeGame = new BridgeGame(bridge, new BridgeGameReferee());
        //when
        bridgeGame.move(result, direction, index);
        //then
        assertThat(result.getIsAnswers()
                         .get(0)).isTrue();
    }

    @DisplayName("사용자의 index번째에 입력한 이동할 칸 값과 index번째 다리의 정답이 일치하지 않을 때 결과에 거짓이 반영되는지 테스트")
    @Test
    void moveFalse() {
        //given
        MoveDirection direction = new MoveDirection("D");
        int index = 0;

        BridgeGame bridgeGame = new BridgeGame(bridge, new BridgeGameReferee());
        //when
        bridgeGame.move(result, direction, index);
        //then
        assertThat(result.getIsAnswers()
                         .get(0)).isFalse();
    }
}