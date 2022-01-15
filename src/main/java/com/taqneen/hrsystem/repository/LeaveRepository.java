package com.taqneen.hrsystem.repository;

import com.taqneen.hrsystem.model.Leave;
import com.taqneen.hrsystem.model.Enum.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LeaveRepository extends JpaRepository<Leave,Long> {

    List<Leave> findAllByEmployee_IdAndStatus(Long id, Status status);
    List<Leave> findAllByStatusAndManagerId(Status status, Long id);
}
