package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class BridgeMakerServiceTest {

    @Test
    void 다리_생성_기능_테스트() {
        String input = "20";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(BridgeMakerService.createBridge()).isInstanceOf(Bridge.class);
    }
}