package org.irri.snpseek.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "stock")
public class Variety implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long stockId;

    @Column(name = "dbxref_id")
    private Long dbxrefId;

    @Column(name = "organism_id")
    private Long organismId;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "uniquename", length = 255)
    private String uniquename;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "is_obsolete")
    private Boolean isObsolete;

    @Column(name = "stock_geolocation_id")
    private Long stockGeolocationId;

    @Column(name = "tmp_oldstock_id")
    private Long tmpOldstockId;

    // No-arg constructor for JPA
    public Variety() {
    }

    // Convenience constructor (without PK)
    public Variety(Long dbxrefId, Long organismId, String name, String uniquename, String description,
                   Long typeId, Boolean isObsolete, Long stockGeolocationId, Long tmpOldstockId) {
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

    // Full constructor
    public Variety(Long stockId, Long dbxrefId, Long organismId, String name, String uniquename,
                   String description, Long typeId, Boolean isObsolete, Long stockGeolocationId,
                   Long tmpOldstockId) {
        this.stockId = stockId;
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

    public Long getOrganismId() {
        return organismId;
    }

    public void setOrganismId(Long organismId) {
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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Boolean getIsObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean isObsolete) {
        this.isObsolete = isObsolete;
    }

    public Long getStockGeolocationId() {
        return stockGeolocationId;
    }

    public void setStockGeolocationId(Long stockGeolocationId) {
        this.stockGeolocationId = stockGeolocationId;
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
        if (!(o instanceof Variety)) return false;
        Variety variety = (Variety) o;
        return Objects.equals(stockId, variety.stockId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stockId);
    }

    @Override
    public String toString() {
        return "Variety{" +
                "stockId=" + stockId +
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

	public BigDecimal getVarietyId() {
		return this.stockId != null ? new BigDecimal(this.stockId) : null;
	}

	public Object getDataset() {
		// TODO Auto-generated method stub
		return null;
	}
}