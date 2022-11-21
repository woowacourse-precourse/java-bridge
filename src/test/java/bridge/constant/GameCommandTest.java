package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @ParameterizedTest
    @ValueSource(strings = {"R"})
    void equalFirstLetterWithStringByR(String string) {
        // given
        GameCommand gameCommand = GameCommand.RESTART;

        // when
        boolean result = gameCommand.equalFirstLetterWithString(string);

        // then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Q"})
    void equalFirstLetterWithStringByQ(String string) {
        // given
        GameCommand gameCommand = GameCommand.QUIT;

        // when
        boolean result = gameCommand.equalFirstLetterWithString(string);

        // then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "", " ", "ar", "aq"})
    void equalFirstLetterWithStringByFail(String string) {
        // given
        GameCommand gameCommand = GameCommand.QUIT;

        // when
        boolean result = gameCommand.equalFirstLetterWithString(string);

        // then
        assertFalse(result);
    }

    @Test
    void isMiss() {
        // given
        GameCommand gameCommand = GameCommand.MISS;

        // when
        boolean result = gameCommand.isMiss();

        // then
        assertTrue(result);
    }

    @Test
    void isMissByNotMiss() {
        // given
        GameCommand gameCommand = GameCommand.RESTART;

        // when
        boolean result = gameCommand.isMiss();

        // then
        assertFalse(result);
    }
}