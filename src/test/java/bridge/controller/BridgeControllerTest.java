package bridge.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class BridgeControllerTest {

    static class MockOutPutView extends OutputView {

        public int printMap = 0;
        public int printResult = 0;
        public int printStartPhrase = 0;
        public int printInputBridgeSizePhrase = 0;
        public int printOnGamePhrase = 0;
        public int printRetryOrQuitPhrase = 0;

        @Override
        public void printMap(BridgeGame bridgeGame) {
            printMap++;
        }

        @Override
        public void printResult(BridgeGame bridgeGame) {
            printResult++;
        }

        @Override
        public void printStartPhrase() {
            printStartPhrase++;
        }

        @Override
        public void printInputBridgeSizePhrase() {
            printInputBridgeSizePhrase++;
        }

        @Override
        public void printOnGamePhrase() {
            printOnGamePhrase++;
        }

        @Override
        public void printRetryOrQuitPhrase() {
            printRetryOrQuitPhrase++;
        }
    }

    InputView inputView;
    MockOutPutView outputView;
    BridgeGame bridgeGame;
    BridgeController bridgeController;

    private void initBridgeController(Queue<String> inputs, Queue<Integer> numbers) {
        outputView = new MockOutPutView();
        inputView = new InputView(inputs::poll);
        bridgeGame = new BridgeGame(new BridgeMaker(numbers::poll));
        this.bridgeController = new BridgeController(inputView, outputView, bridgeGame);
    }

    @Test
    void 게임시작시_시작멘트호출_성공() throws Exception {
        initBridgeController(new LinkedList<>(List.of("4")),
            new LinkedList<>(Arrays.asList(1, 0, 0, 1)));
        bridgeController.startGame();
        assertAll(
            () -> assertThat(outputView.printStartPhrase).isOne(),
            () -> assertThat(outputView.printInputBridgeSizePhrase).isOne()
        );
    }

    @Test
    void 게임_진행_멘트호출_사용자_다리_출력호출_성공() throws Exception {
        initBridgeController(new LinkedList<>(List.of("4", "U")),
            new LinkedList<>(Arrays.asList(1, 0, 0, 1)));
        bridgeController.startGame();
        bridgeController.onGame();
        assertAll(
            () -> assertThat(outputView.printOnGamePhrase).isOne(),
            () -> assertThat(outputView.printMap).isOne()
        );
    }

    @Test
    void 게임_종료_선택멘트호출_성공() throws Exception {
        initBridgeController(new LinkedList<>(List.of("4", "D", "Q")),
            new LinkedList<>(Arrays.asList(1, 0, 0, 1)));
        bridgeController.startGame();
        bridgeController.onGame();
        boolean quit = bridgeController.isNotEnd();
        assertAll(
            () -> assertThat(outputView.printRetryOrQuitPhrase).isOne(),
            () -> assertThat(quit).isFalse()
        );
    }

    @Test
    void 게임_재시작_선택멘트호출_성공() throws Exception {
        initBridgeController(new LinkedList<>(List.of("4", "D", "R")),
            new LinkedList<>(Arrays.asList(1, 0, 0, 1)));
        bridgeController.startGame();
        bridgeController.onGame();
        boolean retry = bridgeController.isNotEnd();
        assertAll(
            () -> assertThat(outputView.printRetryOrQuitPhrase).isOne(),
            () -> assertThat(retry).isTrue()
        );
    }

    @Test
    void 맞춘경우_재시작_종료_호출하지않는다() throws Exception {
        initBridgeController(new LinkedList<>(List.of("4", "U")),
            new LinkedList<>(Arrays.asList(1, 0, 0, 1)));
        bridgeController.startGame();
        bridgeController.onGame();
        boolean retry = bridgeController.isNotEnd();
        assertAll(
            () -> assertThat(outputView.printRetryOrQuitPhrase).isZero(),
            () -> assertThat(retry).isTrue()
        );
    }

    @Test
    void 게임_종료_결과_호출_성공() throws Exception {
        initBridgeController(new LinkedList<>(List.of("R")),
            new LinkedList<>(Arrays.asList(1, 0, 0, 1)));
        bridgeController.endGame();
        assertThat(outputView.printResult).isOne();
    }
}