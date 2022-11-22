package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public boolean survival;
    public char[][] log;
    public checkTheEnd survivalStatus;

    public void move(String answer, String submit) {
        survival = answer.equals(submit);
        creatingLog(submit);
    }

    private void creatingLog(String submit) {
        int lengthOfLog = 0;
        if (log != null) {
            lengthOfLog = log[0].length;
        }
        char[][] tempLog = new char[2][lengthOfLog + 1];
        copyLog(lengthOfLog, tempLog);
        recordNow(submit, lengthOfLog, tempLog);
        log = tempLog;
    }

    private void copyLog(int lengthOfLog, char[][] tempLog) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < lengthOfLog; j++) {
                tempLog[i][j] = log[i][j];
            }
        }
    }

    private void recordNow(String submit, int lengthOfLog, char[][] tempLog) {
        if (submit.equals("U")) {
            tempLog[0][lengthOfLog] = Life.heIsSurvive(survival);
            tempLog[1][lengthOfLog] = ' ';
        } else if (submit.equals("D")) {
            tempLog[1][lengthOfLog] = Life.heIsSurvive(survival);
            tempLog[0][lengthOfLog] = ' ';
        }
    }


    public boolean retry(String input) {
        return Restart.gameRestart(input);
    }

    public void checkTheEndByBrideSize(int bridgeSize) {
        if(survival){
            if (log[0].length == bridgeSize) {
                survivalStatus = checkTheEnd.SUCCESS;
                return;
            }
            survivalStatus = checkTheEnd.RUNNING;
            return;
        }
        survivalStatus = checkTheEnd.FAILED;



    }
}

enum Restart {
    RESTART("R", true),
    END("Q", false);

    final String restartOrEnd;
    final boolean survival;


    Restart(String restartOrEnd, boolean survival) {
        this.restartOrEnd = restartOrEnd;
        this.survival = survival;
    }

    static boolean gameRestart(String restartOrEnd) {
        if (restartOrEnd.equals("R")) {
            return Restart.RESTART.survival;
        }
        return END.survival;
    }
}

enum Life {
    Alive('O', true),
    Dead('X', false);
    final char deadOrAlive;
    final boolean survival;


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