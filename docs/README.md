# Bridge Game
## 패키지
- **constant** : Enum 클래스를 정리한 패키지.
- **controller** : model 패키지 안에 있는 클래스를 동작 시키기 위한 컨트롤러를 정리한 패키지 
- **model** : 브리지 게임을 실질적으로 동작시키는 클래스를 정리한 패키지
- **view** :  메시지 출력을 다루는 클래스를 정리한 패키지

## constant
- **BridgeLengthSizeStatus** : 브리지 사이즈의 최소 값과 최대 값
- **BridgeMakerNumberStatus** : 브리지 메이커 랜덤 값을을 스트링으로 변환해서 리턴
- **CmdStatus** : 사용자가 입력하는 명령을 정리
- **ErrorStatus** : 입력 값이 잘못된 경우 에러 메시지를 정리
- **PrintStatus** : 게임의 출력되는 메시지를 정리

## controller
- **BridgeGameController** : 브리지 게임 클래스의 기능을 동작시키는 클래스

## model
- **BridgeGame** : 브리지 게임에 필요한 기능을 가지고 있는 클래스
- **BridgeMaker** : 다리를 만들기 위한 클래스
- **InputValidation** : 오류 검사를 위한 클래스

## view
- **InputView** : 사용자에게 변수를 입력 받기위한 클래스
- **OutputView** : 화면에 메시지를 출력하기 위한 클래스