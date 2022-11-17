package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class StatusTest {
    private final static Status status = new Status();

    @ParameterizedTest
    @DisplayName("Status Class 테스트")
    @CsvSource(
            value = {
                    "U:U:[ O ],[   ]",
                    "D:D:[ O |   ],[   | O ]",
                    "U:D:[ O |   |   ],[   | O | X ]",
                    "D:U:[ O |   |   | X ],[   | O | X |   ]"},
            delimiter = ':')
    public void test(
            String answer,
            String userAnswer,
            String output) {
        status.updateStatus(answer, userAnswer);
        status.createMessage();
        String[] tmp = output.split(",");
        assertAll(
                () -> assertTrue(status.getMessage().contains(tmp[0])),
                () -> assertTrue(status.getMessage().contains(tmp[1]))
        );
    }
}