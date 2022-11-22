package bridge.domain;

import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    private static final int BRIDGE_SIZE = 3;
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 0));
        bridgeGame = new BridgeGame(numberGenerator, BRIDGE_SIZE);
    }

    @DisplayName("마지막까지 맞추면 성공")
    @Test
    void isSuccess() {
        bridgeGame.move("D");
        assertThat(bridgeGame.isSuccess()).isFalse();
        bridgeGame.move("U");
        assertThat(bridgeGame.isSuccess()).isFalse();
        bridgeGame.move("D");
        assertThat(bridgeGame.isSuccess()).isTrue();
    }

    @DisplayName("플레이어 입력이 Q일 때 게임 종료")
    @Test
    void isEndByPlayerInput() {
        bridgeGame.retry("Q");
        assertThat(bridgeGame.isEnd()).isTrue();
    }

    @DisplayName("마지막까지 맞추어서 게임 종료")
    @Test
    void isEndBySuccess() {
        for (String playerDirection : List.of("D", "U", "D")) {
            bridgeGame.move(playerDirection);
        }
        assertThat(bridgeGame.isEnd()).isTrue();
    }

    @DisplayName("정답과 플레이어의 방향이 맞으면 움직임")
    @ParameterizedTest
    @CsvSource(value = {"D:true", "U:false"}, delimiter = ':')
    void moveByPlayerDirection(String playerDirection, boolean expected) {
        assertThat(bridgeGame.move(playerDirection)).isEqualTo(expected);
    }

    @DisplayName("재시도를 할수록 재시도 횟수 증가")
    @Test
    void retryByContinuousTry() {
        List<Integer> tryCountList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tryCountList.add(bridgeGame.getTryCount());
            bridgeGame.retry("R");
        }
        assertThat(tryCountList).containsExactly(1, 2, 3, 4, 5);
    }

    @DisplayName("플레이어의 입력대로 map 생성")
    @Test
    void getMap() {
        for (String playerDirection : List.of("D", "U", "U")) {
            bridgeGame.move(playerDirection);
        }
        assertThat(bridgeGame.getMap())
                .containsExactly(
                        List.of(" ", "O", "X"),
                        List.of("O", " ", " ")
                );
    }

    private static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        public TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
