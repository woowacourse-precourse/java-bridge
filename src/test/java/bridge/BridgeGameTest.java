package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("사용자가 칸을 이동할 때 정상적으로 작동하는지 체크")
    @Test
    void 사용자가_칸을_이동할_때_정상적으로_작동하는지_체크(){
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        Application.bridge = bridge;

        assertThat(bridgeGame.move("U")).isEqualTo(true);
        assertThat(bridgeGame.move("D")).isEqualTo(true);
        assertThat(bridgeGame.move("U")).isEqualTo(false);
    }



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