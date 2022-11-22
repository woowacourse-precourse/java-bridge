package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {
    @Test
    @DisplayName("update resultMap")
    void updateMapTest(){
        GameResult result=new GameResult();
        result.updateResultMap("U","O");
        assertThat(result.upBridgeToString()).contains("[ O ]");
        assertThat(result.downBridgeToString()).contains("[   ]");

    }

    @Test
    @DisplayName("맵을 초기화 하고 attempts를 1 증가시킨다.")
    void updateResultTest(){
        GameResult result=new GameResult();
        result.updateResultMap("U","O");
        result.updateGameResult();
        assertThat(result.upBridgeToString()).contains("[  ]");
        assertThat(result.downBridgeToString()).contains("[  ]");
        assertThat(result.getAttempts()).isEqualTo(2);
    }

}
