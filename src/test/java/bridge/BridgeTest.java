package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.domain.Bridge;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeTest extends NsTest {

    @ValueSource(ints = {-1, 0, 2, 21, 100})
    @ParameterizedTest
    void 다리길이_범위초과_예외_테스트(int size) {
        assertThatThrownBy(() -> new Bridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    protected void runMain() {

    }
}
