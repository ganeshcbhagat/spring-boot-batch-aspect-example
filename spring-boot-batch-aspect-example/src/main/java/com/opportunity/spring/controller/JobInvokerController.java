package com.opportunity.spring.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opportunity.application.configuration.AutomationConfiguration;
import com.opportunity.spring.service.AutomationConfigurationService;

@RestController
@RequestMapping(value="/rest")
public class JobInvokerController {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job1;

	@Autowired
	private AutomationConfigurationService automationConfigurationService;

	@RequestMapping("/invokejob")
	public String handle() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(job1, jobParameters);

		return "Batch job has been invoked";
	}

	@RequestMapping("/save")
	public String process() {
		automationConfigurationService.save(new AutomationConfiguration(1L, "Ganesh.test@email.com", "Ganesh"));
		automationConfigurationService.save(new AutomationConfiguration(2L, "Rajesh.test@email.com", "Rajesh"));
		automationConfigurationService.save(new AutomationConfiguration(3L, "Shambhu@email.com", "Shambhu"));
		automationConfigurationService.save(new AutomationConfiguration(4L, "Shripad@email.com", "Shripad"));
		return "Done";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";

		for (AutomationConfiguration automationConfiguration : automationConfigurationService.findAll()) {
			result += automationConfiguration.toString() + "</br>";
		}

		return result;
	}

	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id) {
		String result = "";
		result = automationConfigurationService.findById(id).toString();
		return result;
	}

	@RequestMapping("/findbyname")
	public String fetchDataByName(@RequestParam("name") String name) {
		String result = "";

		for (AutomationConfiguration automationConfiguration : automationConfigurationService.findByName(name)) {
			result += automationConfiguration.toString() + "</br>";
		}

		return result;
	}
}
