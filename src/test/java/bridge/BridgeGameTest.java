package bridge;

import bridge.domain.BridgeJudge;
import bridge.domain.Player;
import bridge.dto.BridgeRouteDto;
import bridge.dto.ResultDto;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void preInit() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeJudge bridgeJudge = new BridgeJudge();
        bridgeJudge.addBridge(Arrays.asList("U","U","D"));
        Player player = new Player();
        player.move("U");
        player.move("D");
        bridgeGame = new BridgeGame(bridgeMaker, bridgeJudge, player);
    }

    @DisplayName("bridge와 moveHistory 정보를 담은 bridgeRouteDto를 생성한다.")
    @Test
    void getBridgeRouteDto() {
        BridgeRouteDto bridgeRouteDto = bridgeGame.getBridgeRouteDto();
        assertThat(bridgeRouteDto.getBridge()).containsExactly("U","U","D");
        assertThat(bridgeRouteDto.getMoveHistory()).containsExactly("U","D");
    }

    @DisplayName("시도 횟수, 성공 여부, bridge, moveHistory 정보를 담은 ResultDto를 생성한다.")
    @Test
    void getResultDtoTest() {
        ResultDto resultDto = bridgeGame.getResultDto();

        assertThat(resultDto.getTryCount()).isEqualTo(1);
        assertThat(resultDto.getIsComplete()).isEqualTo(false);
        assertThat(resultDto.getBridgeRouteDto().getBridge()).containsExactly("U","U","D");
        assertThat(resultDto.getBridgeRouteDto().getMoveHistory()).containsExactly("U","D");
    }
}
