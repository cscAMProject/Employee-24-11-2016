package employee.bean;
public class Request {
	public int requestId,empId;
	public String managerApprovedDate,assetName,requestDate,status,requestType;
	public Request(){}
	
	
	public Request(int requestId, int empId, String managerApprovedDate, String assetName, String requestDate,
			String status, String requestType) {
		super();
		this.requestId = requestId;
		this.empId = empId;
		this.managerApprovedDate = managerApprovedDate;
		this.assetName = assetName;
		this.requestDate = requestDate;
		this.status = status;
		this.requestType = requestType;
	}


	public int getRequestId() {
		return requestId;
	}


	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getManagerApprovedDate() {
		return managerApprovedDate;
	}


	public void setManagerApprovedDate(String managerApprovedDate) {
		this.managerApprovedDate = managerApprovedDate;
	}


	public String getAssetName() {
		return assetName;
	}


	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}


	public String getRequestDate() {
		return requestDate;
	}


	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRequestType() {
		return requestType;
	}


	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
}

	
