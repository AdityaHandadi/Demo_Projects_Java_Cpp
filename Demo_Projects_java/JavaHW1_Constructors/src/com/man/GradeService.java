package com.man;

import com.classes.Grades;
import com.interfaces_.CalculateGrades;

public class GradeService implements CalculateGrades {

	@Override
	public Grades calculateGrades(float a, float b, float c, float d, float e) {
		Double total = (double) (a+b+c+d+e);
		Double percent = (total/500)*100;
		
		Grades grade =  new Grades();
		grade.setTotal(percent);
		
		if(percent >= 80){
			grade.setDivision("Distinction");
		}
		else if(percent < 80 && percent >= 60){
			grade.setDivision("First Diviion");
		}

		else if(percent < 60 && percent >= 45){
			grade.setDivision("Second Diviion");
		}

		else if(percent < 45 && percent >= 40){
			grade.setDivision("Third Diviion");
		}

		else if(percent < 40){
			grade.setDivision("Fail");
		}
		
		
		return grade;
	}

}
