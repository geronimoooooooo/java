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
