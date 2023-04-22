package com.ByteQuest_Softwares.Exeption;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class MyError {

	private String name;
	
	private String desc;
	
	private LocalTime time;
	
}
