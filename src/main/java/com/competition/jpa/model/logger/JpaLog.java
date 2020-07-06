package com.competition.jpa.model.logger;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "LOGGER", schema = "dbo")
public class JpaLog {
	
	private static final long serialVersionUID = 9190376302469353485L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	private Date insertDate;

	@Column
	private String logger;
	
	@Column
	private String level;
	
	@Column(name="message", length = 5000)
	private String message;
	
}