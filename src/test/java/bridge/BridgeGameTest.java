package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import bridge.service.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}