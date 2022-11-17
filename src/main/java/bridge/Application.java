package bridge;

public class Application {
    private final static ContextFactory contextFactory = new ContextFactory();
    private final static BridgeGameStarter bridgeGameStarter = contextFactory.getBridgeGameStarter();
    private static int tryCount = 1;
    public static void main(String[] args) {
        try {
            bridgeGameStarter.initialize();
            boolean retryFlag = bridgeGameStarter.run();
            while (retryFlag) {
                bridgeGameStarter.reInitialize();
                retryFlag = bridgeGameStarter.run();
                tryCount ++;
            }
            bridgeGameStarter.closeGame(tryCount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
