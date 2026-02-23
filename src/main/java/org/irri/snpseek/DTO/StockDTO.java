package org.irri.snpseek.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class StockDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal varietyId;
    private BigDecimal dbxrefId;
    private BigDecimal organismId;
    private String name;
    private String uniquename;
    private String description;
    private BigDecimal typeId;
    private Boolean isObsolete;
    private BigDecimal stockGeolocationId;
    private BigDecimal tmpOldstockId;

    public StockDTO() {
    }

    public StockDTO(BigDecimal varietyId, BigDecimal dbxrefId, BigDecimal organismId, String name, String uniquename,
                    String description, BigDecimal typeId, Boolean isObsolete, BigDecimal stockGeolocationId,
                    BigDecimal tmpOldstockId) {
        this.varietyId = varietyId;
        this.dbxrefId = dbxrefId;
        this.organismId = organismId;
        this.name = name;
        this.uniquename = uniquename;
        this.description = description;
        this.typeId = typeId;
        this.isObsolete = isObsolete;
        this.stockGeolocationId = stockGeolocationId;
        this.tmpOldstockId = tmpOldstockId;
    }

    public BigDecimal getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(BigDecimal varietyId) {
        this.varietyId = varietyId;
    }

    public BigDecimal getDbxrefId() {
        return dbxrefId;
    }

    public void setDbxrefId(BigDecimal dbxrefId) {
        this.dbxrefId = dbxrefId;
    }

    public BigDecimal getOrganismId() {
        return organismId;
    }

    public void setOrganismId(BigDecimal organismId) {
        this.organismId = organismId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniquename() {
        return uniquename;
    }

    public void setUniquename(String uniquename) {
        this.uniquename = uniquename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTypeId() {
        return typeId;
    }

    public void setTypeId(BigDecimal typeId) {
        this.typeId = typeId;
    }

    public Boolean getIsObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean isObsolete) {
        this.isObsolete = isObsolete;
    }

    public BigDecimal getStockGeolocationId() {
        return stockGeolocationId;
    }

    public void setStockGeolocationId(BigDecimal stockGeolocationId) {
        this.stockGeolocationId = stockGeolocationId;
    }

    public BigDecimal getTmpOldstockId() {
        return tmpOldstockId;
    }

    public void setTmpOldstockId(BigDecimal tmpOldstockId) {
        this.tmpOldstockId = tmpOldstockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockDTO)) return false;
        StockDTO stockDTO = (StockDTO) o;
        return Objects.equals(varietyId, stockDTO.varietyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(varietyId);
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "varietyId=" + varietyId +
                ", dbxrefId=" + dbxrefId +
                ", organismId=" + organismId +
                ", name='" + name + '\'' +
                ", uniquename='" + uniquename + '\'' +
                ", description='" + description + '\'' +
                ", typeId=" + typeId +
                ", isObsolete=" + isObsolete +
                ", stockGeolocationId=" + stockGeolocationId +
                ", tmpOldstockId=" + tmpOldstockId +
                '}';
    }
}
