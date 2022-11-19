package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("입력 값과 다리 이동 정답이 일치하는지 여부를 판단한다")
    @Test
    void 정답_매치_테스트(){
        BridgeGame bridgeGame = new BridgeGame();
        assertTrue(bridgeGame.checkAnswer("U","U"));
        assertFalse(bridgeGame.checkAnswer("U","D"));
    }

    @DisplayName("사용자의 입력이 답과 같을 때, O 표시로 이동하는지를 확인한다.")
    @Test
    void 사용자_이동_성공_테스트(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U");

        assertThat(BridgeGame.getUpSideBridge().toString())
                .contains("O");
    }

    @DisplayName("사용자의 입력이 답과 다를 때, X로 실패하는지를 확인한다.")
    @Test
    void 사용자_이동_실패_테스트(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.moveFailed("U");

        assertThat(BridgeGame.getUpSideBridge().toString())
                .contains("X");
    }

    @DisplayName("재시작 여부를 입력 받을 때, Q 혹은 R가 아닌 다른 값이 들어오면 오류가 발생한다.")
    @Test
    void 재시작_입력_테스트(){
        assertThatThrownBy(()-> new InputView().validateRestartOrQuit("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
