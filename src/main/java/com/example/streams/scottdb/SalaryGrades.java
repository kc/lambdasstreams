package com.example.streams.scottdb;

public class SalaryGrades {
	private final int grade;
	private final double highCutoff;
	private final double lowCutoff;
	
	public SalaryGrades(int grade, double highCutoff, double lowCutoff) {
		this.grade = grade;
		this.highCutoff = highCutoff;
		this.lowCutoff = lowCutoff;
	}

	public int getGrade() {
		return grade;
	}

	public double getHighCutoff() {
		return highCutoff;
	}

	public double getLowCutoff() {
		return lowCutoff;
	}

	@Override
	public String toString() {
		return "SalaryGrades [grade=" + grade + ", highCutoff=" + highCutoff + ", lowCutoff=" + lowCutoff + "]";
	}
}
