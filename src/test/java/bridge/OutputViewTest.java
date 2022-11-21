package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest{

    static ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static GameData gameData = new GameData();

    @BeforeAll
    public static void setGameData() {
        gameData.updateStatus("U", "O");
        gameData.updateStatus("D", "O");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("최신 게임 현황 출력을 확인한다.")
    @Test
    void printCurrentGameStatus() {
        OutputView outputView = new OutputView();
        outputView.printMap(gameData);
        assertThat(outputStreamCaptor.toString().trim()).contains("[ O |   ]", "[   | O ]");
    }
}
