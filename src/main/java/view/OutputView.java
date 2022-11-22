package view;

import constant.Constant;
import constant.NoticeMessage;
import constant.StateCode;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println(NoticeMessage.GAME_START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Integer> record) {
        String map = mapToString(new StringBuilder("["), buildMap(record));
        System.out.println(map);
    }

    private String mapToString(StringBuilder stringBuilder, char[][] map) {
        for (int i = Constant.TOPSIDE; i <= Constant.DOWNSIDE; i++) {
            for (int j = 0; j < map.length; j++) {
                stringBuilder.append(String.format(" %c |", map[j][i]));
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1).append("]\n[");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private char[][] buildMap(List<Integer> record) {
        char[][] Map = initializeMap(record.size());
        for (int i = 0; i < record.size(); i++) {
            int currentRecord = record.get(i);
            Map[i][getRecordIndex(currentRecord)] = getRecordResult(currentRecord);
        }
        return Map;
    }

    private char[][] initializeMap(int mapLength) {
        char[][] Map = new char[mapLength][2];
        for (int i = 0; i < mapLength; i++) {
            Arrays.fill(Map[i], Constant.DEFAULT);
        }
        return Map;
    }

    private int getRecordIndex(int record) {
        if (record == StateCode.UP_CORRECT.getCode() || record == StateCode.DOWN_WRONG.getCode()) {
            return Constant.TOPSIDE;
        }
        return Constant.DOWNSIDE;
    }

    private char getRecordResult(int record) {
        if (record == StateCode.UP_CORRECT.getCode()
            || record == StateCode.DOWN_CORRECT.getCode()) {
            return Constant.RIGHT;
        }
        return Constant.WRONG;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Integer> record, String success, int trial) {
        System.out.println(NoticeMessage.GAME_OVER);
        printMap(record);
        System.out.println(String.format(NoticeMessage.RESULT_SUCCESS, success));
        System.out.println(String.format(NoticeMessage.RESULT_TRIAL, trial));
    }

}
