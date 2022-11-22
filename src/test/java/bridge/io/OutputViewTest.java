package bridge.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  void 올바른_시작_메시지를_출력하는가() {
    // given
    OutputView outputView = new OutputView();

    // when
    outputView.printStart();

    // then
    assertEquals(outContent.toString(), "다리 건너기 게임을 시작합니다.\n\n");
  }

}