package bridge.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.BridgeLength;
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
    private static BridgeGame game;
    private static MockedStatic<Randoms> mock;

    @BeforeEach
    void beforeEach() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 0, 1);
        game = new BridgeGame(3);
    }

    @AfterEach
    void afterEach() {
        mock.close();
    }

    @DisplayName("첫번째 칸을 맞췄을 때 move 메서드는 true를 반환한다.")
    @Test
    void moveOnce() {
        assertThat(game.move("U")).isTrue();
    }

    @DisplayName("한 칸 이상 움직인 이후 틀린 칸을 고를 때 move 메서드는 false를 반환한다.")
    @Test
    void moveContinuously() {
        game.move("U");
        assertThat(game.move("U")).isFalse();
    }

    @DisplayName("마지막 칸이 아닌 칸을 맞추었을 때 게임 상태는 PLAYING 이다.")
    @Test
    void When_UserChoiceCorrectExceptLastPanel_Expect_StatusAsPlaying() {
        game.move("U");
        assertThat(game.getStatus()).isEqualTo(GameStatus.PLAYING);
    }

    @DisplayName("칸에 대한 선택이 틀렸다면 게임 상태는 FAIL 이다.")
    @Test
    void When_UserChoiceWrong_Expect_StatusAsFail() {
        game.move("D");
        assertThat(game.getStatus()).isEqualTo(GameStatus.FAIL);
    }

    @DisplayName("다리의 끝까지 모두 맞췄다면 게임 상태는 SUCCESS 이다.")
    @Test
    void When_UserChoiceOfLastPanelIsCorrect_Expect_StatusAsSuccess() {
        game.move("U");
        game.move("D");
        game.move("U");
        assertThat(game.getStatus()).isEqualTo(GameStatus.SUCCESS);
    }

    @DisplayName("유저가 재시도를 할 경우 게임 상태는 PLAYING 이다.")
    @Test
    void When_UserRetry_Expect_StatusAsPlaying() {
        game.move("D"); // status를 FAIL 상태로 변경
        game.retry();
        assertThat(game.getStatus()).isEqualTo(GameStatus.PLAYING);
    }

    @DisplayName("칸에 대한 선택을 할 때, 시도하는 칸의 순서가 1 증가한다.")
    @Test
    void When_UserChoice_PanelOrderIncreaseByOne() {
        int panelOrder = game.getPanelOrder();
        game.move("U");
        assertThat(game.getPanelOrder())
                .isEqualTo(panelOrder + 1)
                .isEqualTo(1);
    }

    @DisplayName("재시도를 할 경우 시도 횟수가 1 증가한다.")
    @Test
    void When_UserRetry_Expect_AttemptCountIncreaseByOne() {
        int attemptCount = game.getAttemptCount();
        game.move("U");
        game.move("U");
        game.retry();
        assertThat(game.getAttemptCount())
                .isEqualTo(attemptCount + 1)
                .isEqualTo(2);
    }

    @DisplayName("재시도를 할 경우 시도하는 칸의 순서가 1 감소한다.")
    @Test
    void When_UserRetry_PanelOrderDecreaseByOne() {
        game.move("U");
        game.move("U");

        int panelOrder = game.getPanelOrder();
        game.retry();
        assertThat(game.getPanelOrder())
                .isEqualTo(panelOrder - 1)
                .isEqualTo(1);
    }

    @DisplayName("obtainGameLog 는 다리의 각 칸 별 선택 결과를 라인 별로 리스트로 담아 이중 리스트로 반환한다.")
    @Test
    void When_ObtainGameLog_Expect_ShowChoiceResultsOfAllPanelsByLines() {
        game.move("U");
        game.move("D");
        game.move("D");

        List<List<ChoiceResult>> gameLog = List.of(
                List.of(ChoiceResult.CORRECT, ChoiceResult.NOT_CHOSEN, ChoiceResult.NOT_CHOSEN),
                List.of(ChoiceResult.NOT_CHOSEN, ChoiceResult.CORRECT, ChoiceResult.WRONG)
        );

        assertThat(game.obtainGameLog()).isEqualTo(gameLog);
    }
}
