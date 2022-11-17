package bridge;

import bridge.application.GameService;
import bridge.domain.repository.BridgeRepository;
import bridge.presentation.dto.BridgeSize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    @DisplayName("다리 길이 저장 테스트")
    @Test
    void 다리길이_저장(){
        GameService gameService=GameService.getInstance();
        BridgeRepository bridgeRepository=BridgeRepository.getInstance();
        gameService.saveBridgeSize(new BridgeSize("3"));
        Assertions.assertThat(bridgeRepository.getBridgeSize().getSize()).isEqualTo(3);
    }
}
