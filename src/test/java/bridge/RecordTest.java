package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.Domain.Judgement;
import bridge.Domain.Record;
import bridge.Utils.BridgeMaker;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecordTest {

    List<String> bridge;
    Record movingRecord;
    BridgeMaker bridgeMaker;
    Judgement judgement;
    @BeforeEach
    void beforeEach(){
        movingRecord = new Record();
    }

    @DisplayName("Retry Count 1씩 증가하여야 한다")
    @Test
    void addRetryCount() {
        int currentNum = movingRecord.getRetryCount();
        movingRecord.addRetryCount();
        assertThat(movingRecord.getRetryCount()).isEqualTo(currentNum+1);
    }

    @DisplayName("moving 이 add 함수를 호출시 하나 씩 추가 되어야 한다.")
    @Test
    void addMoving() {
        int size = movingRecord.getRecordLength();
        movingRecord.addMoving("U");
        assertThat(movingRecord.getRecordLength()).isEqualTo(size+1);
    }

}

