package com.opportunity.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opportunity.application.configuration.AutomationConfiguration;
import com.opportunity.application.configuration.AutomationConfigurationRepository;
import com.opportunity.spring.service.AutomationConfigurationService;

@Service
@Transactional
public class AutomationConfigurationServiceImpl implements AutomationConfigurationService {

	@Autowired
	private AutomationConfigurationRepository automationConfigurationRepository;
	
	@Override
	public Iterable<AutomationConfiguration> findByName(String name) {
		return automationConfigurationRepository.findByName(name);
	}
	
	@Override
	public Iterable<AutomationConfiguration> findAll() {
		return automationConfigurationRepository.findAll();
	}

	@Override
	public Optional<AutomationConfiguration> findById(Long id) {
		return automationConfigurationRepository.findById(id);
	}
	
	@Override
	public void delete(AutomationConfiguration automationConfiguration) {
		automationConfigurationRepository.delete(automationConfiguration);
	}
	
	@Override
	public void deleteById(Long id) {
		automationConfigurationRepository.deleteById(id);
	}
	
	@Override
	public void deleteAll() {
		automationConfigurationRepository.deleteAll();
	}
	
	@Override
	public AutomationConfiguration save(AutomationConfiguration automationConfiguration) {
		return automationConfigurationRepository.save(automationConfiguration);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AutomationConfiguration> saveAll(List<? extends AutomationConfiguration> automationConfigurationList) {
		return (List<AutomationConfiguration>) automationConfigurationRepository.saveAll(automationConfigurationList);
	}

}
