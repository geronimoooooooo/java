run every 20 seconds

CronTrigger trigger = newTrigger()
    .withIdentity("trigger1", "group1")
    .withSchedule(cronSchedule("0/20 * * * * ?"))
    .build();
--------------------------------------------
ALLE Möglichen Examples bezüglich Zeit: http://www.quartz-scheduler.org/documentation/quartz-2.x/examples/Example3
--------------------------------------------
		JobDetail job = JobBuilder.newJob(JobDescription.class).withIdentity(singleName, grpName).build();
		
		SimpleScheduleBuilder ssb = SimpleScheduleBuilder.simpleSchedule();
		ssb.withIntervalInSeconds(time).withRepeatCount(5);
		
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.startNow()				
				.withIdentity(singleName, grpName)
				.withSchedule(
						ssb
					).build();
--------------------------------------------

		JobDetail job = JobBuilder.newJob(JobDescription.class).withIdentity(singleName, grpName).build();
		
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.startNow()
				.withIdentity(singleName, grpName)
				.withSchedule(
					SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(time).repeatForever()).build();
-----------------------------------------------
