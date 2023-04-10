package TaeSuH.HMW.domain.auth.domain.Repository;

import TaeSuH.HMW.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
}
