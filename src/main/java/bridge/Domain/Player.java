package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> moves;

    public Player(){
        moves = new ArrayList<>();
    }

    public void move(String moveTo){
        moves.add(moveTo);
    }

    public void clearMoves(){
        moves.clear();
    }

    public boolean isMovable(int bridgeSize, String bridgeIndexOf){
        if(moves.size() == 0){
            return true;
        }

        return moves.size() < bridgeSize && compare(bridgeIndexOf);
    }

    public boolean isSuccess(int bridgeSize, String bridgeIndexOf){
        return moves.size() == bridgeSize && compare(bridgeIndexOf);
    }

    public boolean compare(String bridgeIndexOf){
        return moves.get(getMovesLastIndex()).equals(bridgeIndexOf);
    }

    public int getMovesLastIndex(){
        return moves.size() - 1;
    }

    public int getMovesCount(){
        return moves.size();
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

}
