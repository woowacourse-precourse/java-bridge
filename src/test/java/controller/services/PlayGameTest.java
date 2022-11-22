package controller.services;

import camp.nextstep.edu.missionutils.test.NsTest;
import model.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 진행 여부를 결정. 1은 게임 성공후 종료, -1은 사용자에 의해 게임 종료, -2는 가능한 시도 횟수 초과로 게임 강제 종료.")
public class PlayGameTest extends NsTest {
    private GameResult gameResult;

    @Override
    protected void runMain() {
        gameResult = new GamePlay(List.of("U", "D", "D")).playGame();
    }

    @Test
    @DisplayName("게임 플레이를 성공한 경우.")
    void passGame() {
        assertSimpleTest(() -> {
            run("U", "D", "D");
            assertThat(gameResult.getResultNumber()).isEqualTo(1);
            assertThat(gameResult.getCountOfAttempt()).isEqualTo(1);
        });
    }

    @Test
    @DisplayName("게임 플레이를 끝낸 경우.")
    void quitGame() {
        assertSimpleTest(() -> {
            run("D", "R", "D", "Q");
            assertThat(gameResult.getResultNumber()).isEqualTo(-1);
            assertThat(gameResult.getCountOfAttempt()).isEqualTo(2);
        });
    }

    @Test
    @DisplayName("가능한 시도 횟수를 초과한 경우.")
    void endGame() {
        assertSimpleTest(() -> {
            run(createUserInputData());
            assertThat(gameResult.getResultNumber()).isEqualTo(-2);
            assertThat(gameResult.getCountOfAttempt()).isEqualTo(99);
        });
    }

    String[] createUserInputData() {
        String[] userInputData = new String[200];

        for (int i = 0; i < 198; i += 2) {
            userInputData[i] = "D";
            userInputData[i + 1] = "R";
        }
        userInputData[199] = "D";

        return userInputData;
    }
}