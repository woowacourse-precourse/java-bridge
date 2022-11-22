package bridge.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlKeyTest {

  @Test
  void BridgeNumber에_맞는_key를_반환한는가() {

    String expectedKeyUP = ControlKey.findKeyByBridgeNumber(1);
    String expectedKeyDOWN = ControlKey.findKeyByBridgeNumber(0);

    assertEquals("U", expectedKeyUP);
    assertEquals("D", expectedKeyDOWN);
  }

}