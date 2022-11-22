package bridge.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SuccessAndFailTest {
    @Test
    void 성공_여부_반환() {
        Assertions.assertEquals(true, SuccessAndFail.SUCCESS.isSuccess());
        Assertions.assertEquals(false, SuccessAndFail.FAIL.isSuccess());
    }
}