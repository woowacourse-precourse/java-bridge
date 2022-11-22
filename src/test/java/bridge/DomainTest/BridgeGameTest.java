package bridge.DomainTest;

import bridge.Constants.StandardTools.GameStatus;
import bridge.Database.BridgeData;
import bridge.Domain.BridgeGame;
import bridge.UI.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @Mock
    BridgeData bridgeData = new BridgeData();
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

            BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeLength());

            assertThat(bridgeGame.bridgeData.copyBridge()).hasSize(Integer.parseInt(bridgeLength));
        }

        @DisplayName("게임 시작시 다리 길이 입력 후 총 시도횟수 초기화 여부")
        @Test
        void isTotalAttemptInitialized() {
            String bridgeLength = "3";
            InputStream in = new ByteArrayInputStream(bridgeLength.getBytes());
            System.setIn(in);

            BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeLength());

            assertThat(bridgeGame.bridgeData.getTotalAttempt()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("다리 이동 테스트")
    class moveTest {

        @DisplayName("다 건넜을 경우 성공을 선언한다.")
        @Test
        void finishCrossingBridgeTest() {
            bridgeData.setBridge(Arrays.asList("U", "D", "D"));
            List<String> nextSteps = new ArrayList<>(Arrays.asList("U", "D", "D"));

            for (String nextStep : nextSteps) {
                bridgeData.addBridgeDesignByUser(nextStep);
            }

            assertThat(bridgeData.isBridgeDesignByUserCompleted()).isTrue();
        }
    }

    @Nested
    @DisplayName("재시도 여부 테스트")
    class retryOrQuitTest {

        @Mock
        BridgeGame bridgeGame = new BridgeGame(3);
        BridgeData bridgeData = bridgeGame.bridgeData;

        @DisplayName("R을 받을 경우 RETRY를 선언, 시도 횟수를 +1 한다.")
        @Test
        void retryTest() {
            String retryInput = "R";
            GameStatus retry = GameStatus.RETRY;
            int attemptBeforeRetry = bridgeData.getTotalAttempt();
            InputStream in = new ByteArrayInputStream(retryInput.getBytes());
            System.setIn(in);

            bridgeGame.retry(inputView.readGameCommand());

            assertThat(bridgeGame.getGameStatus()).isEqualTo(retry);
            assertThat(bridgeGame.bridgeData.getTotalAttempt()).isEqualTo(attemptBeforeRetry + 1);
        }

        @DisplayName("Q를 받을 경우, QUIT 상태로 선언한다.")
        @Test
        void quitTest() {
            String retryInput = "Q";
            GameStatus quit = GameStatus.QUIT;
            InputStream in = new ByteArrayInputStream(retryInput.getBytes());
            System.setIn(in);

            bridgeGame.retry(inputView.readGameCommand());
            assertThat(bridgeGame.getGameStatus()).isEqualTo(quit);
        }
    }
}
