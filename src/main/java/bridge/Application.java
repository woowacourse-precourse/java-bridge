package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public boolean retry () {
        InputView input = new InputView();
        if (input.readGameCommand().equals("R")) {
            return true;
        }
        return false;
    }
}
