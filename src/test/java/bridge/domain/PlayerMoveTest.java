package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("PlayerMove Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayerMoveTest {

    @Test
    void isNotSameDirection_메서드는_입력_방향과_사용자의_방향이_다른면_true를_반환한다() {
        PlayerMove playerMove = new PlayerMove(MoveResult.SUCCESS, Direction.UP);

        assertThat(playerMove.isNotSameDirection(Direction.UP)).isFalse();
    }

    @Test
    void isFail_메서드는_사용자의_이동이_실패했을_경우_true를_반환한다() {
        PlayerMove playerMove = new PlayerMove(MoveResult.FAIL, Direction.UP);

        assertThat(playerMove.isFail()).isTrue();
    }

    @Test
    void getMoveResult_메서드는_이동_성공_여부를_반환한다() {
        PlayerMove playerMove = new PlayerMove(MoveResult.FAIL, Direction.UP);

        assertThat(playerMove.getMoveResult()).isEqualTo(MoveResult.FAIL);
    }
}
