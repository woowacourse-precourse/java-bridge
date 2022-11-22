package bridge.domain;

import bridge.domain.MoveResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class moveResultTest {
    @Test
    void getSquare() {
        String up = "U";
        boolean matchResult = false;
        MoveResult moveResult = new MoveResult(up, matchResult);

        assertFalse(moveResult.isMatchResult());
    }
}
