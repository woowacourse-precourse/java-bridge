package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void init() {
        bridge = new Bridge();
        List<String> blocks = List.of("U", "D", "U");
        bridge.init(blocks);
    }

    @DisplayName("사용자가 이동하려는 칸이 건널 수 있는 칸이라면 true반환")
    @Test
    void should_True_When_canCross() {
        int playerPosition = 0;
        String moving = "U";
        assertThat(bridge.canCross(playerPosition, moving)).isTrue();
    }

    @DisplayName("사용자가 이동하려는 칸이 건널 수 없는 칸이라면 true반환")
    @Test
    void should_False_When_canCross() {
        int playerPosition = 0;
        String moving = "D";
        assertThat(bridge.canCross(playerPosition, moving)).isFalse();
    }

    @DisplayName("사용자가 이동하려는 칸이 위 칸이라면 true반환")
    @Test
    void should_True_When_isUpBlock() {
        int playerPosition = 0;
        assertThat(bridge.isUpBlock(playerPosition)).isTrue();
    }

    @DisplayName("사용자가 이동하려는 칸이 아래 칸이라면 false반환")
    @Test
    void should_False_When_isUpBlock() {
        int playerPosition = 1;
        assertThat(bridge.isUpBlock(playerPosition)).isFalse();
    }

    @DisplayName("사용자가 다리를 다 건넜다면 true반환")
    @Test
    void should_True_When_isDoneCrossingBridge() {
        int playerPosition = 3;
        assertThat(bridge.isDoneCrossingBridge(playerPosition)).isTrue();
    }

    @DisplayName("사용자가 다리를 다 건너지 못했다면 false반환")
    @Test
    void should_False_When_isDoneCrossingBridge() {
        int playerPosition = 1;
        assertThat(bridge.isDoneCrossingBridge(playerPosition)).isFalse();
    }
}
