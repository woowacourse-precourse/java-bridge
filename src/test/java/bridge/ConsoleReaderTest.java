package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleReaderTest extends NsTest {

    @DisplayName("콘솔 리더 int 변환시 예외 전환 테스트")
    @Test
    void transferIllegalExceptionTest() {
        assertSimpleTest(() -> assertThatThrownBy(() -> run("asd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 형태로 입력해주세요."));
    }

    @Override
    protected void runMain() {
        ConsoleReader.readInt();
    }
}