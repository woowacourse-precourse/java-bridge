package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GameStatusTest {

    @Nested
    @DisplayName("getMatchStatus 메서드는 게임 성공&실패 여부를 입력받아")
    class describe_getMatchStatus {

        @Test
        @DisplayName("알맞은 GameStatus 객체를 반환한다.")
        void returnGameStatus(){
            assertThat(GameStatus.getMatchStatus(true,false)).isEqualTo(GameStatus.CLEARED);
            assertThat(GameStatus.getMatchStatus(false,true)).isEqualTo(GameStatus.OVER);
            assertThat(GameStatus.getMatchStatus(false,false)).isEqualTo(GameStatus.IN_PROCESS);
        }
    }
}
