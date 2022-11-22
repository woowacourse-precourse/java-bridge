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

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("문자를 입력할 시 예외가 발생한다.")
    @Test
    void 다리길이_문자입력(){
        assertThatThrownBy(()->new BridgeSize("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("3부터 20사이의 숫자를 입력 하지 않을 경우 예외가 발생한다.")
    @Test
    void 범위_입력(){
        assertThatThrownBy(()->new BridgeSize("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("U, D를 입력 하지 않을 경우 예외가 발생한다.")
    @Test
    void 이동_입력(){
        assertThatThrownBy(()->new SelectMove("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("R, Q를 입력 하지 않을 경우 예외가 발생한다.")
    @Test
    void 게임_재시작_값_입력(){
        assertThatThrownBy(()->new GameCommand("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
