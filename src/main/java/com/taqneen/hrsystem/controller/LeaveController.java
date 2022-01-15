package com.taqneen.hrsystem.controller;

import com.taqneen.hrsystem.model.Employee;
import com.taqneen.hrsystem.model.Leave;
import com.taqneen.hrsystem.model.Enum.Status;
import com.taqneen.hrsystem.service.EmployeeService;
import com.taqneen.hrsystem.service.LeaveService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LeaveController {

    private final LeaveService leaveService;
    private final EmployeeService employeeService;


    public LeaveController(LeaveService leaveService, EmployeeService employeeService) {
        this.leaveService = leaveService;
        this.employeeService = employeeService;
    }

    @PostMapping("/leaves/{employeeId}/{timeFrom}/{timeTo}")
    public ResponseEntity<Leave> create(@PathVariable Long employeeId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeFrom, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeTo) throws Exception {
        Employee employee = employeeService.findById(employeeId);
        Leave leave = new Leave(timeFrom,timeTo,Status.New,employee,employee.getManager());
        leaveService.save(leave);
        return ResponseEntity.ok(leave);
    }

    @GetMapping("/Leaves/{employeeId}/{status}")
    public List<Leave> findAllLeavesByEmployeeIdAndStatus (@PathVariable Long employeeId,@PathVariable Status status) {
        List<Leave> leaves = leaveService.findAllByEmployee_IdAndStatus(employeeId,status);
      return leaves;
    }

    @GetMapping("/leaves/applies/{status}/{managerId}")
    public List<Leave> findAllLeavesByManagerIdAndStatus (@PathVariable Status status,@PathVariable Long managerId) {
        List<Leave> leaves = leaveService.findAllByStatusAndManagerId(status,managerId);
        return leaves;
    }

    @PutMapping("/leaves/approve/{leaveId}")
    public ResponseEntity<Leave> approve(@PathVariable Long leaveId) throws Exception {
        Leave leave = leaveService.findById(leaveId);
        leave.setStatus(Status.APPROVED);
        leaveService.save(leave);
        return ResponseEntity.ok(leave);
    }
    @PutMapping("/leaves/reject/{leaveId}")
    public ResponseEntity<Leave> reject(@PathVariable Long leaveId) throws Exception {
        Leave leave = leaveService.findById(leaveId);
        leave.setStatus(Status.REJECTED);
        leaveService.save(leave);
        return ResponseEntity.ok(leave);
    }
}
