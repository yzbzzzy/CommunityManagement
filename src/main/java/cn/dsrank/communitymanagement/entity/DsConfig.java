package cn.dsrank.communitymanagement.entity;

import java.io.Serializable;

/**
 * (DsConfig)实体类
 *
 * @author makejava
 * @since 2023-01-29 15:35:41
 */
public class DsConfig implements Serializable {
    private static final long serialVersionUID = -85865650443260197L;
    
    private Integer id;
    
    private String key;
    
    private String value;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

