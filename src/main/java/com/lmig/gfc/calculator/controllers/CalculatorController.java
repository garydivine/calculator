package com.lmig.gfc.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.calculator.models.Calculator;

@Controller
public class CalculatorController {

	private Calculator calc;

	public CalculatorController() {
		calc = new Calculator();
	}

	@RequestMapping("/")
	public ModelAndView showCalculator(String firstNumber, String secondNumber, String operator) {
		ModelAndView mv = new ModelAndView();
		double calcResult = 0;
		if (firstNumber != null && secondNumber != null) {
			calcResult = calc.doMath(firstNumber, secondNumber, operator);
			calc.addPreviousAttempt(firstNumber, secondNumber, operator, calcResult);
			mv.addObject("previousAttempts", calc.getPreviousAttempts());
		}
		
		mv.setViewName("calculator");
		mv.addObject("result", calcResult); // should i hide the ui somehow so i dont have to have this out here??
		return mv;
	}
}
