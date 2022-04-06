Date Time in Kombination mit DB
Class java.util.Date stores a date-time value as milliseconds since the epoch. java.sql.Date stores a date only value and is commonly used in JDBC

while (rs.next()) {
    rowCount++;
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    Date date = rs.getDate("DATUM");

    String strDate = rs.getDate("DATUM").toString();
    System.out.println("strDate: "+strDate); //strDate: 2022-03-29

    String strTime = rs.getTime("DATUM").toString();
    System.out.println("strTime: "+strTime); //strTime: 17:20:00

    String strTimeStamp = rs.getTimestamp("DATUM").toString();
    System.out.println("strTimeStamp: "+strTimeStamp); //strTimeStamp: 2022-03-29 17:20:00.0

    System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date)); //2022-03-29T17:20:00
    System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(date)); //2022-03-29T17:20:00Z
    System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(date)); //2022-03-29T17:20:00+0200

    strDate = sdf2.format(date);
    System.out.println(strDate); // 2022-03-29T17:20:00
			}
