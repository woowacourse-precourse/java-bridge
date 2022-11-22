package bridge.domain.bridge_game;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.constants.MoveCommands;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    private static final int INIT_VALUE_OF_POSITION = 0;
    private static final int INIT_VALUE_OF_CHALLENGES = 1;

    private Bridge bridge;
    private Player player;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U"));
        player = new Player(
                Position.of(INIT_VALUE_OF_POSITION),
                new NumberOfChallenges(INIT_VALUE_OF_CHALLENGES));
    }

    @DisplayName("player가 입력한 값과 현재 포지션이 Bridge와 일치하면 true를 반환한다.")
    @Test
    void isMatchedTrue() {
        boolean actual = bridge.isMatched(player, MoveCommands.MOVE_UP_COMMAND);
        assertThat(actual).isTrue();
    }

    @DisplayName("player가 입력한 값과 현재 포지션이 Bridge와 일치하지 않으면 false를 반환한다.")
    @Test
    void isMatchedFalse() {
        boolean actual = bridge.isMatched(player, MoveCommands.MOVE_DOWN_COMMAND);
        assertThat(actual).isFalse();
    }

    @DisplayName("player의 현재 포지션이 Bridge의 index를 넘기지 않으면 true를 반환한다.")
    @Test
    void isLongerThanTrue() {
        boolean actual = bridge.isLongerThan(Position.of(0));
        assertThat(actual).isTrue();
    }

    @DisplayName("player의 현재 포지션이 Bridge의 index를 넘긴 경우 false를 반환한다.")
    @Test
    void isLongerThanFalse() {
        boolean actual = bridge.isLongerThan(Position.of(3));
        assertThat(actual).isFalse();
    }
}