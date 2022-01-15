package com.taqneen.hrsystem.service;

import com.taqneen.hrsystem.model.Leave;
import com.taqneen.hrsystem.model.Enum.Status;
import com.taqneen.hrsystem.repository.LeaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveService {
    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public Leave save(Leave leave){
        return leaveRepository.save(leave);
    }

    public Leave findById(Long id)throws Exception{
        return leaveRepository.findById(id).orElseThrow(() -> new Exception("Leave not found  with this - " + id));
    }

    public List<Leave> findAll(){
        return leaveRepository.findAll();
    }

    public void delete(Long id){
        leaveRepository.deleteById(id);
    }


    public List<Leave> findAllByEmployee_IdAndStatus(Long id, Status status){
        return leaveRepository.findAllByEmployee_IdAndStatus(id, status);
    }

    public List<Leave> findAllByStatusAndManagerId(Status status, Long id){
        return leaveRepository.findAllByStatusAndManagerId(status,id);
    }

}
