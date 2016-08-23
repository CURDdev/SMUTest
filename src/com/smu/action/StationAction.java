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

	public IStationService getStationService() {
		return stationService;
	}

	public void setStationService(IStationService stationService) {
		this.stationService = stationService;
	}
	public String showAllStations() throws Exception{
		List stations = stationService.gainAllStations();
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("stations", stations);
		return SUCCESS;
	}

}
