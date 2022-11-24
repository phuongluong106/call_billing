package vn.callbilling.infrastructure.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "CALL_BILLING")
public class CallBillingEntity {
    @Id
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "CALL_COUNT")
    private Integer callCount;
    @Column(name = "BLOCK_COUNT")
    private Integer blockCount;
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;
    @Column(name = "CREATE_BY")
    private String createBy;
    @Column(name = "UPDATE_BY")
    private String updateBy;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCallCount() {
        return callCount;
    }

    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
    }

    public Integer getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(Integer blockCount) {
        this.blockCount = blockCount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

}
