package com.rest.springapp.Controller;

import com.rest.springapp.entities.WasteBin;
import com.rest.springapp.Service.WasteBinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/wastebins")
public class WasteBinController {

    private final WasteBinService wasteBinService;

    public WasteBinController(WasteBinService wasteBinService) {
        this.wasteBinService = wasteBinService;
    }

    @PostMapping
    public ResponseEntity<WasteBin> createWasteBin(@RequestBody Map<String, Object> payload) {
        String location = (String) payload.get("location");
        Long userId = ((Number) payload.get("userId")).longValue();

        WasteBin wasteBin = wasteBinService.createWasteBin(location, userId);
        return ResponseEntity.ok(wasteBin);
    }
}
