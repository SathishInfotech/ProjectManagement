package com.demo.authorizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.authorizer.dvo.TimeTrackerDVO;
import com.demo.authorizer.dvo.TimeTrackerDetailsDVO;
import com.demo.authorizer.service.TimeTrackerService;

@Controller
public class TimeTrackerController {

    @Autowired
    private TimeTrackerService timeTrackerService;

    @RequestMapping("/timetracker")
    public ModelAndView getTimeTracker() {
	TimeTrackerDVO timeTrackerDVO = timeTrackerService.getInitDetails(1);
	ModelAndView mv = new ModelAndView("timetracker", "timetracker", timeTrackerDVO);
	return mv;
    }

    @RequestMapping("saveTimeTracker")
    public ModelAndView saveTimeTracker(@ModelAttribute TimeTrackerDVO timeTrackerDVO) {
	boolean response = timeTrackerService.saveTimeTrackerDetails(timeTrackerDVO.getTimeTrackerDetailsDVOs());
	ModelAndView mv = new ModelAndView("timetracker", "timetracker", timeTrackerService.getInitDetails(1));
	if (response) {
	    mv.addObject("saveStatus", "Your task has been successfully saved");
	} else {
	    mv.addObject("saveStatus", "Error has been occured while saving details");
	}
	return mv;
    }

    @RequestMapping(value = "/viewtimetracker", method = RequestMethod.GET)
    public String getViewTimeTracker(Model model) {
	System.out.println("get view time tracker");
	TimeTrackerDVO timeTrackerDVO = timeTrackerService.getAlProjects();
	model.addAttribute("projects", timeTrackerDVO);
	return "viewtimetracker";
    }

    @RequestMapping(value = "/getUsersByProject", method = RequestMethod.GET)
    @ResponseBody
    public String getUsersByProject(Model model) {
	System.out.println("get view time tracker");
	TimeTrackerDVO timeTrackerDVO = timeTrackerService.getUserByProject(1);
	System.out.println("Users Details:"+timeTrackerDVO.getUsers());
	//model.addAttribute("projects", timeTrackerDVO.getProjects());
	return "viewtimetracker";
    }
    
    @RequestMapping(value = "/viewtimetracker", method = RequestMethod.POST)
    public String postViewTimeTracker(Model model, TimeTrackerDetailsDVO timeTrackerDetailsDVO) {

	System.out.println("post view time tracker");
	return "viewtimetracker";
    }

}
