package org.irri.snpseek.service;

import org.irri.snpseek.entity.Passport;
import org.irri.snpseek.repository.PassportRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PassportService {
    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public List<String> getAllPassportFields() {
        return passportRepository.findAll().stream()
                .map(Passport::getPassId)
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, String> getVarietyPassports(Long varietyId) {
        List<Passport> data = passportRepository.findByVarietyId(varietyId);
        Map<String, String> result = new HashMap<>();
        data.forEach(p -> result.put(p.getFieldName(), p.getFieldValue()));
        return result;
    }

    public Map<String, String> getPassportForAllVarieties(String passId) {
        List<Passport> data = passportRepository.findByPassId(passId);
        Map<String, String> result = new HashMap<>();
        data.forEach(p -> result.put(p.getVarietyId().toString(), p.getFieldValue()));
        return result;
    }
}
