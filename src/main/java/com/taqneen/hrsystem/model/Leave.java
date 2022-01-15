package com.taqneen.hrsystem.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.taqneen.hrsystem.model.Enum.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "leave")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotNull
    @Column(name = "Leave_from")
    private LocalDateTime from;

    @NotNull
    @Column(name = "leave_to")
    private LocalDateTime to;

    @NotNull
    @Column(name = "leave_status")
    private Status status;

    @JsonIgnoreProperties("department")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    
    @JsonIgnoreProperties("department")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Manager manager;
    public Leave() {}
    public Leave(LocalDateTime from, LocalDateTime to, Status status, Employee employee, Manager manager) {
        this.from = from;
        this.to = to;
        this.status = status;
        this.employee = employee;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
