package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class GameCommandTest {

    @Test
    void enum_값의_상수를_비교해서_값이_존재하면_그에_맞는_enum_객체_생성() {
        //when
        GameCommand restart = GameCommand.getGameCommand("R");
        GameCommand quit = GameCommand.getGameCommand("Q");

        //then
        assertAll(
                () -> Assertions.assertThat(restart).isEqualTo(GameCommand.RESTART),
                () -> Assertions.assertThat(quit).isEqualTo(GameCommand.QUIT)
        );
    }

    @Test
    void enum_값의_상수를_비교해서_값이_존재하지_않으면_IllegalArgumentException_발생() {
        //then
        Assertions.assertThatThrownBy(() -> {
            GameCommand.getGameCommand("U");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
