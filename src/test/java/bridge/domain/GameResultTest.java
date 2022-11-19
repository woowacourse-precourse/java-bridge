package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void recordResult() {
        GameResult gameResult = new GameResult(new ArrayList<>(),new ArrayList<>());
        gameResult.recordResult("O","U");
        assertThat(gameResult.getUpSpace()).isEqualTo(List.of("O"));
    }
}