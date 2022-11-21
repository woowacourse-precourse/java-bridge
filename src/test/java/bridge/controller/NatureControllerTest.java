package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.dto.BridgeStatusDto;
import bridge.generator.BridgeNumberGenerator;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.mediator.Mediator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class NatureControllerTest {


    @Test
    void generateBridge() {
        Controller controller = new NatureController(i -> createBridgeGame(i, new ArrayList<>()), new MockMediator());
        Runnable runnable = controller.generateBridge(3);
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("moveBridge");
        }

    }

    @Test
    void 다리이동실패케이스() {
        NatureController controller = createController(new ArrayList<>());
        controller.initBridgeGame(3);
        Runnable runnable = controller.moveBridge("D", new HashMap<>());
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("replay");
        }
    }

    @Test
    void 다리이동_한번성공_케이스() {
        NatureController controller = createController(new ArrayList<>());
        controller.initBridgeGame(3);
        Runnable runnable = controller.moveBridge("U", new HashMap<>());
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("moveBridge");
        }
    }

    @Test
    void 다리이동_전체성공_케이스() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("U", "U")));
        controller.initBridgeGame(3);
        Runnable runnable = controller.moveBridge("U", new HashMap<>());
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("end");
        }
    }

    @Test
    void 다리이동_잘못된_입력() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("U", "U")));
        controller.initBridgeGame(3);
        assertThatThrownBy(() -> controller.moveBridge("ad", new HashMap<>())).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다시시작_한다() {
        NatureController controller = createController(new ArrayList<>());
        controller.initBridgeGame(3);
        Runnable runnable = controller.replay("R");
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("moveBridge");
        }
    }

    @Test
    void 다시시작_안한다() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("U")));
        controller.initBridgeGame(3);
        Runnable runnable = controller.replay("Q");
        try {
            runnable.run();
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("end");
        }
    }

    @Test
    void 다시시작_잘못된입력() {
        NatureController controller = createController(new ArrayList<>(Arrays.asList("U")));
        controller.initBridgeGame(3);
        assertThatThrownBy(() -> controller.replay("d")).isInstanceOf(IllegalArgumentException.class);
    }

    private static NatureController createController(ArrayList<String> footPoints) {
        NatureController controller = new NatureController(i -> createBridgeGame(i, footPoints), new MockMediator());
        return controller;
    }

    private static BridgeGame createBridgeGame(Integer integer, ArrayList<String> footPoints) {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 1, 1)));
        return new BridgeGame(bridgeMaker.makeBridge(integer), footPoints);
    }

    static class MockMediator implements Mediator {

        int count = 1;

        @Override
        public void start() {
        }

        @Override
        public void generateBridge(int i) {

        }

        @Override
        public void moveBridge() {
            throw new RuntimeException("moveBridge");
        }

        @Override
        public Runnable moveBridge(String s, HashMap<String, String> map) {

            return null;
        }

        @Override
        public void replay() {
            throw new RuntimeException("replay");
        }

        @Override
        public void replay(String readGameCommand) {

        }

        @Override
        public void end(BridgeStatusDto bridgeStatusDto) {
            throw new RuntimeException("end");
        }
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}