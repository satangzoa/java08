package daoex.entity;

public class Dept {
	private int deptId;
	private String deptName;
	private int locID;
	
	public Dept() {
	}

	public Dept(int deptId, String deptName, int locID) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.locID = locID;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getLocID() {
		return locID;
	}

	public void setLocID(int locID) {
		this.locID = locID;
	}
	
	
	
}
