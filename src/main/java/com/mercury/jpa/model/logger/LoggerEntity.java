package com.mercury.jpa.model.logger;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "MERCURY_TB_LOGGER")
public class LoggerEntity {
	
	private static final long serialVersionUID = 9190376302469353485L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long idx;
	
	@Column
	private String logger;
	
	@Column
	private Date insertDate;

	@Column
	private String level;
	
	@Lob
	@Column(columnDefinition = "text")
	private String message;
	
}
