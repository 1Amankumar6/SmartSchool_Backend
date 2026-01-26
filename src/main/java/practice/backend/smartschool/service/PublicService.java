package practice.backend.smartschool.service;

import org.springframework.stereotype.Service;
import practice.backend.smartschool.dto.response.StatusDTO;
import practice.backend.smartschool.dto.response.VersionDTO;

@Service
public class PublicService {

    public StatusDTO healthCheck() {
        return new StatusDTO("The API is running.");
    }

    public VersionDTO getVersion() {
        return new VersionDTO("1.0.0");
    }
}
