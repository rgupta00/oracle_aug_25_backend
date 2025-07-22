package com.bankapp.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {
	private String message;
	private Map<String, String>contactDetails;
	private List<String> onCallSupport;
}



