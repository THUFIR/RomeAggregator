/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dur.bounceme.net.rome.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thufir
 */
@Entity
@Table(name = "links", catalog = "rome_aggregator", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"link"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Link.findAll", query = "SELECT l FROM Link l"),
    @NamedQuery(name = "Link.findById", query = "SELECT l FROM Link l WHERE l.id = :id"),
    @NamedQuery(name = "Link.findByCreated", query = "SELECT l FROM Link l WHERE l.created = :created"),
    @NamedQuery(name = "Link.findByFeedId", query = "SELECT l FROM Link l WHERE l.feedId = :feedId"),
    @NamedQuery(name = "Link.findByLink", query = "SELECT l FROM Link l WHERE l.link = :link"),
    @NamedQuery(name = "Link.findByStatus", query = "SELECT l FROM Link l WHERE l.status = :status")})
public class Link implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @Column(name = "feed_id", nullable = false)
    private int feedId;
    @Basic(optional = false)
    @Column(nullable = false, length = 767)
    private String link;
    @Basic(optional = false)
    @Column(nullable = false)
    private int status;

    public Link() {
    }

    public Link(Integer id) {
        this.id = id;
    }

    public Link(Integer id, Date created, int feedId, String link, int status) {
        this.id = id;
        this.created = created;
        this.feedId = feedId;
        this.link = link;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof Link)) {
            return false;
        }
        Link other = (Link) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dur.bounceme.net.rome.jpa.Link[ id=" + id + " ]";
    }
    
}
