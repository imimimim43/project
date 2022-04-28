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
<li>유량 네트워크의 모든 간선의 유량을 0으로 초기화.</li>
  
<li>소스에서 싱크로 유량을 더 보낼 수 있는 경로를 찾아 유량 보내기를 반복.</li>
</ol>

![image](https://user-images.githubusercontent.com/102197100/165806071-132388e6-e9e5-402b-8244-7be063d71fda.png)

- 위 사진 속 그래프는 서로 같은 그래프이지만 왼쪽 경로는 최대 유량이 2, 오른쪽 경로는 최대 유량이 1이다. 왼쪽 경로는 오른쪽 경로에서 유량이 1 늘었는데, 유량을 증가시키는 것을 **증가 경로(augmenting path)** 라고 한다. 포드-풀커슨 알고리즘의 목표는 왼쪽 경로와 같이 최대 유량을 찾는 것, 즉 증가 경로를 찾는 것이다.

> 증가 경로로 보낼 수 있는 최대 유량 = 포함된 간선의 잔여 용량 중에서 가장 작은 값.


#### 유량의 최대값을 찾지 못하는 경우
- s-a-t와 s-b-t 경로가 아닌 s-a-b-t경로를 선택한 경우, 최대 유량을 찾지 못하게 되는데 유량 상쇄 개념을 넣게 된다면 최대 유량을 찾는데 수월해진다.


■  **유량 상쇄**

- 새 유량을 보내는 것과 기존의 유량을 상쇄하는 것은 같은 연산.
- ( a , b ) = 1 이라고 생각하면, ( b, a ) = -1 이 되어 a와 b는 서로에게 유량을 보내 주는 것이 의미 없어진다.

![image](https://user-images.githubusercontent.com/102197100/165811706-fa9e3a2c-f686-4b4f-8f00-56e0fc73b557.PNG)

- a와 b의 간선의 합이 0이 되므로 위 그래프는 두 경로로 갈 수 있어 최대 유량이 1 이었던 왼쪽 경로에서 최대 유량이 2인 오른쪽 경로로 바꿀 수 있다.


마지막으로 포드-풀커슨 알고리즘의 과정을 정리해보자면,

<ol>
<li>각 간선의 용량을 입력 받는다.</li>
  
<li>DFS 또는 BFS 를 이용하여 증가 경로를 찾는다.</li>
  
<li>증가 경로 상의 간선 중 잔여 용량이 가장 낮은 것을 찾는다.</li>
  
<li>잔여 용량 최소치만큼 소스에서 싱크까지 유량을 흘려보낸다.</li>
  
<li>더 이상 증가 경로가 발견 되지 않을 때까지 반복한다.</li>
</ol>
<br>

## 코드 구현

■ 필요한 요소
<br>
- 그래프를 표현하는 배열
- path를 저장하기 위한 배열
- edge(간선)의 정보를 저장하기 위한 배열 : capacity, flow
- dfs에서 방문 정보를 확인하기 위한 배열

 **코드에 쓰일 배열 선언 **
 
```

public static int capacity[][]; // 간선의 용량을 저장하기 위한 배열
    public static int flow[][]; // 간선의 유량을 저장하기 위한 배열
    public static int path[]; // // 경로를 저장하기 위한 배열
    public static boolean visited[]; 
    public static LinkedList<Integer> graph[];

```

**dfs 코드 구현 **

```

public static boolean dfs(int start) {
        if (start == Sink) {
            return true;
        }

        visited[start] = true;
        LinkedList<Integer> nexts = graph[start];
        for (int next: nexts) { // 
            if ( !visited[next] && capacity[start][next] - flow[start][next] > 0) {
                path[next] = start; // 방문하지 않았거나, 해당 경로에 여유 용량이 남아있을때

                if (dfs(next)) { // 경로를 끝까지 찾으면 탈출, 아니면 끝까지 찾기 재시도
                    return true;
                }
            }
        }
        return false;
    }

```

**메인 코드 구현**
```

  public static int FordFulkerson() {
        int total = 0;
        while (dfs(Source)) { // dfs로 경로 찾기(증가경로), 경로가 더이상 없으면 종료임.
            int flowNum = Integer.MAX_VALUE;
            for(int i = Sink; i != Source; i = path[i]) {
                int from = path[i];
                int to = i;
                flowNum = Math.min(flowNum, (capacity[from][to]) - flow[from][to]);
		//찾은 경로중에서 capcacity - flow 값이 제일 작은 것을 찾아줌. = 흘릴 수 있는 최대 flow값.
            }

            for(int i = Sink; i != Source; i = path[i]) {
                int from = path[i];
                int to = i;
		// flow 흘리기.
                flow[from][to] += flowNum; // 순방향 간선에는 양수값 넣어주기.
                flow[to][from] -= flowNum; // 유량의 대칭 조건에 따라, 역방향 간선에는 음수값을 넣어줌.
            }                              // 가상의 역방향 간선의 총 유량을 더해주면 capacity = 0, 용량을 넘지 않음.

            total += flowNum; // total값에 유량 더해주기.

            // 찾은 경로를 초기화해서 dfs로 경로 찾기를 Source > Sink 까지 다시 할 수 있게 함.
            Arrays.fill(path, -1);
            Arrays.fill(visited, false);
        }
        return total; //최대 유량의 값 반환.
    }
    
```
 
## **최종 코드 구현**

```

public static int capacity[][];
    public static int flow[][];
    public static int path[]; // 
    public static boolean visited[];
    public static LinkedList<Integer> graph[];

    public static boolean dfs(int start) {
        if (start == Sink) {
            return true;
        }

        visited[start] = true;
        LinkedList<Integer> nexts = graph[start];
        for (int next: nexts) {
            if ( !visited[next] && capacity[start][next] - flow[start][next] > 0) {
                path[next] = start;

                if (dfs(next)) { // 경로를 끝까지 찾으면 탈출, 아니면, 끝까지 찾기 재시도
                    return true;
                }
            }
        }
        return false;
    }
  
  public static int FordFulkerson() {
        int total = 0;
        while (dfs(Source)) { // dfs로 경로 찾기(증가경로), 경로가 더이상 없으면 종료임.
            // 찾은 경로에서 차단 간선 찾기 min (capacity[u][v] - flow[u][v])
            // 결국 의미는 경로에서 흘릴수 있는 최대의 유량(flow)을 찾기
            int flowNum = Integer.MAX_VALUE;
            for(int i = Sink; i != Source; i = path[i]) {
                int from = path[i];
                int to = i;
                flowNum = Math.min(flowNum, (capacity[from][to]) - flow[from][to]);
            }
            // 찾은 경로에 유량을 흘려보내기, 역방향도 반드시!!!!
            for(int i = Sink; i != Source; i = path[i]) {
                int from = path[i];
                int to = i;

                flow[from][to] += flowNum;
                flow[to][from] -= flowNum;
            }

            total += flowNum;

            // 찾은 경로를 초기화해서 dfs로 경로 찾기를 Source > Sink 까지 다시 할 수 있게 함.
            Arrays.fill(path, -1);
            Arrays.fill(visited, false);
        }
        return total;
    }
	
```


코드 참고 링크 : (https://gseok.gitbooks.io/algorithm/content/b124-d2b8-c6cc-d06c-d50c-b85c-c6b0/d3ec-b4dc-d480-cee4-c2a828-ford-fulkerson-c560-b4dc-baac-b4dc-ce74-d50428-edmonds-karp.html)
