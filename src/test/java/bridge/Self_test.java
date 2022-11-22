package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Self_test extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_길이가_3_20_사이가_아닐때() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 이동할_칸_선택시_U_나_D_입력하지_않을때() {
        assertSimpleTest(() -> {
            runException("3", "G");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 재실행_시_Q_나_R_을_입력_하지_않을때() {
        assertSimpleTest(() -> {
            runException("3", "D", "E");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
