package org.irri.snpseek.repository;

import java.util.List;

import org.irri.snpseek.DTO.SnpRefPosIndex;

public interface SnpFeatureRepositoryCustom {
    List<SnpRefPosIndex> findSnpRefPosIndex(Long organismId, Long srcfeatureId, Integer chromosome, Long startPos, Long endPos, List<String> variantsetNames);
    List<SnpRefPosIndex> findSnpRefPosIndexWithProp(Long organismId, Long srcfeatureId, Integer chromosomeOffset, Long startPos, Long endPos, List<String> variantsetNames, List<String> propTypeNames);
}