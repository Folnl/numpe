package br.com.numpetest.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.numpetest.api.domain.FuelingOrder;

@Repository
public interface FuelingOrderRepository extends JpaRepository<FuelingOrder, Long> {
    List<FuelingOrder> findByVehiclePlateOrderByTimestampDesc(String vehiclePlate);
}
