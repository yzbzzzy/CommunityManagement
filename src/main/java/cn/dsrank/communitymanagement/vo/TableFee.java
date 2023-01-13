package cn.dsrank.communitymanagement.vo;

import cn.dsrank.communitymanagement.entity.DsPropertyfee;
import lombok.Data;

@Data
public class TableFee extends DsPropertyfee {
    private Integer has_over;
    private Integer count;

    public TableFee(DsPropertyfee dsFee) {
        this.setId(dsFee.getId());
        this.setTime(dsFee.getTime());
        this.setDesc(dsFee.getDesc());
        this.setPrice(dsFee.getPrice());
    }

    public TableFee() {
    }
}
