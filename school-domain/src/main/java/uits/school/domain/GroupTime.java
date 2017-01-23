/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uits.school.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Нюта
 */
@Entity
@Table(name = "group_time")
@NamedQueries({
    @NamedQuery(name = "GroupTime.findAll", query = "SELECT g FROM GroupTime g")})
public class GroupTime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_group")
    private int idGroup;
    @Basic(optional = false)
    @Column(name = "day_of_week")
    private String dayOfWeek;
    @Basic(optional = false)
    @Column(name = "start_time")
    private String startTime;

    public GroupTime() {
    }

    public GroupTime(Integer id) {
        this.id = id;
    }

    public GroupTime(Integer id, int idGroup, String dayOfWeek, String startTime) {
        this.id = id;
        this.idGroup = idGroup;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupTime)) {
            return false;
        }
        GroupTime other = (GroupTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uits.school.domain.GroupTime[ id=" + id + " ]";
    }
    
}
