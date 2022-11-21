package bridge.domain.history;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HistoryTest {


    @Test
    void 기록을_저장하고_순차적으로_위치별로_결과를_출력할_수_있습니다() {
        var history = new History();

        history.record(SurviveStatus.SURVIVE, BridgePosition.DOWN);
        history.record(SurviveStatus.SURVIVE, BridgePosition.DOWN);
        history.record(SurviveStatus.SURVIVE, BridgePosition.DOWN);
        history.record(SurviveStatus.SURVIVE, BridgePosition.DOWN);

        var result = history.resultByPositions().split("\n");

        assertThat(result[0]).isEqualTo("[   |   |   |   ]");
        assertThat(result[1]).isEqualTo("[ O | O | O | O ]");
    }

    @Test
    void 기록을_저장하고_순차적으로_위치별로_결과를_출력할_수_있습니다_아래가_모두_죽은경우() {
        var history = new History();

        history.record(SurviveStatus.DIE, BridgePosition.DOWN);
        history.record(SurviveStatus.DIE, BridgePosition.DOWN);
        history.record(SurviveStatus.DIE, BridgePosition.DOWN);
        history.record(SurviveStatus.DIE, BridgePosition.DOWN);

        var result = history.resultByPositions().split("\n");

        assertThat(result[0]).isEqualTo("[   |   |   |   ]");
        assertThat(result[1]).isEqualTo("[ X | X | X | X ]");
    }

    @Test
    void 지그재그로_교차하는_기록을_출력() {
        var history = new History();

        history.record(SurviveStatus.DIE, BridgePosition.DOWN);
        history.record(SurviveStatus.SURVIVE, BridgePosition.UP);
        history.record(SurviveStatus.DIE, BridgePosition.DOWN);
        history.record(SurviveStatus.SURVIVE, BridgePosition.UP);

        var result = history.resultByPositions().split("\n");

        assertThat(result[0]).isEqualTo("[   | O |   | O ]");
        assertThat(result[1]).isEqualTo("[ X |   | X |   ]");
    }
}