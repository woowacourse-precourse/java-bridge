package bridge.DomainTest;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Database.BridgeData;
import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.UI.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @Mock
    BridgeData bridgeData = new BridgeData();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    InputView inputView = new InputView();

    @Nested
    @DisplayName("데이터 저장 테스트")
    class BridgeDataTest {
        @DisplayName("게임 시작시 다리 설계도 저장 여부")
        @Test
        void isBridgeDesignStored() {
            String bridgeLength = "3";
            InputStream in = new ByteArrayInputStream(bridgeLength.getBytes());
            System.setIn(in);

            bridgeData.setBridge(bridgeMaker.makeBridge(inputView.readBridgeLength()));
            assertThat(bridgeData.getBridge()).hasSize(Integer.parseInt(bridgeLength));
        }
    }


}
