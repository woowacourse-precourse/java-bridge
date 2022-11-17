package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void readBridgeSize() {
        InputView inputView = new InputView();

        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);

        int bridgeSize = inputView.readBridgeSize();

        assertThat(bridgeSize).isEqualTo(3);
    }


}