package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void findByString(String string) {
        // when
        GameCommand gameCommand = GameCommand.findByString(string);

        // then
        assertThat(gameCommand).isNotNull();
        assertThat(gameCommand).isNotSameAs(GameCommand.MISS);
        assertThat(gameCommand).isBetween(GameCommand.RESTART, GameCommand.QUIT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "", " ", "ar", "aq"})
    void findByStringThatReturnMISS(String string) {
        // when
        GameCommand gameCommand = GameCommand.findByString(string);

        // then
        assertThat(gameCommand).isNotNull();
        assertThat(gameCommand).isEqualTo(GameCommand.MISS);
    }
}