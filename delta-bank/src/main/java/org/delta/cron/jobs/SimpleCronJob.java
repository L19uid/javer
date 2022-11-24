package org.delta.cron.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.apache.log4j.Logger;

public class SimpleCronJob implements Job {

    private Logger log = Logger.getLogger(SimpleCronJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Simple cron job executed");
    }
}
