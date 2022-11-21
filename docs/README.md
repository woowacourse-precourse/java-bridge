# 기능 요구 사항

 - [x] 사용자에게 다리 길이를 입력 받을 수 있다. InputView#readBridgeSize()
   - [x] 3 이상 20이하의 숫자를 입력할 수 있다. InputView#numberRange()
   - [x] 올바른 값이 아니면 예외 처리를 할 수 있다. InputView#checkNumber()
 

 - [x] 시도한 횟수를 셀 수 있다. Count# tryCount()


 - [x] 사용자에게 입력받은 다리 길이에 따라 다리를 만들 수 있다. BridgeMaker#makeBridge()
 

 - [x] 다리를 하나씩 구분할 수 있다. BridgeMaker#splitBridge()
 

 - [x] 다리는 위아래 두 칸으로 이루어져 있다. BridgeMaker#makeBridge()
    - [x] 0과 1 중 무작위 값을 이용해 정할 수 있다. BridgeMaker#putNumber()
    - [x] 0과 1이 아니면 예외처리를 할 수 있다. BridgeMaker#checkNumber()
    - [x] 0이면 다리를 D값으로 나타낼 수 있다. BridgeMaker#putText()
    - [x] 1이면 다리를 U값으로 나타낼 수 있다. BridgeMaker#putText()
    - [x] D,U값이 아니면 예외처리를 할 수 있다. BridgeMaker#checkText()


 - [x] 사용자에게 U와 D값을 입력받을 수 있다. InputView#readMoving()
   - [x] 다른 값을 입력받으면 예외처리를 할 수 있다. InputView#checkText()


 - [x] 게임 시도 여부를 입력 받을 수 있다. InputView#readGameCommand()
     - [x] 올바른 값이 아니면 예외 처리를 할 수 있다. InputView#checkGameCommand()


 - [ ] R을 누른다면 다시 시작한다. BridgeGame#retry()
 - [ ] Q를 누른다면 게임을 종료한다. BridgeGame#end()


 - [ ] 사용자의 값이 U인지 D인지 확인할 수 있다. 


 - [ ] 사용자가 칸을 이동할 수 있다. BridgeGame#move()
     - [ ] 시도한 횟수를 1 올릴 수 있다. BridgeGame#addTryCount()

 - [ ] 사용자의 값과 다리의 값을 비교할 수 있다. BridgeGame#CompareUserValue()
     - [ ] 같고 사용자의 값이 U라면 위칸에 O를 나타낼 수 있다. BridgeGame#correctValue()
     - [ ] 같고 사용자의 값이 D라면 아래칸에 O를 나타낼 수 있다. BridgeGame#correctValue()
     - [ ] 다르고 사용자의 값이 U라면 위칸에 X를 나타낼 수 있다 BridgeGame#wrongValue()
     - [ ] 다르고 사용자의 값이 D라면 아래칸에 X를 나타낼 수 있다. BridgeGame#wrongValue()


#입출력 요구 사항　

- [ ] 다리를 하나씩 나타낼 수 있다. OutputView#printMap()

- [ ] 게임 성공 여부를 나타낼 수 있다. OutputView#printResult()
    -[ ] 성공, 실패가 아닌 다른 단어가 나올 경우 예외 처리를 할 수 있다. OutputView#checkResult() 


- [ ] 시도 횟수를 나타낼 수 있다. OutputView#printTryCount()
  - [ ] 시도 횟수가 다리의 길이 보다 길 경우 예외 처리를 할 수 있다. OutputView#checkTryCount()  



