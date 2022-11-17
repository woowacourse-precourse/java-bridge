package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    boolean survival;
    char[][] log;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String answer, String submit ) {
        survival = answer.equals(submit);
        creatingLog(submit);
    }

    private void creatingLog(String submit) {
        int lengthOfLog = log.length;
        char[][] tempLog = new char[2][lengthOfLog + 1];
        for (int i = 0; i <lengthOfLog ; i++) {
            tempLog[i] = log[i];
        }

        if (submit.equals("U")) {
            tempLog[0][lengthOfLog] = Life.heIsSurvive(survival);
            tempLog[1][lengthOfLog] = ' ';
        } else if (submit.equals("D")) {
            tempLog[1][lengthOfLog] = Life.heIsSurvive(survival);
            tempLog[0][lengthOfLog] = ' ';
        }

        log = tempLog;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
enum Life {
    Alive('O', true),
    Dead('X', false);
    char deadOrAlive;
    boolean survival;


    Life(char deadOrAlive, boolean survival) {
        this.deadOrAlive = deadOrAlive;
        this.survival = survival;
    }

    static char heIsSurvive(boolean survival) {
        if (survival) {
            return Alive.deadOrAlive;
        }
        return Dead.deadOrAlive;
    }

}