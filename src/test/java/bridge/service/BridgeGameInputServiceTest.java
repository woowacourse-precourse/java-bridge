package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import bridge.constant.enumtype.UIMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameInputServiceTest {
    BridgeGameInputService bridgeGameInputService;

    @BeforeEach
    void setup() {
        bridgeGameInputService = new BridgeGameInputService();
    }

}