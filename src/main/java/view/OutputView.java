package view;

import dto.BridgeDto;
import dto.ResultDto;
import java.util.List;

public class OutputView {
    private static final String START_GAME = "다리 건너기 게임을 시작합니다.\n";
    public static final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String LINE_CHANGE = "\n";
    public static String ENTER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String ENTER_RESTART = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static String FINAL_RESULT = "\n최종 게임 결과";
    public static final String SUCCESS_OR_NOT = "\n게임 성공 여부: ";
    public static final String TOTAL_TRIAL = "\n총 시도한 횟수: ";
    public static final String LINE_START = "[";
    public static final String CORRECT = " O ";
    public static final String MISS = " X ";
    public static final String VERTICAL_BAR = "|";
    public static final String LINE_END = "]";
    public static final String ERROR = "[ERROR]";
    public static final String SPACE = "   ";
    public static final String FAIL = "실패";
    public static final String SUCCESS = "성공";
    public static boolean rightAfterFail = false;

    public void printStart() {
        System.out.println(START_GAME);
    }

    public void printEnterBridgeSize() {
        System.out.println(BRIDGE_SIZE);
    }

    public void printEnterMove() {
        if (rightAfterFail) {
            System.out.println(ENTER_MOVE);
            rightAfterFail = false;
            return;
        }
        System.out.println(LINE_CHANGE + ENTER_MOVE);
    }

    public void printResult(BridgeDto bridgeDto, ResultDto resultDto) {
        List<Boolean> result = resultDto.result;
        if (result.contains(false)) {
            FINAL_RESULT = FINAL_RESULT.substring(1);
        }
        System.out.println(FINAL_RESULT);
        printMap(bridgeDto, resultDto);
    }
    public void printMap(BridgeDto bridgeDto, ResultDto resultDto) {
        List<String> answer = bridgeDto.bridge;
        List<Boolean> guess = resultDto.result;
        String target = "U";
        for (int row = 0; row <= 1; row++) {
            if (row == 1) {
                target = "D";
            }
            printSingleLine(answer, guess, target);
        }
    }
    private void printSingleLine(List<String> answer, List<Boolean> guess, String target) {
        System.out.print(LINE_START);
        for (int col = 0; col < guess.size(); col++) {
            String mark = decideMark(answer.get(col), guess.get(col), target);
            System.out.print(mark);
            if (col == guess.size() - 1) {
                System.out.println(LINE_END);
                break;
            }
            System.out.print(VERTICAL_BAR);
        }
    }
    private String decideMark(String answer, Boolean hit, String target) {
        if (answer.equals(target) && hit) {
            return CORRECT;
        }
        if (!answer.equals(target) && !hit) {
            return MISS;
        }
        return SPACE;
    }

    public void printReport(boolean result, int trial) {
        String judgement = FAIL;
        if (result) {
            judgement = SUCCESS;
        }
        System.out.printf(SUCCESS_OR_NOT + judgement);
        String totalTrial = Integer.toString(trial);
        System.out.print(TOTAL_TRIAL + totalTrial);
    }

    public void printRestart() {
        System.out.println(ENTER_RESTART);
    }

    public void printError(String error) {
        System.out.println(error);
    }
}
