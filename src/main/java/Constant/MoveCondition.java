package Constant;

public enum MoveCondition {
    SUCCESS(true),
    FAIL(false);
    private boolean cond;
    MoveCondition(boolean cond){
        this.cond=cond;
    }
    public boolean getCond(){
        return cond;
    }
}
