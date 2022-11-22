package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    private static final BridgeGame game = new BridgeGame();
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";
    private static final List<String> bridge = List.of("U", "U", "U", "U", "U");

    private static List<String> path = new ArrayList<>();


    @DisplayName("path의 마지막 요소가 같은 위치의 bridge 요소와 달라 move가 false 리턴")
    @Test
    void moveFailPathLastElementDiffBridge() {
        path = Arrays.asList("d");
        assertThat(game.move(bridge, path)).isFalse();
    }

    @DisplayName("bridge와 path의 사이즈가 같아 move가 false 리턴")
    @Test
    void moveFailPathSizeEqualBridgeSize() {
        path = Arrays.asList("U", "U", "U", "U", "U");
        assertThat(game.move(bridge, path)).isFalse();
    }

    @DisplayName("정상적인 입력으로 move가 true 리턴하는 경우")
    @Test
    void moveSuccessPathSizeBridgeSize() {
        path = Arrays.asList("U", "U", "U", "U");
        assertThat(game.move(bridge, path)).isTrue();
    }

    @DisplayName("게임 재시작/종료 커맨드가 R,Q 이외의 값으로 예외처리 되는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"asd", "one", "i", " ", "\n", "-1", "1", "22"})
    void retryException(String command) {
        assertThatThrownBy(() ->
                game.retry(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작/종료 커맨드가 R 로 true를 리턴하는 경우")
    @Test
    void retryReturnTrue() {
        assertThat(game.retry("R")).isTrue();
    }

    @DisplayName("게임 재시작/종료 커맨드가 Q 로 false를 리턴하는 경우")
    @Test
    void retryReturnFalse() {
        assertThat(game.retry("Q")).isFalse();
    }


    @DisplayName("다리와 경로가 일치해 성공한 경우 ")
    @Test
    void judgeSuccess() {
        path = Arrays.asList("U", "U", "U", "U", "U");
        assertThat(game.judgeSuccessFailure(bridge, path)).contains(SUCCESS);
    }

    @DisplayName("다리와 경로의 사이즈는 같지만 경로가 일치하지 않아 실패한 경우")
    @Test
    void judgeFailureBridgeDiffPath() {
        path = Arrays.asList("U", "U", "U", "U", "D");
        assertThat(game.judgeSuccessFailure(bridge, path)).contains(FAILURE);
    }

    @DisplayName("입력된 경로는 모두 일치하지만 크기가 달라 실패한 경우")
    @Test
    void judgeFailureBridgeSizeDiffPathSize() {
        path = Arrays.asList("U", "U", "U", "U");
        assertThat(game.judgeSuccessFailure(bridge, path)).contains(FAILURE);
    }

    @DisplayName("경로가 공백으로 입력된 경우")
    @Test
    void judgeFailurePathSizeZero() {
        path = Arrays.asList();
        assertThat(game.judgeSuccessFailure(bridge, path)).contains(FAILURE);
    }
}
