package bridge.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGenerateServiceTest {

    BridgeGenerateService bridgeGenerateService = new BridgeGenerateService();

    @Test
    @DisplayName("길이가 5인 다리를 생성한다.")
    void 입력한_길이만큼의_다리_생성() {
        int size = 5;

        List<String> bridge = bridgeGenerateService.generateBridgeBySize(size);

        assertEquals(size, bridge.size());
    }
}