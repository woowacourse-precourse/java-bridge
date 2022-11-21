package bridge.utils;

import bridge.domain.resources.ReOrQuit;
import bridge.domain.resources.UpOrDown;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.function.Function;
import java.util.stream.Stream;

public class UDRQInstanceBuilder {

    public static UpOrDown makeUDGlass(String inputUD, InputView inputView, OutputView outputView) {
        try {
            return nullCheckAndParse(inputUD, UpOrDown::of);
        } catch (IllegalArgumentException e) {
            outputView.printUDInputException();
            return makeUDGlass(inputView.readMoving(), inputView, outputView);
        }
    }

    public static ReOrQuit makeRQDecision(String inputRQ, InputView inputView, OutputView outputView) {
        try {
            return nullCheckAndParse(inputRQ, ReOrQuit::of);
        } catch (IllegalArgumentException e) {
            outputView.printRQInputException();
            return makeRQDecision(inputView.readGameCommand(), inputView, outputView);
        }
    }

    private static <T> T nullCheckAndParse(String inputUDRQ, Function<String, T> constructors) {
        InputChecker.nullCheck(inputUDRQ);
        return parse(inputUDRQ, constructors);
    }

    private static <T> T parse(String inputUDRQ, Function<String, T> constructors) {
        return Stream.of(inputUDRQ)
                .map(String::trim)
                .map(constructors)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
