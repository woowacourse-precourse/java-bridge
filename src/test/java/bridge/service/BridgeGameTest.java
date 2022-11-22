package bridge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame game;

    @BeforeEach
    void setUp() {
        game = new BridgeGame(List.of("U", "D", "U"));
    }

    @ParameterizedTest
    @CsvSource(value = {"U,true", "D,false"})
    void move(String movement, boolean expected) {
        assertThat(game.move(movement)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"U:U,false", "U:D,false", "U:D:D,false", "U:D:U,true"})
    void isComplete(String movements, boolean expected) {
        for(String movement : movements.split(":")) {
            game.move(movement);
        }
        assertThat(game.isComplete()).isEqualTo(expected);
    }

}