## 포드-풀커슨 알고리즘(Ford-Fulkerson algorithm)

<br>


■ 포드-풀커슨(Ford-Fulkerson)

- 유량 네트워크에서 소스(시작점)와 싱크(끝점)사이에 흐를 수 있는 최대 유량(Maximum Flow)을 구하는 알고리즘이다.

<br>
여기서 유량 네트워크란?

■ 유량 네트워크(flow network)
<br>

- 정의 :

  >  c ( u, v ) : 정점 u에서 v로 가는 간선의 용량 (capacity)
  
  >  f ( u, v ) : 정점 u에서 v로 실제 흐르는 유량(flow)
  
- 간단하게 정리하면, 각 간선에 용량이라는 추가 속성이 존재하는 방향 그래프이다.
  ![image](https://user-images.githubusercontent.com/102197100/165531238-c59d5ab5-c3c3-4601-811e-7aabf90a95c5.png)
  
-  (a,c)간선을 예로 들면, 초당 최대 20만큼의 자료를 전송할 수 있으며 이때의 20은 간선의 용량(capacity)라고 한다. <br>
   또한, 초당 13만큼의 자료가 전송되고 있는데 이때의 13은 간선의 유량(flow)라고 한다.<br>
 - 경로 s-b-d-t를 살펴보면, 거치는 간선의 용량의 최솟값은 3이므로 이 값이 해당 경로를 통해 보낼 수 있는 유량의 최댓값이다.<br>

■ 유량 네트워크(flow network)의 속성 
<ol>
<li>용량 제한 속성</li>
  - 모든 간선에 대해 유량은 용량을 초과할 수 없다.
  
<li>유량의 대칭성 </li>
  - f( u, v ) = -f( u, v )
  
<li>유량의 보존</li>
  - 시작점에서 흘려보낸 유량은 모두 끝점에 도착하게 된다.
</ol>
<br>

■  **포드-풀커슨 알고리즘**
- 유량 네트워크의 모든 간선의 유량을 0으로 두고 시작해서, 시작점에서 끝점으로 유량을 더 보낼 수 있는 경로(증가 경로)를 찾아 유량을 추가로 보내기를 반복한다. 이렇게 증가 경로를 찾아서 유량을 추가로 흘려보내다가 증가 경로가 존재하지 않으면 네트워크에 최대 유량이 흐르고 있다고 판단하고 알고리즘은 종료된다.
<br>

- **포드-풀커슨 알고리즘**이란, 다시 간단히 말해서 소스(source) 노드에서 시작해 싱크(sink) 노드로 도착하는 유량이다.
<ol>
<li>유량 네트워크의 모든 간선의 유량을 0으로 초기화.
  
<li>소스에서 싱크로 유량을 더 보낼 수 있는 경로를 찾아 유량 보내기를 반복.
</ol>
<br>
![ford2](https://user-images.githubusercontent.com/102197100/165804644-ba0404f6-d316-4785-9485-a7d2cffbd376.JPG)
)
