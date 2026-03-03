package org.irri.snpseek.repository;

import java.util.ArrayList;
import java.util.List;

import org.irri.snpseek.DTO.SnpRefPosIndex;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class SnpFeatureRepositoryImpl implements SnpFeatureRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<SnpRefPosIndex> findSnpRefPosIndex(Long organismId, Long srcfeatureId, Integer chromosome,
            Long startPos, Long endPos, List<String> variantsetNames) {

        if (variantsetNames == null || variantsetNames.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT sfl.snp_feature_id AS snpFeatureId, ");
        sql.append(" :chromosome AS chromosome, ");
        sql.append(" sfl.position + 1 AS position, ");
        sql.append(" sfl.refcall, ");
        sql.append(" '' AS altcall, ");
        sql.append(" vvs.hdf5_index AS alleleIndex, ");
        sql.append(" v.variantset_id AS typeId, ");
        sql.append(" v.name AS variantsetName ");
        sql.append(" FROM public.snp_featureloc sfl ");
        sql.append(" JOIN public.variant_variantset vvs ON sfl.snp_feature_id = vvs.variant_feature_id ");
        sql.append(" JOIN public.variantset v ON vvs.variantset_id = v.variantset_id ");
        sql.append(" WHERE sfl.organism_id = :organismId ");
        sql.append(" AND sfl.srcfeature_id = :srcfeatureId ");
        sql.append(" AND sfl.position BETWEEN :startPos AND :endPos ");

        // build IN clause for variantsetNames
        sql.append(" AND v.name IN (");
        for (int i = 0; i < variantsetNames.size(); i++) {
            if (i > 0) sql.append(", ");
            sql.append(":vsname" + i);
        }
        sql.append(") ");
        sql.append(" ORDER BY sfl.position");

        Query q = em.createNativeQuery(sql.toString());
        q.setParameter("organismId", organismId);
        q.setParameter("srcfeatureId", srcfeatureId);
        q.setParameter("chromosome", chromosome);
        q.setParameter("startPos", startPos);
        q.setParameter("endPos", endPos);
        for (int i = 0; i < variantsetNames.size(); i++) {
            q.setParameter("vsname" + i, variantsetNames.get(i));
        }

        @SuppressWarnings("unchecked")
        List<Object[]> rows = q.getResultList();
        List<SnpRefPosIndex> out = new ArrayList<>();
        if (rows == null) return out;
        for (Object[] r : rows) {
            Long snpFeatureId = r[0] == null ? null : ((Number) r[0]).longValue();
            Integer chr = r[1] == null ? null : ((Number) r[1]).intValue();
            Long position = r[2] == null ? null : ((Number) r[2]).longValue();
            String refcall = r[3] == null ? null : r[3].toString();
            String altcall = r[4] == null ? null : r[4].toString();
            Integer alleleIndex = r[5] == null ? null : ((Number) r[5]).intValue();
            Integer typeId = r[6] == null ? null : ((Number) r[6]).intValue();
            String variantsetName = r[7] == null ? null : r[7].toString();
            SnpRefPosIndex dto = new SnpRefPosIndex(snpFeatureId, chr, position, refcall, altcall, alleleIndex, typeId, variantsetName);
            out.add(dto);
        }

        return out;
    }

    @Override
    public List<SnpRefPosIndex> findSnpRefPosIndexWithProp(Long organismId, Long srcfeatureId, Integer chromosomeOffset,
            Long startPos, Long endPos, List<String> variantsetNames, List<String> propTypeNames) {

        if (variantsetNames == null || variantsetNames.isEmpty() || propTypeNames == null || propTypeNames.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT sfl.snp_feature_id AS snpFeatureId, ");
        sql.append(" sfl.srcfeature_id - :chromosomeOffset AS chromosome, ");
        sql.append(" sfl.position + 1 AS position, ");
        sql.append(" v.variantset_id AS typeId, ");
        sql.append(" v.name AS variantsetName, ");
        sql.append(" sfp.value AS alleleNonsyn ");
        sql.append(" FROM public.snp_featureloc sfl ");
        sql.append(" JOIN public.variant_variantset vvs ON sfl.snp_feature_id = vvs.variant_feature_id ");
        sql.append(" JOIN public.variantset v ON vvs.variantset_id = v.variantset_id ");
        sql.append(" JOIN public.snp_featureloc sfl3k ON sfl3k.position = sfl.position AND sfl3k.srcfeature_id = sfl.srcfeature_id ");
        sql.append(" JOIN public.snp_featureprop sfp ON sfl3k.snp_feature_id = sfp.snp_feature_id ");
        sql.append(" WHERE sfp.type_id IN (SELECT cvterm_id FROM cvterm WHERE name IN (");
        for (int i = 0; i < propTypeNames.size(); i++) {
            if (i > 0) sql.append(", ");
            sql.append(":pt" + i);
        }
        sql.append(")) ");
        sql.append(" AND sfl3k.organism_id = :organismId ");
        sql.append(" AND sfl3k.srcfeature_id = :srcfeatureId ");
        sql.append(" AND sfl3k.position BETWEEN :startPos AND :endPos ");

        // build IN clause for variantsetNames
        sql.append(" AND v.name IN (");
        for (int i = 0; i < variantsetNames.size(); i++) {
            if (i > 0) sql.append(", ");
            sql.append(":vsname" + i);
        }
        sql.append(") ");
        sql.append(" ORDER BY sfl3k.position");

        Query q = em.createNativeQuery(sql.toString());
        q.setParameter("organismId", organismId);
        q.setParameter("srcfeatureId", srcfeatureId);
        q.setParameter("chromosomeOffset", chromosomeOffset);
        q.setParameter("startPos", startPos);
        q.setParameter("endPos", endPos);
        for (int i = 0; i < propTypeNames.size(); i++) {
            q.setParameter("pt" + i, propTypeNames.get(i));
        }
        for (int i = 0; i < variantsetNames.size(); i++) {
            q.setParameter("vsname" + i, variantsetNames.get(i));
        }

        @SuppressWarnings("unchecked")
        List<Object[]> rows = q.getResultList();
        List<SnpRefPosIndex> out = new ArrayList<>();
        if (rows == null) return out;
        for (Object[] r : rows) {
            Long snpFeatureId = r[0] == null ? null : ((Number) r[0]).longValue();
            Integer chr = r[1] == null ? null : ((Number) r[1]).intValue();
            Long position = r[2] == null ? null : ((Number) r[2]).longValue();
            Integer typeId = r[3] == null ? null : ((Number) r[3]).intValue();
            String variantsetName = r[4] == null ? null : r[4].toString();
            String alleleNonsyn = r[5] == null ? null : r[5].toString();
            // map alleleNonsyn into altcall field (or use altcall directly if desired)
            SnpRefPosIndex dto = new SnpRefPosIndex(snpFeatureId, chr, position, null, alleleNonsyn, null, typeId, variantsetName);
            out.add(dto);
        }

        return out;
    }
}