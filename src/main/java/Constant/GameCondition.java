package Constant;

public enum GameCondition {
    ENDING();


    private final String[] ending = {"성공","실패"};
    GameCondition(){

    }
    public String getEnding(boolean cond){
        if(cond){
            return ending[0];
        }
        return ending[1];
    }
}
