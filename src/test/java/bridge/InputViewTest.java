package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : bridge
 * fileName : InputViewTest
 * author : gim-yeong-geun
 * date : 2022/11/19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/19         gim-yeong-geun          최초 생성
 */
class InputViewTest {

    @DisplayName("3미만 20을 초과한 숫자를 입력했을 경우 [ERROR] 발생")
    @ValueSource(strings = {"1", "21"})
    @ParameterizedTest
    void readBridgeSize(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new InputView().readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readMoving() {
    }

    @Test
    void readGameCommand() {
    }
}