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
    outputView.printAskBridgeSizeMessage();
    return inputView.readBridgeSize();
  }

  public Bridge makeBridge(int size) {
    return new Bridge(bridgeMaker.makeBridge(size)
            .stream().map(Direction::findByValue)
            .collect(Collectors.toList()));
  }

  public Direction getDirection() {
    outputView.printAskDirectionMessage();
    return inputView.readMoving();
  }

  public MoveResult move(Bridge bridge, int tryNumber) {
    List<Cross> crossResult = new ArrayList<>();
    for (Direction bridgeDirection : bridge.getDirections()) {
      Direction userDirection = getDirection();
      moveAndPrint(bridgeDirection, userDirection, crossResult);
      if (!canCross(bridgeDirection, userDirection)) {
        return new MoveResult(GAME_FAIL, crossResult, tryNumber);
      }
    }
    return new MoveResult(GAME_SUCCESS, crossResult, tryNumber);
  }

  public void moveAndPrint(Direction bridgeDirection, Direction userDirection, List<Cross> crossResult) {
    crossResult = bridgeGame.move(bridgeDirection, userDirection, crossResult);
    outputView.printMap(crossResult);
  }

  public boolean canCross(Direction bridgeDirection, Direction userDirection) {
    return bridgeDirection.equals(userDirection);
  }

  public void playGame() {
    outputView.printGameStartMessage();
    Bridge bridge = makeBridge(getBridgeSize());
    int tryNumber = 1;
    MoveResult moveResult = move(bridge, tryNumber);
    handleMoveResult(bridge, moveResult);
  }

  public void handleMoveResult(Bridge bridge, MoveResult moveResult) {
    String gameResult = moveResult.getGameResult();
    if (gameResult.equals(GAME_FAIL)) {
      handleRestartResult(bridge, moveResult);
    }
    else if (gameResult.equals(GAME_SUCCESS)) {
      outputView.printResult(true, moveResult.getTryNumber(), moveResult.getCrossResult());
    }
  }

  public String getRestartCommand() {
    outputView.printAskRestartMessage();
    return inputView.readGameCommand();
  }

  public void handleRestartResult(Bridge bridge, MoveResult moveResult) {
    String restart = getRestartCommand();
    int tryNumber = moveResult.getTryNumber();

    if (restart.equals(GAME_RESTART)) {
      move(bridge, bridgeGame.retry(tryNumber));
    }
    else if (restart.equals(GAME_QUIT)) {
      outputView.printResult(false, tryNumber,  moveResult.getCrossResult());
    }
  }

}