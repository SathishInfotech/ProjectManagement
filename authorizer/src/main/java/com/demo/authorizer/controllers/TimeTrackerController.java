package com.demo.authorizer.controllers;

import javax.servlet.http.HttpSession;

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
    public String getTimeTracker(Model model,HttpSession session) {
	int userid=1;
	TimeTrackerDVO timeTrackerDVO = timeTrackerService.getInitDetails(userid);
	model.addAttribute("timetracker", timeTrackerDVO);
	return "timetracker";
    }

    @RequestMapping(value = "/getTimeTrckerforDropdown", method = RequestMethod.GET)
    @ResponseBody
    public TimeTrackerDVO getUsersByProject(HttpSession session) {
	int userid=1;
	TimeTrackerDVO timeTrackerDVO = timeTrackerService.getInitDetails(userid);
	return timeTrackerDVO;
    }

    @RequestMapping(value = "/getActicitiesByTaskId", method = RequestMethod.GET)
    @ResponseBody
    public TimeTrackerDVO getActicitiesByTaskId(String taskid) {
	if ("".equals(taskid.trim())) {
	    return null;
	} else {
	    TimeTrackerDVO timeTrackerDVO = timeTrackerService.getActicitiesByTaskId(Integer.valueOf(taskid));
	    return timeTrackerDVO;
	}
    }

    @RequestMapping(value = "/getSubphasesByPhasId", method = RequestMethod.GET)
    @ResponseBody
    public TimeTrackerDVO getSubphasesByPhasId(String phaseid) {
	if ("".equals(phaseid.trim())) {
	    return null;
	} else {
	    TimeTrackerDVO timeTrackerDVO = timeTrackerService.getSubphasesByPhasId(Integer.valueOf(phaseid));
	    return timeTrackerDVO;
	}
    }

    @RequestMapping(value = "/saveTimeTracker", method = RequestMethod.POST)
    public String saveTimeTracker(TimeTrackerDVO timeTrackerDVO,Model model,HttpSession session) {
	int userid=1;
	boolean response = timeTrackerService.saveTimeTrackerDetails(timeTrackerDVO.getTimeTrackerDetailsDVOs(),userid);
	if (response) {
	    TimeTrackerDVO timetracker = timeTrackerService.getInitDetails(userid);
	    model.addAttribute("timetracker", timetracker);
	    model.addAttribute("saveStatus", "Your Timetracker has been successfully saved");
	    model.addAttribute("status", "Success:");
	} else {
	    model.addAttribute("saveStatus", "Error has been occured while saving details");
	    model.addAttribute("status", "Error:");
	}
	return "timetracker";
    }

    @RequestMapping(value = "/viewtimetracker", method = RequestMethod.GET)
    public String getViewTimeTracker(Model model) {
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
	    TimeTrackerDVO timeTrackerDVO = timeTrackerService.getUserByProject(Integer.valueOf(projectid));
	    return timeTrackerDVO;
	}
    }

    @RequestMapping(value = "/viewtimetracker", method = RequestMethod.POST)
    public String postViewTimeTracker(Model model, TimeTrackerDetailsDVO timeTrackerDetailsDVO) {
	TimeTrackerDVO timeTrackerDVO = timeTrackerService.getAllTaskDetailsByUserIdandProjectId(Integer.valueOf(timeTrackerDetailsDVO.getUserId()), timeTrackerDetailsDVO.getTimeDate());
	model.addAttribute("viewTimetrackerDetails", timeTrackerDVO);
	TimeTrackerDVO timeTrackerRespDVO = timeTrackerService.getAlProjects();
	model.addAttribute("timetracker", timeTrackerRespDVO);
	return "viewtimetracker";
    }
}
