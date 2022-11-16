package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public boolean retry (List<String> passHistory) {
        OutputView output = new OutputView();
        InputView input = new InputView();

        output.printMap(passHistory);
        if (input.readGameCommand().equals("R")) {
            return true;
        }
        return false;
    }
}
