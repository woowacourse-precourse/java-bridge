package view;

import dto.BridgeDto;
import dto.ResultDto;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없다.
 */
public class OutputView {
    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String ENTER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String ENTER_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String FINAL_RESULT = "최종 게임 결과";
    public static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
    public static final String TOTAL_TRIAL = "\n총 시도한 횟수: ";
    public static final String LINE_START = "[";
    public static final String CORRECT = " O ";
    public static final String MISS = " X ";
    public static final String SPACE = "|";
    public static final String LINE_END = "]";
    public static final String ERROR = "[ERROR]";

    public void printStart(){
        System.out.println(START_GAME);
    }

    public void printEnterBridgeSize(){
        System.out.println(BRIDGE_SIZE);
    }

    public void printEnterMove() {
        System.out.println(ENTER_MOVE);
    }

    private String decideMark(String answer, Boolean hit, String target) {
        if (answer.equals(target) && hit) {
            return CORRECT;
        }
        if (!answer.equals(target) && !hit) {
            return MISS;
        }
        throw new IllegalArgumentException(ERROR);
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
            System.out.print(SPACE);
        }
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

    public void printResult(BridgeDto bridgeDto, ResultDto resultDto) {
        System.out.println(FINAL_RESULT);
        printMap(bridgeDto, resultDto);
        // System.out.printf(SUCCESS_OR_NOT + "%b");
        // System.out.println(TOTAL_TRIAL + "%d");
    }

    public void printRestart(){
        System.out.println(ENTER_RESTART);
    }

    public void printError(String error){
        System.out.println(error);
    }
}
