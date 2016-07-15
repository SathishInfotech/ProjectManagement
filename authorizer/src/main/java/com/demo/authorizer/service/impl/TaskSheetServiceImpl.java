package com.demo.authorizer.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.authorizer.dvo.SheetDatesDVO;

import com.demo.authorizer.dvo.TaskEstimationSheetDVO;
import com.demo.authorizer.dvo.TaskInfoDVO;
import com.demo.authorizer.service.TaskSheetService;

@Service
public class TaskSheetServiceImpl implements TaskSheetService {

	private static final int DAILY_HOURS = 9;
	private static final String DATE_FORMAT = "dd-MM-yyyy";
	
	@Override
	public List<TaskInfoDVO> generateSheet(TaskEstimationSheetDVO taskEstSheet) {

		double sum = 0;
		double days = 0;
		double totalDays = 0;
		List<String> leaveDays = new ArrayList<String>();
		initLeaveDays(leaveDays);
		//Map<String, Integer> taskMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> dateMap = new LinkedHashMap<String, Integer>();
		Map<TaskInfoDVO, SheetDatesDVO> taskSheetMap = new LinkedHashMap<TaskInfoDVO, SheetDatesDVO>();
		Map<TaskInfoDVO, Integer> taskMap = initTaskDetails(taskEstSheet);
		for (Map.Entry<TaskInfoDVO, Integer> tasks : taskMap.entrySet()) {
			sum += tasks.getValue();
		}
		days = sum / DAILY_HOURS;
		totalDays = Math.ceil(days);
		totalDays = totalDays + leaveDays.size();
		populateWorkingDays(totalDays, dateMap,taskEstSheet.getBeginDate());
		for (String leaveDay : leaveDays) {
			dateMap.remove(leaveDay);
		}
		while (!taskMap.isEmpty()) {

			TaskInfoDVO taskKey = taskMap.keySet().iterator().next();
			int taskHr = taskMap.get(taskKey);
			String dateKey = dateMap.keySet().iterator().next();
			int dateHr = dateMap.get(dateKey);
			if (taskSheetMap.get(taskKey) == null) {
				SheetDatesDVO sheetdate = new SheetDatesDVO();
				sheetdate.setStartDate(dateKey);
				taskSheetMap.put(taskKey, sheetdate);
			}
			int diff = taskHr - dateHr;
			if (diff > 0) {
				dateMap.remove(dateKey);
				taskMap.put(taskKey, diff);
			} else if (diff < 0) {
				taskMap.remove(taskKey);
				taskSheetMap.get(taskKey).setEndDate(dateKey);
				dateMap.put(dateKey, Math.abs(diff));
			} else if (diff == 0) {
				taskMap.remove(taskKey);
				dateMap.remove(dateKey);
				taskSheetMap.get(taskKey).setEndDate(dateKey);
			}
		}
		return printTaskSheet(taskSheetMap);
	
	}

	// Add your task here.param = name,hours
	private Map<TaskInfoDVO, Integer> initTaskDetails(TaskEstimationSheetDVO taskEstSheet) {
		Map<TaskInfoDVO, Integer> taskMap = new LinkedHashMap<TaskInfoDVO, Integer>();
		List<TaskInfoDVO> taskinfos =  taskEstSheet.getTaskInfoDVOs();
		for(TaskInfoDVO taskInfoDVO:taskinfos){
			taskMap.put(taskInfoDVO, taskInfoDVO.getEstimatedHour());
		}
		return taskMap;
	}

	// Add your leaves here.No weekends reqd
	private  void initLeaveDays(List<String> leaveDays) {
		/*leaveDays.add("13-05-2016");
		leaveDays.add("16-05-2016");*/
	}


	private  void populateWorkingDays(double totalDays,
			Map<String, Integer> dateMap,Date beginDate) {
		//Date date = setStartDate();
		for (int i = 0; i < totalDays; i++) {
			if (i == 0) {
				dateMap.put(getSimpleDate(beginDate), DAILY_HOURS);
				continue;
			}
			beginDate = getNextWorkingDay(beginDate);
			dateMap.put(getSimpleDate(beginDate), DAILY_HOURS);
		}
	}

	private  Date getNext(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	private  Date getNextWorkingDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getNext(date));
		while (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.setTime(getNext(cal.getTime()));
		}
		return cal.getTime();
	}

	private  String getSimpleDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		return dateFormat.format(date);
	}
	
	private  Date getDateFromString(String ddmmyyyy) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
			return dateFormat.parse(ddmmyyyy);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private  List<TaskInfoDVO> printTaskSheet(Map<TaskInfoDVO, SheetDatesDVO> taskSheet) {
		List<TaskInfoDVO> taskinfos = new ArrayList<TaskInfoDVO>();
		for(Map.Entry<TaskInfoDVO, SheetDatesDVO> taskInfo:taskSheet.entrySet()){
			System.out.println(taskInfo.getKey()+":"+taskInfo.getValue());
			TaskInfoDVO taskInfoDVO = taskInfo.getKey();
			SheetDatesDVO sheetDatesDVO = taskInfo.getValue();
			taskInfoDVO.setStartDate(sheetDatesDVO.getStartDate());
			taskInfoDVO.setEndDate(sheetDatesDVO.getEndDate());
			taskinfos.add(taskInfoDVO);
		}
		return taskinfos;
	}


}
