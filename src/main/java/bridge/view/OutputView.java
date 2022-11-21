package bridge.view;

import bridge.domain.Bridge;
import bridge.setting.Setting;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    // 게임 시작 메세지 출력 기능
    public void printWelcomeMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    // 다리의 길이를 입력하라는 메세지 출력 기능
    public void printInputBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    // 이동할 칸을 선택하라는 메세지 출력 기능
    public void printInputSpaceToMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    // Bridge 맵 출력
    public void printMap(Bridge bridge) {
        StringBuilder topRow = createSingleLineMap(bridge, Setting.MOVE_UP_KEY);
        StringBuilder bottomRow = createSingleLineMap(bridge, Setting.MOVE_DOWN_KEY);
        System.out.println(topRow);
        System.out.println(bottomRow+"\n");
    }

    // Bridge 맵 한줄 생성 기능
    private StringBuilder createSingleLineMap(Bridge bridge, String key) {
        StringBuilder row = new StringBuilder(Setting.BRIDGE_FIRST_LETTER);
        addMapToAnswerLetter(row, bridge, key);
        return row.append(Setting.BRIDGE_LAST_LETTER);
    }

    // Bridge 맵 한줄에 그릴 정답유무 문자 생성 기능
    private void addMapToAnswerLetter(StringBuilder row, Bridge bridge, String key) {
        for (int index = 0; index < bridge.getBridgeMap().length; index++) {
            addDelimiter(row, index);
            if (bridge.getUserKeyListIndex(index).equals(key)) {
                row.append(bridge.getBridgeMap()[index]);
                continue;
            }
            row.append(Setting.WRONG_ANSWER_LETTER);
        }
    }

    // 구분자 더하기
    private void addDelimiter(StringBuilder row, int index) {
        if (index > 0) {
            row.append(Setting.DELIMITER);
        }
    }

    // 에러메세지 출력 기능
    public void printErrorMessage(IllegalArgumentException error) {
        System.out.println(error.getMessage());
    }

    // 게임을 다시 시도할지 여부를 입력하라는 메세지 출력 기능
    public void printInputRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    // 최종 게임 결과 안내 메세지 출력 기능
    public void printResultMessage() {
        System.out.println("최종 게임 결과");
    }

    // 공백 출력 기능
    public void printEmpty() {
        System.out.println();
    }

    // 총 시도한 횟수 출력 기능
    public void printNumberOfAttempts(Bridge bridge) {
        System.out.println("총 시도한 횟수: " + bridge.getNumberOfAttempts());
    }

    // 게임 성공 여부 출력 기능
    public void printResult(Bridge bridge) {
        if (bridge.isBridgeEnd() && bridge.isAnswer()) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }
        System.out.println("게임 성공 여부: 실패");
    }
}
