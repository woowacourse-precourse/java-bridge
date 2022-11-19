package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GamePlay gamePlay = new GamePlay();
        try {
            gamePlay.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
