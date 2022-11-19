package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoveResultTest {
    private MoveResult moveResult;

    @BeforeEach
    void setUp() {
        moveResult = new MoveResult();
    }

    @ParameterizedTest
    @CsvSource(value = {"true:U:O: ", "false:U:X: ", "true:D: :O", "false:D: :X"}, delimiter = ':', ignoreLeadingAndTrailingWhitespace = false)
    void updateMoveResult(boolean isSuccess, String position, String upperResult, String lowerResult) {
        moveResult.updateMoveResult(isSuccess, position);
        String upper = "U";
        String lower = "D";

        assertAll(
                () -> assertThat(moveResult.getCrossedStatus(upper)).containsExactly(upperResult),
                () -> assertThat(moveResult.getCrossedStatus(lower)).containsOnly(lowerResult)
        );
    }
}
