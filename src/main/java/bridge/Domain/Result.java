package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> moves;
    private boolean isSuccess;
    private int tryCount;

    public Result(){
        moves = new ArrayList<>();
        isSuccess = false;
        tryCount = 1;
    }

    public void move(String moveTo){
        moves.add(moveTo);
    }

    public void clearMoves(){
        moves.clear();
    }

    public void addTryCount(){
        tryCount++;
    }

    public boolean isMovable(int bridgeSize, String bridgeIndexOf){
        if(moves.size() == 0){
            return true;
        }

        return moves.size() < bridgeSize && compare(bridgeIndexOf);
    }

    public boolean isSuccess(int bridgeSize, String bridgeIndexOf){
        return isSuccess = moves.size() == bridgeSize && compare(bridgeIndexOf);
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

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }
}
