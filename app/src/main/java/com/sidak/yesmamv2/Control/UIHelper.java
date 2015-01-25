package com.sidak.yesmamv2.Control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
