package com.opportunity.spring.batch.reader;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.opportunity.spring.model.ExcelRow;

@Component
//public class ExcelFileReader implements ItemReader<ExcelRow> {

public class ExcelFileReader extends FlatFileItemReader<ExcelRow> {
	
	private List<ExcelRow> excelRowList = new ArrayList<ExcelRow>();
/*	
	public ExcelFileReader() {
		excelRowList
	}*/
	
	@Override
	public void setResource(Resource resource) {
		super.setResource(resource);
	}
	
	@Override
	public void setLineMapper(LineMapper<ExcelRow> lineMapper) {
		super.setLineMapper(new DefaultLineMapper<ExcelRow>() {
			@Override
			public void setFieldSetMapper(FieldSetMapper<ExcelRow> fieldSetMapper) {
				super.setFieldSetMapper(new BeanWrapperFieldSetMapper<ExcelRow>() {{
					super.setTargetType(ExcelRow.class);
				}});
			}
		});
		
	}
	
	@Override
	public ExcelRow read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		ExcelRow excelRow = new ExcelRow("User.test@email.com"+RandomUtils.nextInt(), "User"+RandomUtils.nextInt(),"Package1"+RandomUtils.nextInt());
		//excelRowList
		return excelRow;
	}

}
