package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    User user;
    private List<Integer> testNumbers;

    @BeforeEach
    void init() {
        systemInput("3");
        testNumbers = new ArrayList<>(Arrays.asList(0,1,0));
        user = new User(new BridgeTestNumberGenerator(testNumbers));
    }

    @Test
    void crossBridgeByAllPass() {
        systemInput("D");
        user.move();
        systemInput("U");
        user.move();
        systemInput("D");
        user.move();

        assertThat(user.isEnd()).isEqualTo(true);
    }

    @Test
    void crossBridgeByFailedRetry() {
        systemInput("U");
        user.move();
        systemInput("R");
        user.retry();

        assertThat(user.isEnd()).isEqualTo(false);
    }

    @Test
    void crossBridgeByFailedQuit() {
        systemInput("U");
        user.move();
        systemInput("Q");
        user.retry();

        assertThat(user.isEnd()).isEqualTo(true);
    }

    void systemInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
