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

  @Test
  void 올바른_결과_메시지를_출력하는가() {
    // given
    OutputView outputView = new OutputView();

    // when
    outputView.printLastMapResult();

    // then
    assertEquals(outContent.toString(), "최종 게임 결과\n");
  }

  @Test
  void 올바른_맵을_출력하는가() {
    // given
    OutputView outputView = new OutputView();

    // when
    outputView.printMap("[ O | O |   |   | O | O | O |   |   | O | O |   |   | O |   |   |   |   |   |   ]\n" +
      "[   |   | O | O |   |   |   | O | O |   |   | O | O |   | O | O | O | O | O | O ]\n");

    // then
    assertEquals(outContent.toString(), "[ O | O |   |   | O | O | O |   |   | O | O |   |   | O |   |   |   |   |   |   ]\n" +
      "[   |   | O | O |   |   |   | O | O |   |   | O | O |   | O | O | O | O | O | O ]\n\n");
  }



}