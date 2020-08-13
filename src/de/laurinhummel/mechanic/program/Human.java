package de.laurinhummel.mechanic.program;

public class Human {
	
	private String name;
	private int age;
	private String job;
	private String hobby;
	
	public Human(String name, int age, String job, String hobby) {
		this.name = name;
		this.age = age;
		this.job = job;
		this.hobby = hobby;
	}
	
		public void printInformation() {
			System.out.println("Name: " + name);
			System.out.println("Alter: " + age);;
			System.out.println("Job: " + job);
			System.out.println("Hobby: " + hobby);
		}
		
	}
