package bridge;// @ author ninaaano

import bridge.view.MapView;

public class MapMaker {
    StringBuilder upState = new StringBuilder();
    StringBuilder downState = new StringBuilder();

    public void printMap(){
        System.out.println("[ "+upState+" ]");
        System.out.println("[ "+downState+" ]");
    }

    public void addMap(String input){
        if(input.equals("U")){
            upState.append(MapView.MAP_O);
            upState.append(MapView.MAP_MIDDLE);
            upState.append(MapView.MAP_BLANK);
        }
        if(input.equals("D")){
            downState.append(MapView.MAP_O);
            downState.append(MapView.MAP_MIDDLE);
            downState.append(MapView.MAP_BLANK);
        }
    }

}
