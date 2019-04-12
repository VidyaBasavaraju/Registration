package com.poignanat.project.dto;

public class MailRequestDTO {
	public MailRequestDTO() {

		System.out.println("cretaed:" + this.getClass().getSimpleName());
	}

	private String name;
	private String to;
	private String from;
	private String subject;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "MailRequestDTO [name=" + name + ", to=" + to + ", from=" + from + ", subject=" + subject + "]";
	}

}
