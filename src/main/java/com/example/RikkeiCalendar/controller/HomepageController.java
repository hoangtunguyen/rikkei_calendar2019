package com.example.RikkeiCalendar.controller;

import com.example.RikkeiCalendar.convert.TaskConvert;
import com.example.RikkeiCalendar.entity.CalendarModel;
import com.example.RikkeiCalendar.request.TaskRequestOnlyStatus;
import com.example.RikkeiCalendar.respones.TaskReponse;
import com.example.RikkeiCalendar.service.BigTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

// Author Louie
@Controller
public class HomepageController {
    @Autowired
    private BigTaskService bigTaskService;
    public static final String SUNDAY = "Sunday";
    public static final String MONDAY = "Monday";
    public static final String TUESDAY = "Tuesday";
    public static final String WEDNESDAY = "Wednesday";
    public static final String THURSDAY = "Thursday";
    public static final String FRIDAY = "Friday";
    public static final String SATURDAY = "Saturday";
    public static final String JANUARY = "January";
    public static final String FEBRUARY = "February";
    public static final String MARCH = "March";
    public static final String APRIL = "April";
    public static final String MAY = "May";
    public static final String JUNE = "June";
    public static final String JULY = "July";
    public static final String AUGUST = "August";
    public static final String SEPTEMBER = "September";
    public static final String OCTOBER = "October";
    public static final String NOVEMBER = "November";
    public static final String DECEMBER = "December";
    public static Calendar cal = Calendar.getInstance();

    @GetMapping(path = "/homePage")
    public String homePage(Model model) {
        String monthAndYear = month(cal.get(Calendar.MONTH)) + " " + cal.get(Calendar.YEAR);
        String strCalendar = convertCalendartoString(cal);
        List<Calendar> weekly;
        weekly = showCalendar(strCalendar);
        Map<Integer, CalendarModel> mapCalendar = setCalendar(weekly);
        model.addAttribute("calendar", mapCalendar);
        model.addAttribute("monthYear", monthAndYear);
        model.addAttribute("dayOfMonth",String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
        model.addAttribute("month",String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1));
        model.addAttribute("year",String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

        List<String> times=new ArrayList<>();
        for (Calendar calendar:weekly){
            if (calendar.get(Calendar.DAY_OF_MONTH)<10){
                times.add(calendar.get(Calendar.YEAR)+"-"+"0"+(calendar.get(Calendar.MONTH)+1)+"-"+"0"+calendar.get(Calendar.DAY_OF_MONTH));
            }else {
                times.add(calendar.get(Calendar.YEAR) + "-" + "0" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
            }
        }

        List<List<TaskReponse>> listList=new ArrayList<>();
        for (String time:times){
            listList.add(getTasksByDay(time));
        }
        model.addAttribute("listListTaskRepo",listList);
        Map<Integer,String> mapStatus=setMapStatus();
        model.addAttribute("statusMap",mapStatus);
        model.addAttribute("taskEntity",new TaskRequestOnlyStatus());
        return "home_page";
    }
    @PostMapping(path = "/doSaveTask")
    public String doSaveUser(@ModelAttribute TaskRequestOnlyStatus request){
        bigTaskService.saveTask(request);
        return "redirect:/homePage";
    }
    @GetMapping(path = "/nextWeek")
    public String nextWeek() {
        String current = convertCalendartoString(cal);
        current = nextWeek(current);
        cal = convertStringtoCalendat(current);

        return "redirect:/homePage";
    }

    @GetMapping(path = "/previousWeek")
    public String previousWeek() {
        String current = convertCalendartoString(cal);
        current = previousDate(current);
        cal = convertStringtoCalendat(current);
        return "redirect:/homePage";
    }

    @GetMapping(path = "/currentWeek")
    public String currentWeek() {
        String current = convertCalendartoString(cal);
        current = currentDate();
        cal = convertStringtoCalendat(current);
        return "redirect:/homePage";
    }

    public List<TaskReponse> getTasksByDay(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar minCalendar=Calendar.getInstance();
        Calendar maxCalendar=Calendar.getInstance();
        try{
            minCalendar.setTime(sdf.parse(time));
            maxCalendar.setTime(sdf.parse(time));
        }catch (ParseException ps){
            ps.printStackTrace();
        }
        minCalendar.set(Calendar.HOUR_OF_DAY,0);
        minCalendar.set(Calendar.MINUTE,0);
        minCalendar.set(Calendar.SECOND,0);
        minCalendar.set(Calendar.MILLISECOND,0);

        maxCalendar.set(Calendar.HOUR_OF_DAY,23);
        maxCalendar.set(Calendar.MINUTE,59);
        maxCalendar.set(Calendar.SECOND,59);
        maxCalendar.set(Calendar.MILLISECOND,999);

        Date minDate=minCalendar.getTime();
        Date maxDate=maxCalendar.getTime();
        Timestamp minTimeStamp= new Timestamp(minDate.getTime());
        Timestamp maxTimeStamp=new Timestamp(maxDate.getTime());

        return bigTaskService.findAllByStartTimeGreaterThanEqualAndStartTimeLessThan(minTimeStamp,maxTimeStamp).stream().map(TaskConvert::convert).collect(Collectors.toList());
    }

    private Map<Integer, CalendarModel> setCalendar(List<Calendar> calendars) {

        Map<Integer, CalendarModel> map = new HashMap<Integer, CalendarModel>();
        int count = 1;
        String dayOfWeek = SUNDAY;
        for (Calendar calendar : calendars) {
            map.put(count, new CalendarModel(count, day(calendar.get(Calendar.DAY_OF_WEEK)),
                    String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),
                    String.valueOf(calendar.get(Calendar.MONTH) + 1),
                    String.valueOf(calendar.get(Calendar.YEAR))));
            count++;
        }
        return map;

    }

    public static String month(int month) {
        String monthOf;
        month = month + 1;
        switch (month) {
            case 1:
                monthOf = JANUARY;
                break;
            case 2:
                monthOf = FEBRUARY;
                break;
            case 3:
                monthOf = MARCH;
                break;
            case 4:
                monthOf = APRIL;
                break;
            case 5:
                monthOf = MAY;
                break;
            case 6:
                monthOf = JUNE;
                break;
            case 7:
                monthOf = JULY;
                break;
            case 8:
                monthOf = AUGUST;
                break;
            case 9:
                monthOf = SEPTEMBER;
                break;
            case 10:

                monthOf = OCTOBER;
                break;
            case 11:
                monthOf = NOVEMBER;
                break;
            case 12:
                monthOf = DECEMBER;
                break;
            default:
                monthOf = "No thing right";
        }
        return monthOf;
    }

    public static String day(int dayOfWeek) {
        String dayOf;
        switch (dayOfWeek) {
            case 1:
                dayOf = SUNDAY;
                break;
            case 2:
                dayOf = MONDAY;
                break;
            case 3:
                dayOf = TUESDAY;
                break;
            case 4:
                dayOf = WEDNESDAY;
                break;
            case 5:
                dayOf = THURSDAY;
                break;
            case 6:
                dayOf = FRIDAY;
                break;
            case 7:
                dayOf = SATURDAY;
                break;
            default:
                dayOf = "No thing right";
        }
        return dayOf;
    }

    public static Calendar convertStringtoCalendat(String date) {
        Calendar today = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        try {
            d1 = sdf.parse(date);
        } catch (ParseException ps) {
            ps.printStackTrace();
        }
        today.setTime(d1);
        return today;
    }

    public static List<Calendar> showCalendar(String calendar) {
        List<Calendar> weekly = new ArrayList<>();
        int temp = convertStringtoCalendat(calendar).get(Calendar.DAY_OF_WEEK) - 1;
        Calendar day;
        for (int i = 0; i < 7; i++) {
            day = convertStringtoCalendat(calendar);
            day.set(Calendar.DAY_OF_MONTH, day.get(Calendar.DAY_OF_MONTH) - temp);
            weekly.add(day);
            temp--;
        }
        return weekly;
    }

    public static String convertCalendartoString(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(calendar.getTime());
        return strDate;
    }

    public static String currentDate() {
        Calendar calendar = Calendar.getInstance();
        return convertCalendartoString(calendar);
    }

    public static String previousDate(String strCalendar) {
        Calendar calendar = convertStringtoCalendat(strCalendar);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 7);
        strCalendar = convertCalendartoString(calendar);

        return strCalendar;
    }

    public static String nextWeek(String strCalendar) {
        Calendar calendar = convertStringtoCalendat(strCalendar);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        strCalendar = convertCalendartoString(calendar);
        return strCalendar;
    }

    private Map<Integer,String> setMapStatus(){
        Map<Integer,String> map=new HashMap<Integer, String>();
                map.put(1,"Open");
                map.put(2,"Progress");
                map.put(3,"Done");
                map.put(4,"Delay");
        return map;
    }

}

