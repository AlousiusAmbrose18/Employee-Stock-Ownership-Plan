package com.estorezz.esop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.estorezz.esop.constants.SqlConstants;

@Entity
@Table(name=SqlConstants.VESTED_OPTION_INFO)
public class VestedOption implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="grant_Id")
	private Long grantId;
	
	@Column(name="vested_Option")
	private Double vestedOption;
	
	@Column(name="created_Date")
	private LocalDateTime createdDate;
	
	@Column(name="modified_Date")
	private LocalDateTime modifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGrantId() {
		return grantId;
	}

	public void setGrantId(Long grantId) {
		this.grantId = grantId;
	}

	public Double getVestedOption() {
		return vestedOption;
	}

	public void setVestedOption(Double vestedOption) {
		this.vestedOption = vestedOption;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "VestedOption [id=" + id + ", grantId=" + grantId + ", vestedOption=" + vestedOption + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
}
