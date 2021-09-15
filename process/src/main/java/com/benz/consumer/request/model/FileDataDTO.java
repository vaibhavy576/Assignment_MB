package com.benz.consumer.request.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDataDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String fileType;
	private String json;
}
