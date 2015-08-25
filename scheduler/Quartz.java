Cookbook: http://quartz-scheduler.org/documentation/quartz-2.x/cookbook/
Tutorial: http://quartz-scheduler.org/documentation/quartz-2.x/tutorials/
Documentation: http://www.quartz-scheduler.org/generated/2.2.1/html/qs-all/index.html#page/Quartz_Scheduler_Documentation_Set/re-exp_example4.html

PDFS:
http://www.quartz-scheduler.org/generated/2.2.1/pdf/Getting_Started_with_Quartz_Scheduler.pdf
http://www.quartz-scheduler.org/generated/2.2.1/pdf/Quartz_Scheduler_Developer_Guide.pdf
http://www.quartz-scheduler.org/generated/2.2.1/pdf/Quartz_Scheduler_Example_Programs_and_Sample_Code.pdf





------------------------------------
QuartzInitializerServlet
http://quartz-scheduler.org/api/previous_versions/2.1.0/org/quartz/ee/servlet/QuartzInitializerServlet.html

<servlet>
         <servlet-name>
             QuartzInitializer
         </servlet-name>
         <display-name>
             Quartz Initializer Servlet
         </display-name>
         <servlet-class>
             org.quartz.ee.servlet.QuartzInitializerServlet
         </servlet-class>
         <load-on-startup>
             1
         </load-on-startup>
         <init-param>
             <param-name>config-file</param-name>
             <param-value>/some/path/my_quartz.properties</param-value>
         </init-param>
         <init-param>
             <param-name>shutdown-on-unload</param-name>
             <param-value>true</param-value>
         </init-param>
         <init-param>
             <param-name>wait-on-shutdown</param-name>
             <param-value>true</param-value>
         </init-param>
         <init-param>
             <param-name>start-scheduler-on-load</param-name>
             <param-value>true</param-value>
         </init-param>
     </servlet>
------------------------------------
