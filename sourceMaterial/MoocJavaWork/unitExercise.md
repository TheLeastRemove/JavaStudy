### 1 两个3位数之间的所有素数之和。

题目内容：
> 对任意给定的两个正整数n和m，100<n<m<1000, 计算这两个数之间所有素数之和，包含n、m自身。

输入格式:
两个大于0的3位正整数

输出格式：
输出n与m之间的素数之和

**first**

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = 0;
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

```

*Second*
> Java 8 stream API and lambda

```java
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = IntStream.rangeClosed(n, m).filter(Main::isPrime).sum();
        System.out.println(sum);
    }

    public static boolean isPrime(int n) {
        return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }
}

```

---

### 2 居民电费阶梯式计价器

> 为鼓励居民节约用电，电力公司采取按用电量阶梯式计价的办法，居民应交电费y（元）与月用电量x（度）相关：当x不超过100度时，按0.3元/度计费；
> 当x不超过200度时，按0.4元/度计费；当x不超过300度时，按0.5元/度计费；当x超过300度时，按0.8元/度计费。请编写程序实现电费的计算。

输入格式:
一个正整数，代表月用电度数x

输出格式：
居民需要缴纳的电费y

**First**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        double y = x <= 100 ? x * 0.3 : x <= 200 ? x * 0.4 : x <= 300 ? x * 0.5 : x * 0.8;
        System.out.println(y);
    }
}


```

---

### 3 华氏温度与摄氏温度的换算

> 用Java语言编写一个将华氏温度转换成摄氏温度的程序，转换的公式是：
> °C = (°F -32)*5/9
> 其中C表示摄氏温度，F表示华氏温度。
> 程序的输入是一个整数，表示华氏温度。输出对应的摄氏温度，也是一个整数。


输入格式:
一个整数

输出格式：
一个整数

**First**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fahrenheit = input.nextInt();
        int celsius = (int) ((fahrenheit - 32) * 5 / 9);
        System.out.println(celsius);
    }
}

```

**Second**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int f = input.nextInt();
        System.out.println((int) ((f - 32) * 5 / 9));
    }
}

```

---

### 4 字符出现频率统计

>从键盘输入一行中英文混合的文字，统计其中出现的每个英文字母的频率并依字母表顺序，依次输出统计结果，统计时忽略字母大小写的区别。

输入格式:
一行中英文混合的文字

输出格式：
输出每个字母及其出现次数，字母之间用2个空格分隔。


**First**
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        int[] freq = new int[26];

        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char ch = (char) ('a' + i);
                System.out.print(ch + "=" + freq[i] + "  ");
            }
        }
    }
}

```

*Second*
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*
        报错，中文是多字节字符，当程序使用chars()方法将输入字符串转换为字符流时，它实际上会将每个字符表示为一个Unicode代码点。
        对于ASCII字符来说，一个代码点就对应一个字符，但对于多字节字符（如中文字符），一个代码点就不能完全表示一个字符。
        String str = input.nextLine().toLowerCase();
        str.chars().filter(Character::isLetter).forEach(c -> freq[c - 'a']++);
        */

        String str = input.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();

        int[] freq = new int[26];
        str.chars().forEach(c -> freq[c - 'a']++);

        for (int i = 0; i < 26; i++)
            if (freq[i] > 0) System.out.printf("%c=%d  ", i + 'a', freq[i]);
    }
}

```

---

### 5 求n个非负整数之和

>输入n个非负整数，输出他们的和。 1<=n<=100，而每个数则<800。对不符合要求的输入，输出提示信息: "error”。

输入格式:
输入包括两行。 第一行:包括一个整数n，表示总共有n个数。 第二行:包含n个整数。

输出格式：
输出n个数的和。

**First**
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (!(1<=n && n<=100)){
            System.out.println("error");
            return;
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num >= 800) {
                System.out.println("error");
                return;
            }
            total += num;
        }
        System.out.println(total);
    }
}

```

*Second*
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] nums = scanner.nextLine().split(" ");
        int total = java.util.Arrays.stream(nums)
                .mapToInt(Integer::parseInt)
                .filter(num -> num < 800)
                .sum();
        System.out.println(nums.length == n ? total : "error");
    }
}

```

---

### 6 24小时制与12小时制的时间换算

>编写一个程序，要求用户输入24小时制的时间，然后输出显示12小时制的时间。


输入格式:
在一行中输入带有中间的:符号（半角的冒号）的24小时制的时间，小时和分钟均采用2位数字格式，如14:18表示14点18分， 09:06表示9点零6分。

输出格式：
在一行中输出这个时间对应的12小时制的时间，数字部分格式与输入的相同，然后跟上空格，再跟上表示上午的字符串AM或表示下午的字符串PM。如05:06 PM表示下午5点零6分。
注意：在英文的习惯中，中午12点被认为是下午，所以24小时制的12:00就是12小时制的12:00 PM；而夜里12点（24:00）被认为是第二天的时间，所以是12:00 AM。

**First**
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.next();
        scanner.close();

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        
        String period = (hour < 12 || hour==24) ? "AM" : "PM";
        hour = (hour == 0 || hour == 12 || hour==24) ? 12 : hour % 12;
        System.out.printf("%02d:%02d %s\n", hour, minute, period);
    }
}

```
**Second**
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int hour24 = Integer.parseInt(input.substring(0, 2));
        int hour12 = (hour24 == 0 || hour24 == 12 || hour24 == 24) ? 12 : hour24 % 12;
        String amPm = (hour24 < 12 || hour24 == 24) ? "AM" : "PM";
        System.out.printf("%02d%s %s", hour12, input.substring(2), amPm);
    }
}

```

---

### 7 学习小组结伴
>为了促进互帮互相，决定成立学习小组。小组结伴的规则是这样的：先将学号按升序排列，排在最前的一个人和排在最后的那个人结成同伴，排在第2个的与排在倒数第2个的结成同伴......依次类推，2个一组成同伴。


输入格式:
第一行是一个整数n，表明n个同学。(2<=n<=50，n为偶数) 。 第二行n个整数表明n个同学的学号，学号之间有一个空格，学号是无序输入的。
如果输入的学生数是奇数，则输出提示信息：“odd number”

输出格式：
共n/2行，每行二个整数，表明结伴同学的学号，两个学号之间有一个空格。

**First**
```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 1) {
            System.out.println("odd number");
            return;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            System.out.println(nums[i] + " " + nums[n - i - 1]);
        }
    }
}

```

 