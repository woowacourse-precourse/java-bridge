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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String whether, String count) {
        System.out.println(GAME_RESULT.print(whether, count));
    }
}
