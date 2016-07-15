package com.demo.authorizer.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.authorizer.dvo.TimeTrackerDVO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;
import com.demo.authorizer.service.TimeTrackerService;

@Controller
public class TimeTrackerController {

    @Autowired
    private TimeTrackerService timeTrackerService;

    @RequestMapping(value = "/timetracker", method = RequestMethod.GET)
    public String getTimeTracker(Model model) {
	TimeTrackerDVO timeTrackerDVO = timeTrackerService.getInitDetails(1);
	model.addAttribute("timetracker", timeTrackerDVO);
	return "timetracker";
    }

    @RequestMapping(value = "saveTimeTracker", method = RequestMethod.GET)
    public String saveTimeTracker(/*TimeTrackerDVO timeTrackerDVO,*/ Model model) {
	TimeTrackerDetailsDVO timeTrackerDetailsDVO=new TimeTrackerDetailsDVO();
	timeTrackerDetailsDVO.setActivityId("1");
	timeTrackerDetailsDVO.setHoursSpent("20");
	timeTrackerDetailsDVO.setPhaseId("3");
	timeTrackerDetailsDVO.setSubphaseId("1");
	timeTrackerDetailsDVO.setTaskId("1");
	timeTrackerDetailsDVO.setUserId("1");
	timeTrackerDetailsDVO.setRemark("time sheet filled");
	timeTrackerDetailsDVO.setTimeDate("12-02-2016");
	List<TimeTrackerDetailsDVO> timeTrackerDetailsList=new ArrayList<TimeTrackerDetailsDVO>();
	timeTrackerDetailsList.add(timeTrackerDetailsDVO);
	TimeTrackerDVO timeTrackerDVO=new TimeTrackerDVO();
	timeTrackerDVO.setTimeTrackerDetailsDVOs(timeTrackerDetailsList);
	boolean response = timeTrackerService.saveTimeTrackerDetails(timeTrackerDVO.getTimeTrackerDetailsDVOs());
	if (response) {
	    TimeTrackerDVO timetracker = timeTrackerService.getInitDetails(1);
	    model.addAttribute("timetracker", timetracker);
	    model.addAttribute("saveStatus", "Your task has been successfully saved");
	} else {
	    model.addAttribute("saveStatus", "Error has been occured while saving details");
	}
	return "timetracker";
    }

    @RequestMapping(value = "/viewtimetracker", method = RequestMethod.GET)
    public String getViewTimeTracker(Model model) {
	System.out.println("get view time tracker");
	TimeTrackerDVO timeTrackerDVO = timeTrackerService.getAlProjects();
	model.addAttribute("timetracker", timeTrackerDVO);
	return "viewtimetracker";
    }

    @RequestMapping(value = "/getUsersByProject", method = RequestMethod.GET)
    @ResponseBody
    public TimeTrackerDVO getUsersByProject(String projectid, Model model) {
	if ("".equals(projectid.trim())) {
	    return null;
	} else {
	    System.out.println("get view time tracker" + projectid);
	    TimeTrackerDVO timeTrackerDVO = timeTrackerService.getUserByProject(Integer.valueOf(projectid));
	    System.out.println("Users Details:" + timeTrackerDVO.getUsers());
	    return timeTrackerDVO;
	}
    }

    @RequestMapping(value = "/viewtimetracker", method = RequestMethod.POST)
    public String postViewTimeTracker(Model model, TimeTrackerDetailsDVO timeTrackerDetailsDVO) {
	TimeTrackerDVO timeTrackerDVO=timeTrackerService.getAllTaskDetailsByUserIdandProjectId(Integer.valueOf(timeTrackerDetailsDVO.getUserId()), timeTrackerDetailsDVO.getTimeDate());
	TimeTrackerDVO timeTrackerRespDVO = timeTrackerService.getAlProjects();
	model.addAttribute("timetracker", timeTrackerRespDVO);
	model.addAttribute("viewTimetrackerDetails",timeTrackerDVO);
	return "viewtimetracker";
    }

}
