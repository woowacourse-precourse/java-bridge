package bridge.domain.history;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StagedHistoryTest {
    @Test
    void 윗_다리에서_생존상태를_출력할_수_있습니다() {
        var stageHistory = new StagedHistory(SurviveStatus.SURVIVE, BridgePosition.UP);
        var actualList = resultHistoryByPosition(stageHistory);

        assertThat(actualList.get(0)).isEqualTo(" O ");
        assertThat(actualList.get(1)).isEqualTo("   ");
    }

    @Test
    void 윗_다리에서_생존실패_상태를_출력할_수_있습니다() {
        var stageHistory = new StagedHistory(SurviveStatus.DIE, BridgePosition.UP);
        var actualList = resultHistoryByPosition(stageHistory);

        assertThat(actualList.get(0)).isEqualTo(" X ");
        assertThat(actualList.get(1)).isEqualTo("   ");
    }

    @Test
    void 아랫_다리에서_생존상태를_출력할_수_있습니다() {
        var stageHistory = new StagedHistory(SurviveStatus.SURVIVE, BridgePosition.DOWN);
        var actualList = resultHistoryByPosition(stageHistory);

        assertThat(actualList.get(0)).isEqualTo("   ");
        assertThat(actualList.get(1)).isEqualTo(" O ");
    }

    @Test
    void 아랫_다리에서_생존실패_상태를_출력할_수_있습니다() {
        var stageHistory = new StagedHistory(SurviveStatus.DIE, BridgePosition.DOWN);
        var actualList = resultHistoryByPosition(stageHistory);

        assertThat(actualList.get(0)).isEqualTo("   ");
        assertThat(actualList.get(1)).isEqualTo(" X ");
    }

    private List<String> resultHistoryByPosition(StagedHistory stagedHistory) {
        return List.of(
                stagedHistory.resultSurviveStatusByBridgePosition(BridgePosition.UP),
                stagedHistory.resultSurviveStatusByBridgePosition(BridgePosition.DOWN)
        );

    }

}