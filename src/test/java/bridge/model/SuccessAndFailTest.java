package bridge.model;

import static bridge.model.SuccessAndFail.getKoreanDisplay;
import static bridge.model.SuccessAndFail.isSuccess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SuccessAndFailTest {
    @Test
    void 한글_표기_반환() {
        Assertions.assertEquals("성공", getKoreanDisplay(true));
        Assertions.assertEquals("실패", getKoreanDisplay(false));
    }

    @Test
    void 성공_여부_반환() {
        Assertions.assertEquals(true, isSuccess(SuccessAndFail.SUCCESS));
        Assertions.assertEquals(false, isSuccess(SuccessAndFail.FAIL));
    }
}