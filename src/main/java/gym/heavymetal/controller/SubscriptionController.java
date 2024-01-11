package gym.heavymetal.controller;

import gym.heavymetal.converter.SubscriptionConverter;
import gym.heavymetal.dto.SubscriptionDto;
import gym.heavymetal.entity.SubscriptionEntity;
import gym.heavymetal.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final SubscriptionConverter subscriptionConverter;

    @GetMapping
    public ResponseEntity<List<SubscriptionDto>> getAll() {
        return ResponseEntity.ok(subscriptionConverter.toDto(subscriptionService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(subscriptionConverter.toDto(subscriptionService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<SubscriptionDto> create(@RequestBody SubscriptionDto subscriptionDto) {
        SubscriptionEntity subscriptionEntity = subscriptionService.save(subscriptionConverter.toEntity(subscriptionDto));
        return ResponseEntity.ok(subscriptionConverter.toDto(subscriptionEntity));
    }

    @PutMapping
    public ResponseEntity<SubscriptionDto> update(@RequestBody SubscriptionDto subscriptionDto) {
        SubscriptionEntity subscription = subscriptionService.update(subscriptionConverter.toEntity(subscriptionDto));
        return ResponseEntity.ok(subscriptionConverter.toDto(subscription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(subscriptionService.deleteById(id));
    }
}
