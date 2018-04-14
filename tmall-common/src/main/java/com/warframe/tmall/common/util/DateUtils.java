
package com.warframe.tmall.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Type DateUtils.java
 * @Desc 
 * @author warframeprimer
 */
@Slf4j
public class DateUtils {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMM = "yyyyMM";
    
     /** 存放不同的日期模板格式的sdf的Map */  
    private static ThreadLocal<Map<String, SimpleDateFormat>> sdfMap = new ThreadLocal<Map<String, SimpleDateFormat>>() {
        @Override
        protected Map<String, SimpleDateFormat> initialValue() {
            Map<String, SimpleDateFormat> initMap = new HashMap<String, SimpleDateFormat>();
            initMap.put(YYYYMM, new SimpleDateFormat("YYYYMM"));
            initMap.put(YYYY_MM_DD, new SimpleDateFormat("yyyy-MM-dd"));
            initMap.put(YYYY_MM_DD_HH_MM_SS, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            initMap.put(YYYY_MM_DD_HH_MM_SS_SSS, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));
            initMap.put(YYYYMMDDHHMMSS, new SimpleDateFormat("yyyyMMddHHmmss"));
            initMap.put(YYYYMMDD, new SimpleDateFormat("yyyyMMdd"));
            
            return initMap;
        }
    };
    
    /** 
     * 返回一个SimpleDateFormat,每个线程只会new一次pattern对应的sdf 
     *  
     * @param pattern 
     * @return 
     */  
    private static SimpleDateFormat getSdf(final String pattern) {
        Map<String, SimpleDateFormat> tl = sdfMap.get();
        SimpleDateFormat sdf = tl.get(pattern);
        if (sdf == null) {
            sdf = new SimpleDateFormat(pattern); 
        }
        return sdf;
    }
    
    /**
     * 
     * @return
     * @author HanksXu
     */
    public static Date getCurrentDate() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

    /**
     * 得到当前时间str
     * @return
     */
    public static String getCurrentDateStr() {
        Calendar c = Calendar.getInstance();
        return DateUtils.getDate2String(c.getTime(), DateUtils.YYYYMMDDHHMMSS);
    }
    
    /**
     * 得到昨日时间str
     * @return
     */
    public static String getYesterdayStr() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -1);
        return DateUtils.getDate2String(c.getTime(), DateUtils.YYYY_MM_DD);
    }

    /**
     * 得到当前时间str
     * @return
     */
    public static String getCurrentDateStr(String sdf) {
        Calendar c = Calendar.getInstance();
        String dateStr = "";
        try {
            dateStr = getSdf(sdf).format(c.getTime());
        } catch (Exception e) {
            dateStr = getSdf(YYYYMMDDHHMMSS).format(c.getTime());
        }
        return dateStr;
    }

    /**
     * 将“yyyyMMddHHmmss” 字符串格式化成日期
     * @param dateStr
     * @return
     */
    public static Date getDate2(String dateStr){
        if(dateStr!= null && !dateStr.equals("")){
            try{
                return getSdf(YYYYMMDDHHMMSS).parse(dateStr);
            }catch (ParseException e){
                log.error("getDate2 exception:",e);
            }
        }
        return null;
    }
    /**
     * 将日期化成“yyyyMMddHHmmss” 字符串格式
     * @param dateStr
     * @return
     */
    public static String getDate2String(Date date){
        if(null == date) {
            return null;
        }
        return getSdf(YYYYMMDDHHMMSS).format(date);
    }
    
    /**
     * 将日期转化成字符串格式, 如果没有指定SimpleDateFormat， 默认按“yyyyMMddHHmmss”格式转化
     * @param dateStr
     * @param sdf //yyyyMMdd, yyyyMMddHHmmss, yyyy-MM-dd, yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDate2String(Date date, String sdf){
        String dateStr = "";
        try {
            dateStr = getSdf(sdf).format(date);
        } catch (Exception e) {
            dateStr = getSdf(YYYYMMDDHHMMSS).format(date);
        }
        
        return dateStr;
    }
    
    /**
     * 将"yyyy-MM-dd"字符串格式化成日期
     * @param dateStr
     * @return
     */
    public static Date getDate(String dateStr){
        if(dateStr!= null && !dateStr.equals("")){
            try{
                return getSdf(YYYY_MM_DD).parse(dateStr);
            }catch (ParseException e){
                log.error("getDate exception:",e);
            }
        }
        return null;
    }
    
    /**
     * 
     * @param dateStr
     * @param format
     * @return
     * @author HanksXu
     */
    public static Date getDate(String dateStr, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            log.error("getDate exception:",e);
        }
        return null;
    }
    
    /**
     * 将日期格式化成"yyyy-MM-dd"字符串
     * @param date
     * @return
     */
    public static String getDateString(Date date)
    {
        String dateString = null;
        if(date!=null){
            dateString = getSdf(YYYY_MM_DD).format(date);
        }       
        return dateString;
    }
    /**
     *  将"yyyy-MM-dd HH:mm:ss"字符串格式化成日期
     * @param dateStr
     * @return
     */
    public static Date getDateTime(String dateStr)
    {
        if(dateStr!= null && !dateStr.equals("")){
            try{
                return getSdf(YYYY_MM_DD_HH_MM_SS).parse(dateStr);
            }catch (ParseException e){
                log.error("getDateTime exception:",e);
            }
        }   
        return null;
    }
    /**
     * 将日期格式化成"yyyy-MM-dd HH:mm:ss"字符串
     * @param date
     * @return
     */
    public static String getDateTimeString(Date date)
    {
        return getSdf(YYYY_MM_DD_HH_MM_SS).format(date);
    }
    /**
     * 指定日期进行减月份
     * @param date
     * @param offset
     * @return
     */
    public static Date reduceMonth(Date date,int offset){
        Calendar calendar=Calendar.getInstance();   
        calendar.setTime(date);         
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-offset);  
        return calendar.getTime();
    }
    
    /**
     * 指定日期进行减天数
     * @param date
     * @param offset
     * @return
     */
    public static Date reduceDays(Date date,int offset){
        Calendar calendar=Calendar.getInstance();   
        calendar.setTime(date);         
        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-offset);//让日期加位移量  
           
        return calendar.getTime();
    }
    /**
     * 指定日期进行减小时
     * @param date
     * @param offset
     * @return
     */
    public static Date reduceHours(Date date,int offset){
        Calendar calendar=Calendar.getInstance();   
        calendar.setTime(date);         
        calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY)-offset);  
           
        return calendar.getTime();
    }
    /**
     * 指定日期进行减分钟
     * @param date
     * @param offset
     * @return
     */
    public static Date reduceMinutes(Date date,int offset){
        Calendar calendar=Calendar.getInstance();   
        calendar.setTime(date);         
        calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)-offset);  
        return calendar.getTime();
    }
    
    /**
     * 但指定日期进行加减天数
     * @param date
     * @param offset
     * @return
     */
    public static Date addDays(Date date,int offset){
        Date result = null;
        if(date!=null){
            Calendar calendar=Calendar.getInstance();   
            calendar.setTime(date);         
            calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+offset);//让日期加位移量  
            result = calendar.getTime();
        }          
        return result;
    }
    
    /**
     * 指定日期进行加减小时
     * @param date
     * @param offset
     * @return
     */
    public static Date addHours(Date date,int offset){
        Calendar calendar=Calendar.getInstance();   
        calendar.setTime(date);         
        calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY)+offset);  
           
        return calendar.getTime();
    }
    
    /**
     * 
     * @param date
     * @param offset
     * @return
     * @author HanksXu
     */
    public static Date addYears(Date date, int offset) {
        Calendar calendar=Calendar.getInstance();   
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + offset);
        return calendar.getTime();
    }
    
    /**
     * 制定日期加减分钟
     * @param date
     * @param offset
     * @return
     */
    public static Date addMinutes(Date date,int offset){
        Calendar calendar=Calendar.getInstance();   
        calendar.setTime(date);         
        calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+offset);  
           
        return calendar.getTime();
    }
    /**
     * 制定日期加减秒
     * @param date
     * @param offset
     * @return
     */
    public static Date addSeconds(Date date,int offset){
        Calendar calendar=Calendar.getInstance();   
        calendar.setTime(date);         
        calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND)+offset);  
           
        return calendar.getTime();
    }
    /**
     * 得到当周的周一
     * @param day
     * @return
     */
    public static Date getMondayByCurrentWeek(){
        Calendar calendar=Calendar.getInstance();
        Date date =calendar.getTime();
        int idx =calendar.get(Calendar.DAY_OF_WEEK);
        Date result = null;
        if(idx ==1){
            result = reduceDays(date, 6);
        }else{
            result = reduceDays(date, idx-2);
        }
        return result;
    }
    /**
     * 得到当周的周日
     * @param day
     * @return
     */
    public static Date getSundayByCurrentWeek(){
        Calendar calendar=Calendar.getInstance(); 
        Date date =calendar.getTime();
        int idx =calendar.get(Calendar.DAY_OF_WEEK);
        Date result = null;
        if(idx == 1){
            result = date;
        }else{
            result=addDays(date, 7-idx+1);
        }
        return result;
    }
    
    /**
     * 
     * @Title: formatTimetoDate
     * @Description: 格式化日期格式由YYYY-MM-DD hh24:mi:ss 转为 YYYY-MM-DD
     * @param @param date
     * @param @return    
     * @return Date    
     * @throws
     */
    public static Date formatTimetoDate(Date date){
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
        String dateTime = dateFm.format(date);
        return DateUtils.getDate(dateTime);
        
    }
    
    /**
     * 
     * @Title: round
     * @Description: 小数四舍五入保留指定位小数
     * @param @param v
     * @param @param scale
     * @param @return    
     * @return double    
     * @throws
     */
    public static double round(double v,int scale){
        
        if(scale<0){

            throw new IllegalArgumentException("The scale must be a positive integer or zero");

        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    public static List<Date> getDatesBetween(Date startTime, Date endTime) {
        List<Date> dates = new ArrayList<Date>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 
                cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        while(cal.getTime().getTime()<=endTime.getTime()){
            dates.add(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dates;
    }
    
    public static List<Date> getMonthsBetween(Date startTime, Date endTime) {
        List<Date> dates = new ArrayList<Date>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
        while(cal.getTime().getTime()<=endTime.getTime()){
            dates.add(cal.getTime());
            cal.add(Calendar.MONTH, 1);
        }
        return dates;
    }

    public static List<Date> getYearsBetween(Date startTime, Date endTime) {
        List<Date> dates = new ArrayList<Date>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.set(cal.get(Calendar.YEAR), 0, 1, 0, 0, 0);
        while(cal.getTime().getTime()<=endTime.getTime()){
            dates.add(cal.getTime());
            cal.add(Calendar.YEAR, 1);
        }
        return dates;
    }

    public static int getAgeFormBirthDay(Date birthDate){
        if(birthDate == null){
            return 0;
        }

        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);

        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        int birthYear = birth.get(Calendar.YEAR);

        return nowYear - birthYear;
    }
    
    /**
     * 获取指定日期的月的第一天
     * @param date
     * @return
     */
    public static Date getFirstDateOfMonth(Date date){
        Calendar cal = Calendar.getInstance();//获取当前日期
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        return cal.getTime();
    }

    /**
     * 时间转换 string to Date
     * @author chenxiang
     * @date 2014-7-23 下午2:07:24 
     * @param dateString
     * @return
     * @throws ParseException 
     */
    public static Date stringToDate(String dateString) throws ParseException{
        Date date=null;
        
        if (StringUtils.isNotBlank(dateString) && dateString.length() == 8) {
            date = DateUtils.getDate(dateString,"yyyyMMdd");
        }else if (StringUtils.isNotBlank(dateString) && dateString.length() == 14) {
            date = DateUtils.getDate(dateString,"yyyyMMddHHmmss");
        }else if (StringUtils.isNotBlank(dateString) && dateString.length() == 10) {
            date = DateUtils.getDate(dateString,"yyyy-MM-dd");
        }else if (StringUtils.isNotBlank(dateString) && dateString.length() == 19) {
            date = DateUtils.getDate(dateString,"yyyy-MM-dd HH:mm:ss");
        } else if (StringUtils.isNotBlank(dateString) && dateString.length() == 12) {
            date = DateUtils.getDate(dateString, "yyyyMMddHHmm");
        }
        return date;
    }
}

