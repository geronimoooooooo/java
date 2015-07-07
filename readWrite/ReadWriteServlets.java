Bei Servlets: css2.css in den ordner src/resources abstellen
try 
(BufferedReader br = new BufferedReader(new InputStreamReader(
Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/css2.css"))))
