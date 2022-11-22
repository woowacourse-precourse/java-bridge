package controller;

import bridge.model.GameEnd;
import bridge.model.RetryDTO;
import bridge.util.OutputView;


public class RetryController {

    public RetryDTO retryConfig(RetryDTO retryDTO, OutputView outputView){
        retryDTO.viewClear.viewClear(outputView);
        retryDTO.TRY_COUNT++;
        retryDTO.RESULT_CONDITION=GameEnd.SUCCESS.toString();
        retryDTO.GAME_RESULT="";

        return retryDTO;
    }
}
