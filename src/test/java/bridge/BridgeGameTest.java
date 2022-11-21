package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("사용자가 게임 재시작을 선택하는 경우")
    @Test
    void 사용자가_게임_재시작을_선택하는_경우(){
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }

    @DisplayName("사용자가 게임 종료를 선택하는 경우")
    @Test
    void 사용자가_게임_종료를_선택하는_경우(){
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }
}