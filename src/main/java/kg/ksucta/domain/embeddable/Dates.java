package kg.ksucta.domain.embeddable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Created by Aibek Isaev on 03.01.2017.
 */
@Embeddable
@Access(AccessType.FIELD)
public class Dates {

    @Column(name = "changed_date")
    private Date changedDate;

    @Column(name = "created_date")
    private Date createdDate;

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
