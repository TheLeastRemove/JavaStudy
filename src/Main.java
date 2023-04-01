import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String text = "8  赵子涵 008 教授 数学系 微积分学与线性代数学基础 5\n\n9   张天翔  009  讲师  物理系  热力学与统计物理学  6\n\n10   钱宇航  010  教授  数学系  数值分析基础  5\n";
        Pattern pattern = Pattern.compile("^\\s*(\\d+)", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}