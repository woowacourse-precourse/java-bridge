package bridge.View;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static List<Integer> result = new ArrayList<>();

    private static final String error = "[ERROR]";
    private static final String LenError = "다리 길이는 3부터 20사이의 숫자여야 합니다.";

    private static final String MovingCheck = "UD";
    private static final String MovingError = "U 또는 D로만 다리를 건널 수 있습니다.";

    private static final String ReQuCheck = "RQ";
    private static final String RetryQuitError = "R 또는 Q로만 게임을 제어할 수 있습니다.";
    private static final String start = "다리 건너기 게임을 시작합니다.";
    private static final String end = "게임 성공 여부: ";
    private static final String count = "총 시도한 횟수: ";
    private static final String success = "성공";
    private static final String failure = "실패";

    private static final String last = "최종 게임 결과";

    public static void printStart() { System.out.println(start); }

    public static int BridgeLengthCheck(String val) {
        int len = toInt(val);
        if (len < 3 || len > 20)
            System.out.println(error + LenError);
        return len;
    }

    private static int toInt(String val) {
        try {
            return Integer.parseInt(val);
        }
        catch (NumberFormatException e) {
            System.out.println(error + e);
            return 0;
        }
    }

    public static String MovingCheck(String moving){
        if (!MovingCheck.contains(moving))
            System.out.println(error + MovingError);
        return moving;
    }

    public static String RetryCheck (String retry) {
        if (!ReQuCheck.contains(retry))
            throw new IllegalArgumentException(error + RetryQuitError);
        return retry;
    }

    public static void printCount(int result, int count_try) {
        printResult();
        if (result == 1) {
            System.out.println(end + success);
            System.out.println(count + count_try);
            return;
        }
        System.out.println(end + failure);
        System.out.println(count + count_try);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static int printMap(String res, String moving) {
        loadingMap(res, moving);
        if (res.equals("O")){
            Map();
            return 2;
        }
        Map();
        return 3;
    }

    public static void MapReset(){
        result.clear();
    }

    private static void loadingMap(String res, String moving){
        if (moving.equals("U")){
            if (res.equals("X"))
                result.add(3);
            else
                result.add(1);
            return;
        }
        if (res.equals("X"))
            result.add(4);
        else
            result.add(2);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
        System.out.println(last);
        Map();
    }

    private static void Map() {
        System.out.print("[ ");
        for (int i = 0; i < result.size(); i++){
            if (i != 0) System.out.print(" | ");
            if (result.get(i) == 1) System.out.print("O");
            else if (result.get(i) == 3) { System.out.print("X"); }
            else System.out.print(" ");
        }
        System.out.println(" ] ");

        System.out.print("[ ");
        for (int i = 0; i < result.size(); i++){
            if (i != 0) System.out.print(" | ");
            if (result.get(i) == 2) System.out.print("O");
            else if (result.get(i) == 4) { System.out.print("X"); }
            else System.out.print(" ");
        }
        System.out.println(" ] ");
        System.out.println();
    }
}
