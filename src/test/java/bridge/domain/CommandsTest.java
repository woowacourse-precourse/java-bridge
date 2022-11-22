package bridge.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommandsTest {

    private Commands commands;

    @BeforeEach
    void setup() {
        commands = new Commands();
    }

    @Test
    void insertCommand() {
        commands.insertCommand("U");
        assertThat(commands.size()).isEqualTo(1);
    }

    @Test
    void lastIndex() {
        commands.insertCommand("U");
        assertThat(commands.lastIndex()).isEqualTo(0);
    }

    @Test
    void reset() {
        commands.insertCommand("U");
        commands.reset();
        assertThat(commands.size()).isEqualTo(0);
    }

    @Test
    void getRetryCount() {
        commands.retryCountPlus();
        assertThat(commands.getRetryCount()).isEqualTo(2);
    }

    @AfterEach
    void testReset() {
        commands.reset();
    }
}
