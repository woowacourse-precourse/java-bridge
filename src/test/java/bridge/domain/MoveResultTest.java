package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
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
        List<List<String>> map = moveResult.getMap();

        assertAll(
                () -> assertThat(map.get(0)).containsExactly(upperResult),
                () -> assertThat(map.get(1)).containsOnly(lowerResult)
        );
    }
}
