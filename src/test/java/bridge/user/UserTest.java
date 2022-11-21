package bridge.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private static User player;
    private static final int INITIAL_NUMBER_OF_GAME_TRIALS = 2;

    @BeforeEach
    void makeBridge() throws IllegalArgumentException {
        player = new User(User.GameStatus.PLAYING.getStatusNumber(), INITIAL_NUMBER_OF_GAME_TRIALS);
    }

    /**
     * increaseNumberOfMoves - 이동 횟수 1회 증가
     */
    @DisplayName("이동 횟수 증가 테스트")
    @Test
    void increaseNumberOfMoves_테스트() {
        player.increaseNumberOfMoves();
        assertThat(1).isEqualTo(player.getNumberOfMoves());
    }

    /**
     * increaseNumberOfGameTrials - 게임 총 시도 횟수 1회 증가
     */
    @DisplayName("게임 총 시도 횟수 증가 테스트")
    @Test
    void increaseNumberOfGameTrials_테스트() {
        player.increaseNumberOfGameTrials();
        assertThat(INITIAL_NUMBER_OF_GAME_TRIALS + 1).isEqualTo(player.getNumberOfGameTrials());
    }

    /**
     * resetNumberOfMoves - 이동 횟수 초기화
     */
    @DisplayName("이동 횟수 초기화 테스트")
    @Test
    void resetNumberOfMoves_테스트() {
        player.resetNumberOfMoves();
        assertThat(0).isEqualTo(player.getNumberOfMoves());
    }

}
