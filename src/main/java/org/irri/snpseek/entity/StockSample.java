package org.irri.snpseek.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "stock_sample")
public class StockSample implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_sample_id")
    private BigDecimal stockSampleId;

    @Column(name = "stock_id")
    private Long stockId;

    @Column(name = "dbxref_id")
    private Long dbxrefId;

    @Column(name = "hdf5_index")
    private Integer hdf5Index;

    @Column(name = "tmp_oldstock_id")
    private Long tmpOldstockId;

    public StockSample() {
    }

    public StockSample(Long stockId, Long dbxrefId, Integer hdf5Index, Long tmpOldstockId) {
        this.stockId = stockId;
        this.dbxrefId = dbxrefId;
        this.hdf5Index = hdf5Index;
        this.tmpOldstockId = tmpOldstockId;
    }

    public StockSample(BigDecimal stockSampleId, Long stockId, Long dbxrefId, Integer hdf5Index, Long tmpOldstockId) {
        this.stockSampleId = stockSampleId;
        this.stockId = stockId;
        this.dbxrefId = dbxrefId;
        this.hdf5Index = hdf5Index;
        this.tmpOldstockId = tmpOldstockId;
    }

    public BigDecimal getStockSampleId() {
        return stockSampleId;
    }

    public void setStockSampleId(BigDecimal stockSampleId) {
        this.stockSampleId = stockSampleId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getDbxrefId() {
        return dbxrefId;
    }

    public void setDbxrefId(Long dbxrefId) {
        this.dbxrefId = dbxrefId;
    }

    public Integer getHdf5Index() {
        return hdf5Index;
    }

    public void setHdf5Index(Integer hdf5Index) {
        this.hdf5Index = hdf5Index;
    }

    public Long getTmpOldstockId() {
        return tmpOldstockId;
    }

    public void setTmpOldstockId(Long tmpOldstockId) {
        this.tmpOldstockId = tmpOldstockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockSample)) return false;
        StockSample that = (StockSample) o;
        return Objects.equals(stockSampleId, that.stockSampleId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stockSampleId);
    }

    @Override
    public String toString() {
        return "StockSample{" +
                "stockSampleId=" + stockSampleId +
                ", stockId=" + stockId +
                ", dbxrefId=" + dbxrefId +
                ", hdf5Index=" + hdf5Index +
                ", tmpOldstockId=" + tmpOldstockId +
                '}';
    }
}