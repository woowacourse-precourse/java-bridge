package bridge.model;

import bridge.constant.Score;
import bridge.model.GameResult.Record;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecordTest {

    Record record;

    @BeforeEach
    void setUp() {
        record = new Record();
        record.updateBridgeRecord(Score.PASS, "U");
        record.updateBridgeRecord(Score.PASS, "U");
        record.updateBridgeRecord(Score.FAIL, "D");
    }

    @AfterEach
    void afterEach() {
        record = null;
    }

    @DisplayName("이동 결과가 정상적으로 기록되었는 지 확인한다.")
    @Test
    void updateBridgeRecordTest() {
        List<List<String>> bridgeRecord = record.getBridgeRecord();
        List<String> upBridgeRecord = bridgeRecord.get(0);
        List<String> downBridgeRecord = bridgeRecord.get(1);

        assertThat(upBridgeRecord)
                .containsExactly("O", "O", " ");
        assertThat(downBridgeRecord)
                .containsExactly(" ", " ", "X");
    }
}