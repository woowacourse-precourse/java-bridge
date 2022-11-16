package bridge;

@FunctionalInterface
public interface
BridgeNumberGenerator {

    int generate();

    InputView input = new InputView();
    int bridgeLength = input.readBridgeSize();

}
