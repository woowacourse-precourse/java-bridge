package bridge;

public class GameContext {
    private static final int QUIT = 1;
    private static final int PLAYING = 2;

    private int retryCnt;
    private int state;

    public GameContext(){
        retryCnt = 1;
        state = PLAYING;
    }

    public void increaseRetry(){
        retryCnt++;
    }

    public void transition(){
        state = QUIT;
    }

    public int getRetryCnt() {
        return retryCnt;
    }

    public boolean isPlaying() {
        return state == PLAYING;
    }
}
