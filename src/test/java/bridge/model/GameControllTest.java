package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllTest {

    private GameControll gameControll = new GameControll();

    @Nested
    class IdxTest {

        @DisplayName("다리의 칸을 나타내는 idx값을 두번 더했을때")
        @Test
        void case1() {
            int answer = 2;
            gameControll.plusIdx();
            gameControll.plusIdx();
            assertEquals(answer, gameControll.getIdx());
        }
    }

    @Nested
    class CntTest {

        @DisplayName("게임을 몇번 시도 했는지 나타내는 cnt 값을 두번 더했을때")
        @Test
        void case1() {
            int answer = 2;
            gameControll.plusCnt();
            gameControll.plusCnt();
            assertEquals(answer, gameControll.getCnt());
        }
    }

    @Nested
    class GamePowerWheterTest {

        @DisplayName("게임의 전원 버튼 역할을 하는 gamePower를 전원을 껐을때")
        @Test
        void case1() {
            boolean answer = false;
            gameControll.turnoffGamePower();
            assertEquals(answer, gameControll.getGamePower());

        }
    }

    @Nested
    class GameSucessWheterTest {

        @DisplayName("게임에서 성공했을때")
        @Test
        void case1() {
            boolean answer = true;
            gameControll.sucessGame();
            assertEquals(answer, gameControll.getGameSucess());
        }
    }

    @Nested
    class InitializeTest {

        @DisplayName("idx와 gamePower를 초기화 시켜주는 메서드 테스트")
        @Test
        void case1() {
            gameControll.plusIdx();
            gameControll.turnoffGamePower();
            int answerIdx = 0;
            boolean answerGamePowerWheter = true;
            gameControll.initialize();

            assertEquals(answerIdx, gameControll.getIdx());
            assertEquals(answerGamePowerWheter, gameControll.getGamePower());
        }
    }
}