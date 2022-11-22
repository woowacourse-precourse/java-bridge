package bridge.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class RepeatValidatorTest {

    private static int functionRunCount;

    private static final String ERROR_MESSAGE = "[ERROR]";

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    private void setUp() {
        functionRunCount = 0;
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    private void restoreInitialStream() {
        System.setOut(originalOut);
    }

    @DisplayName(value = "2회 예외발생 후 3회째 1 반환 테스트")
    @Test
    void readUntilValidateTest() {
        int tryNumber = 3;
        int actualValue = RepeatValidator.readUntilValidate(() -> returnValueAfter(1, tryNumber));
        String expectedOutput = new String(ERROR_MESSAGE + "\n").repeat(tryNumber-1);

        assertSoftly(softly -> {
            softly.assertThat(actualValue).isEqualTo(1);
            softly.assertThat(out.toString()).isEqualTo(expectedOutput);
        });
    }

    private int returnValueAfter(int value, int tryNumber) {
        functionRunCount++;
        if (functionRunCount < tryNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return value;
    }

}