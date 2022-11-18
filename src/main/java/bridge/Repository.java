package bridge;

import bridge.domain.Game;

public class Repository {

    /**
     * 사용자가 진행한 모든 게임의 결과를 저장하는 리스트
     */
    private Game result;
    /**
     * 시도 횟수 저장
     */
    private int times;


    public Repository() {
        times = 0;
    }
    public Game getResult() {
        return result;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void save(Game game){
        if (result == null || result.getLocation() < game.getLocation()) {
            result = game;
        }
    }
}
