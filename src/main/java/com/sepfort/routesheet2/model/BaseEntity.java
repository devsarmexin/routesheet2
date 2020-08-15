package com.sepfort.routesheet2.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
        // суперкласс, для которого не нужно твблицы
class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreatedDate  //означает что дата установится автоматически
    @Column(name = "created")
    private Date created;

    @LastModifiedDate //означает что дата установится автоматически
    @Column(name = "updated")
    private Date updated;

    @Enumerated(EnumType.STRING)
    // мы можем указать провайдеру JPA преобразовать перечисление в его порядковое или строковое значение.
    @Column(name = "status")
    private Status status;

    BaseEntity() {
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //</editor-fold>
}
