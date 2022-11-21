package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setBridgeGame() {
        bridgeGame = new BridgeGame(2, new BridgeFakeOneZeroLoopNumberGenerator());
    }

    @DisplayName("이동한 칸이 이동가능한 칸인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"U:true","D:false"},delimiter = ':')
    void check_move(String direction,boolean expected) {
        assertThat(bridgeGame.move(direction)).isEqualTo(expected);
    }


    @DisplayName("이동 완료 문의")
    @Test
    void is_completed_move() {
        assertThat(bridgeGame.isCompletedGame()).isFalse();
        bridgeGame.move("U");
        assertThat(bridgeGame.isCompletedGame()).isFalse();
        bridgeGame.move("D");
        assertThat(bridgeGame.isCompletedGame()).isTrue();
    }

    @DisplayName("게임 다시 시도시 상태 변경")
    @Test
    void test_retry() {
        assertThat(bridgeGame.isStartStatus()).isTrue();
        bridgeGame.move("D");
        assertThat(bridgeGame.isCompletedGame()).isFalse();
        bridgeGame.retry();
        assertThat(bridgeGame.isStartStatus()).isTrue();
    }

    @DisplayName("도전 회수 조회")
    @Test
    void get_retry_count() {
        assertThat(bridgeGame.getRetryCount()).isEqualTo(1);
        bridgeGame.retry();
        assertThat(bridgeGame.getRetryCount()).isEqualTo(2);
    }

    @DisplayName("결과 출력")
    @Test
    void print_result() {
        bridgeGame.move("U");
        assertThat(bridgeGame.printResult()).isEqualTo("[ O ]\n[   ]\n");
        bridgeGame.move("U");
        assertThat(bridgeGame.printResult()).isEqualTo("[ O | X ]\n[   |   ]\n");
    }
}
