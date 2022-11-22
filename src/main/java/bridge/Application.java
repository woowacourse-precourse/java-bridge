package bridge;

import bridge.domain.Referee;

public class Application {
    public static void main(String[] args) {
        Referee referee = new Referee();
        referee.start();
    }
}
