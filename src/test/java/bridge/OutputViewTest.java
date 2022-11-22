package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void printGameStart() {
        OutputView outputView = new OutputView();

        outputView.printGameStart();
    }

    @Test
    void printMap() {
        OutputView outputView = new OutputView();

        List<List<String>> bridgeValues = List.of(List.of("O", " ", "O", "X"), List.of(" ", "O", " ", " "));

        outputView.printMap(bridgeValues);
        System.out.println();
    }

    @Test
    void printResult() {
        OutputView outputView = new OutputView();
        GameStatus gameStatus = new GameStatus();
        gameStatus.setGameWon(true);
        gameStatus.setTryCount(4);
        List<List<String>> bridgeValues = List.of(List.of("O", " ", "O", "O"), List.of(" ", "O", " ", " "));

        outputView.printResult(bridgeValues, gameStatus);
    }
}