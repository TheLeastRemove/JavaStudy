## 基本排序算法：

冒泡排序：对N个数进行排序。要求每次相邻的两个数进行比较，如果前一个数大于后一个数，则交换这两个数的位置，直到所有的数都排好序。经典题目：洛谷 P1146 魔板 Magic Squares。

```java
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

```
>在主函数中，我们首先从标准输入读入n个整数，并将它们存储在一个数组中。然后，我们使用两个嵌套的循环来执行冒泡排序。外部循环用于迭代数组中的元素，内部循环用于比较相邻的两个元素并交换它们的位置，直到所有的元素都排好序。


插入排序：对N个数进行排序。每次取出一个数，插入到已经排好序的数列中，直到所有的数都插入完毕。经典题目：洛谷 P1029 反序对。
```java
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0; // 记录逆序对的数量
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
                count++; // 统计逆序对数量
            }
            arr[j + 1] = temp;
        }
        System.out.println(count);
    }
}

```
>在主函数中，我们首先从标准输入读入n个整数，并将它们存储在一个数组中。然后，我们使用一个循环来执行插入排序。在每次迭代中，我们取出一个数，并将它插入到已经排好序的数组中。我们使用一个while循环来将该数与已经排好序的数组中的元素进行比较，并将其插入到合适的位置。在插入过程中，我们统计逆序对的数量。


## 高级排序算法：

快速排序：对N个数进行排序。选择一个数作为枢轴（pivot），将小于枢轴的数放在枢轴的左边，大于枢轴的数放在枢轴的右边，然后递归地对左右两部分进行排序。经典题目：洛谷 P1177 快排。
```java
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); // 获取枢轴的下标
            quickSort(arr, left, pivotIndex - 1); // 对左半部分进行排序
            quickSort(arr, pivotIndex + 1, right); // 对右半部分进行排序
        }
    }
    
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left]; // 将第一个元素设为枢轴
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) { // 从右侧找到第一个小于枢轴的元素
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) { // 从左侧找到第一个大于枢轴的元素
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot; // 将枢轴放在正确的位置上
        return i; // 返回枢轴的下标
    }
}

```
>在主函数中，我们首先从标准输入读入n个整数，并将它们存储在一个数组中。然后，我们调用快速排序函数quickSort来对该数组进行排序。在快速排序函数中，我们使用递归的方式来对左右两部分进行排序，直到所有元素都排好序为止。
>在partition函数中，我们选择第一个元素作为枢轴，使用双指针法来进行排序。在每次迭代中，我们从右侧找到第一个小于枢轴的元素，并将其放到左侧，然后从左侧找到第一个大于枢轴的元素，并将其放到右侧。最终，我们将枢轴放在正确的位置上，并返回其下标。

归并排序：对N个数进行排序。将数列分成两个子序列，分别对这两个子序列进行排序，然后将排好序的子序列进行合并。经典题目：洛谷 P1908 排序。
```java
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // 获取中间下标
            mergeSort(arr, left, mid); // 对左半部分进行排序
            mergeSort(arr, mid + 1, right); // 对右半部分进行排序
            merge(arr, left, mid, right); // 合并左右两部分
        }
    }
    
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1]; // 创建临时数组
        int i = left; // 左半部分的起始下标
        int j = mid + 1; // 右半部分的起始下标
        int k = 0; // 临时数组的下标
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }
        for (int p = 0; p < tmp.length; p++) { // 将临时数组的元素复制回原数组
            arr[left + p] = tmp[p];
        }
    }
}

```
>在主函数中，我们首先从标准输入读入n个整数，并将它们存储在一个数组中。然后，我们调用归并排序函数mergeSort来对该数组进行排序。在归并排序函数中，我们使用递归的方式将数组分成两个子序列，分别对这两个子序列进行排序，然后将排好序的子序列进行合并。
>在merge函数中，我们创建一个临时数组tmp，用于存储排好序的元素。然后，我们使用双指针法来合并左右两部分的元素，并将合并后的元素存储到临时数组中。最后，我们将临时数组的元素复制回原数组中。

## 查找算法：

顺序查找：在一个无序的数列中查找某个数。从数列的第一个数开始依次比较，直到找到所需的数或者查找结束。经典题目：洛谷 P1550 机器翻译。
```java
import java.util.Scanner;

public class SequentialSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int index = sequentialSearch(arr, target);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found at index " + index);
        }
    }
    
    public static int sequentialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

```
>在主函数中，我们首先从标准输入读入n个整数，并将它们存储在一个数组中。然后，我们从标准输入读入要查找的数x，调用顺序查找函数sequentialSearch来查找该数在数列中的位置。在顺序查找函数中，我们使用for循环依次比较数列中的每个元素，如果找到了所需的数，则返回它在数列中的位置；如果在循环结束时仍然没有找到该数，则返回-1。

二分查找：在一个有序的数列中查找某个数。将数列从中间分成两部分，如果所需的数比中间数小，则在左半部分继续查找；如果所需的数比中间数大，则在右半部分继续查找。经典题目：洛谷 P1925 [NOI2004]路标设置。
```java
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数列长度
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt(); // 要查找的数
        int pos = binarySearch(arr, x);
        if (pos == -1) {
            System.out.println("没有找到 " + x);
        } else {
            System.out.println(x + " 的位置是 " + pos);
        }
    }
    
    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // 没有找到
    }
}

```
>在主函数中，我们首先从标准输入读入n个整数，并将它们存储在一个数组中。然后，我们从标准输入读入要查找的数x，调用二分查找函数binarySearch来查找该数在数列中的位置。在二分查找函数中，我们使用while循环将数列从中间分成两部分，并比较中间数与要查找的数的大小，如果找到了所需的数，则返回它在数列中的位置；如果在循环结束时仍然没有找到该数，则返回-1。

## 动态规划算法：

最长上升子序列（LIS）：给定一个长度为N的数列，求这个数列的最长上升子序列的长度。经典题目：洛谷 P1020 导弹拦截。
```java
import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n]; // dp[i]表示以arr[i]为结尾的最长上升子序列长度
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1; // 初始化为1
        }
        int maxLen = 0; // 最长上升子序列的长度
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println(maxLen);
    }
}

```
>在主函数中，我们首先从标准输入读入n个整数，并将它们存储在一个数组arr中。然后，我们定义一个与arr长度相同的数组dp，并将dp[i]初始化为1，表示以arr[i]为结尾的最长上升子序列长度至少为1。
>接着，我们使用两层循环来计算dp数组的值。外层循环枚举数组arr中的每个元素，内层循环枚举该元素之前的所有元素，如果当前元素大于前面的某个元素，就更新dp数组的值。具体地，如果arr[j] < arr[i]，那么dp[i]的值就应该等于dp[j]+1和dp[i]中的较大值。

背包问题：有一个容量为V的背包和N个物品，第i个物品的重量是Wi，价值是Ci。现在需要选择一些物品放进背包中，使得所选物品的总重量不超过背包容量，同时总价值最大。经典题目：洛谷 P1048 采药。
```java
import java.util.Scanner;

public class KnapsackProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int N = scanner.nextInt();
        int[] W = new int[N];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = scanner.nextInt();
            C[i] = scanner.nextInt();
        }
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j < W[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i - 1]] + C[i - 1]);
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}

```
>其中，dp[i][j]表示在前i个物品中选择一些放入容量为j的背包中所能得到的最大价值。在填表格的过程中，如果当前背包容量j小于第i个物品的重量W[i-1]，则不放第i个物品，即dp[i][j] = dp[i-1][j]；如果当前背包容量j大于等于第i个物品的重量W[i-1]，则需要考虑放或不放第i个物品，取两者之间的最大值，即dp[i][j] = max(dp[i-1][j], dp[i-1][j-W[i-1]]+C[i-1])。

## 贪心算法：

霍夫曼编码：给定N个权值，用这N个权值构造一个权值哈夫曼树。哈夫曼树的带权路径长度定义为树中所有叶子节点的权值乘以它们到根节点的路径长度之和。经典题目：洛谷 P1085 过河。
```java
import java.util.*;

public class HuffmanCoding {
    
    static class Node implements Comparable<Node> {
        int weight;
        Node left, right;

        Node(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    
    public static Node buildHuffmanTree(int[] weights) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int weight : weights) {
            pq.offer(new Node(weight));
        }
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }
        return pq.poll();
    }

    public static Map<Integer, String> getHuffmanCodes(Node root) {
        Map<Integer, String> codes = new HashMap<>();
        getHuffmanCodes(root, "", codes);
        return codes;
    }

    private static void getHuffmanCodes(Node node, String code, Map<Integer, String> codes) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            codes.put(node.weight, code);
        }
        getHuffmanCodes(node.left, code + "0", codes);
        getHuffmanCodes(node.right, code + "1", codes);
    }

    public static int getHuffmanTreeWeight(Node root) {
        return getHuffmanTreeWeight(root, 0);
    }

    private static int getHuffmanTreeWeight(Node node, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.weight * depth;
        }
        return getHuffmanTreeWeight(node.left, depth + 1) + getHuffmanTreeWeight(node.right, depth + 1);
    }

    public static void main(String[] args) {
        int[] weights = {3, 1, 4, 1, 5, 9, 2, 6};
        Node root = buildHuffmanTree(weights);
        Map<Integer, String> codes = getHuffmanCodes(root);
        int weight = getHuffmanTreeWeight(root);
        System.out.println("Huffman tree weight: " + weight);
        for (int i = 0; i < weights.length; i++) {
            System.out.println(weights[i] + ": " + codes.get(weights[i]));
        }
    }
}

```
>该程序使用优先队列（PriorityQueue）构建霍夫曼树，并且使用递归方法计算霍夫曼编码和带权路径长度。在主方法中，给定了一个权值数组，程序输出每个权值的霍夫曼编码，并计算了整个霍夫曼树的带权路径长度。

最小生成树（MST）：给定一个有N个节点和M条边的无向图，求它的最小生成树。经典题目：洛谷 P3366 【模板】最小生成树。
<Prim算法>
```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = graph[v][u] = w;
        }
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {
            int u = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (u == 0 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            visited[u] = true;
            for (int v = 1; v <= n; v++) {
                if (!visited[v]) {
                    dist[v] = Math.min(dist[v], graph[u][v]);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != INF) {
                ans += dist[i];
            }
        }
        System.out.println(ans);
    }
}

```
>

## 图论算法：

最短路算法：给定一个有N个节点和M条边的有向图，求其中一个节点到其他节点的最短距离。经典题目：洛谷 P3371 【模板】单源最短路径（标准版）。
<Dijkstra算法>
```java
import java.util.*;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 节点数
        int m = scanner.nextInt(); // 边数
        int s = scanner.nextInt(); // 起点

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(u).add(new Edge(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.to;

            if (curr.weight > dist[u]) {
                continue;
            }

            for (Edge e : graph.get(u)) {
                int v = e.to;
                int w = e.weight;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Edge(v, dist[v]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}

class Edge implements Comparable<Edge> {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(weight, other.weight);
    }
}

```
>其中，`Edge`类表示有向图中的一条边，包含两个属性：终点节点和边的权重。`DijkstraAlgorithm`类包含一个`main`方法，用于读入输入数据，构建有向图，运行Dijkstra算法，最后输出每个节点到起点的最短距离。在算法中，我们使用了优先队列来维护到每个节点的最短距离，每次从队列中取出距离最小的节点进行松弛操作，直到队列为空。


拓扑排序：给定一个有N个节点和M条有向边的有向图，将所有节点排序，使得对于任意一条有向边（u，v），节点u在排序后出现在节点v的前面。经典题目：洛谷 P1094 [NOI2001]普及组 洛谷祭。
```java
import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 节点个数
        int m = sc.nextInt(); // 有向边个数

        // 用邻接表存储图
        List<Integer>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
        }

        // 统计每个节点的入度
        int[] indegree = new int[n + 1];
        for (int u = 1; u <= n; u++) {
            for (int v : adj[u]) {
                indegree[v]++;
            }
        }

        // 将入度为0的节点加入队列
        Queue<Integer> q = new LinkedList<>();
        for (int u = 1; u <= n; u++) {
            if (indegree[u] == 0) {
                q.offer(u);
            }
        }

        // 拓扑排序
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // 输出结果
        if (result.size() == n) {
            for (int u : result) {
                System.out.print(u + " ");
            }
        } else {
            System.out.println("图中存在环");
        }
    }
}

```
>其中，`adj`数组用来存储有向图的邻接表，`indegree`数组用来统计每个节点的入度，`q`队列用来存储入度为0的节点，`result`列表用来存储拓扑排序的结果。在拓扑排序过程中，我们从队列中取出入度为0的节点，并将其加入结果列表中，然后将其所有邻接节点的入度减1，若减1后入度为0，则将其加入队列中。最后，若结果列表的大小等于节点个数，则输出结果，否则说明图中存在环。

## 字符串算法：

字符串匹配：在一个字符串中查找另一个字符串是否存在。KMP算法是一种高效的字符串匹配算法，它利用已经匹配过的信息避免重复匹配。经典题目：洛谷 P3375 【模板】KMP字符串匹配。
```java
public class KMP {
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        int[] next = getNext(pattern);
        int index = kmp(text, pattern, next);
        if (index == -1) {
            System.out.println("Pattern not found in text");
        } else {
            System.out.println("Pattern found at index " + index);
        }
    }

    public static int kmp(String text, String pattern, int[] next) {
        int i = 0, j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}

```
>在这个示例中，我们使用了一个getNext函数来计算pattern字符串的next数组。然后，我们使用kmp函数来搜索text字符串中是否存在pattern字符串。如果存在，则返回pattern字符串在text字符串中第一次出现的位置的索引；否则返回-1。

最长公共子序列：给定两个字符串，找出它们的最长公共子序列。可以用动态规划求解。经典题目：洛谷 P1439 最长公共子序列。
```java
public class Longest {
    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

```
>该算法的时间复杂度为O(mn)，其中m和n分别是两个字符串的长度。该算法使用一个二维数组dp来存储以i和j为结尾的两个子串的最长公共子序列长度。如果s1[i-1]等于s2[j-1]，则它们可以共同构成最长公共子序列的一部分，此时dp[i][j]等于dp[i-1][j-1]+1；否则，最长公共子序列一定不包含s1[i-1]或s2[j-1]，此时dp[i][j]等于dp[i-1][j]和dp[i][j-1]的最大值。最终，dp[m][n]就是两个字符串的最长公共子序列长度。