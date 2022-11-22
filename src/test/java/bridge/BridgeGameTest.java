package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame testBridgeGame;
    private Bridge testBridge = new Bridge(List.of("U"));

    @BeforeEach
    void init() {
        this.testBridgeGame = new BridgeGame(this.testBridge);
    }

    @DisplayName("위쪽으로 이동 가능한 다리에서 위쪽으로 가면 이동한다.")
    @Test
    void moveSuccessTest() {
        assertThat(testBridgeGame.move("U")).isTrue();
        assertThat(testBridgeGame.getCurrentPosition()).isEqualTo(0);
        assertThat(testBridgeGame.getMoveHistory())
                .containsExactly(new History(0, "U", true));
    }

    @DisplayName("위쪽으로 이동 가능한 다리에서 아래쪽으로 가면 이동할 수 없다.")
    @Test
    void moveFailTest() {
        assertThat(testBridgeGame.move("D")).isFalse();
        assertThat(testBridgeGame.getCurrentPosition()).isEqualTo(0);
        assertThat(testBridgeGame.getMoveHistory())
                .containsExactly(new History(0, "D", false));
    }

    @DisplayName("다리의 끝에서는 이동할 수 없다.")
    @Test
    void moveAtEndOfBridgeFailTest() {
        testBridgeGame.move("U");
        assertThat(testBridgeGame.move("U")).isFalse();
    }

    @DisplayName("다리 끝까지 성공적으로 도착했을때 True를 반환한다.")
    @Test
    void isWinTest() {
        testBridgeGame.move("U");
        assertThat(testBridgeGame.isWin()).isTrue();
    }

    @DisplayName("다리 끝에 도착하지 않았을때 False를 반환한다.")
    @Test
    void isWinNotReachedFailTest() {
        assertThat(testBridgeGame.isWin()).isFalse();
    }

    @DisplayName("마지막 칸에서 실패했을때 False를 반환한다.")
    @Test
    void isWinReachedFailTest() {
        testBridgeGame.move("D");
        assertThat(testBridgeGame.isWin()).isFalse();
    }

    @DisplayName("재시도시 원래의 다리를 재사용하고, 처음부터 다리를 건넌다.")
    @Test
    void retryTest() {
        testBridgeGame.move("D");
        testBridgeGame.retry();

        assertThat(testBridgeGame.getBridge()).isEqualTo(testBridge);
        assertThat(testBridgeGame.getTryCount()).isEqualTo(2);
        assertThat(testBridgeGame.getMoveHistory()).isEmpty();
        assertThat(testBridgeGame.getCurrentPosition()).isEqualTo(-1);
    }
}