package authorizer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskSheetGenerator {
	
	private static final int DAILY_HOURS = 9;
	private static final String DATE_FORMAT = "dd-MM-yyyy";

	// Add your task here.param = name,hours
	private static void initTaskDetails(Map<String, Integer> taskMap) {
		taskMap.put("Design", 35);
		taskMap.put("Controllers/SAL", 8);
		taskMap.put("Facade", 2);
		taskMap.put("TaskImpl", 16);
		taskMap.put("BPM", 1);
		taskMap.put("ESB", 1);
		taskMap.put("Filenet", 0);
		taskMap.put("DB", 32);
		taskMap.put("BackBone", 20);
		taskMap.put("UnitTesting", 35);
		taskMap.put("Code Review", 2);
		taskMap.put("Code Rework", 5);
	}

	// Add your leaves here.No weekends reqd
	private static void initLeaveDays(List<String> leaveDays) {
		leaveDays.add("13-05-2016");
		leaveDays.add("16-05-2016");
	}

	//Set a start date here.Format dd-mm-yyyy
	private static Date setStartDate() {
		return getDateFromString("13-05-2016");
	}
	
	public static void main(String[] args) {
		double sum = 0;
		double days = 0;
		double totalDays = 0;
		List<String> leaveDays = new ArrayList<String>();
		initLeaveDays(leaveDays);
		Map<String, Integer> taskMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> dateMap = new LinkedHashMap<String, Integer>();
		Map<String, SheetDates> taskSheetMap = new LinkedHashMap<String, SheetDates>();
		initTaskDetails(taskMap);
		for (Map.Entry<String, Integer> tasks : taskMap.entrySet()) {
			sum += tasks.getValue();
		}
		days = sum / DAILY_HOURS;
		totalDays = Math.ceil(days);
		totalDays = totalDays + leaveDays.size();
		populateWorkingDays(totalDays, dateMap);
		for (String leaveDay : leaveDays) {
			dateMap.remove(leaveDay);
		}
		while (!taskMap.isEmpty()) {

			String taskKey = taskMap.keySet().iterator().next();
			int taskHr = taskMap.get(taskKey);
			String dateKey = dateMap.keySet().iterator().next();
			int dateHr = dateMap.get(dateKey);
			if (taskSheetMap.get(taskKey) == null) {
				SheetDates sheetdate = new SheetDates();
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
		printTaskSheet(taskSheetMap);
	}

	private static void populateWorkingDays(double totalDays,
			Map<String, Integer> dateMap) {
		Date date = setStartDate();
		for (int i = 0; i < totalDays; i++) {
			if (i == 0) {
				dateMap.put(getSimpleDate(date), DAILY_HOURS);
				continue;
			}
			date = getNextWorkingDay(date);
			dateMap.put(getSimpleDate(date), DAILY_HOURS);
		}
	}

	private static Date getNext(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	private static Date getNextWorkingDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getNext(date));
		while (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.setTime(getNext(cal.getTime()));
		}
		return cal.getTime();
	}

	private static String getSimpleDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		return dateFormat.format(date);
	}
	
	private static Date getDateFromString(String ddmmyyyy) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
			return dateFormat.parse(ddmmyyyy);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void printTaskSheet(Map<String, SheetDates> taskSheet) {
		for(Map.Entry<String, SheetDates> taskInfo:taskSheet.entrySet()){
			System.out.println(taskInfo.getKey()+":"+taskInfo.getValue());
		}
	}
}
