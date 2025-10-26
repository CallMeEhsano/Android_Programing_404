package InClassProgram.InJ5;

import java.util.Scanner;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = getHour(hour);
        this.minute = getMinute(minute);
        this.second = getSecond(second);

    }

    private int getHour(int hour){
        if(hour >24 || hour<0){
            return 0;
        }
        else return hour;
    }
    private int getMinute(int minute){
        if(minute >59 || minute<0){
            return 0;
        }
        else return minute;
    }
    private int getSecond(int second){
        if(second >59 || second<0){
            return 0;
        }
        else return second;
    }
    public String displayTime(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter hour : ");
        int hour = input.nextInt();
        System.out.print("enter minute : ");
        int minute = input.nextInt();
        System.out.println("enter second : ");
        int second = input.nextInt();
        Time time = new Time(hour, minute, second);
        System.out.println(time.displayTime());

    }
}
