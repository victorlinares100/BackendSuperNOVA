package BackendSuperNova.Micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import BackendSuperNova.Micro.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}