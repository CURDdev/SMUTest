package com.smu.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smu.model.Station;
import com.smu.model.Case;
import com.smu.service.ICaseService;
import com.smu.service.IStationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.smu.util.stationInfo;
public class StationAction extends ActionSupport{
	private IStationService stationService;
	private ICaseService caseService;
    private int test_id;

	public ICaseService getCaseService() {
		return caseService;
	}

	public void setCaseService(ICaseService caseService) {
		this.caseService = caseService;
	}

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
		List<Station> stations = stationService.gainAllStations(test_id);

		List<stationInfo> stationInfos = new ArrayList<stationInfo>();
		for(int i = 0;i<=stations.size()-1;i++){
			stationInfo s = new stationInfo();
			s.setStationId(stations.get(i).getStId());
			s.setStationName(stations.get(i).getStName());
			List<Case> cases = caseService.getCases(stations.get(i).getStId());
			String caseInfo =  cases.get(0).getCName();
			for(int j = 1;j<=cases.size()-1;j++){
				caseInfo = caseInfo + "," + cases.get(j).getCName();
			}
			s.setStationCases(caseInfo);
			stationInfos.add(s);
		}
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("stations", stationInfos);
		requestMap.put("t_id", test_id);
		return SUCCESS;
	}

}
