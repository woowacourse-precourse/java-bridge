package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.domain.Validation.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidationTest {
    @DisplayName("범위를 벗어난 경우")
    @ParameterizedTest
    @ValueSource(ints = {1,2,25,30})
    void overOrUnderRange(int number){
        assertThatThrownBy(() -> validateRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U, D이외의 값을 넣은 경우")
    @ParameterizedTest
    @CsvSource({"sdfda", "dddd", "UUU","DDDD","Dkjs","UD"})
    void noValidBlankToMove(String str){
        assertThatThrownBy(() -> isValidBlankToMove(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R, Q이외의 값을 넣은 경우")
    @ParameterizedTest
    @CsvSource({"sdfda", "rq", "RRR","QQQ","RsdfQ","RQ"})
    void noValidRetryOrEnd(String str){
        assertThatThrownBy(() -> isValidRetryOrEnd(str))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
