package bridge;

import bridge.model.BridgeGame;
import bridge.model.Direction;
import bridge.model.Round;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    @Nested
    class 기능_테스트 {

        private final String first = "U";
        private final String second = "U";
        private final String third = "D";
        private final Direction firstDir = Direction.fromSymbol(first);
        private final Direction secondDir = Direction.fromSymbol(second);
        private final Direction thirdDir = Direction.fromSymbol(third);


        @Test
        public void 생성자에_따른_올바른_다리_체크(){
            BridgeGame bridgeGame = new BridgeGame(List.of(first, second, third));
            List<Direction> bridge = bridgeGame.getBridge();

            assertThat(bridge.get(0)).isEqualTo(firstDir);
            assertThat(bridge.get(1)).isEqualTo(secondDir);
            assertThat(bridge.get(2)).isEqualTo(thirdDir);
        }

        @Test
        public void 올바른_곳으로_이동시_PASS(){
            BridgeGame bridgeGame = new BridgeGame(List.of(first, second, third));
            Direction selection = firstDir;
            bridgeGame.move(selection);
            List<Round> history = bridgeGame.getHistory();

            assertThat(history.get(0).getSelection()).isEqualTo(selection);
            assertThat(history.get(0).isPass()).isEqualTo(true);
            assertThat(bridgeGame.isFail()).isEqualTo(false);
        }

        @Test
        public void 옳지않은_곳으로_이동시_FAIL(){
            BridgeGame bridgeGame = new BridgeGame(List.of(first, second, third));
            Direction selection = Direction.DOWN;
            bridgeGame.move(selection);
            List<Round> history = bridgeGame.getHistory();

            assertThat(history.get(0).getSelection()).isEqualTo(selection);
            assertThat(history.get(0).isPass()).isEqualTo(false);
            assertThat(bridgeGame.isFail()).isEqualTo(true);
        }

        @Test
        public void 재시도시_history_초기화_후_trial증가(){
            BridgeGame bridgeGame = new BridgeGame(List.of(first, second, third));
            Direction selection = firstDir;

            // 초기 상태
            assertThat(bridgeGame.getTrial()).isEqualTo(1);
            assertThat(bridgeGame.getHistory().size()).isEqualTo(0);

            bridgeGame.move(selection);

            // 이동 후 상태
            assertThat(bridgeGame.getHistory().size()).isEqualTo(1);

            bridgeGame.retry();

            // 재시도 후 상태
            assertThat(bridgeGame.getTrial()).isEqualTo(2);
            assertThat(bridgeGame.getHistory().size()).isEqualTo(0);
        }

        @Test
        public void 포기할_시_게임_종료(){
            BridgeGame bridgeGame = new BridgeGame(List.of(first, second, third));

            // 포기 전
            assertThat(bridgeGame.isEnd()).isEqualTo(false);

            bridgeGame.setGiveUp(true);

            // 포기 후
            assertThat(bridgeGame.isEnd()).isEqualTo(true);
        }

        @Test
        public void 다리_끝에_실패없이_도착하면_게임_종료(){
            BridgeGame bridgeGame = new BridgeGame(List.of(first, second, third));

            assertThat(bridgeGame.isSuccess()).isEqualTo(false);
            assertThat(bridgeGame.isFail()).isEqualTo(false);

            bridgeGame.move(firstDir);

            assertThat(bridgeGame.isSuccess()).isEqualTo(false);
            assertThat(bridgeGame.isFail()).isEqualTo(false);

            bridgeGame.move(secondDir);

            assertThat(bridgeGame.isSuccess()).isEqualTo(false);
            assertThat(bridgeGame.isFail()).isEqualTo(false);

            bridgeGame.move(thirdDir);

            assertThat(bridgeGame.isSuccess()).isEqualTo(true);
            assertThat(bridgeGame.isFail()).isEqualTo(false);
        }

        @Test
        public void 성공할_시_게임_종료(){
            BridgeGame bridgeGame = new BridgeGame(List.of(first, second, third));

            assertThat(bridgeGame.isSuccess()).isEqualTo(false);
            assertThat(bridgeGame.isEnd()).isEqualTo(false);

            bridgeGame.move(firstDir);

            assertThat(bridgeGame.isSuccess()).isEqualTo(false);
            assertThat(bridgeGame.isEnd()).isEqualTo(false);

            bridgeGame.move(secondDir);

            assertThat(bridgeGame.isSuccess()).isEqualTo(false);
            assertThat(bridgeGame.isEnd()).isEqualTo(false);

            bridgeGame.move(thirdDir);

            assertThat(bridgeGame.isSuccess()).isEqualTo(true);
            assertThat(bridgeGame.isEnd()).isEqualTo(true);
        }


    }

    @Nested
    class 예외_테스트 {

        @Test
        public void 올바르지_않은_문자열로_생성시_예외_발생(){
            assertThatThrownBy(() -> new BridgeGame(List.of("A", "B", "C")))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> new BridgeGame(List.of("foo", "bar")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void 올바르지_않은_문자열로_다리_설정시_예외_발생(){
            BridgeGame bridgeGame = new BridgeGame();
            assertThatThrownBy(() -> bridgeGame.setBridge(List.of("A", "B", "C")))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> bridgeGame.setBridge(List.of("foo", "bar")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void 올바르지_않은_값으로_이동시_예외_발생(){
            BridgeGame bridgeGame = new BridgeGame();
            assertThatThrownBy(() -> bridgeGame.move(Direction.valueOf("U")))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> bridgeGame.move(Direction.fromSymbol("foo")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }
}
