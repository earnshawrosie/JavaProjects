package com.payara.entity;

import java.math.BigDecimal;

import com.payara.model.BaggageType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "baggage_class")
public class BaggageClass {

	@Id
	@GeneratedValue(generator="bag_seq")
	@SequenceGenerator(name="bag_seq",sequenceName="BAGGAGE_CLASS_SEQ", allocationSize=1)
	private Long id;
	
	@Column(name = "min_weight")
	private Double minWeight;
	
	@Column(name = "max_weight")
	private Double maxWeight;
	
	@Column(name = "fee")
	private BigDecimal fee;
	
	@Column(name = "baggage_type")
	@Enumerated(EnumType.STRING)
	private BaggageType baggageType;
	
	
	public BaggageClass() {
		super();
	}
	
	public BaggageClass(Double minWeight, Double maxWeight, BigDecimal fee, BaggageType baggageType) {
		super();
		this.minWeight = minWeight;
		this.maxWeight = maxWeight;
		this.fee = fee;
		this.baggageType = baggageType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getMinWeight() {
		return minWeight;
	}
	public void setMinWeight(Double minWeight) {
		this.minWeight = minWeight;
	}
	public Double getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	
	public BaggageType getBaggageType() {
		return baggageType;
	}
	public void setBaggageType(BaggageType baggageType) {
		this.baggageType = baggageType;
	}
	@Override
	public String toString() {
		return "BaggageClass [id=" + id + ", minWeight=" + minWeight + ", maxWeight=" + maxWeight + ", fee=" + fee
				+ ", baggageType=" + baggageType + "]";
	}
	
}
