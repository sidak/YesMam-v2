package com.sidak.yesmamv2.Control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sidak on 25/1/15.
 */
public class UIHelper {
    public static Date getDateObjectFromText(String dateString) {
        // it is assumed that the dateString is validated before sending
        Date d = null;
        try {
            d = new SimpleDateFormat("dd/MM/yy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;

    }
    public static boolean checkIfWeekend(String s ){
        Date d = getDateObjectFromText(s);
        int day = getDayOfWeekFromDate(d);
        if(day== Calendar.SATURDAY || day == Calendar.SUNDAY){
            return true;
        }
        else return false;
    }
    public static int getDayOfWeekFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
    public static boolean checkIfBefore(String s1, String s2){
        Date d1,d2;
        d1=getDateObjectFromText(s1);
        d2=getDateObjectFromText(s2);
        if(d1.compareTo(d2)<=0){
            return true;
        }
        return false;
    }
    public static String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c.getTime());

        //Log.v(TAG, "current date " + formattedDate);
        return formattedDate;
    }
}
