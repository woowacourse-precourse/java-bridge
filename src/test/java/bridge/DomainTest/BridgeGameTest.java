package bridge.DomainTest;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Database.BridgeData;
import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.UI.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @Mock
    BridgeData bridgeData = new BridgeData();
    BridgeGame bridgeGame = new BridgeGame();

    @Nested
    @DisplayName("데이터 저장 테스트")
    class BridgeDataTest {

        @DisplayName("게임 시작시 다리 설계도 저장 여부")
        @Test
        void isBridgeDesignStored() {
            String bridgeLength = "3";
            InputStream in = new ByteArrayInputStream(bridgeLength.getBytes());
            System.setIn(in);

            bridgeGame.gameStart();
            assertThat(bridgeGame.bridgeData.getBridge()).hasSize(Integer.parseInt(bridgeLength));
        }

        @DisplayName("게임 시작시 다리 길이 입력 후 총 시도횟수 초기화 여부")
        @Test
        void isTotalAttemptInitialized() {
            String bridgeLength = "3";
            InputStream in = new ByteArrayInputStream(bridgeLength.getBytes());
            System.setIn(in);

            bridgeGame.gameStart();
            assertThat(bridgeGame.bridgeData.getTotalAttempt()).isEqualTo(0);
        }
    }
}
