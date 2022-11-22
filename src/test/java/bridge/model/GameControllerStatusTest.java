package bridge.model;

import bridge.domain.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerStatusTest {

    private GameStatus gameStatus = new GameStatus();

    @Nested
    class IdxTest {

        @DisplayName("다리의 칸을 나타내는 idx값을 두번 더했을때")
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
    class GameControllerPowerWheterTest {

        @DisplayName("게임의 전원 버튼 역할을 하는 gamePower를 전원을 껐을때")
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
            gameStatus.sucessGame();
            assertEquals(answer, gameStatus.getGameSucess());
        }
    }

    @Nested
    class InitializeTest {

        @DisplayName("idx와 gamePower를 초기화 시켜주는 메서드 테스트")
        @Test
        void case1() {
            gameStatus.plusIdx();
            gameStatus.turnoffGamePower();
            int answerIdx = 0;
            boolean answerGamePowerWheter = true;
            gameStatus.initialize();

            assertEquals(answerIdx, gameStatus.getIdx());
            assertEquals(answerGamePowerWheter, gameStatus.getGamePower());
        }
    }
}