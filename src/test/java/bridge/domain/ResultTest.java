package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    @DisplayName("성공/계속/실패 값이 제대로 나오는지 확인한다.")
    @CsvSource(value = {"SUCCESS:성공", "CONTINUE:계속", "FAIL:실패"}, delimiter = ':')
    @ParameterizedTest
    void checkStringStatusByResultEnum(Result result, String expected) {
        assertEquals(result.getStatusMessage()
                , expected
                , "[ERROR] Enum 객체가 가진 문자와 예상한 값이 일치하지 않습니다.");

    }
}
