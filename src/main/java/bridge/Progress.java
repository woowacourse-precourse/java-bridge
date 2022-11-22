package bridge;

/**
 * 게임 중도 실패 시 진행 여부 커맨드 관리
 */
public enum Progress {
    RETRY("R"),
    QUIT("Q");

    private String command;

    Progress(String command) {
        this.command = command;
    }

    public String toString() {
        return command;
    }
}
