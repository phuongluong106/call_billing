package vn.callbilling.infrastructure.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CALLS"  )
public class CallEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "CALL_DURATION")
    private Integer callDuration;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Integer callDuration) {
        this.callDuration = callDuration;
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

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }
}
