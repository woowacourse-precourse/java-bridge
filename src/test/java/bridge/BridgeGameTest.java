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