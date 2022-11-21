package bridge;


public class Application {

    public static void main(String[] args) {
        NumberGeneratorDependencyContainer numberGeneratorDependencyContainer = new NumberGeneratorDependencyContainerImpl();
        GamePlayer gamePlayer = new GamePlayer(numberGeneratorDependencyContainer);
        gamePlayer.playGame();
    }

}
