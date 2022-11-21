package bridge.dto;

import bridge.model.entity.Player;

public class PlayerDto {

    private String answer;

    private PlayerDto(Player player) {
        this.answer = player.getAnswer();
    }

    public String getAnswer() {
        return this.answer;
    }

    public static PlayerDto of(Player player){
        return new PlayerDto(player);
    }

}
