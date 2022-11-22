package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OutputViewTest extends NsTest {

    @Test
    void 재시도_횟수_반영_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "3", "U", "D", "U");
            assertThat(output()).contains(
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1, 1, 0, 1);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
