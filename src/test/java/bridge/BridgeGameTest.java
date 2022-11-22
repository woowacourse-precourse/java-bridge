package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @DisplayName("사용자의 움직임이 정답일 때")
    @Test
    void User_Move() {
        BridgeGame bg = new BridgeGame();
        assertThat(bg.move("U", "U")).isFalse();
    }

    @DisplayName("사용자의 움직임이 틀렸을 때")
    @Test
    void User_Move2() {
        BridgeGame bg = new BridgeGame();
        assertThat(bg.move("U", "D")).isTrue();
    }

    @DisplayName("게임 종료를 입력")
    @Test
    void User_Over() {
        BridgeGame bg = new BridgeGame();
        assertThat(bg.retry("Q")).isFalse();
    }

    @DisplayName("게임 재시작을 입력")
    @Test
    void User_Retry() {
        BridgeGame bg = new BridgeGame();
        assertThat(bg.retry("R")).isTrue();
    }

    @DisplayName("사용자 움직임 복합테스트")
    @ParameterizedTest
    @CsvSource(value = {"U:U:false","U:D:true","D:U:true","D:D:false"},delimiter = ':')
    void move_Test(String compared, String input, boolean result){
        BridgeGame bg = new BridgeGame();
        assertThat(bg.move(compared,input)).isEqualTo(result);
    }

}