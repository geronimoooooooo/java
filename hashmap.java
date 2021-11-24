Iterate over Hashmap:
http://www.mkyong.com/java/how-to-loop-a-map-in-java/

and how to remove elements from map:
http://java67.blogspot.co.at/2013/08/best-way-to-iterate-over-each-entry-in.html
--------------------------------------------------------------------------------
for (String s : ts.hash_parameter.keySet()) {
		System.out.println(s + " : " + ts.hash_parameter.get(s));
	}
---------------------------------------------------------------------------------
for (Map.Entry<String, JButton> entry : listbouton.entrySet())
{
  String key = entry.getKey();
  JButton value = entry.getValue();

  this.add(value);
}
---------------------------------------------------------------------------------
for (Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
    System.out.println(header.getKey() + "=" + header.getValue());
}
---------------------------------------------------------------------------------
10 Examples:
http://java67.blogspot.co.at/2013/02/10-examples-of-hashmap-in-java-programming-tutorial.html
---------------------------------------------------------------------------------
