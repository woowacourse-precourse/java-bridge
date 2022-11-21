package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;


class BridgeMakerTest {

    private final BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();

    @DisplayName("입력 크기 만큼 다리를 생성한다.")
    @Test
    void createBridgeByValidSize() {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(10);

        Assertions.assertThat(bridge.size()).isEqualTo(10);
    }

    @DisplayName("U와 D로만 구성된 다리를 생성한다.")
    @Test
    void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(20);

        Assertions.assertThat(bridge.stream()
                        .filter(s -> s.equals("U") || s.equals("D"))
                        .collect(Collectors.toList())
                        .size())
                .isEqualTo(20);
    }

    @DisplayName("범위를 벗어난 길이인 경우, 오류가 발생한다.")
    @Test
    void createBridgeBySizeOverRange() {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        Assertions.assertThatThrownBy(() -> bridgeMaker.makeBridge(44))
                .isInstanceOf(IllegalArgumentException.class);
    }
}