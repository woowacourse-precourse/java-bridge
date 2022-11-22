package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
  private User user;

  @BeforeEach
  void init() {
    user = new User();
  }

  @Test
  @DisplayName("사용자가 이동했을때 이동횟수와 현재 index가 증가한다.")
  void userMoveCountTest() {
    // given
    user.move(Direction.UP.getDirection());
    user.move(Direction.DOWN.getDirection());

    // then
    assertEquals(2, user.getMoveCount());
    assertEquals(1, user.getCurrentIndex());
  }

  @Test
  @DisplayName("재시작을 하면 시도횟수가 증가하고, 이동상태가 초기화 된다.")
  void userRetryTest() {
    // given
    user.move(Direction.UP.getDirection());

    // when
    user.retryGame();

    // then
    assertEquals(2, user.getTryCount());
    assertEquals(0, user.getMoveCount());
  }

  @Test
  @DisplayName("재시작을 하면 시도횟수가 증가하고, 이동상태가 초기화 된다.")
  void isUserCorrectlyMoveTest() {
    // given
    List<String> bridgeShape = List.of("U", "D", "U");

    // then
    assertTrue(user.isCorrectlyMove(bridgeShape));
    user.move(Direction.UP.getDirection());
    assertTrue(user.isCorrectlyMove(bridgeShape));
    user.move(Direction.UP.getDirection());
    assertFalse(user.isCorrectlyMove(bridgeShape));
  }
}
