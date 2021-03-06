package com.sidak.yesmamv2.Model;

import com.sidak.yesmamv2.Control.UIHelper;

import java.util.Date;

public class Holiday {
	public final static String TYPE_PLANNED="Planned";
	public final static String TYPE_INSTI="Insti";

	private int day;
	private int month ;
	private int year;
	private String description;
	private String type;
	private long id;
	public Holiday(){
		
	}
	
	public Holiday(int day , int month , int year,  String description, String type){
		this.day=day;
		this.year=year;
		this.month=month;
		this.description=description;
		this.type=type;
		
	}
	public long getId(){
		return id;
	}
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}
	public String getDescription(){
		return description;
	}
	public String getType(){
		return type;
	}
	public void setDay(int day){
		this.day= day;
	}
	public void setMonth(int month){
		 this.month=month;
	}
	public void setYear(int year){
		this.year = year;
	}
	public void setDescription(String description){
		this.description= description;
	}
	public void setType(String type){
		this.type= type;
	}
	public void setId(long id){
		this.id= id;
	}
	@Override
	public String toString() {
		return type+": \n"+ description+ "\n"+ day +"/"+ month+"/"+ year;
	}
	public String toDateString(){
		return day +"/"+ month+"/"+ year;
	}
	public Date toDateObject(){
		String s= day +"/"+ month+"/"+ year;
		return UIHelper.getDateObjectFromText(s);
	}
}
