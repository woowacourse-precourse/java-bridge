package bridge;

import bridge.model.PlayerMap;
import bridge.model.TotalResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalResultTest {
    private static final PlayerMap playerMap = new PlayerMap(
            List.of("O", " "),
            List.of(" ", "X")
    );
    private static final TotalResult result = new TotalResult(playerMap, 1);

    @DisplayName("다리 건너기를 실패하면 false를 반환한다")
    @Test
    void loseTest() {
        assertThat(result.win()).isFalse();
    }
}
