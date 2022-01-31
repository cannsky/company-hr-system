import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Student Name: Can Gok, id: 150118014
 * Project class of the program
 */

public class Project {
	
	private String projectName;
	
	private Calendar startDate;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private boolean state;
	
	public Project(String sName, Calendar startDate, String state) {
		this.projectName = sName;
		this.startDate = startDate;
		if(state.equals("Open")) {
			this.state = true;
		} else if(state.equals("Close")) {
			this.state = false;
		} else {
			//Throw exception
		}
	}
	
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", startDate=" + dateFormat.format(startDate.getTime()) + ", state=" + state + "]";
	}

	public String getState() {
		if(this.state == true) {
			return "Open";
		} else if(this.state == false) {
			return "Close";
		} else {
			//Throw exception
		}
		return null;
	}

	public void setState(String state) {
		if(state.equals("Open")) {
			this.state = true;
		} else if(state.equals("Close")) {
			this.state = false;
		} else {
			//Throw exception
		}
	}
	
	public void close() {
		if(state) {
			this.state = false;
		}
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	
}
