package bridge.view;

import bridge.dto.BridgeDto;
import bridge.dto.ResultDto;
import java.util.List;

public class OutputView {
    private final String START_GAME = "다리 건너기 게임을 시작합니다.\n";
    private final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String LINE_CHANGE = "\n";
    private final String ENTER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String ENTER_RESTART = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private String FINAL_RESULT = "\n최종 게임 결과";
    private final String SUCCESS_OR_NOT = "\n게임 성공 여부: ";
    private final String TOTAL_TRIAL = "\n총 시도한 횟수: ";
    private final String LINE_START = "[";
    private final String CORRECT = " O ";
    private final String MISS = " X ";
    private final String VERTICAL_BAR = "|";
    private final String LINE_END = "]";
    private final String SPACE = "   ";
    private final String FAIL = "실패";
    private final String SUCCESS = "성공";
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
