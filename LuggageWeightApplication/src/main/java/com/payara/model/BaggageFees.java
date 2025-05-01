package com.payara.model;

import java.math.BigDecimal;
import java.util.List;

public class BaggageFees {

	private BigDecimal total = BigDecimal.ZERO.setScale(2);
	private List<BaggageItem> bags;

	public BaggageFees(BigDecimal total, List<BaggageItem> bags) {
		super();
		this.total = total;
		this.bags = bags;
	}

	public BaggageFees() {
		super();
	}

	public BigDecimal getTotal() {
		return total.setScale(2);
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<BaggageItem> getBags() {
		return bags;
	}

	public void setBags(List<BaggageItem> bags) {
		this.bags = bags;
	}

	@Override
	public String toString() {
		return "BaggageFees [total=" + total.setScale(2) + ", bags=" + bags + "]";
	}

}
