 private static final Logger log = Logger.getLogger( CULDemo.class.getName() );
   log.info( "Dann mal los." );
     
     catch ( Exception e )
    {
      log.log( Level.SEVERE, "oh oh", e );
    }
    
Handler handler = new FileHandler( "log.txt" );
log.addHandler( hanlder );

Logger log = Logger.getLogger( CULDemo.class.getName() );
Handler handler = new ConsoleHandler();
handler.setLevel( Level.FINEST );
log.addHandler( handler );
log.setLevel( Level.FINEST );
log.fine( "Alles ist fein!" );
