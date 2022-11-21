### 기능 목록

---
* 핵심 로직 기능
  * 다리를 생성하는 기능 - (BridgeMaker.makeBridge)
     * 랜덤값을 발생시켜 칸을 추가하는 기능 - (BridgeMaker.generateNumAndAddBoxToBridge)
  * 플레이어가 입력한 칸으로 이동하는 기능 - (BridgeGame.move)
  * 다리를 끝까지 건너면 게임을 종료시키는 기능
  * 플레이어의 입력에 따라 게임을 재시작, 종료시키는 기능
   
* 입출력 기능
  * 플레이어가 다리 길이를 입력하는 기능 - (InputView.readBridgeSize)
  * 플레이어가 이동할 칸을 입력하는 기능 - (InputView.readMoving)
  * 이동한 결과를 출력하는 기능
  * 다리를 건너다 실패하면 플레이어가 재시작, 종료 여부를 입력하는 기능
  * 최종 게임 결과 출력하는 기능
  * 게임 성공 여부 출력하는 기능
  * 시도한 총 횟수를 출력하는 기능

### 검증 & 예외 처리 목록

---
* 핵심 로직 검증
  * 생성된 랜덤값이 0 또는 1인지 검증 - (BridgeMakerValidation.validateGeneratedNumValue)
      * ex) 랜덤값이 3인 경우 -> 예외처리
      
  * 랜덤값에 대응하는 칸이 추가되는지 검증 - (BridgeMakerValidation.validateCorrespondingBoxAddedToBridge)
      * ex) 랜덤값이 0일 때 다리에 위 칸이 추가될 경우 -> 예외처리
      
  * 이동 가능한 칸으로 이동했는지 검증 - (BridgeGameValidation.validateMoveWhenAvailable)
      * ex) 위 칸으로 이동해야하는 차례에 아무 칸으로도 이동하지 않은 경우 -> 예외처리
      
  * 이동 불가능한 칸으로 이동하지 않았는지 검증 - (BridgeGameValidation.validateNotMoveWhenUnavailable)
      * ex) 위 칸으로 이동해야하는 차례에 아래 칸으로 이동한 경우 -> 예외처리
      
  * 플레이어가 입력한 다리 길이와 생성된 다리의 길이가 동일한지 검증
      * ex) 둘의 길이가 다를 경우 -> 예외처리

* 입출력 검증
   * 다리 길이가 숫자로 입력되었는지 검증 - (ReadBridgeSizeValidation.validateInputIsInteger)
      * ex) input = a -> 예외처리
      
   * 다리 길이 입력 범위 검증(3 ~ 20) - (ReadBridgeSizeValidation.validateSizeRange)
      * ex) input = 21 -> 예외처리
       
   * 이동할 칸 입력 형식 검증(D, U) - (ReadMovingValidation.validateInputFormat)
      * ex) input = a -> 예외처리
      
   * 재시작, 종료 여부 입력 형식 검증(R, Q)
      * ex) input = a -> 예외처리
