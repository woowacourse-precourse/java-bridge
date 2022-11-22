# InputView                                                                        
 - [ o ] 다리길이를 입력 받는다
 - [ o ] 어디로 건널지 (U, D)
 - [ o ] 재시도 여부 (R, Q)

# BridgeMaker ( 다리 만드는 클래스 )                                                   
 
 - [ o ] 길이 만큼 랜덤 값 가져오기 String 으로 가져오기 ex) [1,0,0]

# BridgeGame ( 다리 게임 어디로 건널지 입력 받고 알려주는, 재시도 입력받고 알려주는 클래스 )    
 - [ o ] move -> 이 다리를 건널수 있는지 체크
 - [ o ] retry -> R이면 true, Q이면 false
 
# BridgeShape ( 게임 진행하면서 다리 모양 만들어주는 클래스 )                          
 - [ o ] "   " 상수
 - [ o ] " o " 상수
 - [ o ] " x " 상수
 - [ o ] "]", "[", , "|" 상수
 - [ o ] 어느다리로 갈건지, 거기로 갈수있는지 변수를 받아서 윗다리와, 아랫다리에 각각의 값을 넣어준다.
 - [ o ] 어느다리로 가는지 확인하고 안가는 다리엔 empty를 넣어준다.
 - [ o ] 가는 다리가 갈수 있는지 못가는지에 따라서 o,x를 넣어준다.
 - [ o ] 다리모양 초기화
 - [ o ] "|" 사용하여 구분한다.
 - [ o ] "]", "[" 감싼다.

# OutputView (출력 문 클래스)                                                           

# Verification ( 검증 클래스 )
- [ o ] 3 이상 20이하 인가
- [ o ] U, D 둘 중 하나 인가
- [ o ] R, Q 둘 중 하나 인가

# GameStatus (게임을 전반적 조종 해주는 요소들이 모여있는 클래스)
- [ o ] cnt -> 게임을 몇번 시도했는지
- [ o ] idx -> 몇번째 다리를 건너는지 -> idx ==  size 일때 게임 성공
- [ o ] gamePower -> 게임 전원 버튼 -> 게임성공, 실패 시 게임의 반복문 끄는 역할
- [ o ] gameSuccessWheter -> 게임에 성공했는지
- [ o ] 위 요소들 초기화
- [ o ] cnt, idx 1씩증가하는 메서드

# Bridge (size 값을 던져주면 BridgeMaker를 이용하여 다리를 생성해주고 그 다리를 가지고 있는 클래스)

# GameController (게임 전반적으로 컨트롤 하는 클래스)

# TypeChange (입력 받은 값을 형 변환 하는 클래스)
- [ o ] 입력 받은 size를 integer 형으로 변환

# 패키지
# domain - 비즈니스에 관련된거 - BridgeMaker, ...

- 클래스
- BridgeGame - 다리를 건널 수 있는지 , 다시 게임 시작할건지 판별해주는 클래스
- BridgeMaker - 다리를 만들어주는 클래스
- BridgeNumberGenerator
- BridgeRandomNumberGenerator
- Bridge
- BridgeShape
- GameStatus

# view
- 클래스
- InputView
- OutputView
- valification
- TypeChange

# constants
(Command, Message, Move)

# controller - view와 model를 이어주는 패키지
- GameController


