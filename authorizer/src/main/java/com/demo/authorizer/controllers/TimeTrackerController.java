package com.demo.authorizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.authorizer.dvo.TimeTrackerDVO;
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
    
    

}
