package bridge;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_NOTICE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE_INPUT_NOTICE = "다리의 길이를 입력해주세요.";
    private static final String RESTART_OR_QUIT_INPUT_NOTICE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT_NOTICE = "최종 게임 결과";

    private static final String MOVING_DIRECTION_INPUT_NOTICE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public void printMap(List<String> map) {
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }
//
//    public String toMap(CharSequence result) {
//        String map = sperateByDelimiter(result, DELIMITER);
//        map = addBracket(map, PREFIX_BRACKET, SUFFIX_BRACKET);
//        return sperateByDelimiter(map, BLANK);
//
//    }
//
//    private void addHistory(StringBuilder top, StringBuilder bottom, String moving) {
//        if (moving.equals(Direction.Code.UP.getName())) {
//            top.append(SUCCESS_CODE);
//            bottom.append(BLANK);
//        }
//        if (moving.equals(Direction.Code.DOWN.getName())) {
//            top.append(BLANK);
//            bottom.append(SUCCESS_CODE);
//        }
//    }
//
//    private void checkResult(StringBuilder line, boolean didmove) {
//        int endIndex = line.length() - 1;
//        if (!didmove && String.valueOf(line.charAt(endIndex)).equals(SUCCESS_CODE)) {
//            line.replace(endIndex, endIndex + 1, FAIL_CODE);
//        }
//    }
//
//    public String sperateByDelimiter(CharSequence charSequence, String delimiter) {
//        StringJoiner stringJoiner = new StringJoiner(delimiter);
//        for (int i = 0; i < charSequence.length(); i++) {
//            stringJoiner.add(String.valueOf(charSequence.charAt(i)));
//        }
//        return stringJoiner.toString();
//    }
//
//    public String addBracket(CharSequence charSequence, String prefix, String suffix) {
//        return prefix + charSequence + suffix;
//    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> map, boolean hasWin, int tryCount) {
        printResultNotice();
        printMap(map);
        System.out.println("게임 성공 여부:");
    }

    public void printStartNotice() {
        System.out.println(START_NOTICE);
    }

    public void printBridgeSizeInputNotice() {
        System.out.println(BRIDGE_SIZE_INPUT_NOTICE);
    }

    public void printRestartOrQuitInputNotice() {
        System.out.println(RESTART_OR_QUIT_INPUT_NOTICE);
    }

    public void printResultNotice() {
        System.out.println(FINAL_RESULT_NOTICE);

    }

    public void printMovingDirectionInputNotice() {
        System.out.println(MOVING_DIRECTION_INPUT_NOTICE);

    }

    public void printNewLine() {
        System.out.println();
    }
}


