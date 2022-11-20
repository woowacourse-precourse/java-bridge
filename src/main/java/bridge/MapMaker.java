package bridge;// @ author ninaaano

import bridge.view.MapView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MapMaker {
    StringBuilder upState = new StringBuilder();
    StringBuilder downState = new StringBuilder();

    private Queue<String> bridge;

    public MapMaker() {
        this.bridge = new LinkedList<>(bridge);
    }

    public List<String> printMap(){
        return List.of("[ "+upState+" ]","[ "+downState+" ]");
    }

    public void addMapO(String input){
        if(input.equals("U")){
            upState.append(MapView.MAP_O);
            upState.append(MapView.MAP_BLANK);
        }
        if(input.equals("D")){
            downState.append(MapView.MAP_BLANK);
            downState.append(MapView.MAP_O);
        }
    }

    public void addMapX(String input){
        if(input.equals("U")){
            upState.append(MapView.MAP_BLANK);
            upState.append(MapView.MAP_X);
        }
        if(input.equals("D")){
            downState.append(MapView.MAP_X);
            downState.append(MapView.MAP_BLANK);
        }
    }

    public void addMap(boolean answer){
        if(upState.length() != 0 && downState.length() != 0){
            upState.append(MapView.MAP_MIDDLE);
            downState.append(MapView.MAP_MIDDLE);
        }
        if(answer)
            addMapO(bridge.remove());
        if(!answer)
            addMapX(bridge.remove());
    }

}
