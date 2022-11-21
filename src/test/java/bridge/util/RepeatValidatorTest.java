package bridge.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class RepeatValidatorTest {

    private static int functionRunCount;

    @BeforeEach
    private void setUp() {
        functionRunCount = 0;
    }

    @DisplayName(value = "2회 예외발생 후 3회째 1 반환 테스트")
    @Test
    void readUntilValidateTest() {
        int actualValue = RepeatValidator.readUntilValidate(() ->
                returnValueAfter(1, 3));

        assertSoftly(softly -> {
           softly.assertThat(actualValue).isEqualTo(1);
           softly.assertThat(functionRunCount).isEqualTo(3);
        });
    }

    private int returnValueAfter(int value, int tryNumber) {
        functionRunCount++;
        if(functionRunCount < tryNumber){
            throw new IllegalArgumentException("[ERROR]");
        }
        return value;
    }

}