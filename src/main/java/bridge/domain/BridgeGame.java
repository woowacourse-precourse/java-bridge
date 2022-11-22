package bridge.domain;

import java.util.List;

public class BridgeGame {
    private int index;

    public BridgeGame(int index){
        this.index = index;
    }

    public boolean move(List<String> bridge, String readMoving) {
        if (bridge.get(index).equals(readMoving)){
            return (true);
        }
        return (false);
    }

    public void retry(List<String> bridge, int bridgeSize) {
        Game reGame = new Game(bridge, bridgeSize);
        reGame.start();
    }

    private void correctMove(String input, MapString mapString){
        if (input.equals("U")){
            mapString.setUpstairs("O");
            mapString.setDownstairs(" ");
            return ;
        }
        mapString.setUpstairs(" ");
        mapString.setDownstairs("O");
    }

    private void incorrectMove(String input, MapString mapString){
        if (input.equals("U")){
            mapString.setUpstairs("X");
            mapString.setDownstairs(" ");
            return ;
        }
        mapString.setUpstairs(" ");
        mapString.setDownstairs("X");
    }

    public MapString makeMap(String input, boolean move, MapString mapString){
        index++;
        if (move){
            correctMove(input, mapString);
            return (mapString);
        }
        incorrectMove(input, mapString);
        return (mapString);
    }

    public int getIndex(){
        return (this.index);
    }
}
