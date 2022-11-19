package bridge.model.entity;

public class Move {
    private String move;

    private Move(String move) {
        validate(move);
        this.move = move;
    }

    public String getMove(){
        return this.move;
    }
    private void validate(String move){
        //TODO: 예외 추후 구현 예정
    }

    public static Move of(String move){
        return new Move(move);
    }

}
