package controller.services;

import camp.nextstep.edu.missionutils.test.NsTest;
import model.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class PlayGameTest extends NsTest {


    private GamePlay gamePlay;
    private GameResult gameResult;

    @Test
    @DisplayName("게임 플레이를 성공했을 때")
    void passGame() {
        String[] userInputData = new String[]{"U", "D", "D"};

        assertSimpleTest(() -> {
            run(userInputData);
            assertThat(gameResult.getResultNumber()).isEqualTo(1);
            assertThat(gameResult.getCountOfAttempt()).isEqualTo(1);

        });

    }

    @Test
    @DisplayName("사용자가 게임 플레이를 끝냈을 때")
    void quitGame() {
        String[] userInputData = new String[]{"D", "R", "D", "Q"};

        assertSimpleTest(() -> {
            run(userInputData);
            assertThat(gameResult.getResultNumber()).isEqualTo(-1);
            assertThat(gameResult.getCountOfAttempt()).isEqualTo(2);

        });
    }

    @Test
    @DisplayName("게임 플레이 횟수가 최대 가능 횟수를 초과 했을 때")
    void endGame() {
        String[] userInputData = new String[200];

        for (int i = 0; i < 198; i += 2) {
            userInputData[i] = "D";
            userInputData[i + 1] = "R";
        }
        userInputData[199] = "D";

        assertSimpleTest(() -> {
            run(userInputData);
            assertThat(gameResult.getResultNumber()).isEqualTo(-2);
            assertThat(gameResult.getCountOfAttempt()).isEqualTo(99);

        });
    }

    @Override
    protected void runMain() {
        gamePlay = new GamePlay(List.of("U", "D", "D"));
        gameResult = gamePlay.playGame();
    }
}

//run을 실행 시킬 때 버퍼 데이터가 유지 된다.
//메소드가 사전순 이름에 따라 실행되는 듯 싶다.