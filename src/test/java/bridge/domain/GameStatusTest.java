package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameStatusTest {

    @Test
    void getResult() {
        GameStatus gameStatus = GameStatus.SUCCESS;
        String result = "게임 성공 여부: 성공";
        assertThat(gameStatus.getResult()).isEqualTo(result);
    }
}