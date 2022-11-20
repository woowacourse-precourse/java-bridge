package bridge;


import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    BridgeGame bridgeGame;
    Bridge bridge;

    @Test
    @DisplayName("플레이어의 끝에 다다르면 true를 반환한다.")
    void 플레이어가_입력방향이_다르면_예외발생() {
        bridge = new Bridge(List.of("D", "U", "D", "U"));
        bridgeGame = new BridgeGame(bridge, new Result());
        List.of("D", "U", "D", "U").forEach((direction) ->{
            bridgeGame.move(direction);
        });
        assertThat(bridgeGame.isFinish()).isTrue();
    }

    @Test
    @DisplayName("플레이어의 입력이 움직일 수 있는 방향이면 정상 실행한다.")
    void 플레이어의_입력방향이_틀리면_정상종료() {
        bridge = new Bridge(List.of("D", "U", "D", "U"));
        bridgeGame = new BridgeGame(bridge, new Result());
        List.of("D", "U", "D", "U").forEach((direction) ->{
            bridgeGame.move(direction);
            assertThat(bridgeGame.hasNotSameDirection()).isFalse();
        });
    }

    @Test
    @DisplayName("다리 길이와 같은 정수 값이 들어오면 true 를 반환한다.")
    void 다리_길이와_같은_정수값이_들어오면_true_를_반환한다() {
        bridge = new Bridge(List.of("D", "D", "D"));
        assertThat(bridge.isFinish(3)).isTrue();
    }

    @Test
    @DisplayName("다리 길이와 다른 정수 값이 들어오면 true 를 반환한다.")
    void 다리_길이와_다른_정수값이_들어오면_true_를_반환한다() {
        bridge = new Bridge(List.of("D", "D", "D"));
        assertThat(bridge.isFinish(2)).isFalse();
    }
}
