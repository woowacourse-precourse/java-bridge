### 구현할 기능   
1.다리를 건너는 기능    
2.다리의 길이를 입력받고 생성하는 기능    
3.대문자를 입력받아 다리 건너기    
4.건너다 실패하면 게임 종료


### 구현한 기능

# BridgeGame Class : 게임 진행을 관리하는 클래스
## move(): 입력받은 이동 커맨드와 Bridge와 비교하는 메소드        
## retry(): 재시작 입력을 받게되면 총시도횟수에 1을 더해주며 재시작하는 메소드  
## gameOver():게임진행 상태를 false로 바꾸며 게임을 종료하는 메소드    

# BridgeMaker Class : 다리를 생성하는 클래스
## makeBridge():사이즈를 인수로 받아 다리를 생성하는 메소드    
## loopAddBridge():사이즈만큼 반복하여 bridgeNumberGenerator 메소드를 실행하는 메소드   
## addBridge():생성된 수가 0 이면 D, 1이면 U를 Bridge에더해주는 메소드    
## generateBridge(): bridgeNumberGenerator를 실행해서 생성된 수를 return하는 메소드    

# InputView Class : 게임 진행에 필요한 입력을 받는 클래스   
## readBridgeSize(): BridgeSize를 입력받는 메소드   
## checkError():범위에 맞는 숫자인지(isRandge()), 숫자아닌 다른 문자인지(isNumber()) 예외를 판별하는 메소드        
## readMoving(): 사용자의 이동방향을 입력받는 메소드    
## isUD(): U or D 인지 확인하여 예외를 판단하는 메소드    
## readGameCommand(): 중간에 다리건너기 실패했을때 게임을 재시작할건지 종료할건지 입력받는 메소드   
## isRQ():R or Q 인지 확인하여 예외를 판단하는 메소드   

# OutputView Class : 게임 진행에 필요한 결과를 출력하는 클래스    
## printMap(): 다리 건너기 성공했을 때 사용자의 입력이 U인지 D인지 입력받아 게임진행결과를 출력하는 메소드   
## printFailMap() : 다리 건너기 실패했을 때 사용자의 입력이 U인지 D인지 입력받아 게임진행결과를 출력하는 메소드    
## printUMap(): 다리를 건넌게 처음인지 아닌지 판별후 U일때를 출력하는 메소드    
## mergeUMap(): 인덱스를 이용하여 전에 있던 결과에 새로운 결과를 merge시키는 메소드    
## printDMap(): 다리를 건넌게 처음인지 아닌지 판별후 D일때를 출력하는 메소드    
## mergeDMap(): 인덱스를 이용하여 전에 있던 결과에 새로운 결과를 merge시키는 메소드    
## printResult(): 최종 게임 결과를 출력하는 메소드    
## printStart(),printInputSize(),printMoving(),printReGame(): 게임을 진행할때 안내문을 출력하는 메소드   

# PlayGame Class: 게임을 진행시키는 클래스   
## sizeStart(): 안내문을 출력하고 BridgeSize를 입력받는 메소드    
## upTotal(): 총 시도횟수를 1 올려주는 메소드    
## changePlayingState(): 게임 진행상태를 바꿔주는 메소드    
## moveStart(): 다리와 사용자의 입력이 맞는지 확인하는 메소드   
## checkMove(): 다리와 사용자의 입력이 맞는지 확인후 결과를 출력하는 메소드   
## checkReGameAnswer(): 재시작 or 종료 확인하여 프로그램을 진행시키는 메소드    
## reGameAnswer(): 게임의 재시작 여부를 입력받는 메소드   
## setBridge(): 사이즈를 입력받아 다리를 만드는 메소드    
## Startgame(): 게임을 시작하는 메소드    
## run(): 게임 진행 상태에 맞춰 반복문으로 게임을 진행시키고 게임종료조건을(isEqualsAnswer(),checkWinCondition()) 확인하여 최종결과를 출력하는 메소드


