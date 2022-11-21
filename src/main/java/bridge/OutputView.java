package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_PHRASES = "다리 건너기 게임을 시작합니다.";
    private static final String ASK_LENGTH_PHRASES = "다리의 길이를 입력해주세요.";
    private static final String ASK_MOVING_PHRASES = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final List<StringBuilder> map;

    public OutputView() {
        map = List.of(new StringBuilder(), new StringBuilder());
    }

    /**
     * 게임이 시작할 때의 문구를 출력한다.
     */
    public void printStartPhrases() {
        System.out.println(START_PHRASES);
        System.out.println();
    }

    /**
     * 다리 길이를 요구하는 문구를 출력한다.
     */
    public void printAskLengthPhrases() {
        System.out.println(ASK_LENGTH_PHRASES);
    }

    /**
     * 이동에 대한 입력을 요구하는 문구를 출력한다.
     */
    public void printAskMovingPhrases() {
        System.out.println(ASK_MOVING_PHRASES);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * @param bridge 기존 다리의 상태
     * @param inputs 현재까지 이동한 사용자의 입력
     */
    public void printMap(List<String> bridge, List<String> inputs) {
        buildMap(bridge, inputs);
        System.out.println(map.get(VerticalPositionValue.UP.getNumber()).toString());
        System.out.println(map.get(VerticalPositionValue.DOWN.getNumber()).toString());
    }

    /**
     * 사용자에게 보여줄 다리의 출력물을 만든다.
     *
     * @param bridge 기존 다리의 상태
     * @param inputs 현재까지 이동한 사용자의 입력
     */
    private void buildMap(List<String> bridge, List<String> inputs) {
        int size = inputs.size();
        deleteMap();
        buildPrefixMap();
        for (int i = 0; i < size; ++i) {
            String sign = judgeSign(bridge.get(i), inputs.get(i));
            int position = judgePrintingPosition(inputs.get(i));
            appendSignCorrectPosition(sign, position);
            buildPostfixMap(size, i);
        }
    }

    /**
     * 다리 상태 출력시 가장 앞에 나오는 것을 생성한다.
     */
    private void buildPrefixMap() {
        StringBuilder upperLine = map.get(VerticalPositionValue.UP.getNumber());
        StringBuilder lowerLine = map.get(VerticalPositionValue.DOWN.getNumber());
        upperLine.append("[ ");
        lowerLine.append("[ ");
    }

    /**
     * 다리 상태 출력시 각 단계별 출력물을 생성한다.
     */
    private void buildPostfixMap(int size, int i) {
        StringBuilder upperLine = map.get(VerticalPositionValue.UP.getNumber());
        StringBuilder lowerLine = map.get(VerticalPositionValue.DOWN.getNumber());
        if (i == size - 1) {
            upperLine.append(" ]");
            lowerLine.append(" ]");
            return ;
        }
        upperLine.append(" | ");
        lowerLine.append(" | ");
    }

    /**
     * 기존의 다리 상태를 초기화한다.
     */
    private void deleteMap() {
        StringBuilder upperLine = map.get(VerticalPositionValue.UP.getNumber());
        StringBuilder lowerLine = map.get(VerticalPositionValue.DOWN.getNumber());
        upperLine.delete(0, upperLine.length());
        lowerLine.delete(0, lowerLine.length());
    }

    /**
     * 문자 두 개를 비교하여 맞는지 틀린지를 알리는 문자를 반환한다.
     * 
     * @param str1 비교할 첫번째 문자
     * @param str2 비교할 두번째 문자
     * @return 두 문자가 같으면 "O" 다르면 "X"를 반환
     */
    private String judgeSign(String str1, String str2) {
        if (str1.equals(str2)) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자의 입력 값으로 출력 위치를 선택한다.
     *
     * @param input 사용자의 입력 값
     * @return 입력 값이 "U"일 경우 0을 반환, "D"일 경우 1을 반환
     */
    private int judgePrintingPosition(String input) {
        if (input.equals(VerticalPositionValue.UP.getSign())) {
            return VerticalPositionValue.UP.getNumber();
        }
        return VerticalPositionValue.DOWN.getNumber();
    }

    /**
     * 출력할 문자를 적합한 위치에 추가한다.
     *
     * @param sign 중간에 출력할 문자
     * @param position 출력할 위치
     */
    private void appendSignCorrectPosition(String sign, int position) {
        StringBuilder upperLine = map.get(VerticalPositionValue.UP.getNumber());
        StringBuilder lowerLine = map.get(VerticalPositionValue.DOWN.getNumber());
        if (VerticalPositionValue.UP.getNumber().equals(position)) {
            upperLine.append(sign);
            lowerLine.append(" ");
            return ;
        }
        upperLine.append(" ");
        lowerLine.append(sign);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
