package bridge.infra.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import bridge.infra.dto.ReTryCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReTryCommandTest {

  @ParameterizedTest
  @ValueSource(strings = {"Z","K","HELLO"})
  void 게임재시작_요청이아닌_값이오면_에러가발생한다(String input){
    //게임재시작 요청 : R, 종료 : Q
    assertThatThrownBy(()-> new ReTryCommand(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"R","Q"})
  void 게임재시작요청을입력하면_성공한다(String input){
    ReTryCommand command = new ReTryCommand(input);
    assertThat(command.getSignal()).isEqualTo(input);
  }

  @Test
  void R요청시_재시작여부를판단할수_있다(){
    String givenSignal = "R";

    ReTryCommand command = new ReTryCommand(givenSignal);

    assertThat(command.isReTry()).isEqualTo(true);
  }
}