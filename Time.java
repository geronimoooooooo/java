//Gibt im Grunde ein DateTime.NOW() aus
  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
  Date date = new Date();
  System.out.println(dateFormat.format(date)); //2015-08-14T11:22:46:131Z  use :SSS for ms
  time_value=dateFormat.format(date);
---------------------------------------------------------------
public String getCurrentTimeStamp() {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
}
---------------------------------------------------------------
