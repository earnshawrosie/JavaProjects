package com.payara.model;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.UUID;

public class BaggageItem {

	private String id;
	private BaggageType baggageType;
	private Double weight;
	private BigDecimal fee;

	public BaggageItem(BaggageType baggageType, Double weight, BigDecimal fee) {
		super();
		this.id = shortUUID();
		this.baggageType = baggageType;
		this.weight = weight;
		this.fee = fee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaggageType getBaggageType() {
		return baggageType;
	}

	public void setBaggageType(BaggageType baggageType) {
		this.baggageType = baggageType;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	private String shortUUID() {
		UUID uuid = UUID.randomUUID();
		long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
		return Long.toString(l, Character.MAX_RADIX);
	}

	@Override
	public String toString() {
		return "BaggageItem [id=" + id + " baggageType=" + baggageType + ", weight=" + weight + ", fee=" + fee + "]";
	}
}
