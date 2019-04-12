package com.poignanat.project.dto;

public class MailResponseDTO {
	private String message;
	private boolean status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MailResponseDTO [message=" + message + ", status=" + status + "]";
	}

}
