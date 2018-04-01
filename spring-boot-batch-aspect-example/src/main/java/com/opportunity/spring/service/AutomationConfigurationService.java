package com.opportunity.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.opportunity.application.configuration.AutomationConfiguration;

@Service
public interface AutomationConfigurationService {
	
	public Iterable<AutomationConfiguration> findByName(String name);
	
	public Iterable<AutomationConfiguration> findAll();

	public Optional<AutomationConfiguration> findById(Long id);
	
	public void delete(AutomationConfiguration automationConfiguration);
	
	public void deleteById(Long id);
	
	public void deleteAll();
	
	public AutomationConfiguration save(AutomationConfiguration automationConfiguration);
	
	public List<AutomationConfiguration> saveAll(List<? extends AutomationConfiguration> automationConfigurationList);
	
}
