package com.example.RikkeiCalendar.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BigFunction {
    public static final int MILLISECONDS_OF_DAY = 86400000;

    public static void main(String[] args) {
        String dateStart = "05/05/2019";
        String dateStop = "30/06/2019";
        List<String> result = new ArrayList<>();

        List<Integer> dayRepeated;
        List<Integer> repeatWeek = new ArrayList<>();
        repeatWeek.add(1);
        repeatWeek.add(2);
        repeatWeek.add(5);
        result = repeatBy(dateStart, dateStop, repeatWeek, 2);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public static long daysBetweenDates(Date d1, Date d2) {
        long differene = (d2.getTime() - d1.getTime()) / MILLISECONDS_OF_DAY;
        return differene;
    }

    public static List<String> repeatBy(String dateStart, String dateStop, List<Integer> repeatWeek, int repeatType) {
        List<String> result = new ArrayList<>();
        Calendar calen_date_start = new GregorianCalendar();
        Calendar calen_date_finish = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(dateStart);
            d2 = sdf.parse(dateStop);
        } catch (ParseException ps) {
            ps.printStackTrace();
        }
        calen_date_start.setTime(d1);
        calen_date_finish.setTime(d2);
        long days;
        int dayStart;
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int choice = repeatType;
        switch (choice) {
            case 1:
                days = daysBetweenDates(d1, d2);

                while (days >= 0) {
                    result.add(sdf.format(calen_date_start.getTime()));
                    calen_date_start.add(Calendar.DAY_OF_MONTH, 1);
                    days--;
                }
                break;
            case 2:
                int index = 0;
                int[] list = new int[repeatWeek.size()];
                for (int i = 0; i < repeatWeek.size(); i++) {
                    list[i] = repeatWeek.get(i);
                }
                int change = 0;
                for (int i = 0; i < 6; i++) {
                    boolean x = false;
                    for (int j = 0; j < list.length; j++) {
                        if (calen_date_start.get(Calendar.DAY_OF_WEEK) == list[j]) {
                            index = j;
                            x = true;
                            break;
                        }
                    }
                    if (x) {
                        break;
                    }
                    change++;
                    calen_date_start.add(Calendar.DAY_OF_MONTH, 1);
                }
                days = daysBetweenDates(d1, d2);
                for (long d = 0; d < (days + 1 - change) / 7; d++) {
                    for (int i = 0; i < list.length; i++) {
                        result.add(sdf.format(calen_date_start.getTime()));
                        if (index != list.length - 1) {
                            calen_date_start.add(Calendar.DAY_OF_MONTH, list[index + 1] - list[index]);
                            index++;
                        } else {
                            calen_date_start.add(Calendar.DAY_OF_MONTH, 7 - list[index] + list[0]);
                            index = 0;
                        }
                    }
                }
                long sodu = (days + 1 - change) % 7;
                if (sodu != 0) {
                    for (int i = 0; i < list.length; i++) {
                        result.add(sdf.format(calen_date_start.getTime()));
                        if (index != list.length - 1) {
                            if (sodu > list[index + 1] - list[index]) {
                                calen_date_start.add(Calendar.DAY_OF_MONTH, list[index + 1] - list[index]);
                                sodu = sodu - (list[index + 1] - list[index]);
                                index++;
                            } else break;
                        } else {
                            if (sodu > 7 - list[index] + list[0]) {
                                calen_date_start.add(Calendar.DAY_OF_MONTH, 7 - list[index] + list[0]);
                                index = 0;
                                sodu = sodu - (7 - list[index] + list[0]);
                            } else break;
                        }
                    }
                }
                break;
            case 3:
                dayStart = calen_date_start.get(Calendar.DAY_OF_MONTH);
                int monthStart = calen_date_start.get(Calendar.MONTH) + 1;
                int year = calen_date_finish.get(Calendar.YEAR) - calen_date_start.get(Calendar.YEAR);
                int finishDay = calen_date_finish.get(Calendar.DAY_OF_MONTH);
//                int[] daysInMonthFake = daysInMonths;
                while (year >= 0) {
                    //ssss
                    daysInMonths[1] = 28;
                    daysInMonths[1] += isLeapYear(calen_date_start.get(Calendar.YEAR)) ? 1 : 0;
                    if (year > 0) {
                        while (monthStart <= 12) {
                            int realMonth = monthStart - 1;
                            if (dayStart <= daysInMonths[realMonth]) {
                                calen_date_start.set(Calendar.MONTH, realMonth);
                                calen_date_start.set(Calendar.DAY_OF_MONTH, dayStart);
                                result.add(sdf.format(calen_date_start.getTime()));
                            }
                            monthStart++;
                        }
                        monthStart = 1;
                        calen_date_start.add(Calendar.YEAR, 1);
                    } else {
                        while (monthStart <= calen_date_finish.get(Calendar.MONTH) + 1) {
                            if (!(monthStart == calen_date_finish.get(Calendar.MONTH) + 1 && dayStart > finishDay)) {
                                int realMonth = monthStart - 1;
                                if (dayStart <= daysInMonths[realMonth]) {
                                    calen_date_start.set(Calendar.DAY_OF_MONTH, dayStart);
                                    calen_date_start.set(Calendar.MONTH, realMonth);
                                    result.add(sdf.format(calen_date_start.getTime()));
                                }
                            }
                            monthStart++;
                        }
                    }
                    year--;
                }
                break;
            case 4:
                dayStart = calen_date_start.get(Calendar.DAY_OF_MONTH);
                year = calen_date_finish.get(Calendar.YEAR) - calen_date_start.get(Calendar.YEAR);
                System.out.println("Year: " + year);
                while (year >= 0) {
                    daysInMonths[1] = 28;
                    daysInMonths[1] += isLeapYear(calen_date_start.get(Calendar.YEAR)) ? 1 : 0;
                    if (!(dayStart > daysInMonths[calen_date_start.get(Calendar.MONTH)])) {
                        if (year == 0) {
                            if (!(calen_date_start.get(Calendar.MONTH) >= calen_date_finish.get(Calendar.MONTH) && (calen_date_start.get(Calendar.DAY_OF_MONTH) > calen_date_finish.get(Calendar.DAY_OF_MONTH)))) {
                                result.add(sdf.format(calen_date_start.getTime()));
                            }
                        } else {
                            result.add(sdf.format(calen_date_start.getTime()));
                        }
                    }
                    year--;
                    calen_date_start.add(Calendar.YEAR, 1);
                }
                break;
            default:
                System.out.println("Erroe");
        }
        return result;
    }

}
