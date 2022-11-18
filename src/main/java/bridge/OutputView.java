package bridge;

import java.util.List;
import java.util.Objects;

public class OutputView {

    public void printMap(List<List<String>> userPlaying) {
        System.out.println(printLoop(userPlaying, "U"));
        System.out.println(printLoop(userPlaying, "D"));


    }

    public String printLoop(List<List<String>> userPlaying, String bridgeLocate) {
        StringBuilder upPrint = new StringBuilder("[");
        for (int i = 0; i< userPlaying.size(); i++) {
            if (i != 0)
                upPrint.append("|");
            upPrint.append(printContent(userPlaying.get(i), bridgeLocate));
        }
        upPrint.append("]");
        return upPrint.toString();
    }

    public String printContent(List<String> currentPlaying, String bridgeLocate) {
        if (Objects.equals(currentPlaying.get(0), bridgeLocate))
            return " " + currentPlaying.get(1) + " ";
        return "   ";
    }

    public void printResult(String isSuccess, int tryCount, List<List<String>> userPlaying) {
        System.out.println("최종 게임 결과");
        printMap(userPlaying);
        System.out.println("게임 성공 여부: " + isSuccess);
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
