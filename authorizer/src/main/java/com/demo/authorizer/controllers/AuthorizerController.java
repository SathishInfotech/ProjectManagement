package com.demo.authorizer.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.authorizer.dvo.EventInDVO;
import com.demo.authorizer.dvo.EventOutDVO;
import com.demo.authorizer.dvo.TaskDetailsDVO;
import com.demo.authorizer.dvo.TaskEstimationSheetDVO;
import com.demo.authorizer.dvo.TaskInfoDVO;
import com.demo.authorizer.dvo.TaskSheetDVO;

@Controller
public class AuthorizerController {

	@RequestMapping("/home")
	public String entry(){
		return "home";
	}
	
	@RequestMapping("/tasks")
	public String viewTask(){
		return "tasks";
	}
	
	@RequestMapping("/teamresources")
	public String viewResources(){
		return "teamresources";
	}
	
	@RequestMapping("/tasksheet")
	public ModelAndView viewTaskSheet(){
		TaskDetailsDVO taskDetailsDVO = new TaskDetailsDVO();
		List<TaskDetailsDVO> taskDetailsDVOs = new ArrayList<TaskDetailsDVO>();
		taskDetailsDVOs.add(taskDetailsDVO);
		TaskSheetDVO taskSheet = new TaskSheetDVO();
		taskSheet.setTaskDetailsDVOs(taskDetailsDVOs);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		taskSheet.setSheetDate(dateFormat.format(new Date()));
		ModelAndView mv = new  ModelAndView("tasksheet", "taskSheet", taskSheet);
		return mv;
	}
	
	@RequestMapping("/taskestimation")
	public ModelAndView viewTaskEstimationSheet(){
		TaskInfoDVO taskInfoDVO = new TaskInfoDVO();
		List<TaskInfoDVO> taskInfoDVOs = new ArrayList<TaskInfoDVO>();
		taskInfoDVOs.add(taskInfoDVO);
		TaskEstimationSheetDVO taskEstSheet = new TaskEstimationSheetDVO();
		taskEstSheet.setTaskInfoDVOs(taskInfoDVOs);;
		ModelAndView mv = new  ModelAndView("taskestimation", "taskEstSheet", taskEstSheet);
		return mv;
	}
	
	@RequestMapping("/editprofile")
	public String editProfile(){
		return "editprofile";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		model.setViewName("security/login");
		if (error != null) {
			model.addObject("loginMsg", "Invalid username and password!");
			model.addObject("loginClass", "red");
		}
		if (logout != null) {
			model.addObject("loginMsg", "Hasta la vista!!! Logged out successfully");
			model.addObject("loginClass", "positive");
		}
		return model;

	}
	
	@RequestMapping("getTasksCalendar")
	@ResponseBody
	public List<EventOutDVO> getTasksCalendar(@RequestBody EventInDVO eventInput){
		List<EventOutDVO> events = new ArrayList<EventOutDVO>();
		EventOutDVO event = new EventOutDVO();
		event.setTitle("Meeting");
		event.setStart(new Date());
		event.setEnd(new Date());
		events.add(event);
		return events;
	}
	
	@RequestMapping("saveTaskSheet")
	public ModelAndView saveTaskSheet(@ModelAttribute TaskSheetDVO taskSheet, Principal principal){
		System.out.println(principal.getName());
		System.out.println(taskSheet);
		ModelAndView mv = new ModelAndView("tasksheet", "taskSheet",taskSheet);
		mv.addObject("disabled", "disabled");
		mv.addObject("saveStatus", "Your task has been successfully saved");
		return mv;
	}
}
