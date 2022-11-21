package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameHistoryTest {

    private BridgeGameHistory bridgeGameHistory;

    public BridgeGameHistoryTest() {
    }

    @DisplayName("다리 생성후 정상적으로 값이 들어갔는지 확인한다.")
    @Test
    public void create_Bridge_Check_Value() {
        int bridgeSize = 4;
        List<String> answer = List.of("U", "D");
        bridgeGameHistory = new BridgeGameHistory(bridgeSize);
        bridgeGameHistory.addBridgeHistory("U");
        bridgeGameHistory.addBridgeHistory("D");
        assertEquals(bridgeGameHistory.getBridgeHistory(), answer);
    }

    @DisplayName("다리 생성후 초기화 후 값이 들어갔는지 확인한다.")
    @Test
    public void create_Bridge_Init_Check_Value() {
        int bridgeSize = 4;
        assertAll(
                () -> {
                    List<String> answer = List.of("U", "D");
                    bridgeGameHistory = new BridgeGameHistory(bridgeSize);
                    bridgeGameHistory.addBridgeHistory("U");
                    bridgeGameHistory.addBridgeHistory("D");
                    assertEquals(bridgeGameHistory.getBridgeHistory(), answer);
                },
                () -> {
                    List<String> answer = List.of("D", "D");
                    bridgeGameHistory.initBridgeHistory();
                    bridgeGameHistory.addBridgeHistory("D");
                    bridgeGameHistory.addBridgeHistory("D");
                    assertEquals(bridgeGameHistory.getBridgeHistory(), answer);
                }
        );
    }

    @DisplayName("다리 길이만큼 기록 추가 한 뒤 끝났는지 확인한다.")
    @Test
    public void is_End_Game() {
        int bridgeSize = 4;
        boolean isEnd = true;
        bridgeGameHistory = new BridgeGameHistory(bridgeSize);
        bridgeGameHistory.addBridgeHistory("U");
        bridgeGameHistory.addBridgeHistory("U");
        bridgeGameHistory.addBridgeHistory("U");
        bridgeGameHistory.addBridgeHistory("U");
        assertEquals(bridgeGameHistory.isEndGame(), isEnd);
    }

    @DisplayName("현재다리의 인덱스를 가져온다.")
    @Test
    public void check_Current_Move_Bridge_Count() {
        int bridgeSize = 4;
        bridgeGameHistory = new BridgeGameHistory(bridgeSize);
        assertAll(
                () -> {
                    bridgeGameHistory.addBridgeHistory("U");
                    assertEquals(bridgeGameHistory.getCurrentIndex(), 0);
                },
                () -> {
                    bridgeGameHistory.addBridgeHistory("U");
                    assertEquals(bridgeGameHistory.getCurrentIndex(), 1);
                },
                () -> {
                    bridgeGameHistory.addBridgeHistory("U");
                    assertEquals(bridgeGameHistory.getCurrentIndex(), 2);
                }
        );
    }
}