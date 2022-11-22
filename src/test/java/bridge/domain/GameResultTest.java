package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    GameResult gameResult = new GameResult(true, 1);

    @DisplayName("게임 성공여부 확인")
    @Test
    void checkSuccess() {
        assertThat(gameResult.getSuccess()).isEqualTo(true);
        gameResult.setSuccess(false);
        assertThat(gameResult.getSuccess()).isEqualTo(false);
    }

    @DisplayName("게임 시도횟수 확인")
    @Test
    void getTryCount() {
        assertThat(gameResult.getTryCount()).isEqualTo(1);
    }

    @DisplayName("게임 시도횟수 증가 확인")
    @Test
    void plusTryCount() {
        int count = 0;
        while(count!=2){
            gameResult.plusTryCount();
            count++;
        }
        assertThat(gameResult.getTryCount()).isEqualTo(3);
    }

}