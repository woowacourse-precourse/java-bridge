package bridge;

import bridge.domain.Player;
import bridge.dto.Bridge;
import bridge.dto.MoveResult;
import bridge.dto.PathTravel;
import bridge.repository.PlayerRepository;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BridgeGameTest {
    private final String POSSIBLE = " O ";
    private final String IMPOSSIBLE = " X ";
    private BridgeGame bridgeGame;
    private Long playerId;

    @BeforeEach
    void 세팅() {
        bridgeGame = new BridgeGame();
        playerId = bridgeGame.generatePlayer();
    }

    @DisplayName("플레이어 이동 실패")
    @Test
    void 플레이어_이동_실패() {
        Bridge bridge =  new Bridge(List.of("U","D","U"));
        String position = "D";

        MoveResult moveResult = bridgeGame.move(playerId, bridge, position);

        assertTrue(moveResult.isGameOver());
    }

    @DisplayName("플레이어 이동 성공")
    @Test
    void 플레이어_이동_성공() {
        Bridge bridge =  new Bridge(List.of("U","D","U"));
        String position = "U";

        MoveResult moveResult = bridgeGame.move(playerId, bridge, position);

        assertFalse(moveResult.isGameOver());
    }

    @DisplayName("플레이어 위쪽 다리 이동 성공 후 경로가 올바른지 테스트")
    @Test
    void 플레이어_위쪽_다리_이동_성공_경로() {
        Bridge bridge =  new Bridge(List.of("U","D","U"));
        String position = "U";
        bridgeGame.move(playerId, bridge, position);

        PathTravel pathTravel = bridgeGame.getPathTravel(playerId);
        List<String> upperBridge = pathTravel.getUpperBridge();

        assertTrue(upperBridge.get(0).equals(POSSIBLE));
    }

    @DisplayName("플레이어 위쪽 다리 이동 실패 후 경로가 올바른지 테스트")
    @Test
    void 플레이어_위쪽_다리_이동_실패_경로() {
        Bridge bridge =  new Bridge(List.of("D","D","U"));
        String position = "U";
        bridgeGame.move(playerId, bridge, position);

        PathTravel pathTravel = bridgeGame.getPathTravel(playerId);
        List<String> upperBridge = pathTravel.getUpperBridge();

        assertTrue(upperBridge.get(0).equals(IMPOSSIBLE));
    }

    @DisplayName("플레이어 아래쪽 다리 이동 성공 후 경로가 올바른지 테스트")
    @Test
    void 플레이어_아래쪽_다리_이동_성공_경로() {
        Bridge bridge =  new Bridge(List.of("D","D","U"));
        String position = "D";
        bridgeGame.move(playerId, bridge, position);

        PathTravel pathTravel = bridgeGame.getPathTravel(playerId);
        List<String> lowerBridge = pathTravel.getLowerBridge();

        assertTrue(lowerBridge.get(0).equals(POSSIBLE));
    }

    @DisplayName("플레이어 아래쪽 다리 이동 실패 후 경로가 올바른지 테스트")
    @Test
    void 플레이어_아래쪽_다리_이동_실패_경로() {
        Bridge bridge =  new Bridge(List.of("U","D","U"));
        String position = "D";
        bridgeGame.move(playerId, bridge, position);

        PathTravel pathTravel = bridgeGame.getPathTravel(playerId);
        List<String> lowerBridge = pathTravel.getLowerBridge();

        assertTrue(lowerBridge.get(0).equals(IMPOSSIBLE));
    }

    @DisplayName("재시도했을 때 시도 횟수 증가하는지 테스트")
    @Test
    void 재시도_시도_횟수_증가() {
        PlayerRepository playerRepository = PlayerRepository.getInstance();
        bridgeGame.retry(playerId, "R");
        Player player = playerRepository.findById(playerId);

        Long numberOfTry = player.getNumberOfTry();

        assertEquals(2, numberOfTry);
    }

    @DisplayName("모든 다리를 건너는 것이 성공했는지 테스트")
    @Test
    void 모든_다리_이동_성공() {
        Bridge bridge =  new Bridge(List.of("D","D","U"));
        List<String> positions = List.of("D","D","U");
        positions.stream()
                        .forEach(position -> bridgeGame.move(playerId, bridge, position));
        PlayerRepository playerRepository = PlayerRepository.getInstance();
        Player player = playerRepository.findById(playerId);

        Boolean result = player.isGameClear(bridge.getSize());
        assertTrue(result);
    }

    @DisplayName("모든 다리를 건너는 것이 실패했는지 테스트")
    @Test
    void 모든_다리_이동_실패() {
        Bridge bridge =  new Bridge(List.of("D","D","U"));
        List<String> positions = List.of("D","D","D");
        positions.stream()
                .forEach(position -> bridgeGame.move(playerId, bridge, position));
        PlayerRepository playerRepository = PlayerRepository.getInstance();
        Player player = playerRepository.findById(playerId);

        Boolean result = player.isGameClear(bridge.getSize());
        assertFalse(result);
    }
}