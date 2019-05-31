
package com.example.RikkeiCalendar.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserTest{
    public static void main(String[] args) {
        Date d=new Date();

        String s=String.valueOf(d);
        SimpleDateFormat sdf = new SimpleDateFormat(" E, dd MMMM yyyy HH:mm");
        String ss=sdf.format(d);
        System.out.println(ss);

    }
}




//package com.example.RikkeiCalendar.test;
//
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class UserTest {
//    public static Calendar day=Calendar.getInstance();
//
//    public static void main(String[] args) {
//        String todayStr=convertCalendartoString(day);
//
//
//        List<Calendar> weekly;
//
//        String current=nextWeek(todayStr);
//        current=nextWeek(current);
//        current=currentDate();
//        current=previousDate(current);
//
//        weekly=showCalendar(current);
//
//
//        for (Calendar date:weekly){
//            System.out.println(convertCalendartoString(date));
//        }
//
//    }
//    public static Calendar convertStringtoCalendat(String date){
//        Calendar today=new GregorianCalendar();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date d1 = null;
//        try {
//            d1 = sdf.parse(date);
//        }catch (ParseException ps){
//            ps.printStackTrace();
//        }
//        today.setTime(d1);
//        return today;
//    }
//    public static List<Calendar> showCalendar(String calendar){
//        List<Calendar> weekly=new ArrayList<>();
//        int temp=convertStringtoCalendat(calendar).get(Calendar.DAY_OF_WEEK)-1;
//        Calendar day;
//        for (int i=0;i<7;i++){
//            day=convertStringtoCalendat(calendar);
//            day.set(Calendar.DAY_OF_MONTH,day.get(Calendar.DAY_OF_MONTH)-temp);
//            weekly.add(day);
//            temp--;
//        }
//        return weekly;
//    }
//    public static String convertCalendartoString(Calendar calendar){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate=sdf.format(calendar.getTime());
//        return strDate;
//    }
//    public static String currentDate(){
//        Calendar calendar=Calendar.getInstance();
//        return convertCalendartoString(calendar);
//    }
//    public  static String previousDate(String strCalendar){
//        Calendar calendar=convertStringtoCalendat(strCalendar);
//        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-7);
//         strCalendar=convertCalendartoString(calendar);
//
//        return strCalendar ;
//    }
//    public  static String nextWeek(String strCalendar){
//        Calendar calendar=convertStringtoCalendat(strCalendar);
//        calendar.add(Calendar.DAY_OF_MONTH,7);
//        strCalendar=convertCalendartoString(calendar);
//        return strCalendar;
//    }
//}
