package bridge.modelTest;

import bridge.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {

    BridgeGame bridgeGame;
    String[] cases = new String[]{"[ O ]\n[   ]", "[ X ]\n[   ]", "[   ]\n[ O ]", "[   ]\n[ X ]"};

    @BeforeEach
    void initializeClass(){
        bridgeGame = new BridgeGame(3);
    }

    @DisplayName("move를 하면 다리의 결과가 문자열로 반환된다. ")
    @Test
    void moveTest(){
        assertThat(cases)
                .contains(bridgeGame.move("U"));
    }

    @DisplayName("retry하면 TotalCount가 증가한다. ")
    @Test
    void retryTest(){
        bridgeGame.retry();
        assertThat(bridgeGame.getTotalTrialCount())
                .isEqualTo(2);
    }

    @DisplayName("isSuccess는 3번 성공하지 않으면 거짓을 반환한다")
    @Test
    void isSuccessTest(){
        assertThat(bridgeGame.isSuccess()).isFalse();
    }

    @DisplayName("isPaused는 플레이어가 다른 문자를 가지고 있지 않으면 거짓을 반환한다")
    @Test
    void isPausedTest(){
        assertThat(bridgeGame.isPaused()).isFalse();
    }
}
