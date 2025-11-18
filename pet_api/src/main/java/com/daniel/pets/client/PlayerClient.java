package com.daniel.pets.client;

import com.daniel.pets.dto.PlayerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "playerClient", url = "http://localhost:8081/player")
public interface PlayerClient {

    @GetMapping("/{id}")
    PlayerDTO buscarPlayer(@PathVariable("id") String id);
}
