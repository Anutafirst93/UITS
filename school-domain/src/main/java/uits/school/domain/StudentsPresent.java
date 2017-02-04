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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author stan
 */
@Entity
@Table(name = "students_present")
@NamedQueries({
    @NamedQuery(name = "StudentsPresent.findAll", query = "SELECT s FROM StudentsPresent s")})
public class StudentsPresent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_student")
    private int idStudent;
    @Basic(optional = false)
    @Column(name = "present_on_lesson")
    private boolean presentOnLesson;
    @JoinColumn(name = "id_journal", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Journal journal;

    public StudentsPresent() {
    }

    public StudentsPresent(Integer id) {
        this.id = id;
    }

    public StudentsPresent(Integer id, int idStudent, boolean presentOnLesson) {
        this.id = id;
        this.idStudent = idStudent;
        this.presentOnLesson = presentOnLesson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public boolean getPresentOnLesson() {
        return presentOnLesson;
    }

    public void setPresentOnLesson(boolean presentOnLesson) {
        this.presentOnLesson = presentOnLesson;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
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
        if (!(object instanceof StudentsPresent)) {
            return false;
        }
        StudentsPresent other = (StudentsPresent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uits.school.domain.StudentsPresent[ id=" + id + " ]";
    }
    
}
