Seit Java8:
Examples
+ http://www.journaldev.com/2800/java-8-date-time-api-example-tutorial-localdate-instant-localdatetime-parse-and-format

System.out.println("time: " +new java.util.Date()+ ", "+Instant.now()); 
//Mon Mar 14 20:41:46 CET 2022, 2022-03-14T19:41:46.256Z
-----------------------------------------------------------------------------------
	DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
	Instant instant = Instant.now();		
	instant = Instant.parse("1995-10-23T10:12:35Z");		
	System.out.println(instant);
	//1995-10-23T10:12:35Z
	System.out.println("time: "+Instant.now());
	//time: 2016-03-21T13:25:43.415Z
	System.out.println("ldt:  "+LocalDateTime.now().withNano(0).format(FORMATTER));
	//ldt:  2016-03-21T14:25:43Z
------------------------------------------------------------------------------------------------
	Date dateCreated = rs.getDate("DATUM");
	java.sql.Date d2 = new java.sql.Date(rs.getDate("DATUM").getTime());
	// boolean isAdmin = rs.getBoolean("is_admin");
	// int numPoints = rs.getInt("num_points");

	java.sql.Timestamp timestamp = rs.getTimestamp("DATUM"); // O/P: DD:MM:YYYY HH:mm:ss
	java.util.Date d3 = new java.util.Date(timestamp.getTime());

	java.sql.Timestamp ts = rs.getTimestamp("DATUM");
	java.sql.Date date = new java.sql.Date(ts.getTime());
	java.util.Date dd = new java.util.Date(date.getTime());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	System.out.println(sdf.format(dd)); // 2021-09-20T16:40:00
	System.out.println("date: " + dateCreated); // 2021-09-20
	System.out.println("date: " + d2); // 2021-09-20
	System.out.println("date: " + d3); // Mon Sep 20 17:00:00 CEST 2021
------------------------------------------------------------------------------------------------
Unlike the old java.util.Date which has milliseconds precision, an Instant has nanoseconds precision.
	Instant in = Instant.now();
	System.out.println(in); // 2021-09-22T10:17:16.862Z
	in = in.truncatedTo(ChronoUnit.SECONDS);
	System.out.println(in); // 2021-09-22T10:18:38Z

	LocalDateTime ldt = LocalDateTime.now();
	System.out.println(ldt); // 2021-09-22T12:18:38.243
	ldt = ldt.truncatedTo(ChronoUnit.SECONDS);
	System.out.println(ldt);// 2021-09-22T12:18:38	
------------------------------------------------------------------------------------------------
<% out.print("Today is:"+java.util.Calendar.getInstance().getTime()); %><br>
------------------------------------------------------------------------------------------------
  //Gibt im Grunde ein DateTime.NOW() aus
  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
  Date date = new Date();
  System.out.println(dateFormat.format(date)); //2015-08-14T11:22:46:131Z  use :SSS for ms
  time_value=dateFormat.format(date);
---------------------------------------------------------------
Calendar cal = Calendar.getInstance();  // current time
cal.set(Calendar.WEEK_OF_MONTH, cal.get(Calendar.WEEK_OF_MONTH) - 2);
Date now = cal.getTime();
SimpleDateFormat sdf = SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");
String timeStr = sdf.format(now);
--------------------------------------------------------------------
Wenn man möchte dass ein ein RequestDispatcher erst nach 5 Sekunden aufgerufen wird.
Oder überhaupt einen thread.sleep(5000) möchte

new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                // your code here
            }
        }, 
        5000 
);
--------------------------------------------------------------------
public String getCurrentTimeStamp() {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
}
---------------------------------------------------------------
G   Era designator  Text    AD
y   Year    Year    1996; 96
Y   Week year   Year    2009; 09
M   Month in year   Month   July; Jul; 07
w   Week in year    Number  27
W   Week in month   Number  2
D   Day in year Number  189
d   Day in month    Number  10
F   Day of week in month    Number  2
E   Day name in week    Text    Tuesday; Tue
u   Day number of week (1 = Monday, ..., 7 = Sunday)    Number  1
a   Am/pm marker    Text    PM
H   Hour in day (0-23)  Number  0
k   Hour in day (1-24)  Number  24
K   Hour in am/pm (0-11)    Number  0
h   Hour in am/pm (1-12)    Number  12
m   Minute in hour  Number  30
s   Second in minute    Number  55
S   Millisecond Number  978
z   Time zone   General time zone   Pacific Standard Time; PST; GMT-08:00
Z   Time zone   RFC 822 time zone   -0800
X   Time zone   ISO 8601 time zone  -08; -0800; -08:00
Examples:

"yyyy.MM.dd G 'at' HH:mm:ss z"  2001.07.04 AD at 12:08:56 PDT
"EEE, MMM d, ''yy"  Wed, Jul 4, '01
"h:mm a"    12:08 PM
"hh 'o''clock' a, zzzz" 12 o'clock PM, Pacific Daylight Time
"K:mm a, z" 0:08 PM, PDT
"yyyyy.MMMMM.dd GGG hh:mm aaa"  02001.July.04 AD 12:08 PM
"EEE, d MMM yyyy HH:mm:ss Z"    Wed, 4 Jul 2001 12:08:56 -0700
"yyMMddHHmmssZ" 010704120856-0700
"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"   2001-07-04T12:08:56.235-0700
"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"   2001-07-04T12:08:56.235-07:00
"YYYY-'W'ww-u"  2001-W27-3
---------------------------------------------------------------
http://stackoverflow.com/questions/4772425/change-date-format-in-a-java-string
---------------------------------------------------------------
formatter = new SimpleDateFormat("EEE d MMM yy", currentLocale);
today = new Date();
result = formatter.format(today);
System.out.println("Locale: " + currentLocale.toString());
System.out.println("Result: " + result);
--------------------------------------------------------------
long startTime = System.nanoTime;
long endTime = System.nanoTime() - startTime;
System.out.println("elapsed time:" + endTime / 1000000);
--------------------------------------------------------------
---------------------------------------------------------------
show actual time in jsp
<%@page import="utility.DateTimeHelper"%>
<%@page import="java.util.Date"%>

<%
Date date = new Date();
String currentDate = DateTimeHelper.date2String_T_Z_Format(date);
%>
<input id="_endDate" type="text" name="_endDate" size="65" placeholder="provide a end date" value="<%= currentDate %>"   />    </td>
---------------------------------------------------------------
Date dateNow = new Date();
System.out.println("execute() nowTime: "+ DateTimeHelper.date2String_T_Z_Format(dateNow));
Date datePast = new Date(dateNow.getTime()-(1000*60*sdio.timeRepeatInterval)); //ms * seconds * minutes
System.out.println("execute() : "+ DateTimeHelper.date2String_T_Z_Format(datePast));
---------------------------------------------------------------
Date today = new Date();
Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
---------------------------------------------------------------
Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2012-05-20T09:00:00.000Z");
---------------------------------------------------------------
---------------------------------------------------------------
---------------------------------------------------------------
