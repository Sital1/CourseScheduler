
/**
 * This class stores the information regarding the course.
 */
public class Courses {
	String department;
	String number;
	String building;
	String room;
	String instructor;

	/**
	 * Initialize a Courses object 
	 * @param department The department of the course
	 * @param number The course number
	 * @param building The building where the course is taught
	 * @param room The room number where the course is taught.
	 * @param instructor The name of the instructor.
	 */
	public Courses(String department, String number, String building, String room, String instructor) {
		this.department = department;
		this.number = number;
		this.building = building;
		this.room = room;
		this.instructor = instructor;
	
	}
	
	
	/**
	 * Getter method for Department.
	 * @return department The department of course.
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Getter method for course number.
	 * @return number The course number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Getter method for Building
	 * @return building The building where the course is taught.
	 */
	public String getBuilding() {
		return building;
	}


	/**
	 * Getter method for room
	 * @return room The room number of the course.
	 */
	public String getRoom() {
		return room;
	}


	/**
	 * Getter method for instructor.
	 * @return instructor The name of the instructor.
	 */
	public String getInstructor() {
		return instructor;
	}





	
}


