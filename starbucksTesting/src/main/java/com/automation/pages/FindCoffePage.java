package com.automation.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasePage;
import com.automation.configurations.AnswerOption;

public class FindCoffePage extends BasePage {

	public FindCoffePage(WebDriver pDriver) {
		super(pDriver);
	}

	@FindBy(id="question1")
	private WebElement questionOne;
	
	@FindBy(id="question2")
	private WebElement questionTwo;
	
	@FindBy(id="question3")
	private WebElement questionThree;
	
	@FindBy(id="question4")
	private WebElement questionFour;
	
	@FindBy(css=".col-xs-12.col-sm-12.col-md-12.col-lg-12.text-center")
	private WebElement findMyCoffeeDiv;
	
	@FindBy(id="find-my-coffee")
	private WebElement findMyCoffee;
	
	public String selectCoffee(AnswerOption answerOption) {
		selectAnswerOption(questionOne, answerOption.getOption());
		selectAnswerOption(questionTwo, answerOption.getOption());
		selectAnswerOption(questionThree, answerOption.getOption());
		selectAnswerOption(questionFour, answerOption.getOption());
		
		clickOnButton(findMyCoffee);
		return getURL();	
	}
	
	private void selectAnswerOption(WebElement question, Integer answerOption) {
		
		List<WebElement> answers = getAnswers(question);
		if (answerOption < answers.size() ) {
			clickOnAnswer(answers.get(answerOption));
			}
	}
	
	private List<WebElement> getAnswers(WebElement question){
		return question.findElements(By.tagName("button")).stream()
				.filter(we -> !we.getText().isEmpty()).collect(Collectors.toList());
	}
	
	private void clickOnAnswer(WebElement answer) {
		getWait().until(ExpectedConditions.visibilityOf(answer));
		getWait().until(ExpectedConditions.elementToBeClickable(answer));
		answer.click();
	}
	
	private void clickOnButton(WebElement button) {
		getWaitSeconds(10);
		getWait().until(ExpectedConditions.visibilityOf(button));
		getWait().until(ExpectedConditions.elementToBeClickable(button));
		button.click();
	}
}
