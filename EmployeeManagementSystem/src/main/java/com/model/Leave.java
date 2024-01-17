package com.model;

public class Leave {
		
		private String Emp_id;
		private String Reason;
		private String Description;
		private String From;
		private int Days;
		
		public Leave(String emp_id, String reason, String description, String from, int days) {
			super();
			Emp_id = emp_id;
			Reason = reason;
			Description = description;
			From = from;
			Days = days;
		}
		public String getEmp_id() {
			return Emp_id;
		}
		public void setEmp_id(String emp_id) {
			Emp_id = emp_id;
		}
		public String getReason() {
			return Reason;
		}
		public void setReason(String reason) {
			Reason = reason;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getFrom() {
			return From;
		}
		public void setFrom(String from) {
			From = from;
		}
		public int getDays() {
			return Days;
		}
		public void setDays(int days) {
			Days = days;
		}
}