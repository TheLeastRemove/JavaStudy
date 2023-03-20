package Solutions;
public class CenturyEndDayOfWeekVio {
        public static void main(String[] args) {
            int year=1999,n=19;
            while(true) {
                int day=getDay(year,Integer.parseInt((++n)+"99"));
                int value=(day)%7;
                if(value==2) {
                    System.out.println(n+"99");
                    System.exit(0);
                }
            }
        }
        public static int getDay(int year,int now) {
            int day=0;
            for(int i=year+1;i<=now;i++) {
                if(i%100!=0&&i%4==0||i%400==0)
                    day+=366;
                else
                    day+=365;
            }
            return day;
        }
    }


