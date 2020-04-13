import java.io.FileNotFoundException;

/**
   Program to test the basic functionality of the the CourseScheduler class
   @author Dr. J. Cordova
*/   

public class SchedulerTest
{
   public static void main (String[] args) throws FileNotFoundException, InterruptedException
   {
	   

//
//CourseScheduler schedule1 = 
//    new CourseScheduler("aa.txt");
//System.out.println("aa.txt");
//System.out.print(schedule1.getSchedule(1));

//String [] slot1 = {"BUSN 1001", "CINS 3044", "RMIN 3008", "ACCT 3008", "CSCI 3011",
//  "MRKT 3002", "MGMT 4030", "ECON 3020", "ACCT 1020", "CONS 2011"};
//
//boolean ok = true;
//
//for (String course: slot1)
//{
//  String out = schedule1.reachable(course);
//  System.out.println(out);
////  ok = ok && out.contains("1 course") && out.contains(course); 
//}
//	   System.out.println(ok);
     
////	   CourseScheduler schedule1 = 
////			    new CourseScheduler("CBAClasses10.txt");
////	   //schedule1.solutionExists(2);
////			System.out.println("CBAClasses10.txt");
////			System.out.print(schedule1.getSchedule(2));
////			String output1 = schedule1.getSchedule(2);
////			System.out.println(output1);
////			System.out.print (output1.toLowerCase().contains("no solution with 2 slots"));
	CourseScheduler schedule1 = new CourseScheduler("CBAClasses10.txt");
    CourseScheduler schedule2 = new CourseScheduler("CBAClasses20.txt");
////      
////       System.out.println("SCHEDULE 1 RESULTS:\n");
      System.out.println("There is a 2-slot solution: " + schedule1.solutionExists(3)); 
      System.out.println("There is a 2-slot solution: " + schedule1.solutionExists(3)); 
    System.out.println("Two-slot solution: " + schedule1.getSchedule(3));
////     System.out.println("\nThere is a 3-slot solution: " + schedule1.solutionExists(3)); 
////   System.out.println("\nThree-slot solution: " + schedule1.getSchedule(3));   
     System.out.println("\nReachable from BUSN 1001: " + schedule1.reachable("ACCT 4020"));
//////
//   System.out.println("\nSCHEDULE 2 RESULTS:");
//  System.out.println("\nThere is a 6-slot solution: " + schedule2.solutionExists(5)); 
//
// System.out.println("\nThree-slot solution: " + schedule2.solutionExists(7));  
//
// System.out.println("\nThree-slot solution: asdasdasd" + schedule2.getSchedule(7));  
//      System.out.println("\nReachable from BUSN 1001: " + schedule2.reachable("MRKT 3005"));
    }
}
