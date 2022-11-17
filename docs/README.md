## 🎯 프로그래밍 요구 사항 정리

1. 무분별한 getter를 지양하고 객체에 메시지를 보내 객체가 로직을 수행하도록 하자
2. 메소드 10라인 제한
3. 메소드 파라미터 3개
4. 클래스 요구사항 충족
   1. InputView
      1. 메소드 시그니처와 반환 타입 변경 불가
   2. OutputView
      1. 메소드의 이름은 변경 불가, 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
   3. BridgeGame
      1. 메소드 이름 변경 불가, 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
   4. BridgeMaker
      1. 필드 변경 불가
      2. 메소드 시그니처와 반환 타입 변경 불가
   5. BridgeRandomNumberGenerator
      1. Ramdom 값 추출은 bridge.BridgeRandomNumberGenerator의 generate()를 활용
      2. BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드는 변경 불가