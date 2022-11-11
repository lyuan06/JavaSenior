import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author nihao
 * @create 2022-11-09 16:17
 */
public class test {

    @Test
    public void test1() throws ParseException {
        String s1 = "2020-09-08";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(s1);

        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println(i);
        System.gc();
    }}


