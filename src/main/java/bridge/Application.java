package bridge;

public class Application {
    private static final ContextFactory contextFactory = new ContextFactory();
    private static final BridgeGameStarter bridgeGameStarter = contextFactory.getBridgeGameStarter();

    public static void main(String[] args) {
        bridgeGameStarter.run();
    }
}
