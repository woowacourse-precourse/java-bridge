package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.repository.BridgeResultData;
import bridge.repository.MovingData;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame(3, new BridgeRandomNumberGenerator());

    @AfterEach
    void clearData() {
        bridgeGame.quit();
    }

    @Test
    @DisplayName("upBridge 를 제대로 건넜을 때 각각 O와 공백을 반환한다.")
    void winUpBridgeTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);
        bridgeGame.move("U");

        assertThat(BridgeResultData.getUpBridgeResults().get(0)).isEqualTo("O");
        assertThat(BridgeResultData.getDownBridgeResults().get(0)).isEqualTo(" ");
    }

    @Test
    @DisplayName("upBridge 를 잘못 건넜을 때 각각 X와 공백을 반환한다.")
    void loseUpBridgeTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);
        bridgeGame.move("U");

        assertThat(BridgeResultData.getUpBridgeResults().get(0)).isEqualTo("X");
        assertThat(BridgeResultData.getDownBridgeResults().get(0)).isEqualTo(" ");
    }

    @Test
    @DisplayName("downBridge 를 제대로 건넜을 때 각각 공백과 O을 반환한다.")
    void winDownBridgeTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);
        bridgeGame.move("D");

        assertThat(BridgeResultData.getUpBridgeResults().get(0)).isEqualTo(" ");
        assertThat(BridgeResultData.getDownBridgeResults().get(0)).isEqualTo("O");
    }

    @Test
    @DisplayName("downBridge 를 잘못 건넜을 때 각각 공백과 X를 반환한다.")
    void loseDownBridgeTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);
        bridgeGame.move("D");

        assertThat(BridgeResultData.getUpBridgeResults().get(0)).isEqualTo(" ");
        assertThat(BridgeResultData.getDownBridgeResults().get(0)).isEqualTo("X");
    }

    @Test
    @DisplayName("move 하면 데이터 저장소에 데이터가 들어간다.")
    void moveTest() {
        String moving = "D";
        bridgeGame.move(moving);

        assertThat(MovingData.getSize()).isEqualTo(1);
        assertThat(BridgeResultData.getUpBridgeResults().size()).isEqualTo(1);
        assertThat(BridgeResultData.getDownBridgeResults().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("retry 하면 마지막 데이터가 삭제된다.")
    void retryTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.retry();

        assertThat(MovingData.getSize()).isEqualTo(1);
        assertThat(BridgeResultData.getUpBridgeResults().size()).isEqualTo(1);
        assertThat(BridgeResultData.getDownBridgeResults().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("quit 하면 모든 데이터가 삭제된다.")
    void quitTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.quit();

        assertThat(MovingData.getSize()).isEqualTo(0);
        assertThat(BridgeResultData.getUpBridgeResults().size()).isEqualTo(0);
        assertThat(BridgeResultData.getDownBridgeResults().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("승리하면 참을 반환한다.")
    void winTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);

        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        boolean winBridgeGame = bridgeGame.isWin("U");

        assertThat(winBridgeGame).isEqualTo(true);
    }


    public static class TestNumberGenerator implements BridgeNumberGenerator {
        private final List<Integer> bridgeNumbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.bridgeNumbers = numbers;
        }

        @Override
        public int generate() {
            return bridgeNumbers.remove(0);
        }
    }
}
