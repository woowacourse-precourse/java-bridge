package bridge;

public class Application {

    public static void main(String[] args) {
        final ContextFactory contextFactory = new ContextFactory();
        final BridgeGameStarter bridgeGameStarter = contextFactory.getBridgeGameStarter();
        bridgeGameStarter.run();
    }
}
