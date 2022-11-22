package bridge;

import bridge.domain.BridgeGameService;
import bridge.infra.GameController;
import bridge.infra.InputView;
import bridge.infra.OutputView;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    InputView input = new InputView();
    OutputView output = new OutputView();
    BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    BridgeMaker maker = new BridgeMaker(generator);
    BridgeGameService service = new BridgeGameService();
    GameController controller = new GameController(input, output, maker, service);
    controller.run();
  }
}
