package bridge.DTO;

public class MoveCommandDTO {
    private String moveCommande;

    public MoveCommandDTO(String inputMoveCommande){
        this.moveCommande = inputMoveCommande;
    }

    public String getMoveCommande(){
        return moveCommande;
    }
}
