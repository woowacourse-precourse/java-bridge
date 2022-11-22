package bridge.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InGameMessageTest {

  @Test
  void success_여부에_맞는_메시지를_반환하는가() {

    String expectedMessageSuccess = InGameMessage.findMessageBySuccessOrNot(true);
    String expectedMessageFailure = InGameMessage.findMessageBySuccessOrNot(false);

    assertEquals("성공", expectedMessageSuccess);
    assertEquals("실패", expectedMessageFailure);
  }

}