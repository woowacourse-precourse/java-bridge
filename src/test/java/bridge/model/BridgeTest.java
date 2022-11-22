package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @DisplayName("U, D 이외의 문자가 들어가 있는 리스트로 Bridge 를 생성하면 예외가 발생한다.")
    @Test
    void createBridgeByInvalidList() {
        assertThatThrownBy(() -> new Bridge(List.of("U", "D", "O")))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("U, D 문자만 들어가 있는 리스트로 Bridge 를 생성할 수 있다.")
    @Test
    void createBridgeByValidList() {
        Bridge bridge = new Bridge(List.of("U", "D"));
        assertThat(bridge.getBridge()).containsExactly("U", "D");
    }
}
