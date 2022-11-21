# To-Do list

### BridgeGame
- move : 입력받은 값을 전달 받아 이동하기
- retry : 입력받은 값을 통해 게임 재시작 결정  
*InputView, OutputView 클래스 사용 X, 그 외 예외처리 생각*
---
### BridgeMaker
- makeBridge : 난수 생성하여 다리 생성 -> UDUD 와 같은 문자열을 반환  
*예외처리 생각*
---
### BridgeNumberGenerator
- 단순 인터페이스, 혹시 추가할 함수가 있을 지 생각해보기
---
### BridgeRandomNumberGenerator
- generate : 난수 생성, 그 외 고려할 사항이 있을 지 확인
---
### InputView
- readBridgeSize : 다리 길이 입력
- readMoving : 이동할 칸 입력
- readGameCommand : 게임 재시작 여부 입력  
*전체적으로 예외 처리, 해당 값을 어떤 식으로 BridgeGame 에서 사용할 지 생각*
---
### OutputView
- printMap : 다리 형식 출력 -> String? List? 생각
- printResult : 결과 출력  
*예외 처리 및 BridgeGame 사용 방법 생각*
---