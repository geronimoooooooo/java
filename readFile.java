
------------------------------------------------------------------------------------------------------


---------------------------------
Read input from console

System.out.print("Enter your name: ");
 
        //  open up standard input, and buffer it
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 
        // use the readLine method of the BufferedReader class
        // to get whatever line the user types in:
        userName = bufferedReader.readLine();
        System.out.println("Thanks for the name, " + userName);
------------------------------------------------------
