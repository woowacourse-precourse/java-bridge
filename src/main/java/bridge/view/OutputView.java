package bridge.view;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.view.OutputViewString.*;

public class OutputView {

    public static void startMessage(){
        System.out.println(START_MESSAGE.print());
    }

    public static void printMap(List<List<String>> bridgeCrossingResult){
        for (int i = 0; i < bridgeCrossingResult.size(); i++){
            System.out.println(bridgeCrossingResult.get(i).stream()
                    .collect(Collectors.joining(" | ", "[ ", " ]")));
        }
    }

    public static void printResult(String whether, String count) {
        System.out.println(GAME_RESULT.print(whether, count));
    }

    public static void endMessage(){
        System.out.println(END_MESSAGE.print());
    }
}
