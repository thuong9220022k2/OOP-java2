import java.util.Scanner ;
public class DayOfMonth{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input month: ");
        int month = keyboard.nextInt();
        System.out.println("Input year");
        int year = keyboard.nextInt();
        switch(month){
            case 1,3,5,7,8,12:
               System.out.println("Month " + " " + month + " " +" has 31 days");
               break;
            case 2:
               if(year % 4 == 0){
                   System.out.println("Month"+" " + month + " " + " has 29 days");
               }
               else{
                   System.out.println("Month"+" " + month + " " + " has 28 days");                 
               }
               break;
            case 4,6,9,11 :
               System.out.println("Month " + " " + month + " "+ " has 30 days");
               break;
        }
    }

}