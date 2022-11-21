package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.repository.BridgeResultData;
import bridge.repository.MovingData;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("[메서드 테스트] upBridge에 O 값 반환 / downBridge에 공백 반환")
    void test1() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);

        String moving = "U";
        String upBridgeResult = bridgeGame.getBridgeResult(moving, "U");
        String downBridgeResult = bridgeGame.getBridgeResult(moving, "D");
        assertThat(upBridgeResult).isEqualTo("O");
        assertThat(downBridgeResult).isEqualTo(" ");
    }

    @Test
    @DisplayName("[메서드 테스트] upBridge에 공백 반환 / downBridge에 O 값 반환")
    void test2() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 0, 0));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);

        String moving = "D";
        String upBridgeResult = bridgeGame.getBridgeResult(moving, "U");
        String downBridgeResult = bridgeGame.getBridgeResult(moving, "D");
        assertThat(upBridgeResult).isEqualTo(" ");
        assertThat(downBridgeResult).isEqualTo("O");
    }

    @Test
    @DisplayName("[메서드 테스트] upBridge에 X 값 반환 / downBridge에 O 값 반환")
    void test3() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 0, 0));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);

        String moving = "U";
        String upBridgeResult = bridgeGame.getBridgeResult(moving, "U");
        String downBridgeResult = bridgeGame.getBridgeResult(moving, "D");
        assertThat(upBridgeResult).isEqualTo("X");
        assertThat(downBridgeResult).isEqualTo(" ");
    }

    @Test
    @DisplayName("[메서드 테스트] upBridge에 공백 반환 / downBridge에 X 값 반환")
    void test4() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);

        String moving = "D";
        String upBridgeResult = bridgeGame.getBridgeResult(moving, "U");
        String downBridgeResult = bridgeGame.getBridgeResult(moving, "D");
        assertThat(upBridgeResult).isEqualTo(" ");
        assertThat(downBridgeResult).isEqualTo("X");
    }

    @Test
    @DisplayName("[메서드 테스트] move 하면 데이터 저장소에 데이터가 들어간다.")
    void test5() {
        BridgeGame bridgeGame = new BridgeGame(3, new BridgeRandomNumberGenerator());
        String moving = "D";
        bridgeGame.move(moving);

        assertThat(MovingData.getSize()).isEqualTo(1);
        assertThat(BridgeResultData.getUpBridgeResults().size()).isEqualTo(1);
        assertThat(BridgeResultData.getDownBridgeResults().size()).isEqualTo(1);

        bridgeGame.quit();
    }

    @Test
    @DisplayName("[메서드 테스트] retry 하면 마지막 데이터가 삭제된다.")
    void test6() {
        BridgeGame bridgeGame = new BridgeGame(3, new BridgeRandomNumberGenerator());

        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.retry();

        assertThat(MovingData.getSize()).isEqualTo(1);
        assertThat(BridgeResultData.getUpBridgeResults().size()).isEqualTo(1);
        assertThat(BridgeResultData.getDownBridgeResults().size()).isEqualTo(1);

        bridgeGame.quit();
    }

    @Test
    @DisplayName("[메서드 테스트] quit 하면 모든 데이터가 삭제된다.")
    void test7() {
        BridgeGame bridgeGame = new BridgeGame(3, new BridgeRandomNumberGenerator());

        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.quit();

        assertThat(MovingData.getSize()).isEqualTo(0);
        assertThat(BridgeResultData.getUpBridgeResults().size()).isEqualTo(0);
        assertThat(BridgeResultData.getDownBridgeResults().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("[메서드 테스트] 승리하면 참을 반환한다.")
    void test8() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeGame bridgeGame = new BridgeGame(3, numberGenerator);

        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        boolean winBridgeGame = bridgeGame.winBridgeGame("U");

        assertThat(winBridgeGame).isEqualTo(true);

        bridgeGame.quit();
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
