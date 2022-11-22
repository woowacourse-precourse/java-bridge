package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MovingMapTest {

    MovingMap movingMap = new MovingMap();

    @ParameterizedTest
    @CsvSource({"U,true,' O '", "U,false,' X '","D,true,'   '","D,false,'   '"})
    @DisplayName("입력에 대한 판정에 따라 상태(O,X,공백)를 판단할 수 있다.")
    void tryJudgeState(String moving, boolean moveStatus, String result) {
        String judgeStatus = movingMap.judgeStatus("U", moving, moveStatus);
        assertThat(judgeStatus).isEqualTo(result);
    }
}