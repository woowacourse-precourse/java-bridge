package bridge.game;

import static bridge.game.State.PLAYING;

/**
 * 전체 게임 현황 정보가 있는 클래스
 * <p>
 * - retryCnt : 총 시도한 횟수 (1이 default)
 * <p>
 * - state : PLAYING, QUIT_PLAYING (PLAYING이 default)
 */
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
