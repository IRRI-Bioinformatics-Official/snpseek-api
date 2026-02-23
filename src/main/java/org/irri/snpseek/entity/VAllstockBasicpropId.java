package org.irri.snpseek.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * IdClass for VAllstockBasicprop composite primary key (stockSampleId,
 * allStockIdId)
 */
public class VAllstockBasicpropId implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal stockSampleId;
	private BigDecimal allStockIdId;

	public VAllstockBasicpropId() {
	}

	public VAllstockBasicpropId(BigDecimal stockSampleId, BigDecimal allStockIdId) {
		this.stockSampleId = stockSampleId;
		this.allStockIdId = allStockIdId;
	}

	public BigDecimal getStockSampleId() {
		return stockSampleId;
	}

	public void setStockSampleId(BigDecimal stockSampleId) {
		this.stockSampleId = stockSampleId;
	}

	public BigDecimal getAllStockIdId() {
		return allStockIdId;
	}

	public void setAllStockIdId(BigDecimal allStockIdId) {
		this.allStockIdId = allStockIdId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		VAllstockBasicpropId that = (VAllstockBasicpropId) o;
		return Objects.equals(stockSampleId, that.stockSampleId) && Objects.equals(allStockIdId, that.allStockIdId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(stockSampleId, allStockIdId);
	}
}
