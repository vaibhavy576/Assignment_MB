package com.benz.consumerfacing.process.service;

import java.io.IOException;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import com.benz.consumer.request.model.FileDataDTO;
import com.benz.consumerfacing.process.exception.CustomException;

@Component
@EnableJms
public interface RequestProcessService {
	public String listener(FileDataDTO fileDataDTO) throws IOException, CustomException;
}
