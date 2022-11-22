package bridge.utils;

import bridge.game.context.BridgeGameContext;
import bridge.game.status.BridgeGameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {
    public static List<Integer> convertStringToListNumber(final String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> convertStringToListString(final String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static BridgeGameStatus statusNext(BridgeGameStatus gameStatus, BridgeGameContext context) {
        return gameStatus.next(context, new InputView(), new OutputView());
    }
}
