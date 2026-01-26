package practice.backend.smartschool.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.backend.smartschool.dto.response.StatusDTO;
import practice.backend.smartschool.dto.response.VersionDTO;
import practice.backend.smartschool.service.PublicService;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    private final PublicService publicService;

    public PublicController(PublicService publicService) {
        this.publicService = publicService;
    }

    @GetMapping("/health")
    public ResponseEntity<StatusDTO> healthCheck() {
        return ResponseEntity.ok(publicService.healthCheck());
    }

    @GetMapping("/version")
    public ResponseEntity<VersionDTO> getVersion() {
        return ResponseEntity.ok(publicService.getVersion());
    }
}
