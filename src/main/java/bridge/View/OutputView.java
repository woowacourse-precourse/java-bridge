package bridge.View;

import bridge.Controller.BridgeController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static List<String> result = new ArrayList<String>();

    public static final String VALID_NUMERIC_FORMAT = "[1-2]?\\d";
    private static final String Retry = "Retry";
    private static final String SuccessSignal = "S";
    private static final String Move = "Move";
    private static final String error = "[ERROR] ";
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
    private static final String yes = "O";
    private static final String no = "X";
    private static final String up = "U";
    private static final String down = "D";
    private static final String left = "[ ";
    private static final String mid = " | ";
    private static final String right = " ]";
    private static final String empty = " ";

    private static final String last = "최종 게임 결과";

    public static void printStart() {
        System.out.println(start);
    }

    public static int BridgeLengthCheck(String val) {
        return PrintLenError(toInt(val));
    }

    private static int PrintLenError(int len) throws IllegalArgumentException {
        if (len >= 3 && len <= 20) {
            return len;
        }
        throw new IllegalArgumentException(error + LenError);
    }

    private static int toInt(String val) throws IllegalArgumentException {
        if (!val.matches(VALID_NUMERIC_FORMAT)) {
            throw new IllegalArgumentException(error);
        }
        return Integer.parseInt(val);
    }

    public static String MovingCheck(String moving) throws IllegalArgumentException {
        if (!MovingCheck.contains(moving)) {
            throw new IllegalArgumentException(error + MovingError);
        }
        return moving;
    }

    public static String RetryCheck(String retry) throws IllegalArgumentException {
        if (!ReQuCheck.contains(retry)) {
            throw new IllegalArgumentException(error + RetryQuitError);
        }
        return retry;
    }

    public static void printCount(String result, int count_try) {
        printResult();
        if (result.contains(SuccessSignal)) {
            PrintSorF(success, count_try);
            return;
        }
        PrintSorF(failure, count_try);
    }

    private static void PrintSorF(String result, int count_try) {
        System.out.println(end + result);
        System.out.println(count + count_try);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String printMap(String res, String moving) {
        loadingMap(res, moving);
        Map();
        if (res.equals(yes)) {
            return Move;
        }
        return Retry;
    }

    public static void MapReset() {
        result.clear();
    }

    private static void loadingMap(String res, String moving) {
        if (moving.equals(up)) {
            storeMap(res, up);
            return;
        }
        storeMap(res, down);
    }

    private static void storeMap(String res, String signal) {
        if (res.equals(yes)) {
            result.add(yes + signal);
            return;
        }
        result.add(no + signal);
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
        Mapping(up);
        Mapping(down);
        System.out.println();
    }

    private static void Mapping(String signal) {
        System.out.print(left);

        for (int i = 0; i < result.size(); i++) {
            if (i != 0) System.out.print(mid);
            if (result.get(i).contains(signal)) {
                System.out.print(result.get(i).charAt(0));
                continue;
            }
            System.out.print(empty);
        }

        System.out.println(right);
    }
}