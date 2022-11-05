package com.estorezz.esop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.estorezz.esop.constants.SqlConstants;

@Entity
@Table(name=SqlConstants.EXERCISE_INFO)
public class Exercise implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long grantId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private VestedOption vestedOption;
	
	private Double exerciseOptions;
	
	private Double soldOptions;
	
	private String status;
	
	private LocalDateTime createdDate;
	
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

	public VestedOption getVestedOption() {
		return vestedOption;
	}

	public void setVestedOption(VestedOption vestedOption) {
		this.vestedOption = vestedOption;
	}

	public Double getExerciseOptions() {
		return exerciseOptions;
	}

	public void setExerciseOptions(Double exerciseOptions) {
		this.exerciseOptions = exerciseOptions;
	}

	public Double getSoldOptions() {
		return soldOptions;
	}

	public void setSoldOptions(Double soldOptions) {
		this.soldOptions = soldOptions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Exercise [id=" + id + ", grantId=" + grantId + ", vestedOption=" + vestedOption + ", exerciseOptions="
				+ exerciseOptions + ", soldOptions=" + soldOptions + ", status=" + status + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	
}
