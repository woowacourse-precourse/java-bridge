package bridge.domain.command;

import bridge.domain.BridgeArea;
import java.util.List;
import java.util.stream.Collectors;

public class CreateBridgeGameCommand {

  private final List<BridgeArea> bridges;

  public CreateBridgeGameCommand(List<String> bridges) {
    validateLength(bridges);
    validateValue(bridges);
    this.bridges = bridges.stream().map(BridgeArea::of).collect(Collectors.toList());
  }

  private void validateValue(List<String> bridges) {
    for (String bridge : bridges) {
      if (!BridgeArea.isMatch(bridge)) {
        throw new IllegalArgumentException("잘못된 값입니다.");
      }
    }
  }

  private void validateLength(List<String> bridges) {
    final int MIN_SIZE = 3;
    final int MAX_SIZE = 20;
    int size = bridges.size();
    if (size < MIN_SIZE || size > MAX_SIZE) {
      throw new IllegalArgumentException("다리의 크기가 너무 크거나 작습니다.");
    }
  }

  public List<BridgeArea> getBridges() {
    return bridges;
  }
}
