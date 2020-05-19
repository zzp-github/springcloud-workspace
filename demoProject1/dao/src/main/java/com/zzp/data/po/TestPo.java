package com.zzp.data.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzp
 * @since 2020-05-18
 */
@Data
@TableName("test")
public class TestPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

}
