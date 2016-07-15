package com.demo.authorizer.controllers;

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

    @RequestMapping(value = "saveTimeTracker", method = RequestMethod.POST)
    public String saveTimeTracker(TimeTrackerDVO timeTrackerDVO, Model model) {
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
	System.out.println("project id" + timeTrackerDetailsDVO.getProjectId());
	System.out.println("User id:" + timeTrackerDetailsDVO.getUserId());
	System.out.println("Date:" + timeTrackerDetailsDVO.getTimeDate());
	return "viewtimetracker";
    }

}
