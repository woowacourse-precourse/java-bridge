package bridge;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static final String BLANK = " ";
    /**
     * 사용자가 진행한 모든 게임의 결과를 저장하는 리스트
     */
    private Game result;
    /**
     * 현재 진행 중인 게임을 저장하는 리스트
     */
    private Game game;


    public Game getGame() {
        return game;
    }
    public void init(){
        game = new Game();
    }
    public void write(String direction, String answer){
        if (direction.equals("U")){
            game.getPlaying().get(0).add(answer);
            game.getPlaying().get(1).add(BLANK);
            return;
        }
        game.getPlaying().get(1).add(answer);
        game.getPlaying().get(0).add(BLANK);
    }

    public void save(){
        if (result.getLocation() < game.getLocation()) {
            result = game;
        }
    }
}
