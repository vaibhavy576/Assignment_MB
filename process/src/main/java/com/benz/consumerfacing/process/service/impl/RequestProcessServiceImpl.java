package com.benz.consumerfacing.process.service.impl;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;

import com.benz.consumer.request.model.FileDataDTO;
import com.benz.consumerfacing.process.exception.CustomErrorCodes;
import com.benz.consumerfacing.process.exception.CustomException;
import com.benz.consumerfacing.process.service.RequestProcessService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;



public class RequestProcessServiceImpl implements RequestProcessService {

	private final Logger logger = LoggerFactory.getLogger(RequestProcessServiceImpl.class);

	@Value("${saved_file_location}")
	private String savedFileLocation;
	
	
	@Override
	@JmsListener(destination = "test-queue")
	public String listener(FileDataDTO fileDataDTO) throws IOException, CustomException {
	
		logger.info("Message received {} ", fileDataDTO);
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonTree = objectMapper.readTree('[' + fileDataDTO.getJson() + ']');
			Builder csvSchemaBuilder = CsvSchema.builder();
			JsonNode firstObject = jsonTree.elements().next();
			firstObject.fieldNames().forEachRemaining(fieldName -> {
				csvSchemaBuilder.addColumn(fieldName);
			});
			CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
			CsvMapper csvMapper = new CsvMapper();
			csvMapper.writerFor(JsonNode.class).with(csvSchema).writeValue(new File(savedFileLocation), jsonTree);
		} catch (IOException e) {
			logger.info("Unable to save Json : {}", fileDataDTO.getJson());
			throw new CustomException(CustomErrorCodes.UNABLE_TO_SAVE);
		}
		return fileDataDTO.getJson();
	}

}
