package bridge.domain;

import java.util.ArrayList;

public class BridgeBoard {

    private static ArrayList<String> upBoard = new ArrayList<>();
    private static ArrayList<String> downBoard = new ArrayList<>();

    public BridgeBoard(){
        this.upBoard = new ArrayList<>();
        this.downBoard = new ArrayList<>();
    }

    private void addMove(String input,String result){
        if(input =="U"){
            addUpMove(result);
            return;
        }
        addDownMove(result);
    }

    private void addUpMove(String result){
        upBoard.add(" "+result);
        downBoard.add("  ");
    }

    private void addDownMove(String result){
        downBoard.add(" "+result);
        upBoard.add("  ");
    }

    private void addWall(){
        downBoard.add(" |");
        upBoard.add(" |");
    }

}
