# 미션 - 다리 건너기

-[x] 예외처리 - class ExceptionBasket
  - [x] 입력값이 U나 D가 아닐경우 예외 처리 - invalidGameKey()
  - [x] 입력값이 R이나 Q가 아닐 경우 예외 처리 - invalidRetryRequestInputKey()
  - [x] 1 ~ 20 이외에는 예외 처리, 0100도 예외처리 - inputIsNotRangeException()
  - [x] 숫자이외의 수가 들어갈 경우 예외 처리 - inputIsNotNumberException()

-[ ] 유틸 - class Util
  - [x] 숫자인가? - isNumber()
  - [x] 문자인가? - isLetter()
  - [x] 한글자인가? - isOneLetter()
  - [x] 여러 글자인가? - isString()
  - [x] 1, 0을 U, D로 바꿈 - convertBridgenumberGenerator()

-[x] 사용자로부터 입력을 받는 역할을 한다. - class InputView
  - [x] 다리의 길이를 입력받는다. - readBridgeSize()
  - [x] 사용자가 이동할 칸을 입력받는다. - readMoving()
  - [x] 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. - readGameCommand()

-[x] 랜덤으로 숫자를 만들어냄 - class BridgeRandomNumberGeneratore
  - [x] 0 ~ 1 랜덤 숫자를 만들어 반환함 - generate()

-[x] 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다. - class BridgeMaker
  - [x] 입력받은 길이에 해당하는 다리 모양 만들기. - makeBridge()

-[x] 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 함 - class MovingProcessing
  - [x] 랜덤으로 입력된 브릿지를 매개변수로 사용자의 입력과 매치하는 기능. - compareBridgeToInput()
  - [x] 사용자의 입력을 읽어내는 기능 - readNextMoving()
  - [x] 맞췄는가 아닌가의 분기로 나누는 기능 - jumpToBridge()
  - [x] 맞췄을 경우 그것이 U인지 Q인지 분기로 나눈다 - selectedBridgeIsSucceed()
  - [x] 맞추지 못했을 경우 그것이 U인지 Q인지 분기로 나눈다. - selectedBridgeIsFail()
  - [x] 다리 상황을 출력하는 기능 - printBridge()