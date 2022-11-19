package bridge;


import bridge.domain.Bridge;
import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    Bridge bridge;
    Player success;
    Player fail;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("D", "U", "D", "U"));
        success = new Player(4);
        fail = new Player(4);
        List.of("D", "U", "D", "U").forEach(e -> success.inputDirection(e));
        List.of("D", "U", "D", "D").forEach(e -> fail.inputDirection(e));
    }

    @Test
    @DisplayName("플레이어의 입력 횟수가 다리 끝에 도달하면 true를 반환한다.")
    void 플레이어가_끝에_도달하면_정상종료() {
        assertThat(success.isFinish()).isTrue();
    }

    @Test
    @DisplayName("플레이어의 입력이 움직일 수 있는 방향이 아니면 true를 반환한다.")
    void 플레이어의_입력방향이_틀리면_정상종료() {
        assertThat(fail.hasNotSameDirection(bridge)).isTrue();
    }
}
