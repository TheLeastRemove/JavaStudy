package Solutions;

import java.time.*;

public class CenturyEndDayOfWeek {
    public static void main(String[] args) {
        int year = 1999; // 从1999年开始查找
        while (true) {
            LocalDate date = LocalDate.of(year, 12, 31);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SUNDAY) {
                System.out.println(year + "年的12月31日是星期日。");
                break;
            }
            year += 100; // 每隔100年查找一次
        }
    }
}
