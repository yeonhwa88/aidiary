package com.lec.dto;

import java.security.Timestamp;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Person {
	private int id;
	private String name;
	private String tel;
	private String address;
	private Date birth;
	private String memo;
	private Timestamp rdate;
}
