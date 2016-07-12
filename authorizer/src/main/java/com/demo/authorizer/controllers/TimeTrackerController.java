package com.demo.authorizer.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
		TimeTrackerDetailsDVO timeTrackerDetailsDVO = new TimeTrackerDetailsDVO();
		List<TimeTrackerDetailsDVO> timeTrackerDetailsDVOs = new ArrayList<TimeTrackerDetailsDVO>();
		timeTrackerDetailsDVOs.add(timeTrackerDetailsDVO);
		TimeTrackerDVO timeTrackerDVO = new TimeTrackerDVO();
		timeTrackerDVO.setTimeTrackerDetailsDVOs(timeTrackerDetailsDVOs);
		ModelAndView mv = new ModelAndView("timetracker", "timetracker", timeTrackerDVO);
		return mv;
	}

	@RequestMapping("saveTimeTracker")
	public ModelAndView saveTimeTracker(@ModelAttribute TimeTrackerDVO timeTrackerDVO) {
		for (TimeTrackerDetailsDVO timeTracker : timeTrackerDVO.getTimeTrackerDetailsDVOs()) {
			System.out.println("*******Row Number**********");
			System.out.println("Time:" + timeTracker.getTimeDate());
			System.out.println("Task Name:" + timeTracker.getTaskId());
			System.out.println("Activity Name:" + timeTracker.getActivityId());
			System.out.println("Phase:" + timeTracker.getPhaseId());
			System.out.println("SubPhase:" + timeTracker.getSubphaseId());
			System.out.println("Hours:" + timeTracker.getHoursSpent());
			System.out.println("Remarks:" + timeTracker.getRemark());

		}
		//timeTrackerService.saveTimeTrackerDetails(timeTrackerDetailsDVO);
		ModelAndView mv = new ModelAndView("timetracker", "timetracker", new TimeTrackerDVO());
		mv.addObject("disabled", "disabled");
		mv.addObject("saveStatus", "Your task has been successfully saved");
		return mv;
	}

}
