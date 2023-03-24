### 一点简单的对拍示例
> 24hour转12hour,与W的代码对拍。

```java

import java.util.Objects;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        while (true)
        {
            String time = generate24HourTime();
            if (!Objects.equals(convertTo12Hour(time), convertTo12HourW(time))) {
                System.out.println(time);
                System.out.println("First:"+convertTo12Hour(time));
                System.out.println(("Second:"+convertTo12HourW(time)));
                break;
            }
        }
    }

    public static String generate24HourTime() {
        Random rand = new Random();
        int hours = rand.nextInt(24);
        int minutes = rand.nextInt(60);
        String hourString = (hours < 10) ? "0" + hours : Integer.toString(hours);
        String minuteString = (minutes < 10) ? "0" + minutes : Integer.toString(minutes);
        return hourString + ":" + minuteString;
    }

    public static String convertTo12Hour(String input) {
        int hour24 = Integer.parseInt(input.substring(0, 2));
        int hour12 = (hour24 == 12) ? 12 : hour24 % 12;
        String amPm = (hour24 < 12 || hour24 == 24) ? "AM" : "PM";
        return String.format("%02d%s %s", hour12, input.substring(2), amPm);
    }
    public static String convertTo12HourW(String input){

        int flag=0,thour=0,tmin=0,count=0;
        for(int i = 0; i< input.length(); i++){
            if(input.charAt(i)==':'){
                flag=1;
                count=0;
                continue;
            }else{
                if(flag==0){
                    thour=thour*count*10+Integer.valueOf(input.charAt(i))-48;
                    count++;
                }else{
                    tmin=tmin*count*10+Integer.valueOf(input.charAt(i))-48;
                    count++;
                }
            }
        }
        int tflag=0;
        if(thour>=12){
            tflag=1;
        }
        if(tflag==1){
            if(thour==24){
                return String.format("%02d:%02d AM",thour-12,tmin);
            }
            else if(thour==12){
                return String.format("%02d:%02d PM",thour,tmin);
            }else{
                return String.format("%02d:%02d PM",thour-12,tmin);
            }
        }else{
            return String.format("%02d:%02d AM",thour,tmin);
        }
    }




}

```