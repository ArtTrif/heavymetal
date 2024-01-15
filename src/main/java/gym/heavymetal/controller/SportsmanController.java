package gym.heavymetal.controller;

import gym.heavymetal.converter.SportsmanConverter;
import gym.heavymetal.dto.SportsmanDto;
import gym.heavymetal.entity.SportsmanEntity;
import gym.heavymetal.service.SportsmanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/sportsman")
public class SportsmanController {
    private final SportsmanService sportsmanService;
    private final SportsmanConverter sportsmanConverter;

    @GetMapping
    public ResponseEntity<List<SportsmanDto>> getAll() {
        return ResponseEntity.ok(sportsmanConverter.toDto(sportsmanService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SportsmanDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(sportsmanConverter.toDto(sportsmanService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<SportsmanDto> create(@RequestBody SportsmanDto sportsmanDto) {
        SportsmanEntity sportsman = sportsmanService.save(sportsmanConverter.toEntity(sportsmanDto));
        return ResponseEntity.ok(sportsmanConverter.toDto(sportsman));
    }

    @PutMapping
    public ResponseEntity<SportsmanDto> update(@RequestBody SportsmanDto sportsmanDto) {
        SportsmanEntity sportsman = sportsmanService.update(sportsmanConverter.toEntity(sportsmanDto));
        return ResponseEntity.ok(sportsmanConverter.toDto(sportsman));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(sportsmanService.deleteById(id));
    }

}
