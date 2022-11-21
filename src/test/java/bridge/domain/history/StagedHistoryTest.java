package bridge.domain.history;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StagedHistoryTest {
    @Test
    void 윗_다리에서_생존상태를_출력할_수_있습니다() {
        var stageHistory = new StagedHistory(SurviveStatus.SURVIVE, BridgePosition.UP);

        var upResult = stageHistory.resultSurviveStatusByBridgePosition(BridgePosition.UP);
        var downResult = stageHistory.resultSurviveStatusByBridgePosition(BridgePosition.DOWN);

        assertThat(upResult).isEqualTo(" O ");
        assertThat(downResult).isEqualTo("   ");
    }

    @Test
    void 윗_다리에서_생존실패_상태를_출력할_수_있습니다() {
        var stageHistory = new StagedHistory(SurviveStatus.DIE, BridgePosition.UP);

        var upResult = stageHistory.resultSurviveStatusByBridgePosition(BridgePosition.UP);
        var downResult = stageHistory.resultSurviveStatusByBridgePosition(BridgePosition.DOWN);

        assertThat(upResult).isEqualTo(" X ");
        assertThat(downResult).isEqualTo("   ");
    }

    @Test
    void 아랫_다리에서_생존상태를_출력할_수_있습니다() {
        var stageHistory = new StagedHistory(SurviveStatus.SURVIVE, BridgePosition.DOWN);

        var upResult = stageHistory.resultSurviveStatusByBridgePosition(BridgePosition.UP);
        var downResult = stageHistory.resultSurviveStatusByBridgePosition(BridgePosition.DOWN);

        assertThat(upResult).isEqualTo("   ");
        assertThat(downResult).isEqualTo(" O ");
    }

    @Test
    void 아랫_다리에서_생존실패_상태를_출력할_수_있습니다() {
        var stageHistory = new StagedHistory(SurviveStatus.DIE, BridgePosition.DOWN);

        var upResult = stageHistory.resultSurviveStatusByBridgePosition(BridgePosition.UP);
        var downResult = stageHistory.resultSurviveStatusByBridgePosition(BridgePosition.DOWN);

        assertThat(upResult).isEqualTo("   ");
        assertThat(downResult).isEqualTo(" X ");
    }

}