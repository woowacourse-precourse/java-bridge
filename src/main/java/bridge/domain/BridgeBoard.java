package bridge.domain;

import java.util.ArrayList;

public class BridgeBoard {

    private static ArrayList<String> upBoard = new ArrayList<>();
    private static ArrayList<String> downBoard = new ArrayList<>();

    public BridgeBoard(){
        this.upBoard = new ArrayList<>();
        this.downBoard = new ArrayList<>();
    }

    public void addMove(String input,String result){
        if(input.equals("U")){
            addUpMove(result);
            return;
        }
        addDownMove(result);
    }

    private void addUpMove(String result){
        upBoard.add(result);
        downBoard.add(" ");
    }

    private void addDownMove(String result){
        downBoard.add(result);
        upBoard.add(" ");

    }

    public void addWall(){
        downBoard.add("|");
        upBoard.add("|");
    }

    public String showUpBoard(){
        return String.join(" | ", upBoard);
    }

    public String showDownBoard(){
        return String.join(" | ", downBoard);
    }

}
