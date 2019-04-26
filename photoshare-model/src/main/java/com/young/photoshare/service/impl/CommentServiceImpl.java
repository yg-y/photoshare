package com.young.photoshare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.young.photoshare.entity.Comment;
import com.young.photoshare.mapper.CommentMapper;
import com.young.photoshare.service.ICommentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author young
 * @since 2019-04-26
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
