package bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    @DisplayName("무작위로 만든 이동가능한 곳")
    @Test
    void makeBridge() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThat(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(3))
                .asList();
    }
}
