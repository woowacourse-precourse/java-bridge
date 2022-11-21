package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SuccessValidatorTest {

    @Test
    void isSuccess() {
        List<String> targetBridges = List.of("U", "D", "U");
        List<String> successRout = List.of("U", "D");
        assertThat(SuccessValidator.isSuccess(targetBridges, successRout)).isTrue();

        List<String> failRout = List.of("U", "U");
        assertThat(SuccessValidator.isSuccess(targetBridges, failRout)).isFalse();
    }
}
