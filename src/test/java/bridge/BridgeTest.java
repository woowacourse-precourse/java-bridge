package bridge;

import bridge.application.BridgeGame;
import bridge.domain.repository.BridgeRepository;
import bridge.presentation.dto.BridgeSize;
import bridge.presentation.dto.GameCommand;
import bridge.presentation.dto.SelectMove;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeTest {
    @DisplayName("다리 길이 저장 테스트")
    @Test
    void 다리길이_저장(){
        BridgeGame bridgeGame=BridgeGame.getInstance();
        BridgeRepository bridgeRepository=BridgeRepository.getInstance();
        bridgeGame.saveBridgeSize(new BridgeSize("3"));
        Assertions.assertThat(bridgeRepository.getBridgeSize().getSize()).isEqualTo(3);
    }
    @DisplayName("이동할 칸 저장 테스트")
    @Test
    void 이동할칸_저장(){
        BridgeGame bridgeGame=BridgeGame.getInstance();
        BridgeRepository bridgeRepository=BridgeRepository.getInstance();
        bridgeGame.saveSelectMove(new SelectMove("U"));
        Assertions.assertThat(bridgeRepository.getSelectMove().getMove()).isEqualTo("U");
    }
    @DisplayName("이동 테스트")
    @Test
    void 이동(){
        BridgeGame bridgeGame=BridgeGame.getInstance();
        BridgeRepository bridgeRepository=BridgeRepository.getInstance();
        bridgeRepository.setResult();
        bridgeRepository.saveSelectMove(new SelectMove("U"));
        bridgeRepository.updateBridge(List.of("U"));
        Assertions.assertThat(bridgeGame.move()).isEqualTo(1);
    }
    @DisplayName("재시작 값 저장 테스트")
    @Test
    void 재시작_저장(){
        BridgeGame bridgeGame=BridgeGame.getInstance();
        Assertions.assertThat(bridgeGame.checkRetry(new GameCommand("R"))).isEqualTo(true);
    }
}
