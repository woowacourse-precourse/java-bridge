package bridge.model;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/22
 */
public class GameStatus {
    private static GameStatus gameStatus; // 싱글톤 패턴 적용
    private boolean finish;     // 종료 여부
    private int attemptCount;   // 시도 횟수
    private boolean result;     // 승리 여부

    private GameStatus() {
        this.finish = false;
        this.attemptCount = 0;
        this.result = false;
    }

    public static GameStatus getInstance() {
        if(gameStatus == null) {
            synchronized(GameStatus.class)
            {
                gameStatus = new GameStatus();
            }
        }
        return gameStatus;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinishTrue() {
        this.finish = true;
    }

    public int getAttemptCount() {
        return this.attemptCount;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setResultSuccess() {
        this.result = true;
    }

    public void addAttemptCount() {
        this.attemptCount++;
    }

    public void reset() {
        this.finish = false;
        this.result = false;
    }
}
