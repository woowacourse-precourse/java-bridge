package bridge.DomainTest;

import bridge.Database.BridgeData;
import bridge.Domain.BridgeGame;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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

    @Nested
    @DisplayName("다리 이동 테스트")
    class moveTest {

        @DisplayName("건널수 없는 칸으로 갈 때 이동한 칸을 저장하고 실패를 선언한다.")
        @Test
        void moveToImpossibleZone() {
            bridgeGame.bridgeData.setBridge(Arrays.asList("U", "D", "D"));

            List<String> nextStep = new ArrayList<>(Arrays.asList("D"));
            InputStream in = new ByteArrayInputStream(nextStep.get(0).getBytes());
            System.setIn(in);

            bridgeGame.move();
            assertThat(bridgeGame.bridgeData.getBridgeDesignByUser()).isEqualTo(nextStep);
            assertThat(bridgeGame.getIsGameSucceed()).isFalse();
        }

        @DisplayName("다 건넜을 경우 성공을 선언한다.")
        @Test
        void finishCrossingBridgeTest() {
            bridgeGame.bridgeData.setBridge(Arrays.asList("U", "D", "D"));
            bridgeGame.bridgeData.updateBridgeDesignByUser(Arrays.asList("U", "D", "D"));

            assertThat(bridgeGame.getIsGameSucceed()).isTrue();
        }
    }


}
