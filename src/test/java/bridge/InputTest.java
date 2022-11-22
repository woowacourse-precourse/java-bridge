package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 다리길이_입력_테스트(){
        assertThatThrownBy(() -> Application.main(new String[]{"ㄱㄴㄷ"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
