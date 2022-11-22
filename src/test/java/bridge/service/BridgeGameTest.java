package bridge.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.User;
import bridge.service.constant.ChoiceResult;
import bridge.service.constant.GameStatus;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

public class BridgeGameTest {
    private static User user;
    private static BridgeGame game;
    private static MockedStatic<Randoms> mock;

    @BeforeEach
    void beforeEach() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 0, 1);
        game = new BridgeGame(3);
        user = new User();
    }

    @AfterEach
    void afterEach() {
        mock.close();
    }

    @DisplayName("마지막 칸이 아닌 칸을 맞추었을 때 유저의 게임 상태는 PLAYING 이다.")
    @Test
    void When_UserChoiceCorrectExceptLastPanel_Expect_StatusAsPlaying() {
        game.move(user,"U");
        assertThat(user.getStatus()).isEqualTo(GameStatus.PLAYING);
    }

    @DisplayName("칸에 대한 선택이 틀렸다면 게임 상태는 FAIL 이다.")
    @Test
    void When_UserChoiceWrong_Expect_StatusAsFail() {
        game.move(user,"D");
        assertThat(user.getStatus()).isEqualTo(GameStatus.FAIL);
    }

    @DisplayName("다리의 끝까지 모두 맞췄다면 게임 상태는 SUCCESS 이다.")
    @Test
    void When_UserChoiceOfLastPanelIsCorrect_Expect_StatusAsSuccess() {
        game.move(user,"U");
        game.move(user,"D");
        game.move(user,"U");
        assertThat(user.getStatus()).isEqualTo(GameStatus.SUCCESS);
    }

    @DisplayName("유저가 재시도를 할 경우 게임 상태는 PLAYING 이다.")
    @Test
    void When_UserRetry_Expect_StatusAsPlaying() {
        game.move(user, "D"); // status를 FAIL 상태로 변경
        game.retry(user);
        assertThat(user.getStatus()).isEqualTo(GameStatus.PLAYING);
    }

    @DisplayName("칸에 대한 선택을 할 때, 유저의 round가 1 증가한다.")
    @Test
    void When_UserChoice_PanelOrderIncreaseByOne() {
        int userRound = user.getRound();
        game.move(user, "U");
        assertThat(user.getRound())
                .isEqualTo(userRound + 1)
                .isEqualTo(1);
    }

    @DisplayName("재시도를 할 경우 유저의 시도 횟수가 1 증가한다.")
    @Test
    void When_UserRetry_Expect_AttemptCountIncreaseByOne() {
        int attemptCount = user.getAttemptCount();
        game.move(user, "U");
        game.move(user, "U");
        game.retry(user);
        assertThat(user.getAttemptCount())
                .isEqualTo(attemptCount + 1)
                .isEqualTo(2);
    }

    @DisplayName("재시도를 할 경우 시도하는 유저의 round가 1 감소한다.")
    @Test
    void When_UserRetry_PanelOrderDecreaseByOne() {
        game.move(user, "U");
        game.move(user, "U");

        int userRound = user.getRound();
        game.retry(user);
        assertThat(user.getRound())
                .isEqualTo(userRound - 1)
                .isEqualTo(1);
    }

    @DisplayName("obtainGameLog 는 다리의 각 칸 별 선택 결과를 라인 별로 리스트로 담아 이중 리스트로 반환한다.")
    @Test
    void When_ObtainGameLog_Expect_ShowChoiceResultsOfAllPanelsByLines() {
        game.move(user, "U");
        game.move(user, "D");
        game.move(user, "D");

        List<List<ChoiceResult>> gameLog = List.of(
                List.of(ChoiceResult.CORRECT, ChoiceResult.NOT_CHOSEN, ChoiceResult.NOT_CHOSEN),
                List.of(ChoiceResult.NOT_CHOSEN, ChoiceResult.CORRECT, ChoiceResult.WRONG)
        );

        assertThat(game.obtainGameLog(user)).isEqualTo(gameLog);
    }
}
