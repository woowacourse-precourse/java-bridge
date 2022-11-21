package bridge.domain;

import bridge.domain.MoveResult;
import bridge.domain.MoveResults;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MoveResultsTest {
    @Test
    void addResult() {
        MoveResults moveResults = new MoveResults();
        MoveResult success = new MoveResult("U", true);
        moveResults.addResult(success);

        assertAll(() -> assertThat(moveResults).isNotNull(),
                () -> assertThat(moveResults.getMoveResults()).hasSize(1),
                ()  -> assertThat(moveResults.getMoveResults()).contains(success));
    }

    @Test
    void removeFailure() {
        MoveResults moveResults = new MoveResults();
        MoveResult success = new MoveResult("U", true);
        MoveResult failure = new MoveResult("U", false);

        moveResults.addResult(success);
        moveResults.addResult(failure);
        moveResults.removeFailure();

        assertAll(() -> assertThat(moveResults).isNotNull(),
                () -> assertThat(moveResults.getMoveResults()).hasSize(1),
                ()  -> assertThat(moveResults.getMoveResults()).containsOnly(success));
    }
}
