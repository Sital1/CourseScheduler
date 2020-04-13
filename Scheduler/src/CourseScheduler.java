// Importing packages.

/**
Date:04/10/2020
Course:CSCI 3005
Description: This program finds the time slots for courses using backtracking(graphColoring) algorithm. 
On my honor, I have neither given nor received unauthorized help while completing this assignment.
Name: Sital Sitoula
CWID: 30112741
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program finds the time slots for courses using backtracking(graphColoring) algorithm. 
 */
public class CourseScheduler {
	ArrayList<Courses> courses = new ArrayList<Courses>();
	int courseNumber;
	ArrayList<Integer> time = new ArrayList<Integer>();

	boolean solve = true;
	boolean flag2 = true;

	/**
	 * Initializes the CourseScheduler object. Reads the file and add details regarding course into a arraylist.
	 * @param filename The name of the file to be read
	 * @throws FileNotFoundException
	 */
	public CourseScheduler(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		courseNumber = Integer.parseInt(scanner.nextLine());
		while (scanner.hasNextLine()) {

			Scanner line = new Scanner(scanner.nextLine());
			line.useDelimiter(",");
			while (line.hasNext()) {
				Courses course = new Courses(line.next(), line.next(), line.next(), line.next(), line.next());
				courses.add(course);
				time.add(0);
			}
			line.close();
		}
		scanner.close();
		
	}

	/**
	 * Checks if two courses have same instructor.
	 * @param i The index of the array list.
	 * @param j The index of the array list.
	 * @return True if the instructor are same
	 */
	private boolean checkInstructor(int i, int j) {
		if (courses.get(i).getInstructor().equals(courses.get(j).getInstructor())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if two Rooms are same.
	 * @param i The index of the array list.
	 * @param j The index of the array list.
	 * @return True if the Rooms are same.
	 */
	private boolean checkClassRoom(int i, int j) {

		if (courses.get(i).getRoom().equals(courses.get(j).getRoom())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the department are same and the courses are 3000 or 4000 level courses.
	 * @param i The index of the array list.
	 * @param j The index of the array list.
	 * @return True if the department are same and the courses are 3000 or 4000 level courses.
	 */
	private boolean checkDepartment(int i, int j) {
		String cn1 = courses.get(i).getNumber().substring(0, 1);

		String cn2 = courses.get(j).getNumber().substring(0, 1);
		boolean f1 = cn1.equals("3") && cn2.equals("4");

		boolean f2 = cn1.equals("4") && cn2.equals("3");
		boolean f3 = cn1.equals("3") && cn2.equals("3");
		boolean f4 = cn1.equals("4") && cn2.equals("4");
		if ((courses.get(i).getDepartment().equals(courses.get(j).getDepartment())) && (f1 || f2 || f3 || f4)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a course can be kept under particular time slot
	 * @param v The index of the arrayList.
	 * @param timeSlot The time slot.
	 * @param k The index of the arrayList.
	 * @return True if the course can be kept in the particular time slot.
	 */
	private boolean isSafe(int v, int timeSlot, int k) {
		for (int i = 0; i < v; i++) {
		
			if ((checkInstructor(v, i) || checkClassRoom(v, i) || checkDepartment(v, i))) {
				if (k == 1) {
					
					return true;
				}

				if ((timeSlot == time.get(i))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Backtracking algorithm to assign timeSlot to courses.
	 * @param m The number of timeSlots.
	 * @param i The course number.
	 * @return True if all the courses were successfully assigned a timeSlot.
	 */
	private boolean backtrack(int m, int i)
	{
		int backtrackOver = 1; 
		if (i == courseNumber) {
			return true;
		}
		for (int timeSlot = 1; timeSlot <= m; timeSlot++) {
			if (isSafe(i, timeSlot, 0)) {
				time.set(i, timeSlot);
				if (i + 1 <= courseNumber) {		
					if (backtrack(m, i + 1)) {
						return true;
					}
					System.out.println("I: "+i);

					time.set(i, 0);
					backtrackOver = -1;
					if (backtrackOver < 0) {
						return false;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if given number of timeSlots are enough to assign courses according to the requirement.
	 * @param m The number of time slots
	 * @return True if the of timeSlots are enough to assign courses according to the requirement.
	 */
	public boolean solutionExists(int m)  {
		if (!backtrack(m, 0)) {
			return false;
		}

		return true;
	}
	
	/**
	 * Displays the courses in their respective time slot.
	 * @param m The number of time slots.
	 * @return A string with the information of courses in their respective time slot.
	 */
	public String getSchedule(int m){
		if (!backtrack(m, 0)) {
			solve = false;
		}

		String result = "No solution with " + m + " slots";
		
		if (solve) {
			result = "";
			for (int i = 1; i <= m; i++) {
				boolean flag =true;
				result = result + ("Time " + i + ": \n");
				for (int j = 0; j < time.size(); j++) {
					if (time.get(j) == i) {
						flag = false;
						result = result + courses.get(j).getDepartment() + " " + courses.get(j).getNumber() + " "
								+ courses.get(j).getBuilding() + " " + courses.get(j).getRoom() + " "
								+ courses.get(j).getInstructor() + "\n";
					}
				}
				result = result + "\n";
				if (flag==true)
				{
					result = result+ "NO courses in this slot\n";
					
				}
				
			}
		}

		return result;

	}
	
	/**
	 * Creates an adjacency matrix of courses.
	 * @return matrix the adjacency matrix.
	 */
	private int[][] adj()
	{	
		int [][] matrix = new int[courseNumber][courseNumber];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if ((checkInstructor(i,j) || checkClassRoom(i,j) || checkDepartment(i,j))) {
					matrix[i][j] = 1;
				}
			}
		}
		return matrix;
	}
	
	/**
	 * Conducts a depth first search on the courses
	 * @param i The index of the element to start the depth-first search from.
	 * @param visited An array of the element to keep track of the courses(nodes) that have been visited.
	 * @param result
	 * @return  visited The visited array
	 */
	private boolean[] DFS(int i, boolean visited[], String result) {

		visited[i] = true;
		for (int j = 0; j < courses.size(); j++) {
		

			if (!visited[j] && adj()[i][j] == 1) {
			
				result = result + courses.get(i).getDepartment() + " " + courses.get(i).getNumber();
				DFS(j, visited, result);
			}
		}

		return visited;
	}

	public String reachable(String from) {
		int start = 0;
		String check = "";
		String result = "";
		boolean[] vistied = new boolean[courseNumber];
		for (int i = 0; i < courses.size(); i++) {
			check = courses.get(i).getDepartment()+" "+courses.get(i).getNumber();
			System.out.println(check);
			if (from.equals(check)) {
				start = i;
				break;
			}
		}
		  vistied = DFS(start,vistied,result);
		  
		  int i =0;
		  int j =0;
		  for(boolean course:vistied)
		  {		
			  if(course)
			  {	
				
				result =   result +", "+ courses.get(i).getDepartment() + " " + courses.get(i).getNumber();
				j++;
			  }
			  i++;
			  
		  }
		  
		  if(j ==1)
		  {  
			  return j+" course: "+from;
			  
		  }
		  return j+" courses: "+result.substring(1);
		
	}
}
