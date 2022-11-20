package Constant;

public enum MoveCondition {
    SUCCESS(true),
    ARRIVE(true),
    FAIL(false),
    Q(false),
    R(true);

    private boolean cond;
    MoveCondition(boolean cond){
        this.cond=cond;
    }
    public boolean getCond(){
        return cond;
    }
}
