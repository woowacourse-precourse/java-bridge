package bridge;

import bridge.domain.NewGame;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new NewGame();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e);
        }
    }
}
