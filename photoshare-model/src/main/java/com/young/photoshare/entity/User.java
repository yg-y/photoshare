package com.young.photoshare.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author young
 * @since 2019-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 手机
     */
    private String userPhone;

    /**
     * 性别【1.男2.女】
     */
    private Boolean userSex;

    private String userAddress;

    private String userAutograph;


}
