<meta http-equiv="refresh" content="1; url=/next/page/to/go/to.jsp">

<script>
  setTimeout(function() {
      document.location = "/next/page/to/go/to.jsp";
  }, 1000); // <-- this is the delay in milliseconds
</script>


In JavaScript:
http://stackoverflow.com/questions/23596931/forwarding-jsp-page-after-the-delay

functionToRunFirst();
setTimeout(function() {
    // rest of code here
}, 2000);

function mainGeneratorFunction() {
    functionToRunFirst();
    yield sleep(2000);
    //rest of the code
}

function run() {    
    // run this code

    setTimeout(afterTwoSeconds, 2000);    
}

function afterTwoSeconds() {    
    // run this code two seconds after executing run.   
}

// call run
run();
