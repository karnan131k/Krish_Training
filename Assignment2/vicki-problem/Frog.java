import java.util.*;
public class Frog{
 public static int timeCalculation(double distance){
  int time=0;
   while(distance>0){
    if(distance<=5){
     distance =distance-5;
     time=time+1;
    }else if(distance<=8){
     distance =distance-8;
     time=time+3;
    }else if (distance<=9){
     distance =distance-9;
     time=time+6;
    }else {
     int dis =(int)distance/9;
     time= 6*dis;
     distance = distance%9;
    }
  }
 return time;
 } 
 public static void main(String[] args){
  try {
   Scanner scanner = new Scanner(System.in);
   System.out.println("Enter the distance to travel by vicki ?");
   double distance = scanner.nextDouble();
   if (distance<0){
    System.out.println("Only Poisitive Numbers && no Letters");
     distance = scanner.nextDouble();
   }
   System.out.println("Vicki will take time(seconds) :- " + timeCalculation(distance));
  } catch (InputMismatchException e){
    System.out.println(e);
  }
 }
}