package com.demo.authorizer.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.demo.authorizer.dvo.TaskActivityDetailsDVO;
import com.demo.authorizer.dvo.TaskDVO;
import com.demo.authorizer.dvo.TaskDetailsDVO;
import com.demo.authorizer.dvo.TaskEstimationSheetDVO;
import com.demo.authorizer.dvo.TaskInfoDVO;
import com.demo.authorizer.dvo.TaskSheetDVO;
import com.demo.authorizer.service.impl.TaskServiceImpl;
import com.demo.authorizer.service.TaskSheetService;

@Controller
public class AuthorizerController {
	
	@Autowired
	TaskServiceImpl taskServiceImpl;
	@Autowired
	private TaskSheetService taskSheetService;

	@RequestMapping("/home")
	public String entry(){
		
		return "home";
	}
	@RequestMapping("/homeManager")
	public String Manager(){
		return "homeManager";
	}
	
	
	@RequestMapping("/tasks")
	public String viewTask(){
		return "tasks";
	}
	
	@RequestMapping("/teamresources")
	public String viewResources(){
		return "teamresources";
	}
	
	@RequestMapping("/createtask")
	public ModelAndView  createTask(HttpServletRequest request){
		TaskDVO taskDVO = taskServiceImpl.initTask();
		ModelAndView model = new ModelAndView("createtask");
		model.addObject("taskDVO", taskDVO);
		return model;
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public TaskDVO  getUser(String projectId){
		TaskDVO taskDVO = taskServiceImpl.getUsers(projectId);
		return taskDVO;
	}
	
	
	
	@RequestMapping("/savetask")
	public ModelAndView saveTask(TaskDVO taskDVO){
		taskServiceImpl.create(taskDVO);
		TaskDVO taskDVOResp = taskServiceImpl.initTask();
		ModelAndView model = new ModelAndView("createtask");
		model.addObject("taskDVO", taskDVOResp);
		model.addObject("loginMsg", "Task Created successfully");
		model.addObject("loginClass", "positive");
		return model;
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
	
	@RequestMapping("saveTaskEstSheet")
	public ModelAndView saveTaskSheet(@ModelAttribute TaskEstimationSheetDVO taskSheet, Principal principal){
		System.out.println(taskSheet);
		List<TaskInfoDVO> taskInfoDVOs = taskSheetService.generateSheet(taskSheet);
		TaskEstimationSheetDVO updatedTaskEstimationSheetDVO = taskSheet;
		updatedTaskEstimationSheetDVO.setTaskInfoDVOs(taskInfoDVOs);
		ModelAndView mv = new ModelAndView("taskestimationdetails", "taskEstSheet", updatedTaskEstimationSheetDVO);
		mv.addObject("disabled", "disabled");
		mv.addObject("saveStatus", "Your task has been successfully saved");
		System.out.println(updatedTaskEstimationSheetDVO);
		return mv;
	}
	
	@RequestMapping("/viewtask")
	public ModelAndView  viewTask(HttpServletRequest request){
		TaskDVO taskDVO = taskServiceImpl.initTask();
		ModelAndView model = new ModelAndView("viewtask");
		model.addObject("taskDVO", taskDVO);
		return model;
	}
	
	@RequestMapping("/viewtaskdetails")
	@ResponseBody
	public List<TaskDVO>  viewTaskDetails(TaskDVO taskDVO){
		List<TaskDVO> taskDVOs = taskServiceImpl.getTaskDetails(taskDVO);
		return taskDVOs;
	}
	
	@RequestMapping("/viewactivity")
	@ResponseBody
	public List<TaskActivityDetailsDVO>  viewActivity(TaskDVO taskDVO){
		List<TaskActivityDetailsDVO> taskDVOs = taskServiceImpl.viewActivity(taskDVO);
		return taskDVOs;
	}
	
	
}
