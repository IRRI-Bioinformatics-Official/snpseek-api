package org.irri.snpseek.service;

import org.irri.snpseek.DTO.BlastRequest;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class BlastService {

    public Map<String, Object> runBlast(BlastRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "BLAST results - Implementation needed");
        result.put("request", request);
        return result;
    }
}
