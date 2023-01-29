Seit Java8:
Examples
+ http://www.journaldev.com/2800/java-8-date-time-api-example-tutorial-localdate-instant-localdatetime-parse-and-format
+ https://www.tutorialspoint.com/javatime/index.htm Auflistung aller Klassen und verfügbarer Methoden bezüglich ZEIT time

long startTime = System.nanoTime();
long startTime2 = System.currentTimeMillis();
long durationTime = System.nanoTime() - startTime;
String duration = Long.toString(durationTime);
System.out.println("elapsed time in ms:" + endTime / 1000000);

-----------------------------------------------------------------------------------
	https://www.youtube.com/watch?v=9hUEiu_Ts68
-----------------------------------------------------------------------------------
 public static void main(String[] args) {
    
    double messZeitpunkteVorhanden = 3900;
    
    YearMonth monthsInYear = YearMonth.of(2022,2);

    int daysInMonth = monthsInYear.lengthOfMonth();
    int messZeitpunkteImMonat = daysInMonth *24*6;
    System.out.println("days in month: "+daysInMonth +", und Anzahl Messzeitpunkte: "+messZeitpunkteImMonat);
    
    double percent = messZeitpunkteVorhanden/messZeitpunkteImMonat*100;
    double fehlendeProzent = 100-percent;
    int ceil = (int)Math.ceil(fehlendeProzent);
    int floor = (int)Math.floor(fehlendeProzent);
    System.out.println("Prozent: "+percent + "fehlende %: "+ fehlendeProzent);
    System.out.println("ceil: "+ceil +", floor: "+floor);
  }
-----------------------------------------------------------------------------------
compare Datum und Zeiten: https://howtodoinjava.com/java/date-time/compare-localdates/
-----------------------------------------------------------------------------------
Instant in = Instant.now();
System.out.println(in); // 2021-09-22T10:17:16.862Z
in = in.truncatedTo(ChronoUnit.SECONDS);
System.out.println(in); // 2021-09-22T10:18:38Z		

Date date1 = Date.from(in);
System.out.println(date1); //

LocalDateTime ldt = LocalDateTime.now();
System.out.println(ldt); // 2021-09-22T12:18:38.243
ldt = ldt.truncatedTo(ChronoUnit.SECONDS);
System.out.println(ldt);// 2021-09-22T12:18:38
-----------------------------------------------------------------------------------
LocalDateTime oldDate = LocalDateTime.of(2016, Month.AUGUST, 31, 10, 20, 55);2016-08-31T10:20:55
-----------------------------------------------------------------------------------
Von Instant zu LocalDateTime:
	Instant in = Instant.now(); 2022-03-29T12:39:08.052Z
	LocalDateTime ldt = LocalDateTime.now(); 2022-03-29T14:39:08.052
	LocalDateTime ldt2 = LocalDateTime.ofInstant(in, ZoneOffset.UTC);2022-03-29T12:39:08.052 UTC Zeit aber ohne Z hinten
	LocalDateTime ldt3 = LocalDateTime.ofInstant(in, ZoneId.systemDefault());  2022-03-29T14:39:08.052
		
Von LocalDateTime zu Instant mit UTC Z (geht nur über ZonedDateTime):	
      LocalDateTime ldt5 = LocalDateTime.now(); 2022-03-29T15:49:38.975      
      ZonedDateTime zdt = ldt5.atZone(ZoneId.systemDefault()); 2022-03-29T15:49:38.975+02:00[Europe/Berlin]      
      Instant in5 = zdt.toInstant(); 2022-03-29T13:49:38.975Z      

	System.out.println(LocalDateTime.now(Clock.systemUTC())); 2022-03-29T13:04:20.139  UTC Zeit aber ohne Z hinten
	System.out.println(ZonedDateTime.now()); 2022-03-29T15:04:20.140+02:00[Europe/Berlin]
-----------------------------------------------------------------------------------	
System.out.println("time: " +new java.util.Date()+ ", "+Instant.now()); 
//Mon Mar 14 20:41:46 CET 2022, 2022-03-14T19:41:46.256Z
-----------------------------------------------------------------------------------
Get Current Date and Time:  https://www.javatpoint.com/java-get-current-date
LocalDateTime now = LocalDateTime.now(); 

jshell> LocalDateTime.of(LocalDate.now(), LocalTime.now())
$52 ==> 2018-07-07T00:40:38.198318200
-----------------------------------------------------------------------------------
	DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
	Instant instant = Instant.now();		
	instant = Instant.parse("1995-10-23T10:12:35Z");		
	System.out.println(instant); //1995-10-23T10:12:35Z
	System.out.println("time: "+Instant.now());//time: 2016-03-21T13:25:43.415Z
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
---------------------------------------------------------------
Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2012-05-20T09:00:00.000Z");
---------------------------------------------------------------
---------------------------------------------------------------
---------------------------------------------------------------
