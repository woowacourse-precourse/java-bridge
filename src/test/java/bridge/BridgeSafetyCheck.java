package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static bridge.GameResultCondition.UPPERPASS;
import static bridge.GameResultCondition.LOWERPASS;
import static bridge.GameResultCondition.FAIL;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

 class BridgeSafetyCheckTest {

    @DisplayName("다리 건너기 결과를 반환한다")
    @ParameterizedTest
    @CsvSource({"O, U, U, UPPERPASS", "O, D, D, LOWERPASS", "X, U, D, FAIL"})
    void of(final String result, final String inputMoving, final String bridge,final GameResultCondition expected){
        //when
        final GameResultCondition actual = GameResultCondition.of(inputMoving, bridge);
        //then
        assertThat(actual).isEqualTo(expected);
    }
}