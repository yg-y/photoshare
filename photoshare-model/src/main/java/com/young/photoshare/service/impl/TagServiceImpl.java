package com.young.photoshare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.young.photoshare.entity.Tag;
import com.young.photoshare.mapper.TagMapper;
import com.young.photoshare.service.ITagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
