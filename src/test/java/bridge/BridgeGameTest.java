package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.service.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class BridgeGameTest {

    @DisplayName("다리 길이를 입력받을 때 3~20 이외의 입력값은 검증 후 예외처리")
    @Test
    void 다리_길이_입력값이_3에서_20_사이가_아니면_예외처리하는_기능_테스트() {
        //given
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        int case1 = 0;
        int case2 = 21;

        //when
        Throwable result1 = catchThrowable(()->{new BridgeGame(generator,case1);});
        Throwable result2 = catchThrowable(()->{new BridgeGame(generator, case2);});

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 선택한 방향으로 움직일 수 있게 한다.")
    @Test
    void 플레이어가_입력한_방향으로_움직이는_기능_테스트() {
        //given
        BridgeGame bridgeGameCase1 = new BridgeGame(new TestNumberGenerator(newArrayList(0,1,1)),3);
        bridgeGameCase1.move("D");
        bridgeGameCase1.move("U");
        bridgeGameCase1.move("U");

        //when
        List<String> result1 = bridgeGameCase1.getRoundResult().get(0);

        //then
        assertThat(result1).isEqualTo(List.of("D", "U", "U"));
    }

    @DisplayName("플레이어가 움직이고 난 후 결과를 계산한다.")
    @Test
    void 플레이어가_움직인_후_결과를_계산하는_기능_테스트() {
        //given
        BridgeGame bridgeGameCase1 = new BridgeGame(new TestNumberGenerator(newArrayList(0,1,1)),3);

        //when
        bridgeGameCase1.move("D");
        bridgeGameCase1.move("U");
        List<String> result1 = bridgeGameCase1.getRoundResult().get(1);

        bridgeGameCase1.move("D");
        List<String> result2 = bridgeGameCase1.getRoundResult().get(1);

        //then
        assertThat(result1).isEqualTo(List.of("O", "O"));
        assertThat(result2).isEqualTo(List.of("O", "O", "X"));
    }

    @DisplayName("게임 오버 여부를 판단한다.")
    @Test
    void 플레이어가_움직인_후_게임오버_여부를_판단하는_기능_테스트() {
        //given
        BridgeGame bridgeGameCase1 = new BridgeGame(new TestNumberGenerator(newArrayList(0,1,1)),3);
        bridgeGameCase1.move("D");
        bridgeGameCase1.move("U");
        bridgeGameCase1.move("U");

        BridgeGame bridgeGameCase2 = new BridgeGame(new TestNumberGenerator(newArrayList(0,1,1)),3);
        bridgeGameCase2.move("D");
        bridgeGameCase2.move("D");

        //when
        boolean result1 = bridgeGameCase1.isGameOver();
        boolean result2 = bridgeGameCase2.isGameOver();

        //then
        assertThat(result1).isEqualTo(false);
        assertThat(result2).isEqualTo(true);
    }

    @DisplayName("게임 성공 여부를 판단한다.")
    @Test
    void 플레이어가_다리를_건너는_데_성공했는지_여부를_판단하는_기능_테스트() {
        //given
        BridgeGame bridgeGameCase1 = new BridgeGame(new TestNumberGenerator(newArrayList(0,1,1)),3);
        bridgeGameCase1.move("D");
        bridgeGameCase1.move("U");
        bridgeGameCase1.move("U");

        BridgeGame bridgeGameCase2 = new BridgeGame(new TestNumberGenerator(newArrayList(0,1,1)),3);
        bridgeGameCase2.move("D");
        bridgeGameCase2.move("D");

        //when
        boolean result1 = bridgeGameCase1.isGameCompleted();
        boolean result2 = bridgeGameCase2.isGameCompleted();

        //then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }

    @DisplayName("미리 설정된 다리를 유지하면서 게임을 재시작한다.")
    @Test
    void 미리_설정된_다리를_유지하며_게임을_재시작하는_기능_테스트() {
        //given
        BridgeGame bridgeGameCase1 = new BridgeGame(new TestNumberGenerator(newArrayList(0,1,1)),3);
        bridgeGameCase1.move("D");
        bridgeGameCase1.move("D");
        bridgeGameCase1.retry();
        bridgeGameCase1.move("D");
        bridgeGameCase1.move("U");
        bridgeGameCase1.move("U");

        //when
        List<List<String>> result1 = bridgeGameCase1.getRoundResult();

        //then
        assertThat(result1.get(0)).isEqualTo(List.of("D", "U", "U"));
        assertThat(result1.get(1)).isEqualTo(List.of("O", "O", "O"));
    }

    @DisplayName("총 시도한 횟수를 계산한다.")
    @Test
    void 총_시도한_횟수를_계산하는_기능_테스트() {
        //given
        BridgeGame bridgeGameCase1 = new BridgeGame(new TestNumberGenerator(newArrayList(0,1,1)),3);
        bridgeGameCase1.retry();
        bridgeGameCase1.retry();
        //when
        int result1 = bridgeGameCase1.getTotalAttempt();

        //then
        assertThat(result1).isEqualTo(3);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}