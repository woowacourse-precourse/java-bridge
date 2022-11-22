package bridge.view;

import java.util.List;
import java.util.Stack;

public class OutputView {
    public static final String FINAL_GAME_RESULT = "\n최종 게임 결과";
    public static final String GAME_SUCCESS_STATUS = "\n게임 성공 여부: ";
    public static final String TOTAL_ATTEMPTS_NUM = "총 시도한 횟수: ";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    public static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String ENTER_LENGTH = "\n다리의 길이를 입력해주세요.";
    public static final String SELECT_MOVING_SPACE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String RETRY_STATUS = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    public void printMap(List<Stack> stairs) {
        for (Stack stair : stairs) {
            for (Object o : stair) {
                System.out.print(o + "");
            }
            System.out.println();
        }
    }

    public void printResult(List<Stack> stairs, int runCnt, boolean isSuccess) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(stairs);
        String success = convertBooleanToStr(isSuccess);
        System.out.println(GAME_SUCCESS_STATUS + success);
        System.out.println(TOTAL_ATTEMPTS_NUM + runCnt);
    }

    private String convertBooleanToStr(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        if (!isSuccess) {
            return FAIL;
        }
        throw new IllegalArgumentException("잘못된 입력 값입니다.");
    }

    public void printStart() {
        System.out.println(START_GAME);
        System.out.println(ENTER_LENGTH);
    }

    public void printPlay() {
        System.out.println(SELECT_MOVING_SPACE);
    }

    public void printRetry() {
        System.out.println(RETRY_STATUS);
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
