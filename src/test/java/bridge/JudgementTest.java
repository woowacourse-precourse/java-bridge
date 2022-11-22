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

public class JudgementTest {
    List<String> bridge;
    Record movingRecord;
    BridgeMaker bridgeMaker;
    Judgement judgement;
    @BeforeEach
    void beforeEach(){
        movingRecord = new Record();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        judgement = new Judgement();
    }


    @DisplayName("사용자 입력한 다리와 실제 다리길이가 같은지, 즉 도달했는지 판단할 수 있다")
    @Test
    void checkArrival(){
        bridge = bridgeMaker.makeBridge(3);
        movingRecord.addMoving("D");
        movingRecord.addMoving("D");
        assertThat(judgement.checkArrival(movingRecord,bridge)).isEqualTo(false);
    }

    @DisplayName("사용자가 마지막으로 입력한 다리와 실제 다리의 방향이 같은지 판단할 수 있다")
    @Test
    void checkSameDirection(){
        bridge = bridgeMaker.makeBridge(3);
        movingRecord.addMoving(bridge.get(0));
        assertThat(judgement.checkSameDirection(movingRecord,bridge.get(0),bridge)).isEqualTo(true);
    }

}
