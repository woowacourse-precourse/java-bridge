package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.print("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        boolean again = true;

        while (again){
                List<List<String>> result;
            again = Boolean.parseBoolean(inputView.readGameCommand());
        }
    }
}
