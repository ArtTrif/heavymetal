package gym.heavymetal.service;

import gym.heavymetal.entity.SportsmanEntity;
import gym.heavymetal.repository.SportsmanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SportsmanService {
    private final SportsmanRepository sportsmanRepository;

    public SportsmanEntity save(SportsmanEntity sportsman) {
        return sportsmanRepository.save(sportsman);
    }

    public List<SportsmanEntity> getAll() {
        return sportsmanRepository.findAll();
    }

    public SportsmanEntity getById(UUID id) {
        return sportsmanRepository.findById(id).orElse(null);
    }

    public UUID deleteById(UUID id) {
        sportsmanRepository.deleteById(id);
        return id;
    }

    public SportsmanEntity update(SportsmanEntity sportsman) {
        return save(sportsman);
    }
}
