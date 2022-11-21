package bridge.view;

import bridge.constant.PrintMessage;
import java.util.List;

public class OutputView {
    public void printMap(List<String> map) {
        int mid = map.size() / 2;
        List<String> upperMap = map.subList(0, mid);
        List<String> lowerMap = map.subList(mid, map.size());
        printHalfMap(upperMap);
        printHalfMap(lowerMap);
        System.out.println();
    }

    private void printHalfMap(List<String> halfMap) {
        System.out.println(String.format(PrintMessage.MAP_FORMAT.getString(),
                String.join(PrintMessage.MAP_SEPARATOR.getString(), halfMap)));
    }

    public void printResult(boolean isSuccess, List<String> map, int trials) {
        PrintMessage resultInKor = PrintMessage.FAIL_IN_KOR;
        if (isSuccess) {
            resultInKor = PrintMessage.SUCCEED_IN_KOR;
        }
        System.out.println(PrintMessage.RESULT_MAP.getString());
        printMap(map);
        System.out.printf(PrintMessage.RESULT_IS_SUCCESS.getString(), resultInKor.getString());
        System.out.printf(PrintMessage.RESULT_TRIALS.getString(), trials);
    }
}
