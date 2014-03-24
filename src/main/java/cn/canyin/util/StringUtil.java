package cn.canyin.util;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public class StringUtil {

	public static final String ST_BLANK = "";
	public static final String ST_COMMA = ",";
	public static final String ST_VERTICAL = "\\|";
	public static final String ST_ENTER = "\n";
	public static final String ST_QUOTE = "'";
	public static DecimalFormat df = new DecimalFormat("000000000000");
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdf2 =  new SimpleDateFormat("yyyyMMddHHmmss");
	public static SimpleDateFormat sdf3 =  new SimpleDateFormat("yyyy/MM/dd HH:mm");
	public static SimpleDateFormat sdf4 =  new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdf5 =  new SimpleDateFormat("yyyy年MM月dd日");
	/**
	 * 判断是否为空
	 * @param str
	 * @return 为空返回true
	 */
	public static boolean isEmpty(String str){
		if((str == null)||("".equals(str.trim()))){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param date
	 * @return  yyyy-MM-dd HH:mm:ss
	 */
	public static String dateFormat(Date date){
		if(date == null){
			return null;
		}else{
			return sdf.format(date);
		}
	}
	
	/**
	 * @param date
	 * @return  YYYYMMDD24HHMMSS
	 */
	public static String dateFormat2(Date date){
		if(date == null){
			return null;
		}else{
			return sdf2.format(date);
		}
	}
	
	/**
	 * @param 
	 * @return yyyy-MM-dd
	 */
	public static String dateFormat4(Date date){
		if(date == null){
			return null;
		}else{
			return sdf4.format(date);
		}
	}
	
	/**
	 * @param 
	 * @return "yyyy年MM月dd日"
	 */
	public static String dateFormat5(Date date){
		if(date == null){
			return null;
		}else{
			return sdf5.format(date);
		}
	}
	
	/**
	 * @param date 4-12 修改 yyyy/MM/dd -->yyyy/MM/dd 
	 * @return  yyyy/MM/dd HH:mm 
	 */
	public static String dateFormat3(Date date){
		if(date == null){
			return null;
		}else{
			return sdf3.format(date);
		}
	}
	
	public static String date2String(Date date, String format) {
		if(date == null) {
			return null;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
	}
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return 不为空返回true
	 */
	public static boolean isNotEmpty(String str){
		if((str == null)||("".equals(str.trim()))){
			return false;
		}
		return true;
	}
	
	/**
	 * toString
	 * @param str
	 * @return 为null返回""
	 */
	public static String toString(Object obj){
		return obj == null ? "" : obj.toString();
	}
	

    public static boolean isNotBlank(String str) {
        if (str == null) {
            return false;
        } else if ("".equalsIgnoreCase(str.trim())) {
            return false;
        } else if ("null".equalsIgnoreCase(str.trim())) {
            return false;
        }
        return true;

    }
    
    /**
     * 获取一个不重复的字符串
     * @return
     */
    public static String GetUniquelyString() 
    {
		    UUID uuid = UUID.randomUUID(); 
		    return uuid.toString();
    }
    
    /**
     * 取某天0点0分0秒
     * @param date
     * @return
     */
    public static Date getDateStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

    /**
     * 取某天23点59分59秒
     * @param date
     * @return
     */
    public static Date getDateEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}  

    
    /**
     * 取得某月的第一天
     * @param date
     * @return
     */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getMinimum(Calendar.DATE)); 
		return calendar.getTime();
	}
	
	/**
	 * 取得某月的最后一天
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE));    
		return calendar.getTime();
	}
	
	
	/**
	 * 取得向前或向后移动N个月时间
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date getAddMonthOfDate(Date date,int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH,amount);  
		return calendar.getTime();
	}
	
	/**
	 * 取得向前或向后移动N天
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date getAddDayOfDate(Date date,int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE,amount);  
		return calendar.getTime();
	}
	/**
	 * 取得向前或向后移动N年
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date getAddYearOfDate(Date date,int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR,amount);  
		return calendar.getTime();
	}
	/**
	 * 计算两个时间相差的秒数 date2-date1
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDifferSecond(Date date1, Date date2) 
	{ 
	    return (date2.getTime()- date1.getTime())/1000; 
	} 
	
	/**
	 * 计算两个时间相差的天数 date2-date1
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDifferDay(Date date1, Date date2) 
	{ 
	    //return date1.getTime() / (24*60*60*1000) - date2.getTime() / (24*60*60*1000); 
	    return (date2.getTime()- date1.getTime()) / 86400000;  //用立即数，减少乘法计算的开销
	} 
	public static long getDifferDayNoHMS(Date date1, Date date2) 
	{ 
//		TimeZone gmt8 = TimeZone.getTimeZone("GMT+8");
//		TimeZone.setDefault(gmt8);
		if (date1!=null&&date2!=null) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(date1);
			calendar1.set(Calendar.HOUR_OF_DAY, 0);
			calendar1.set(Calendar.MINUTE, 0);
			calendar1.set(Calendar.SECOND, 0);
			calendar1.set(Calendar.MILLISECOND, 0);
			
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(date2);
			calendar2.set(Calendar.HOUR_OF_DAY, 0);
			calendar2.set(Calendar.MINUTE, 0);
			calendar2.set(Calendar.SECOND, 0);
			calendar2.set(Calendar.MILLISECOND, 0);
			return (calendar1.getTime().getTime()- calendar2.getTime().getTime()) / 86400000;  //用立即数，减少乘法计算的开销
		}
		return 0;
	} 
	
	// TODO : 方法需要修改
	public static String getHtmlStringForCredit(double score,long userId)
    {
        int number = (int)score;
		String sb = "";
        String img = "<img src='../static/img/xxx'/>"; 
        
        //String letterPlus = "+";
        //String letterSub = "-";
        String letterA = "a.gif";
        String letterB = "b.gif";
        String letterC = "c.gif";
        String letterAplus = "a+.gif";
       // String letterAplusplus = "a++.gif";
      //  String letterAplusplusplus = "a+++.gif";
        String letterAA = "aa.gif";
        String letterAAplus = "aa+.gif";
       // String letterAAplusplus = "aa++.gif";
       // String letterAAplusplusplus = "aa+++.gif";
        String letterAAA = "aaa.gif";
        String letterAAAsub = "aaa-.gif";
        String letterAAAplus = "aaa+.gif";
       // String letterAAAplusplus = "aaa++.gif";
       // String letterAAAplusplusplus = "aaa+++.gif";
        String letterAAsub = "aa-.gif";
        String letterAsub = "a-.gif";
      //  String letterAsubsub = "a--.gif";
       // String letterAsubsubsub = "a---.gif";
        String letterBlevelTwo = "bb.gif";
        String letterBlevelThree = "bbb.gif";

//        int iCityCountNum = UserCityNum(username);
//        decimal Top4CityTotalMoney = SpecialCityTotalMoney(username);
//        decimal Top4CityTotalRate = SpecialCityTotalRate(username, Top4CityTotalMoney);
//        decimal Top16CityTotalMoney = CommonCityTotalMoney(username);
//        decimal Top16CityTotalRate = SpecialCityTotalRate(username, Top16CityTotalMoney);
//        bool repayment12Months = RepaymentMonths(username, 12);
//        bool repayment24Months = RepaymentMonths(username, 24);
//        bool repayment30Months = RepaymentMonths(username, 30);
//        bool repayment36Months = RepaymentMonths(username, 36);
//        bool repaymentNoOverdue = RepaymentNoOverdue(username);
        
        if (number < 61) //小于61分 C
        {
            sb = img.replace("xxx", letterC);
        }
        else if (number > 60 && number < 71) // 61-70 B
        {
            sb = img.replace("xxx", letterB);
        }
        else if (number > 70 && number < 91) // 71-90 BB
        {
            sb = img.replace("xxx", letterBlevelTwo);
        }
        else if (number > 90) // 50-59 BBB
        {
            sb = img.replace("xxx", letterBlevelThree);
            if (number > 105 )//&& ((iCityCountNum >= 1 && ((Top4CityTotalMoney >= 北上广深A && Top4CityTotalRate < (int)CityRateLevel.北上广深A) || (Top16CityTotalMoney >= (int)CityValueLevel.其它城市A && Top16CityTotalRate < (int)CityRateLevel.其它城市A))) || (repayment12Months && repaymentNoOverdue)))
            {
                sb = img.replace("xxx", letterAsub);
            }
            if (number > 125 )//&& ((iCityCountNum >= 1 && ((Top4CityTotalMoney >= (int)CityValueLevel.北上广深A && Top4CityTotalRate < (int)CityRateLevel.北上广深A) || (Top16CityTotalMoney >= (int)CityValueLevel.其它城市A && Top16CityTotalRate < (int)CityRateLevel.其它城市A))) || (repayment12Months && repaymentNoOverdue)))
            {
                sb = img.replace("xxx", letterA);
            }
            if (number > 145 )//&& ((iCityCountNum >= 1 && ((Top4CityTotalMoney >= (int)CityValueLevel.北上广深A && Top4CityTotalRate < (int)CityRateLevel.北上广深A) || (Top16CityTotalMoney >= (int)CityValueLevel.其它城市A && Top16CityTotalRate < (int)CityRateLevel.其它城市A))) || (repayment12Months && repaymentNoOverdue)))
            {
                sb = img.replace("xxx", letterAplus);
            }

            if (number > 165 )//&& ((iCityCountNum >= 2 && ((Top4CityTotalMoney >= (int)CityValueLevel.北上广深AA && Top4CityTotalRate < (int)CityRateLevel.北上广深AA) || (Top16CityTotalMoney >= (int)CityValueLevel.其它城市AA && Top16CityTotalRate < (int)CityRateLevel.其它城市AA))) || (repayment36Months && repaymentNoOverdue)))
            {
                sb = img.replace("xxx", letterAAsub);
            }
            if (number > 190 )//&& ((iCityCountNum >= 2 && ((Top4CityTotalMoney >= (int)CityValueLevel.北上广深AA && Top4CityTotalRate < (int)CityRateLevel.北上广深AA) || (Top16CityTotalMoney >= (int)CityValueLevel.其它城市AA && Top16CityTotalRate < (int)CityRateLevel.其它城市AA))) || (repayment36Months && repaymentNoOverdue)))
            {
                sb = img.replace("xxx", letterAA);
            }
            if (number > 215 )//&& ((iCityCountNum >= 2 && ((Top4CityTotalMoney >= (int)CityValueLevel.北上广深AA && Top4CityTotalRate < (int)CityRateLevel.北上广深AA) || (Top16CityTotalMoney >= (int)CityValueLevel.其它城市AA && Top16CityTotalRate < (int)CityRateLevel.其它城市AA))) || (repayment36Months && repaymentNoOverdue)))
            {
                sb = img.replace("xxx", letterAAplus);
            }

            if (number > 240 )//&& ((iCityCountNum >= 3 && ((Top4CityTotalMoney >= (int)CityValueLevel.北上广深AAAAsub && Top4CityTotalRate < (int)CityRateLevel.北上广深AAAsub) || (Top16CityTotalMoney >= (int)CityValueLevel.其它城市AAAplus && Top16CityTotalRate < (int)CityRateLevel.北上广深AAAsub))) || (repayment24Months && repaymentNoOverdue)))
            {
                sb = img.replace("xxx", letterAAAsub);
            }
            if (number > 270 )//&& ((iCityCountNum >= 3 && ((Top4CityTotalMoney >= (int)CityValueLevel.北上广深AAA && Top4CityTotalRate < (int)CityRateLevel.北上广深AAA) || (Top16CityTotalMoney >= (int)CityValueLevel.其它城市AAA && Top16CityTotalRate < (int)CityRateLevel.其它城市AAA))) || (repayment30Months && repaymentNoOverdue)))
            {
                sb = img.replace("xxx", letterAAA);
            }
            if (number > 300 )//&& ((iCityCountNum >= 3 && ((Top4CityTotalMoney >= (int)CityValueLevel.北上广深AAAplus && Top4CityTotalRate < (int)CityRateLevel.北上广深AAAplus) || (Top16CityTotalMoney >= (int)CityValueLevel.其它城市AAAplus && Top16CityTotalRate < (int)CityRateLevel.其它城市AAAplus))) || (repayment36Months && repaymentNoOverdue)))
            {
                sb = img.replace("xxx", letterAAAplus);
            }
          
        }
        return sb.toString();
    }
	
	/**
	 * // 12位左补0 , 出参数分
	 * @param e  单位 元
	 * @return
	 */
	public static String getString(Double e){
		return df.format(e*100);
	}
	/**
	 * 借款标状态
	 */
	
	public static Map<String,String> orderStatus=new HashMap<String,String>();	
	static{
		//-1草稿,0投标进行中,1满标待审核,2还款中,3还款完成(交易结束),-2撤标,-3流标,-4审核拒绝
		orderStatus.put("0", "投标进行中");
		orderStatus.put("1", "已满额");
		orderStatus.put("2", "还款中");
		orderStatus.put("3", "还款完成");
		orderStatus.put("-1", "草稿");
		orderStatus.put("-2", "撤标");
		orderStatus.put("-3", "流标");
		orderStatus.put("-4", "审核拒绝");
		orderStatus.put("-5", "删除");
		orderStatus.put("-6", "等待审核");
		orderStatus.put("-7", "审核拒绝");
	}

	/**
	 * 认证名称
	 */
	public static Map<String,String>auditName=new HashMap();
	static{
		auditName.put("101", "身份认证");
		auditName.put("102", "学历认证");
		auditName.put("103", "视频认证");
		auditName.put("104", "手机实名认证");
	
		auditName.put("112", "征信认证");
		auditName.put("116", "不动产认证");
		auditName.put("117", "法院数据认证");
		auditName.put("119", "银行流水认证");
		
		auditName.put("123", "联系方式认证");
		auditName.put("124", "现居住地址认证");
		auditName.put("125", "百度Google认证");
		auditName.put("201", "身份证图片认证");
		auditName.put("109", "公积金认证");
		auditName.put("126", "户籍认证");
	}
	/**
	 * 还款方式
	 */
	public static Map<String,String>borrowRepayType=new HashMap();
	static{
		borrowRepayType.put("-1", "请选择");
		borrowRepayType.put("1", "每月等额本息还款");
		borrowRepayType.put("2", "每月等本金还款");
		borrowRepayType.put("3", "每月还息到期还本(按月算)");
		borrowRepayType.put("4", "到期一次还本付息");
		borrowRepayType.put("5", "每月还息到期还本(按日算)");
	}
	/**
	 * 是否担保
	 */
	public static Map<String,String>isWarrant=new HashMap();
	static{
		isWarrant.put("0", "未选择担保");
		isWarrant.put("1", "选择担保");
	}
	/**
	 * 投标方式
	 */
	public static Map<String,String>bidType=new HashMap();
	static{
		bidType.put("0", "自动投标");
		bidType.put("1", "手动投标");
		bidType.put("3", "理财投标");
		bidType.put("7", "畅盈宝投标");
	}
	/**
	 * 借款目的
	 */
	public static Map<String,String>borrowGoal=new HashMap();
	static{
	
		borrowGoal.put("120101", "享装修");
		borrowGoal.put("120102", "享旅游");
		borrowGoal.put("120103", "享购车");
		borrowGoal.put("120104", "享教育");
		
		borrowGoal.put("120105", "满标有礼");
		borrowGoal.put("120201", "个人消费借款");
		borrowGoal.put("120202", "个人创业借款");
		borrowGoal.put("120203", "短期周转借款");
		borrowGoal.put("120204", "其他借款");
		
	}
	/**
	 * 资金交易类型
	 */
	public static Map<String,String>accountHistory=new HashMap();
	static {
		accountHistory.put("0", "首次充值");
		accountHistory.put("1", "首次取现");
		
		accountHistory.put("2", "充值");
		accountHistory.put("3", "充值手续费");
		accountHistory.put("4", "提现");	
		accountHistory.put("5", "提现手续费");	
		
		accountHistory.put("6", "借款保证金");	
		accountHistory.put("7", "投标担保金");	
		accountHistory.put("8", "投标金额");
		accountHistory.put("9", "借款保证金");	
		accountHistory.put("10", "投标担保金");	
		accountHistory.put("11", "投标担保金");	
		accountHistory.put("12", "投标担保金");	
		accountHistory.put("13", "投标金额");
		accountHistory.put("14", "投标金额");	
		accountHistory.put("15", "投标金额");	
		accountHistory.put("16", "借款服务费");	
		accountHistory.put("17", "借款服务费");	
		accountHistory.put("18", "扣除保证金");	
		accountHistory.put("19", "分得保证金");
		accountHistory.put("20", "还款");	
		accountHistory.put("21", "收款");	
		accountHistory.put("22", "逾期还款,罚息");
		accountHistory.put("23", "逾期还款,罚息");	
		accountHistory.put("24", "提前还款,违约");	
		accountHistory.put("25", "提前还款,违约");
		accountHistory.put("26", "发标审核拒绝/撤标,平台分得剩余保证金");
		accountHistory.put("27", "逾期赔付,出");
		accountHistory.put("28", "逾期赔付,入");
		//#### new 
		
		
		
	}
	/**
	 * 资金记录--收支类型
	 */
	public static Map<String,String>action=new HashMap();
	static{		
		action.put("1", "入账");
		action.put("-1", "出账");
		action.put("-2", "冻结");
		action.put("2", "解冻");
		action.put("3", "用户充值");
		action.put("-3", "用户取现");
	}
	/**
	 * 规避solr 的特殊符号
	 * @param s
	 * @return
	 */
	 public static String escapeQueryChars(String s) {
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < s.length(); i++) {
		      char c = s.charAt(i);
		      // These characters are part of the query syntax and must be escaped
		      if (c == '\\' || c == '+' || c == '-' || c == '!'  || c == '(' || c == ')' || c == ':'
		        || c == '^' || c == '[' || c == ']' || c == '\"' || c == '{' || c == '}' || c == '~'
		        || c == '*' || c == '?' || c == '|' || c == '&'  || c == ';'
		        || Character.isWhitespace(c)) {
		        sb.append('\\');
		      }
		      sb.append(c);
		    }
		    return sb.toString();
		  }
	 
	 /**
	  * html to text
	  * @param inputString
	  * @return
	  */
	   public static String htmlToText(String inputString) {  
	       String htmlStr = inputString; // 含html标签的字符串  
	        String textStr = "";  
	        java.util.regex.Pattern p_script;  
	        java.util.regex.Matcher m_script;  
	        java.util.regex.Pattern p_style;  
	        java.util.regex.Matcher m_style;  
	       java.util.regex.Pattern p_html;  
	        java.util.regex.Matcher m_html;  
	  
	    /*    java.util.regex.Pattern p_html1;  
	        java.util.regex.Matcher m_html1;  */
	  
	        try {  
	            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>  
	            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>  
	            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
	           
	            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
	            m_script = p_script.matcher(htmlStr);  
	            htmlStr = m_script.replaceAll(""); // 过滤script标签  
	  
	            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
	            m_style = p_style.matcher(htmlStr);  
	            htmlStr = m_style.replaceAll(""); // 过滤style标签  
	  
	            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
	            m_html = p_html.matcher(htmlStr);  
	            htmlStr = m_html.replaceAll(""); // 过滤html标签  
	  
	            textStr = htmlStr;  
	  
	        } catch (Exception e) {  
	        	 e.printStackTrace();
	        }  
	  
	        return textStr;// 返回文本字符串  
	    }  	 
	   
	   /**
	    * 生成随机密码
	    * @param pwd_len 长度
	    * @return
	    */
		public static String genRandomPwd(int pwd_len) {
			// 35是因为数组是从0开始的，26个字母+10个数字
			final int maxNum = 36;
			int i; // 生成的随机数
			int count = 0; // 生成的密码的长度
			char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
					'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
					'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

			StringBuffer sb = new StringBuffer("");
			Random r = new Random();
			while (count < pwd_len) {
				// 生成随机数，取绝对值，防止生成负数，

				i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

				if (i >= 0 && i < str.length) {
					sb.append(str[i]);
					count++;
				}
			}

			return sb.toString();
		}
		

	public static long getDifferDayForMonth(Integer monthTerm, Date startDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
//		calendar.set(Calendar.MONTH, monthTerm);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(startDate);
		calendar1.set(Calendar.MONTH, monthTerm);
		long days=StringUtil.getDifferDayNoHMS(calendar.getTime(), calendar1.getTime());
		return days;
	}
	public static String makeNbsp(int count){
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < count; i++)
		{
			sBuffer.append("&nbsp;");
		}
		return sBuffer.toString();
	}
	
	/**
	 * 获得当前日期和时间
	 * @throws ParseException 
	 */
	public static Date getCurDateTime()throws ParseException {
		String dateStr = dateFormat(new Date());
		return String2DateTime(dateStr);
	}
	
	/**
	 * 获得当前日期和时间
	 */
	public static Date getCurDateTimeNOException() {
		Date result = null;
		try {
			String dateStr = dateFormat(new Date());
			result = String2DateTime(dateStr);
		} catch (ParseException e) {
			result = null;
		}
		
		return result;
	}
	
	/**
	 * 字符串转换为时间(带时分秒)
	 * 需要迁移到专门的DateUtil
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date String2DateTime(String str) throws ParseException {
		return DateUtils.parseDate(str, new String[]{"yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss"});
	}
	
	/**
	 * 字符串转换为日期(只是年月日,不带时分秒)
	 * 需要迁移到专门的DateUtil
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date String2Date(String str) throws ParseException {
		return DateUtils.parseDate(str, new String[]{"yyyy-MM-dd", "yyyyMMdd"});
	}
	
	/**
	 * 字符串转换为日期(只是年月日,不带时分秒)
	 * 需要迁移到专门的DateUtil
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date String2DateNOException(String str, Date defaultValue)  {
		Date result = null;
		if(StringUtils.isEmpty(str)) {
			result = defaultValue;
		}else {
			try {
				result = DateUtils.parseDate(str, new String[]{"yyyy-MM-dd", "yyyyMMdd"});
			} catch (ParseException e) {
				result = defaultValue;
			}
		}
		
		return result;
	}
	
	/**
	 * 字符串转换为日期(只是年月日,不带时分秒)
	 * 需要迁移到专门的DateUtil
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date String2DateNOException(String str)  {
		Date result = null;
		try {
			result = String2DateNOException(str, getCurDateTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
