package bridge;

public class Application {

    public static void main(String[] args) {
        final ContextFactory contextFactory = new ContextFactory();
        final BridgeGameStarter bridgeGameStarter = contextFactory.getBridgeGameStarter();
        try {
            bridgeGameStarter.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
