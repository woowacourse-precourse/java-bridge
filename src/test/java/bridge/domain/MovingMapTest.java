package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

class MovingMapTest {

    MovingMap movingMap = new MovingMap();

    @BeforeEach
    void setUp() {
        movingMap.init();
    }

    @ParameterizedTest
    @CsvSource({"U,true,' O '", "U,false,' X '", "D,true,'   '", "D,false,'   '"})
    @DisplayName("입력에 대한 판정에 따라 상태(O,X,공백)를 판단할 수 있다.")
    void tryJudgeState(String moving, boolean moveStatus, String result) {
        String judgeStatus = movingMap.judgeStatus("U", moving, moveStatus);
        assertThat(judgeStatus).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"U,true,' O ','   '", "U,false,' X ','   '", "D,true,'   ',' O '", "D,false,'   ',' X '"})
    @DisplayName("입력에 대한 판정과, 입력이 주어지면 그에 대한 알맞은 상태를 결과값에 넣을 수 있다.")
    void tryPutStatus(String moving, boolean moveStatus, String resultOfU, String resultOfD) {
        movingMap.putStatus(moving, moveStatus);

        Map<String, List<String>> resultMap = movingMap.getMovingMap();
        String uStatus = resultMap.get("U").get(0);
        String dStatus = resultMap.get("D").get(0);

        assertThat(uStatus).isEqualTo(resultOfU);
        assertThat(dStatus).isEqualTo(resultOfD);
    }
}