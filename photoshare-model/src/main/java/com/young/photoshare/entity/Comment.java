package com.young.photoshare.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author young
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 评论时间
     */
    private LocalDateTime commentTime;

    /**
     * 父级ID
     */
    private String parentId;

    /**
     * 点赞数
     */
    private String like;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改日期
     */
    private LocalDateTime updateTime;


}
