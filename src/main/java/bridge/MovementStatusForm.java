package bridge;

public enum MovementStatusForm {
    UP_O(true),
    UP_X(false),
    DOWN_O(true),
    DOWM_X(false);

    private final boolean isPass;

    MovementStatusForm(boolean isPass) {
        this.isPass = isPass;
    }

    public static MovementStatusForm createPassCaseByCode(String movement_command){
        if(Site.UP.isSameCommand(movement_command)){
            return UP_O;
        }
        return DOWN_O;
    }

    public static MovementStatusForm createWrongCaseByCode(String movement_command){
        if(Site.UP.isSameCommand(movement_command)){
            return UP_X;
        }
        return DOWM_X;
    }

    public static boolean isPassCase(MovementStatusForm movementStatusForm){
        return movementStatusForm.isPass;
    }

}
