Möchte man ein Servlet nach Deploy oder Serverstart sofort ausführen, dann auch die init() Methode in dem Servlet implementieren. Load-on-startup bedeutet nicht, 
dass doGet()aufgerufen wird. Ohne init() muss man noch immer ein GET aufs Servlet machen.
Noch besser ist es gleich einen Listener zu nutzen.
	
https://stackoverflow.com/questions/18808853/load-on-start-up-using-annotation-in-java
  
@Override
    public void init() throws ServletException {
        System.out.println("This is init load-on-startup from Tester");
    }

<servlet>   
  <display-name>Tester</display-name>
  <servlet-name>Tester</servlet-name>
  <servlet-class>handler.Tester</servlet-class>
  <load-on-startup>0</load-on-startup>  
</servlet>
