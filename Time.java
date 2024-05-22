
### HOW TO DO #################################################################
### ConvertFromFormatToFormat ##################################################
### FORMATTING STRINGS ###########################################################
### SUBSTRING #################################################################
### CONVERTING #################################################################
### KLASSEN ################################################################

### HOW TO DO #################################################################
Measure Elapsed Time mit Instant: https://howtodoinjava.com/java/date-time/intro-to-date-time-api/
Date to String with DateTimeFormatter https://stackoverflow.com/questions/42210257/java-util-date-to-string-using-datetimeformatter
Date to Lcd und Instant https://www.baeldung.com/java-date-to-localdate-and-localdatetime

https://medium.com/elca-it/how-to-get-time-zones-right-with-java-8dea13aabe5c
set date time zone
+ Wenn Sekunden bei der Zeit fehlen, dann StringFormatter mit SS nutzen
#########################
Seit Java8:
Examples
+ http://www.journaldev.com/2800/java-8-date-time-api-example-tutorial-localdate-instant-localdatetime-parse-and-format
+ https://www.tutorialspoint.com/javatime/index.htm Auflistung aller Klassen und verfügbarer Methoden bezüglich ZEIT time

long startTime = System.nanoTime();
long startTime2 = System.currentTimeMillis();
long durationTime = System.nanoTime() - startTime;
String duration = Long.toString(durationTime);
System.out.println("elapsed time in ms:" + endTime / 1000000);

if(KlimaApp.zeitOffset.equals("0")) {
	java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("GMT"));
	System.out.println("timedefault GMT: " + TimeZone.getDefault());
}else if(KlimaApp.zeitOffset.equals("1")) {
	java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("GMT+1"));
	System.out.println("timedefault: GMT+1 " + TimeZone.getDefault());
}

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
Instant in = Instant.now(); // 2024-05-09T23:37:10.050083400Z
in = in.truncatedTo(ChronoUnit.SECONDS);// 2021-09-22T10:18:38Z		

Date date1 = Date.from(in);
System.out.println(date1); //

LocalDateTime ldt = LocalDateTime.now(); // 2021-09-22T12:18:38.243
ldt = ldt.truncatedTo(ChronoUnit.SECONDS); // 2021-09-22T12:18:38
-----------------------------------------------------------------------------------
LocalDateTime oldDate = LocalDateTime.of(2016, Month.AUGUST, 31, 10, 20, 55); //2016-08-31T10:20:55
-----------------------------------------------------------------------------------
Von Instant zu LocalDateTime:
	Instant in = Instant.now(); 2022-03-29T12:39:08.052Z
	LocalDateTime ldt = LocalDateTime.now(); 2022-03-29T14:39:08.052
	LocalDateTime ldt2 = LocalDateTime.ofInstant(in, ZoneOffset.UTC); 2022-03-29T12:39:08.052 UTC Zeit aber ohne Z hinten
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
### ConvertFromFormatToFormat ##################################################
	https://www.ionos.com/digitalguide/websites/web-development/iso-8601/
	
ZeitString(FormatA) wird geparsed zu Date und Date wird dann mit FormatB zu String formatiert
	
public static String getOurDate() {
	String dateStr = "2019-09-26T07:58:30.996+0200";
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	try {
	    Date unformatedDate = format.parse(dateStr);
	    String formatedDate = new SimpleDateFormat("HH:mm dd.MM.yyyy").format(unformatedDate);
	    return formatedDate; //07:58 26.09.2019
	    }   catch (ParseException e){
		    System.out.println("Error");
	    }
	    return dateStr;
}
### FORMATTING STRINGS ##########################################################################
System.out.println(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS)); 2023-10-06T17:25:35.401
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSS");
System.out.println(LocalDateTime.now().format(formatter)); 2023-10-06T17:25:41.3104
	LocalDateTime localDateTime = LocalDateTime.of(2024, 5, 9, 10, 30);
        // Create a ZonedDateTime from the LocalDateTime with a specific time zone (UTC)
	ZonedDateTime zonedDateTimeUTC = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String formattedDateTime = formatter.format(zonedDateTimeUTC);
        System.out.println("Formatted date and time in UTC: " + formattedDateTime);
	
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
Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2012-05-20T09:00:00.000Z");
"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"   2001-07-04T12:08:56.235-07:00
"YYYY-'W'ww-u"  2001-W27-3
"yyyy-MM-dd HH:mm:ssXXX" 2024-05-09 23:35:08+01:00 wenn objekt timezone info hat, wie z.B. OffsetDateTime, ZonedDateTime
YYYY-MM-DD"T"HH24:MI:SS"Z" in Oracle NLS zeigt in Spalte Datum die standard Z ISO Zeit an
("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2012-05-20T09:00:00.000Z");
	TO_DATE('2024-05-14T18:50:00', 'yyyy-MM-dd"T"HH24:mi:ss')
	dateTime = listOneMeasurementProcess.get(0).replace(' ', 'T');
	String dateTimeFormat = "yyyy-MM-dd\"T\"HH24:mi:ss";
	toDate = "TO_DATE('" + dateTime + "', 'yyyy-MM-dd\"T\"HH24:mi:ss')";
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
  sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
  return sdf.format(date);
---------------------------------------------------------------
http://stackoverflow.com/questions/4772425/change-date-format-in-a-java-string
---------------------------------------------------------------
--------------------------------------------------------------
long startTime = System.nanoTime;
long endTime = System.nanoTime() - startTime;
System.out.println("elapsed time:" + endTime / 1000000);
--------------------------------------------------------------
---------------------------------------------------------------

<input id="_endDate" type="text" name="_endDate" size="65" placeholder="provide a end date" value="<%= currentDate %>"   />    </td>
---------------------------------------------------------------


---------------------------------------------------------------
    	Instant in = Instant.now();
    	LocalDateTime ldt = LocalDateTime.now();
    	LocalDateTime ldt2 = LocalDateTime.ofInstant(in, ZoneOffset.UTC);
      LocalDateTime ldt3 = LocalDateTime.ofInstant(in, ZoneId.systemDefault());  
      System.out.println("Instant:" +in);
  		System.out.println("ldt:" +ldt);
  		System.out.println("ldt ZoneOffset.UTC) :"+ldt2);
      System.out.println("ldt ZoneId.systemDefault():" +ldt3);
      ZonedDateTime ldtZoned = ldt.atZone(ZoneId.systemDefault());
      System.out.println("ldtZoned: "+ldtZoned);
      System.out.println("ldtZoned.toInstant(): "+ldtZoned.toInstant());
      
      ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));

      System.out.println("utcZoned: "+ utcZoned);
      
      LocalDateTime ldt5 = LocalDateTime.now();
      System.out.println("ldt5: "+ldt5);
      ZonedDateTime zdt = ldt5.atZone(ZoneId.systemDefault());
      System.out.println("zdt: "+zdt);
      Instant in5 = zdt.toInstant();
      System.out.println("in5: "+in5);
 
      
      Instant in6= Instant.now();
      LocalDateTime l = LocalDateTime.ofInstant(in6, ZoneId.systemDefault());
      System.out.println(in6);
      System.out.println(l);
      
      Instant in7 = in6.plus(30, ChronoUnit.DAYS);
      System.out.println(in7);
      Duration duration = Duration.between(LocalDateTime.ofInstant(in6, ZoneId.systemDefault()), LocalDateTime.ofInstant(in7, ZoneId.systemDefault()));
      System.out.println(duration.toDays());

---------------------------------------------------------------
Expected :2020-10-10T15:16
Actual   :2020-10-10T15:16:00
https://stackoverflow.com/questions/65124679/how-to-format-localdatetime-with-minutes-only-truncate-seconds
---------------------------------------------------------------


### SUBSTRING #################################################################
NodeList textTSVList = tsvMeasTimeElement.getChildNodes();
// System.out.print( "\n" +
// ((Node)textTSVList.item(0)).getNodeValue().trim() ); // optionale
// Ausgabe des eingelesenen Zeitpunkts auf den Bildschirm

String date = ((Node) textTSVList.item(0)).getNodeValue().trim().toString();

// ... fuer die weitere Prozessierung sinnvoll formatiert ...
String date_year = date.substring(0, 4);
String date_month = date.substring(5, 7);
String date_day = date.substring(8, 10);
String date_hour = date.substring(11, 13);
String date_minute = date.substring(14, 16);
String date_second = date.substring(17, 19);
// System.out.println ( "\n" + date + " " + date_year + " " +
// date_month + " " + date_day + " " + date_hour + " " + date_minute +
// " " + date_second ); // optionale Bildschirmausgabe

// ... und in die zu erzeugende Ausgabedatei geschrieben
// output.write ( date_hour + date_minute + date_second + date_day +
// date_month + date_year );
// System.out.println("Ausgangsdatei geschrieben: " + date_hour + date_minute + date_second + date_day +
// date_month + date_year);

// System.out.println("Messzeitpunkte: "+ date_year + date_month + date_day + date_hour + date_minute +
// date_second );

// ----------------------------------------------------------------
// Je Messzeitpunkt werden über eine geschachtelte Schleife saemtliche
// gemessenen Parameter eingelesen ...

### CONVERTING #################################################################
------------------- Parse String into LocalDateTime with DateTimeFormatter
String dateString = "2020-04-08 12:30";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
LocalDateTime parsedDateTime = LocalDateTime.parse(dateString, formatter);
System.out.println(parsedDateTime);		//2020-04-08T12:30

------------------ LocalDateTime to String with DateTimeFormatter		
//Format a date
LocalDateTime myDateObj = LocalDateTime.now();
DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
String formattedDate = myDateObj.format(myFormatObj);
System.out.println(formattedDate);	//	03-05-2020 13:46


### KLASSEN ################################################################
	https://medium.com/@hoangxuantoank13/a-simple-way-to-pocket-date-time-in-java-8-0b0288b73452
	Overview diagram zu den Klassen: https://miro.medium.com/v2/resize:fit:1400/format:webp/0*EpMHWU1U8JOHeix4.png

+ LocalDateTime class represents date and time without any time zone information	
	.withZone() hat keinen Effekt auf ldt, sondern nur auf ZonedDateTime und OffsetDateTime. Zeit die Zeitzone im time String an.
	LocalDateTime localDateTime = LocalDateTime.parse("2015-02-20T06:30:00");
	LocalDateTime currentDateTime = LocalDateTime.now();
	LocalDateTime newDateTime = currentDateTime.plusDays(7);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String formattedDateTime = currentDateTime.format(formatter);
	LocalDateTime ldt3 = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS);

+ ZonedDateTime represents date and time in a particular time zone. Includes info about the time offset from UTC.
	daylight saving time (DST) wird beachtet. .withZone() hat keinen Effekt auf ldt, sondern nur auf ZonedDateTime und OffsetDateTime. Zeit die Zeitzone im time String an.
	zdt objekt = ldt + zoneId
	// Using LocalDateTime and ZoneId
	LocalDateTime localDateTime = LocalDateTime.of(2023, 11, 6, 14, 30);
	ZoneId zoneId = ZoneId.of("America/New_York");
	ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
	// parse a string
	ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
	ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneId.of("Europe/London"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
		ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-05-05 10:15:30 Europe/Paris", formatter);

	ZonedDateTime newDateTime = currentDateTime.plusDays(7);	
	// Truncate to the nearest hour
	ZonedDateTime originalDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
	ZonedDateTime truncatedDateTime = originalDateTime.truncatedTo(ChronoUnit.HOURS);	
	// Compare if dateTime1 is before dateTime2
	ZonedDateTime dateTime1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
	ZonedDateTime dateTime2 = ZonedDateTime.now(ZoneId.of("Europe/London")).plusHours(2);
	boolean isBefore = dateTime1.isBefore(dateTime2);
	
	ZonedDateTime originalDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
	// Change to a different time zone (e.g., Europe/London) while keeping the same instant
	ZonedDateTime newDateTime = originalDateTime.withZoneSameInstant(ZoneId.of("Europe/London"));
	// Change the time zone without changing the instant
	ZonedDateTime updatedDateTime = originalDateTime.withZoneSameLocal(ZoneId.of("Europe/London"));

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
	String formattedDateTime = currentDateTime.format(formatter);
		ZonedDateTime zonedDateTime = ZonedDateTime.now(); // Get current ZonedDateTime
		// Convert ZonedDateTime to UTC+1
		LocalDateTime utc1 = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC+1")).toLocalDateTime();
		utc1 = utc1.truncatedTo(ChronoUnit.SECONDS);
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String utc1Formatted = dtf.format(utc1);
    

+ ZoneId class represents a time zone; convert datetime between timezones
	ZoneId zoneParis = ZoneId.of("Europe/Paris");
	ZoneId.systemDefault()
		
+ ZoneOffset class represents a fixed time offset (difference in hours/mins between a specific time zone and UTC) from UTC.
		ZoneOffset offset = ZoneOffset.ofHours(3);
	ZoneOffset utcOffset = ZoneOffset.UTC; //ZoneOffset.UTC returns a mere ZoneOffset with ID "Z", offset of 0 and default zone rules.

+ OffsetDateTime class represents a datetime with a fixed offset from UTC. Passend für Situationen wo z.B. daylight saving time (DST) nicht relevant. z.B. fixe UTC+1 MDS
	.withZone() hat keinen Effekt auf ldt, sondern nur auf ZonedDateTime und OffsetDateTime. Zeit die Zeitzone im time String an.
	offsetDateTime = ldt + ZoneOffSet
	LocalDateTime localDateTime = LocalDateTime.of(2023, 11, 6, 14, 30);
	ZoneOffset zoneOffset = ZoneOffset.ofHours(3);  // For UTC+03:00
	OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
	OffsetDateTime mdsDateTime = OffsetDateTime.now(ZoneOffset.ofHours(1));  // For UTC+01:00
	
	// Parse a string
	OffsetDateTime offsetDateTime = OffsetDateTime.parse("2023-11-06T14:30:00+03:00");
	OffsetDateTime originalDateTime = OffsetDateTime.now();

	// Change to a different offset (e.g., UTC+02:00)
	OffsetDateTime newDateTime = originalDateTime.withOffsetSameInstant(ZoneOffset.ofHours(2));
	// Change the offset without changing the instant
	OffsetDateTime updatedDateTime = originalDateTime.withOffsetSameLocal(ZoneOffset.ofHours(2));

+ Instant class liefert UTC Zeit,
	Instant currentInstant = Instant.now();
	Instant instantFromZonedDateTime = zonedDateTime.toInstant(); date.toInstant()	

+ Date class aus java.util.Date; sehr alt pre java8; Nimmt Java default system time zone her. represents the number of sec (unix epoch time)
	Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2012-05-20T09:00:00.000Z");
	Date dateNow = new Date();
	System.out.println("execute() nowTime: "+ DateTimeHelper.date2String_T_Z_Format(dateNow));
	Date datePast = new Date(dateNow.getTime()-(1000*60*sdio.timeRepeatInterval)); //ms * seconds * minutes
	System.out.println("execute() : "+ DateTimeHelper.date2String_T_Z_Format(datePast));
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
		formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		
		String dateInString = "22-01-2015 10:15:55 AM"; 
		Date date = formatter.parse(dateInString);
		String formattedDateString = formatter.format(date);
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	java.util.Date date = new java.util.Date(System.currentTimeMillis());
	Instant instant = date.toInstant();
	LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
	System.out.println(ldt.format(fmt));
		dateJava = new java.util.Date(dateSql.getTime()); //java.sql.Date to java.util.Date object
	java.util.Date date = Date.from( instant ) ;
	Instant instant = myJavaUtilDate.toInstant() ;
		dateSql = rs.getDate("DATUM");
		System.out.println("z time: "+TimeConverter.formatUTCTZ(new java.util.Date(dateSql.getTime())));
		java.util.Date newDate = rs.getTimestamp("DATUM");
		System.out.println("z time with getTimestamp: "+TimeConverter.formatUTCTZ(newDate));

+ SimpleDateFormat is not threadsafe. uses default timezone of system if none specified
	SimpleDateFormat shortTimeFormat = new SimpleDateFormat("HH:mm");
        shortTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

+ .withZone() hat keinen Effekt auf ldt, sondern nur auf ZonedDateTime und OffsetDateTime. Zeit die Zeitzone im time String an.
	2024-05-09 10:30:00 UTC+01:00
