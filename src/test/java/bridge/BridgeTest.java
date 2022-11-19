package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeTest {

    @DisplayName("다리 길이 입력이 3~20을 벗어나면 오류가 발생한다.")
    @Test
    void 다리_길이_사이즈_테스트(){
        assertThatThrownBy(()-> new InputView().validateOverSize(222))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력에 숫자가 아닌 입력이 들어오면 오류가 발생한다.")
    @Test
    void 다리_길이_숫자여부_테스트(){
        assertThatThrownBy(() -> new InputView().validateisDigit("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 칸이 U 혹은 D가 아닌 값이 들어오면 오류가 발생한다.")
    @ValueSource(strings = {"123123","Z"})
    @ParameterizedTest
    void 이동할_칸의_값_테스트(String moving){
        assertThatThrownBy(()-> new InputView().validateUpOrDown(moving))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값과 다리 이동 정답이 일치하는지 판단한다.")
    @Test
    void 정답_매치_테스트(){
        BridgeGame bridgeGame = new BridgeGame();
        assertTrue(bridgeGame.checkAnswer("U","U"));
        assertFalse(bridgeGame.checkAnswer("U","D"));
    }
}
