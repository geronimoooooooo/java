Calendar cal = Calendar.getInstance();  // current time
cal.set(Calendar.WEEK_OF_MONTH, cal.get(Calendar.WEEK_OF_MONTH) - 2);
Date now = cal.getTime();
SimpleDateFormat sdf = SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");
String timeStr = sdf.format(now);
