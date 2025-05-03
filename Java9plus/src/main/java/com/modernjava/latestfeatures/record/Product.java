package com.modernjava.latestfeatures.record;

import java.math.BigDecimal;
import java.util.Objects;

public record Product(String name, BigDecimal cost, String type) {
	
	//By default constructors generated are called 'Canonical Constructor'
	
	public Product { //apply validations before construction
		
		if (name != null && name.isBlank()) {
			throw new IllegalArgumentException("name is not valid");
		}
		
		if (cost.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("cost is not valid");
		}
	}
	
	public Product(String name, BigDecimal cost) {  //Custom constructor
		this(name, cost, "GENERAL");
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(cost, other.cost) 
				&& Objects.equals(name, other.name); 
				//&& Objects.equals(type, other.type);
	}
	
	
}
