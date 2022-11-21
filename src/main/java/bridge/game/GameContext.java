package bridge.game;

import static bridge.game.State.PLAYING;

public class GameContext {
    private int retryCnt;
    private State state;

    public GameContext(){
        retryCnt = 1;
        state = PLAYING;
    }

    public void increaseRetry(){
        retryCnt++;
    }

    public void transition(String cmd){
        state = state.transitionTo(cmd);
    }

    public int getRetryCnt() {
        return retryCnt;
    }

    public boolean isPlaying() {
        return state == PLAYING;
    }
}
