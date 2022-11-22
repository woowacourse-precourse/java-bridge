package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.command.BridgeMoveCommand;
import bridge.domain.command.CreateBridgeGameCommand;
import bridge.domain.dto.MovingResult;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameServiceTest {

  private final BridgeGameService bridgeGameService = new BridgeGameService();

  @Test
  void 다리정보를입력시_해당다리정보를가진_BridgeGame을리턴한다() {
    CreateBridgeGameCommand givenCommand = new CreateBridgeGameCommand(List.of("U", "D", "U"));

    BridgeGame result = bridgeGameService.createGame(givenCommand);
    Bridge bridge = result.getBridge();
    assertThat(bridge.getBridgeAreas().get(0)).isEqualTo(givenCommand.getBridges().get(0));
  }


  @Test
  void 다리이동시_결과를리턴한다() {
    BridgeGame givenGame = new BridgeGame(new Bridge(List.of(BridgeArea.U, BridgeArea.U, BridgeArea.U)),
        new GameState());
    String nextArea = "U";
    BridgeMoveCommand command = new BridgeMoveCommand(nextArea, givenGame);

    MovingResult moving = bridgeGameService.moving(command);

    assertThat(moving.isClear()).isFalse();
    assertThat(moving.isMoveSuccess()).isTrue();
  }

  @Test
  void 재시도시_게임상태를_초기화한다(){
    BridgeGame givenGame = new BridgeGame(new Bridge(List.of(BridgeArea.U, BridgeArea.U, BridgeArea.U)),
        new GameState());
    //게임 1회 진행.
    givenGame.move(BridgeArea.U);
    GameState gameState = givenGame.getGameState();

    bridgeGameService.retry(givenGame);

    assertThat(gameState.getTryCount()).isEqualTo(2);
    assertThat(gameState.getMovementHistory().size()).isEqualTo(0);
  }
}