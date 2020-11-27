package com.assign.assing.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Userdto 
{
	private String name;
	
	private String email;
	
	private Long phonenumber;
	
	private String address;
	
	private Long pincode;
}
