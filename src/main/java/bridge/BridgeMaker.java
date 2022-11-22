package bridge;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

  private final BridgeNumberGenerator bridgeNumberGenerator;

  public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
    this.bridgeNumberGenerator = bridgeNumberGenerator;
  }

  /**
   * @param size 다리의 길이
   * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
   */
  public List<String> makeBridge(int size) {
    List<String> bridge = new ArrayList<>();
    String bridgeNum;
    for (int i = 0; i < size; i++) {
      bridgeNum = convertItoS(bridgeNumberGenerator.generate());
      bridge.add(bridgeNum);
    }
    return bridge;
  }

  /**
   * 랜덤으로 뽑힌 수 randN을 커맨드 문자로 변경하는 메서드
   *
   * @param randN 입력받은 랜덤 값(0 또는 1)
   * @return 입력받은 값에 따라 반환되는 커맨드 문자열(U 또는 D)
   */
  public String convertItoS(int randN) {
    if (randN == 1) {
      return "U";
    }
    return "D";
  }
}
