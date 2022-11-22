package bridge.domain;

import bridge.domain.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerStatusTest {

    private final GameStatus gameStatus = new GameStatus();

    @Nested
    class IdxTest {

        @DisplayName("다리의 칸을 나타내는 idx 값을 두번 더했을때")
        @Test
        void case1() {
            int answer = 2;
            gameStatus.plusIdx();
            gameStatus.plusIdx();
            assertEquals(answer, gameStatus.getIdx());
        }
    }

    @Nested
    class CntTest {

        @DisplayName("게임을 몇번 시도 했는지 나타내는 cnt 값을 두번 더했을때")
        @Test
        void case1() {
            int answer = 2;
            gameStatus.plusCnt();
            gameStatus.plusCnt();
            assertEquals(answer, gameStatus.getCnt());
        }
    }

    @Nested
    class GameControllerPowerWhetherTest {

        @DisplayName("게임의 전원 버튼 역할을 하는 gamePower 를 전원을 껐을때")
        @Test
        void case1() {
            boolean answer = false;
            gameStatus.turnoffGamePower();
            assertEquals(answer, gameStatus.getGamePower());

        }
    }

    @Nested
    class GameControllerSucessWheterTest {

        @DisplayName("게임에서 성공했을때")
        @Test
        void case1() {
            boolean answer = true;
            gameStatus.successGame();
            assertEquals(answer, gameStatus.getGameSuccess());
        }
    }

    @Nested
    class InitializeTest {

        @DisplayName("idx 와 gamePower 를 초기화 시켜주는 메서드 테스트")
        @Test
        void case1() {
            gameStatus.plusIdx();
            gameStatus.turnoffGamePower();
            int answerIdx = 0;
            boolean answerGamePowerWhether = true;
            gameStatus.initialize();

            assertEquals(answerIdx, gameStatus.getIdx());
            assertEquals(answerGamePowerWhether, gameStatus.getGamePower());
        }
    }
}