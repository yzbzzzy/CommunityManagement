package cn.dsrank.communitymanagement.vo;

import cn.dsrank.communitymanagement.entity.DsPropertyfee;
import lombok.Data;

import java.util.Date;

@Data
public class UserTableFee extends DsPropertyfee {
    private int status;

    private Date time;

    public UserTableFee(DsPropertyfee fee) {
        this.setId(fee.getId());
        this.setDesc(fee.getDesc());
        this.setPrice(fee.getPrice());
        this.setTime(fee.getTime());
    }

    public UserTableFee() {
    }
}
