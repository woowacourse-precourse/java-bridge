package bridge.view.validation;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.view.validation.InputValidation.checkValidation;
import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest extends NsTest {

    @Test
    @DisplayName("readBridgeSize 그룹은 3 ~ 20 숫자 입력시 false 반환되야 한다.")
    void readBridgeSizeGroupInput() {
        // given
        String input = "3";
        String validationGroup = "readBridgeSize";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertFalse(checkValidation);
    }

    @Test
    @DisplayName("readBridgeSize 그룹은 null 입력시 true가 반환되고 메시지가 출력되어야한다.")
    void readBridgeSizeGroupInputNull() {
        // given
        String input = "";
        String validationGroup = "readBridgeSize";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertTrue(checkValidation);
        assertEquals("[ERROR] 아무것도 입력하지 않으셨습니다.", output());
    }

    @Test
    @DisplayName("readBridgeSize 그룹은 숫자가 아닌 입력시 true가 반환되고 메시지가 출력되어야한다.")
    void readBridgeSizeGroupInputNotNumber() {
        // given
        String input = "한글";
        String validationGroup = "readBridgeSize";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertTrue(checkValidation);
        assertEquals("[ERROR] 숫자가 아닙니다.", output());
    }

    @Test
    @DisplayName("readBridgeSize 그룹은 숫자가 3~20범위가 아닐시 true가 반환되고 메시지가 출력되어야한다.")
    void readBridgeSizeGroupInputNot3To20() {
        // given
        String input = "2";
        String validationGroup = "readBridgeSize";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertTrue(checkValidation);
        assertEquals("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.", output());
    }

    @Test
    @DisplayName("readBridgeSize 그룹은 U 입력시 false 반환되야 한다.")
    void readMovingGroupInput() {
        // given
        String input = "U";
        String validationGroup = "readMoving";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertFalse(checkValidation);
    }

    @Test
    @DisplayName("readMoving 그룹은 null 입력시 true가 반환되고 메시지가 출력되어야한다.")
    void readMovingGroupInputNull() {
        // given
        String input = "";
        String validationGroup = "readMoving";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertTrue(checkValidation);
        assertEquals("[ERROR] 아무것도 입력하지 않으셨습니다.", output());
    }

    @Test
    @DisplayName("readMoving 그룹은 U 나 D 이외 입력시 true가 반환되고 메시지가 출력되어야한다.")
    void readMovingGroupInputNotUorD() {
        // given
        String input = "G";
        String validationGroup = "readMoving";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertTrue(checkValidation);
        assertEquals("[ERROR] U 또는 D를 입력해주세요.", output());
    }

    @Test
    @DisplayName("readGameCommand 그룹은 R 입력시 false 반환되야 한다.")
    void readGameCommandGroupInput() {
        // given
        String input = "R";
        String validationGroup = "readGameCommand";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertFalse(checkValidation);
    }

    @Test
    @DisplayName("readGameCommand 그룹은 null 입력시 true가 반환되고 메시지가 출력되어야한다.")
    void readGameCommandGroupInputNull() {
        // given
        String input = "";
        String validationGroup = "readGameCommand";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertTrue(checkValidation);
        assertEquals("[ERROR] 아무것도 입력하지 않으셨습니다.", output());
    }

    @Test
    @DisplayName("readGameCommand 그룹은 R 나 Q 이외 입력시 true가 반환되고 메시지가 출력되어야한다.")
    void readGameCommandGroupInputNotRorQ() {
        // given
        String input = "G";
        String validationGroup = "readGameCommand";

        // when
        boolean checkValidation = checkValidation(input, validationGroup);

        // then
        assertTrue(checkValidation);
        assertEquals("[ERROR] R 또는 Q를 입력해주세요.", output());
    }

    @Override
    protected void runMain() {

    }
}