기능 구현 목록

bridge

- Application
  : 사다리게임을 시작하는 클래스

constant

- ErrorMessage
  : 에러메세지를 enum으로 저장하고 message로 출력하는 기능

- GameConstant
  : 필요한 정수형 상수를 enum으로 저장

- StringConstant
  : 필요한 문자형 상수를 enum으로 저장

controller

- BridgeController
  : view와 model의 값을 받고 전달하는 기능

generator

- BridgeNumberGenerator
- BridgeRandomNumberGenerator
  : 다리의 요소를 랜덤으로 생성하는 기능

model

- BridgeGame
  : 게임에 필요한 로직을 구성

service

- BridgeMaker
  : 다리를 생성하는 기능

view

- InputView
  : 사용자의 입력을 받는 기능

- OutputView
  : 사용자에게 보여지는 출력을 하는 기능

- View
  : 출력과 관련된 상수를 enum타입으로 저장

