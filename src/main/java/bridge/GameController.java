package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

  private final BridgeMaker bridgeMaker;
  private final InputView inputView;
  private final OutputView outputView;
  public static final String RESTART = "R";
  public static final String STOP = "Q";
  public static final String SUCCESS = "성공";
  public static final String FAIL = "실패";
  int gameNum = 0;

  public GameController(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
    this.bridgeMaker = bridgeMaker;
    this.inputView = inputView;
    this.outputView = outputView;
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

  public MoveResult move(Bridge bridge) {
    List<Cross> crossResult = new ArrayList<>();
    gameNum ++;
    for (Direction bridgeDirection : bridge.getDirections()) {
      outputView.printAskDirectionMessage();
      Direction userDirection = getMove();
      addCrossResult(crossResult, bridgeDirection, userDirection);
      outputView.printMap(crossResult);
      if (!canCross(bridgeDirection, userDirection)) {
        return new MoveResult(FAIL, crossResult);
      }
    }
    return new MoveResult(SUCCESS, crossResult);
  }

  public boolean canCross(Direction bridgeDirection, Direction userDirection) {
    return bridgeDirection.equals(userDirection);
  }

  public void addCrossResult(List<Cross> crossResult, Direction bridgeDirection, Direction userDirection) {
    crossResult.add(new Cross(userDirection, canCross(bridgeDirection, userDirection)));
  }

}