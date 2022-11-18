package bridge;

import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        List<String> list = new ArrayList<>();
        IntStream.range(3,9).mapToObj(String::valueOf).forEach(list::add);
        System.out.println(list);
    }
}
