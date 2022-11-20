package Constant;

public enum GameCondition {
    Q(true),
    R(false);

    private boolean cond;
    GameCondition(boolean cond){
        this.cond=cond;
    }
    public boolean getCond(){
        return cond;
    }
}
