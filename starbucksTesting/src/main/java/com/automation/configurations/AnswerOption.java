package com.automation.configurations;

public class AnswerOption {

	private Integer option;
	
	public AnswerOption(Integer option) {
		this.option = option;
	}
	
	public Integer getOption() {
		return option;
	}
	
	public String toString() {
		return "Option number: " + option;
	}
}
