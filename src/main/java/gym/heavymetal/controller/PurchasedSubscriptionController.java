package gym.heavymetal.controller;

import gym.heavymetal.converter.PurchasedSubscriptionConverter;
import gym.heavymetal.dto.PurchasedSubscriptionDto;
import gym.heavymetal.entity.PurchasedSubscriptionEntity;
import gym.heavymetal.service.PurchasedSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/subscription/purchased")
public class PurchasedSubscriptionController {
    private final PurchasedSubscriptionService purchasedSubscriptionService;
    private final PurchasedSubscriptionConverter purchasedSubscriptionConverter;

    @GetMapping
    public ResponseEntity<List<PurchasedSubscriptionDto>> getAll() {
        return ResponseEntity.ok(purchasedSubscriptionConverter.toDto(purchasedSubscriptionService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchasedSubscriptionDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(purchasedSubscriptionConverter.toDto(purchasedSubscriptionService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<PurchasedSubscriptionDto> create(@RequestBody PurchasedSubscriptionDto purchasedSubscriptionDto) {
        PurchasedSubscriptionEntity purchasedSubscriptionEntity =
                purchasedSubscriptionService.save(purchasedSubscriptionConverter.toEntity(purchasedSubscriptionDto));
        return ResponseEntity.ok(purchasedSubscriptionConverter.toDto(purchasedSubscriptionEntity));
    }

    @PutMapping
    public ResponseEntity<PurchasedSubscriptionDto> update(@RequestBody PurchasedSubscriptionDto purchasedSubscriptionDto) {
        var purchasedSubscriptionEntity = purchasedSubscriptionConverter.toEntity(purchasedSubscriptionDto);
        return ResponseEntity.ok(
                purchasedSubscriptionConverter.toDto(purchasedSubscriptionService.update(purchasedSubscriptionEntity))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable UUID id) {
        return ResponseEntity.ok(purchasedSubscriptionService.deleteById(id));
    }
}
