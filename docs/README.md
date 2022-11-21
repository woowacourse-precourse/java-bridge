기능 구현 목록

bridge

- Application
  : 사다리게임을 시작하는 클래스

constant

- BothSideConstant
  : bothSide에 필요한 상수를 enum으로 저장

- BridgeConstant
  : bridge에 필요한 상수를 enum으로 저장

- BridgeRegexConstant
  : bridge size에 필요한 정규표현식을 enum으로 저장

- ErrorConstant
  : 에러메세지를 enum으로 저장하고 message로 출력하는 기능

- InputConstant
  : 사용자의 입력값에 필요한 상수를 enum으로 저장

- NumberConstant
  : 필요한 정수형 상수를 enum으로 저장

- PrintConstant
  : 출력에 필요한 상수를 enum으로 저장

controller

- BridgeController
  : view와 model의 값을 받고 전달하는 기능

generator

- BridgeNumberGenerator
- BridgeRandomNumberGenerator
  : 다리의 요소를 랜덤으로 생성하는 기능

model

- BothSide
  : bothSide에 대한 로직을 구성

- BridgeGame
  : 게임에 필요한 로직을 구성

service

- BridgeMaker
  : 다리를 생성하는 기능

util

- CleanerUtil
  : 저장된 값을 초기화하는 기능

- ConverterUtil
  : 값을 대문자나 정수, 문자열로 변환하는 기능

  validator

- BridgeGameValidator
  : bridgeGame을 판별하는 기능

- BridgeSizeValidator
  : 입력값 bridge의 Size를 판별하고 예외를 발생시키는 기능

- GameCommandValidator
  : 입력값 gameCommand를 판별하고 예외를 발생시키는 기능

- MovingValidator
  : 입력값 moving을 판별하고 예외를 발생시키는 기능

view

- InputView
  : 사용자의 입력을 받는 기능

- OutputView
  : 사용자에게 보여지는 출력을 하는 기능

- View
  : 출력과 관련된 상수를 enum타입으로 저장
  