package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.Bridge;
import bridge.vo.Cross;
import bridge.vo.Direction;
import bridge.vo.MoveResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static bridge.Constants.*;

public class GameController {

  private final BridgeMaker bridgeMaker;
  private final InputView inputView;
  private final OutputView outputView;
  public final BridgeGame bridgeGame;

  public GameController(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
    this.bridgeMaker = bridgeMaker;
    this.inputView = inputView;
    this.outputView = outputView;
    this.bridgeGame = bridgeGame;
  }

  public int getBridgeSize() {
    return inputView.readBridgeSize();
  }

  public Bridge makeBridge(int size) {
    return new Bridge(bridgeMaker.makeBridge(size)
            .stream().map(Direction::findByValue)
            .collect(Collectors.toList()));
  }

  public Direction getMove() {
    return inputView.readMoving();
  }

  public MoveResult move(Bridge bridge, int tryNumber) {
    List<Cross> crossResult = new ArrayList<>();

    for (Direction bridgeDirection : bridge.getDirections()) {
      outputView.printAskDirectionMessage();
      Direction userDirection = getMove();

      crossResult = bridgeGame.move(bridgeDirection, userDirection, crossResult);

      outputView.printMap(crossResult);
      if (!canCross(bridgeDirection, userDirection)) {
        return new MoveResult(GAME_FAIL, crossResult, tryNumber);
      }
    }
    return new MoveResult(GAME_SUCCESS, crossResult, tryNumber);
  }

  public boolean canCross(Direction bridgeDirection, Direction userDirection) {
    return bridgeDirection.equals(userDirection);
  }

  public void playGame() {
    outputView.printGameStartMessage();
    outputView.printAskBridgeSizeMessage();
    Bridge bridge = makeBridge(getBridgeSize());
    int tryNumber = 1;
    MoveResult moveResult = move(bridge, tryNumber);
    String status = moveResult.getGameResult();
    List<Cross> crossResult = moveResult.getCrossResult();
    tryNumber = moveResult.getTryNumber();
    if (status.equals(GAME_FAIL)) {
      isRestart(bridge, moveResult);
    } else if (status.equals(GAME_SUCCESS)) {
      outputView.printResult(true, tryNumber, crossResult);
    }
  }

  public void isRestart(Bridge bridge, MoveResult moveResult) {
    outputView.printAskRestartMessage();
    String restart = inputView.readGameCommand();
    int tryNumber = moveResult.getTryNumber();
    if (restart.equals(GAME_RESTART)) {
      move(bridge, bridgeGame.retry(tryNumber));
    } else if (restart.equals(GAME_QUIT)) {
      outputView.printResult(false, tryNumber,  moveResult.getCrossResult());
    }
  }

}