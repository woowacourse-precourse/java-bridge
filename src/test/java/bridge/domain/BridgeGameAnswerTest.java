package bridge.domain;


import static org.assertj.core.api.Assertions.*;

import bridge.common.ErrorMessage;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameAnswerTest {

    @ParameterizedTest
    @DisplayName("[예외] 올바르지 않은 bridge size일 때 BrideGameAnswer 오류 발생한다.")
    @ValueSource(ints = {2, 21})
    void createBridgeAnswer(int size) {
        final BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        final BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThatThrownBy(() -> new BridgeGameAnswer(bridge))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.isInvalidBridgeSize());
    }
}
