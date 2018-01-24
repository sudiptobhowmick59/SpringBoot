package com.aws.poc.sqlserver.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author sussain
 * @version $Revision: 1$
 */
@MappedSuperclass
public class BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "CREATE_ID")
    private String createId;

    @Column(name = "CREATE_TMSTMP")
    private Timestamp createTS;

    @Column(name = "UPDT_ID")
    private String updateId;

    @Column(name = "UPDT_TMSTMP")
    private Timestamp updateTS;

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("CREATE_ID: [").append(createId).append("]");
        sb.append("\n");
        sb.append("CREATE_TMSTMP: [").append(createTS).append("]");
        sb.append("\n");
        sb.append("UPDT_ID: [").append(updateId).append("]");
        sb.append("\n");
        sb.append("UPDT_TMSTMP: [").append(updateTS).append("]");
        sb.append("\n");

        return sb.toString();
    }

    /**
     * @return the createId
     */
    public String getCreateId()
    {
        return createId;
    }

    /**
     * @param createId
     *            the createId to set
     */
    public void setCreateId(String createId)
    {
        this.createId = createId;
    }

    /**
     * @return the createTS
     */
    public Timestamp getCreateTS()
    {
        return createTS;
    }

    /**
     * @param createTS
     *            the createTS to set
     */
    public void setCreateTS(Timestamp createTS)
    {
        this.createTS = createTS;
    }

    /**
     * @return the updateId
     */
    public String getUpdateId()
    {
        return updateId;
    }

    /**
     * @param updateId
     *            the updateId to set
     */
    public void setUpdateId(String updateId)
    {
        this.updateId = updateId;
    }

    /**
     * @return the updateTS
     */
    public Timestamp getUpdateTS()
    {
        return updateTS;
    }

    /**
     * @param updateTS
     *            the updateTS to set
     */
    public void setUpdateTS(Timestamp updateTS)
    {
        this.updateTS = updateTS;
    }
}
