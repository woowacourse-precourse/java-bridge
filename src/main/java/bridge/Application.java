package bridge;


import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> map = new ArrayList<>(asList(" ", "X"," ","O"));
        OutputView.printMap(map);
    }
}
