package bridge;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.ApplicationTest.TestNumberGenerator;

import bridge.domain.Command;
import bridge.domain.Direction;
import bridge.service.BridgeGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ExceptionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 21, 23, 50, 100})
    void bridgeSizeExceptionTest(int size) {
        assertThrows(IllegalArgumentException.class, () -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeMaker.makeBridge(size);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3, 5})
    void randomBridgeNumberExceptionTest(int number) {
        assertThrows(IllegalArgumentException.class, () -> {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(number, 0, 0));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            bridgeMaker.makeBridge(3);
        });
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3, 5})
    void moveExceptionTest(int number) {
        assertThrows(IllegalArgumentException.class, () -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(0, 0, 0)));
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
            Direction direction = Direction.toDirection(number);
            bridgeGame.move(direction);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"s", "r", "s", "q", "w", ";", ""})
    void retryExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(0, 0, 0)));
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
            bridgeGame.retry(Command.toCommand(input));
        });
    }


}