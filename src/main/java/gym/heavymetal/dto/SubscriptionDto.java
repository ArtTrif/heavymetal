package gym.heavymetal.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record SubscriptionDto (
     UUID id,
     String name,
     CountVisits countVisits,
     BigDecimal price,
     Integer actionTime
){}
