package bridge;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static String RESULT_SUCCESS = "성공";
    public static String RESULT_FAIL = "실패";
    public static int BRIDGE_SIZE;
    public static int CURRENT_LOCATION;

    public void printMap(List moveCourse) {

    }

    public void printResult(int currentLocation, int retryCount) {
        InputView inputView = new InputView();
        BRIDGE_SIZE = inputView.bridgeSize();
        CURRENT_LOCATION = currentLocation;

        System.out.print("게임 성공 여부: " );
        if (CURRENT_LOCATION == BRIDGE_SIZE) {
            System.out.println(RESULT_SUCCESS);
        } else {
            System.out.println(RESULT_FAIL);
        }

        System.out.println("총 시도한 횟수: "  + retryCount);

    }
}