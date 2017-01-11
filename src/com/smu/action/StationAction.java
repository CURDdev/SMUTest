package com.smu.action;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.smu.service.IStationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class StationAction extends ActionSupport{
	private IStationService stationService;
    private int test_id;
    
	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public IStationService getStationService() {
		return stationService;
	}

	public void setStationService(IStationService stationService) {
		this.stationService = stationService;
	}
	public String showAllStations() throws Exception{
		List stations = stationService.gainAllStations(test_id);
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("stations", stations);
		requestMap.put("t_id", test_id);
		return SUCCESS;
	}

}
