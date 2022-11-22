package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.service.constant.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    private static User user;

    @BeforeEach
    void beforeEach() {
        user = new User();
    }

    @DisplayName("다음 라운드를 진행하면 round가 1 증가한다.")
    @Test
    void When_playNextRound_Expect_RoundIncreaseByOne() {
        int round = user.getRound();
        user.playNextRound();
        assertThat(user.getRound()).isEqualTo(round + 1)
                .isEqualTo(1);
    }

    @DisplayName("다음 라운드를 진행하면 시도 횟수는 변하지 않는다.")
    @Test
    void When_playNextRound_Expect_AttemptCountSameAsBefore() {
        int attemptCount = user.getAttemptCount();
        user.playNextRound();
        assertThat(user.getAttemptCount()).isEqualTo(attemptCount)
                .isEqualTo(1);
    }

    @DisplayName("다음 라운드를 진행하면 게임 상태는 PLAYING 이다.")
    @Test
    void When_playNextRound_Expect_StatusAsPlaying() {
        user.playNextRound();
        assertThat(user.getStatus()).isEqualTo(GameStatus.PLAYING);
    }

    @DisplayName("같은 라운드를 다시 진행하면 round가 1 감소한다.")
    @Test
    void When_playSameRoundAgain_Expect_RoundDecreaseByOne() {
        user.playNextRound();
        int round = user.getRound();
        user.playSameRoundAgain();
        assertThat(user.getRound()).isEqualTo(round - 1)
                .isEqualTo(0);
    }

    @DisplayName("같은 라운드를 다시 진행하면 시도 횟수가 1 증가한다.")
    @Test
    void When_playSameRoundAgain_Expect_AttemptCountIncreaseByOne() {
        user.playNextRound();
        int attemptCount = user.getAttemptCount();
        user.playSameRoundAgain();
        assertThat(user.getAttemptCount()).isEqualTo(attemptCount + 1)
                .isEqualTo(2);
    }

    @DisplayName("같은 라운드를 다시 진행하면 게임 상태는 PLAYING 이다.")
    @Test
    void When_playSameRoundAgain_Expect_StatusAsPlaying() {
        user.playNextRound();
        user.playSameRoundAgain();
        assertThat(user.getStatus()).isEqualTo(GameStatus.PLAYING);
    }

    @DisplayName("라운드를 실패하면 게임 상태는 FAIL 이다.")
    @Test
    void When_failRound_Expect_StatusAsFail() {
        user.failRound();
        assertThat(user.getStatus()).isEqualTo(GameStatus.FAIL);
    }

    @DisplayName("라운드를 실패하면 게임 상태 이외의 필드 값은 변하지 않는다.")
    @Test
    void When_failRound_Expect_FieldsValueExceptStatusSameAsBefore() {
        int round = user.getRound();
        int attemptCount = user.getAttemptCount();
        user.failRound();
        assertThat(user.getRound()).isEqualTo(round);
        assertThat(user.getAttemptCount()).isEqualTo(attemptCount);
    }

    @DisplayName("게임을 클리어하면 게임 상태는 SUCCESS 이다.")
    @Test
    void When_clearGame_Expect_StatusAsSuccess() {
        user.clearGame();
        assertThat(user.getStatus()).isEqualTo(GameStatus.SUCCESS);
    }

    @DisplayName("게임을 클리어하면 게임 상태 이외의 필드 값은 변하지 않는다.")
    @Test
    void When_clearGame_Expect_FieldsValueExceptStatusSameAsBefore() {
        int round = user.getRound();
        int attemptCount = user.getAttemptCount();
        user.clearGame();
        assertThat(user.getRound()).isEqualTo(round);
        assertThat(user.getAttemptCount()).isEqualTo(attemptCount);
    }


}
