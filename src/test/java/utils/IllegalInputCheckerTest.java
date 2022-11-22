package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IllegalInputCheckerTest {


    @Test
    void checkMoveInputTest() {
        IllegalInputChecker illegalInputChecker = new IllegalInputChecker();
        String moveInput = "U";

        String actual = illegalInputChecker.checkMoveInput(moveInput);
        String expect = "U";

        assertThat(actual).isEqualTo(expect);
    }
}
