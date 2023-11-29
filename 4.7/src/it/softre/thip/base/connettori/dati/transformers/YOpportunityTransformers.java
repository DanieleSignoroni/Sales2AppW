package it.softre.thip.base.connettori.dati.transformers;

import java.math.BigDecimal;
import java.util.ArrayList;

public class YOpportunityTransformers {

	public String id;
	public String status;
	public String title;
	public Activity activity;
	public String code;
	public ArrayList<User> users;
	public Customer customer;
	public String location;
	public ArrayList<Object> contacts;
	public String description;
	public int success_rate;
	public int economic_value;
	public int economic_value_recurring;
	public String economic_value_period;
	public String economic_value_display;
	public ArrayList<Object> attachments;
	public String note;
	public int score;
	public String score_display;
	public ArrayList<Object> products;
	public ActivationDate activation_date;
	public Object project_id;
	public Object project_title;
	public Object project_value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char getStatus() {
		if (status == null) {
			return 'A';
		} else if (status.contains("active")) {
			return 'A';
		} else if (status.contains("win")) {
			return 'V';
		} else if (status.contains("lose")) {
			return 'P';
		}
		return 'A';
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Object> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Object> contacts) {
		this.contacts = contacts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSuccess_rate() {
		return success_rate;
	}

	public void setSuccess_rate(int success_rate) {
		this.success_rate = success_rate;
	}

	public BigDecimal getEconomic_value() {
		return BigDecimal.valueOf(economic_value);
	}

	public void setEconomic_value(int economic_value) {
		this.economic_value = economic_value;
	}

	public BigDecimal getEconomic_value_recurring() {
		return BigDecimal.valueOf(economic_value_recurring);
	}

	public void setEconomic_value_recurring(int economic_value_recurring) {
		this.economic_value_recurring = economic_value_recurring;
	}

	public String getEconomic_value_period() {
		return economic_value_period;
	}

	public void setEconomic_value_period(String economic_value_period) {
		this.economic_value_period = economic_value_period;
	}

	public String getEconomic_value_display() {
		return economic_value_display;
	}

	public void setEconomic_value_display(String economic_value_display) {
		this.economic_value_display = economic_value_display;
	}

	public ArrayList<Object> getAttachments() {
		return attachments;
	}

	public void setAttachments(ArrayList<Object> attachments) {
		this.attachments = attachments;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getScore_display() {
		return score_display;
	}

	public void setScore_display(String score_display) {
		this.score_display = score_display;
	}

	public ArrayList<Object> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Object> products) {
		this.products = products;
	}

	public ActivationDate getActivation_date() {
		return activation_date;
	}

	public void setActivation_date(ActivationDate activation_date) {
		this.activation_date = activation_date;
	}

	public Object getProject_id() {
		return project_id;
	}

	public void setProject_id(Object project_id) {
		this.project_id = project_id;
	}

	public Object getProject_title() {
		return project_title;
	}

	public void setProject_title(Object project_title) {
		this.project_title = project_title;
	}

	public Object getProject_value() {
		return project_value;
	}

	public void setProject_value(Object project_value) {
		this.project_value = project_value;
	}

	public class ActivationDate {
		public Date date;
	}

	public class Activity {
		public String id;
		public String method;
		public Object direction;
		public ArrayList<Customer> customers;
		public ArrayList<User> users;
		public ArrayList<Object> contacts;
		public Start start;
		public End end;
		public String title;
		public String description;
		public ActivationDate activation_date;
		public Object project_id;
		public Object project_title;
		public Object project_value;
		public Object project_value_display;
		public Object project_value_text;
	}

	public class Counters {
		public int position;
		public int score;
		public String scores_display;
		public int trend;
		public String trend_display;
	}

	public class Customer {
		public String id;
		public String picture;
		public String company_name;
		public ArrayList<Object> products;
		public String email;
		public String phone;
		public String phone_display;
		public String fax;
		public String fax_display;
		public String company_street_prefix;
		public String company_street_name;
		public String company_house_number;
		public String company_cap;
		public String company_city;
		public String company_district;
		public double latitude;
		public double longitude;
		public boolean assigned;
		public boolean assigned_to_none;
	}

	public class Customer2 {
		public String id;
		public String picture;
		public String company_name;
		public ArrayList<Object> products;
		public String email;
		public String phone;
		public String phone_display;
		public String fax;
		public String fax_display;
		public String company_street_prefix;
		public String company_street_name;
		public String company_house_number;
		public String company_cap;
		public String company_city;
		public String company_district;
		public double latitude;
		public double longitude;
		public boolean assigned;
		public boolean assigned_to_none;
	}

	public class Date {
		public String date_html;
		public String date_text;
		public String day;
		public String date;
		public String hour;
		public int timestamp;
	}

	public class End {
		public Date date;
	}

	public class Group {
		public Group group;
	}

	public class Group2 {
		public String id;
		public String title;
		public Object owner;
	}

	public class Start {
		public Date date;
	}

	public class User {
		public Counters counters;
		public User user;
	}

	public class User2 {
		public String id;
		public String status;
		public String role;
		public ArrayList<Group> groups;
		public ArrayList<Object> group_resp;
		public String avatar;
		public String username;
		public String company;
		public String fullname;
		public String firstname;
		public String lastname;
		public String eulogy;
		public String email;
		public String phone;
		public String phone_display;
		public int position;
	}

}
