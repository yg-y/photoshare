/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50726
Source Host           : 120.79.30.86:3306
Source Database       : photoshare-blog

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-04-29 22:16:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `comment_id` varchar(32) DEFAULT NULL COMMENT '评论ID',
  `tag_id` varchar(32) DEFAULT NULL COMMENT '标签ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `article_title` varchar(24) NOT NULL COMMENT '文章标题',
  `article_content` text NOT NULL COMMENT '文章内容',
  `article_like` varchar(10) DEFAULT NULL COMMENT '点赞数',
  `article_cover` varchar(255) DEFAULT NULL COMMENT '封面图',
  `article_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布日期',
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', null, null, '627756022', '自然风光摄影教学自然风光摄影教学自然风光摄影教学', '首先，这不是一篇深奥的教学文章——它几乎不会涉及非常具体的技术的层面。\r\n\r\n \r\n\r\n很多人在学习摄影的过程中，会着重将精力放在抠细节上，但往往过分地在技术上进行强化会令人进入循规蹈矩的怪圈。当然这并不是说基本功力不重要，只是想提醒大家意识到应当去question一下：当你观察眼前的景象时，难道首先注意到的是那些细节吗？恐怕有的时候并非如此。一个场景之所以吸引你驻足拍摄，一定是那里有宏观的兴趣点或者引人注目的动态，当你首先注意到、考虑到的是这些时，你所拍摄的照片中也许就会有一个明确的主题和更多的内容。\r\n\r\n \r\n\r\n这篇教程是我从美国西部行摄归来时所作，携带了佳能EOS 5D Mark Ⅳ机身、EF 24-70mm F2.8L II USM镜头、EF 70-200mm F4L IS USM镜头、EF 16-35mm F4L USM镜头，总的来说整体器材能够达到我想要的画质水平，同时广角和长焦两支镜头都选用了F4级别，非常轻量化，便于携带。\r\n\r\n \r\n\r\n具体的摄影教学，通过以下举例来说。\r\n\r\n \r\n\r\n拓宽特写的定义\r\n\r\n \r\n\r\n\r\n\r\n \r\n\r\n多数影友首先想到的问题往往是：我应该配置一支长焦镜头，或者至少是中长焦段的镜头来确保可以在远距离拍到它们。\r\n\r\n \r\n\r\n从技术上讲，这固然无错。但当你下意识地先将目标直接与设备基础进行关联时，说明你首先已经忽略了主题和内容的优先级。上图是于圣莫妮卡使用EF 24-70mm F2.8L Ⅱ USM镜头拍摄，这支镜头绝算不上是长焦镜头，而这张照片也绝算不上是标准的动物特写，但图片本身是否因为没有迎合传统观念中的这些硬指标而缺乏内容呢？显然不，海鸥的位置在标准反向三点式构图的位置略微有所偏上，大面积的蓝天留白为海鸥的飞行姿态提供了空间上的规模感和自由感，而海鸥摆头的角度和展翅姿态均交代得足够明确，亦不失特写感。\r\n\r\n \r\n\r\n在拍摄动物时，其行动（栖息）环境、动物本身与环境的互动形式，将这些内容表现在照片中，有时会比一张精致而清晰的特写要更值得阅读。\r\n\r\n \r\n\r\n拍摄为人熟知的景观的另一面\r\n\r\n \r\n\r\n\r\n\r\n \r\n\r\n去到一些人气极旺、知名度极高的景点时，我们往往需要注意一点，那就是应该尽量避免过多地拍摄那种“在搜索引擎上输入景点名称后会被找到的景观肖像”——根本不需要你再来增添这种随处可见、已经被印在每个普通人脑中的照片。\r\n\r\n \r\n\r\n以大峡谷为例，一个广阔的视角固然可以展现景观规模，但要命的是大多数人都会这么干。如何能表达自己的观点呢？你要花一些时间寻找机位并找到一个兴趣点。比如，人人都愿意无限大地展现大峡谷的宽广，而你是否会注意到某个细微的局部呢？一个大峡谷很小局部的照片，也可以将其地质结构展现出来，甚至展现得更加细致。', '12', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 22:05:48', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('10', null, null, '627756022', '虫虫是我的小可爱', '一、单点登录系统\r\n1.     使用xxl-sso(开源中国)单点登录框架统一公司管理系统的登录入口，由用户发起登录请求去到认证中心校验登录权限后跳转至登录系统。\r\n2.     在子系统通过配置Spring拦截器拦截用户请求，进一步校验是否有权限登录此系统，否则注销登录驳回至登录界面。\r\n3.     在登录页面接入企业微信扫码登录\r\n\r\n二、游戏社区系统（SpringBoot、MyBatisPlus、Redis、Vue、H5、Element-UI）\r\n系统介绍：在积累了一定的用户量之后，通过 游戏内的社区功能连接用户与用户之间的交流 与探讨，提升用户在游戏内的归属感从而留住 用户。目前已上线至手Q、微信、安卓及IOS，累计进入用户量达100W+ \r\n工作内容：\r\n负责模块为用户成长体系，包含成就体系、称号体系、金币体系、评论、关卡点赞以及后台管理。\r\n1.	 为游戏客户端提供接口。使用SVN进行版本控制；\r\n2.	 使用Redis进行数据缓存和作为数据中间件，通过定时任务(Spring)定时将数据写入MySQL数据库； \r\n3.	 使用Flex弹性布局开发客户端内H5评论页面；\r\n4.	 使用v-charts进行数据统计图表展示；\r\n5.	 使用zixing 后端生成base64返回前端进行二维码展示；\r\n6.	 优化单台服务器上万用户同时在线访问的速度。\r\n\r\n三、知识库系统（SpringBoot、MyBatisPlus、Vue全家桶） \r\n系统介绍：为了方便公司各部门间工作的协调和快速上手工作，开发了一个公司内部知识体系的知识库系统，通过有经验的人编写相关教程文档，以及平时的技术积累，供以后公司内部人员参考学习和使用。\r\n工作内容：使用vue-cli搭建前端单页面应用、内容编辑整合Markdown编辑器、使用Axios进行后台数据交互\r\n\r\n四、游戏资源管理系统（SpringBoot、MyBatisPlus、Vue） \r\n独立完成公司游戏资源管理系统后端及前端，实现文件储存判断上传至本地服务还是阿里云OSS对象储存', '520', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 22:05:51', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('11', null, null, '627756022', '人像三要素', '一、单点登录系统\r\n1.     使用xxl-sso(开源中国)单点登录框架统一公司管理系统的登录入口，由用户发起登录请求去到认证中心校验登录权限后跳转至登录系统。\r\n2.     在子系统通过配置Spring拦截器拦截用户请求，进一步校验是否有权限登录此系统，否则注销登录驳回至登录界面。\r\n3.     在登录页面接入企业微信扫码登录\r\n\r\n二、游戏社区系统（SpringBoot、MyBatisPlus、Redis、Vue、H5、Element-UI）\r\n系统介绍：在积累了一定的用户量之后，通过 游戏内的社区功能连接用户与用户之间的交流 与探讨，提升用户在游戏内的归属感从而留住 用户。目前已上线至手Q、微信、安卓及IOS，累计进入用户量达100W+ \r\n工作内容：\r\n负责模块为用户成长体系，包含成就体系、称号体系、金币体系、评论、关卡点赞以及后台管理。\r\n1.	 为游戏客户端提供接口。使用SVN进行版本控制；\r\n2.	 使用Redis进行数据缓存和作为数据中间件，通过定时任务(Spring)定时将数据写入MySQL数据库； \r\n3.	 使用Flex弹性布局开发客户端内H5评论页面；\r\n4.	 使用v-charts进行数据统计图表展示；\r\n5.	 使用zixing 后端生成base64返回前端进行二维码展示；\r\n6.	 优化单台服务器上万用户同时在线访问的速度。\r\n\r\n三、知识库系统（SpringBoot、MyBatisPlus、Vue全家桶） \r\n系统介绍：为了方便公司各部门间工作的协调和快速上手工作，开发了一个公司内部知识体系的知识库系统，通过有经验的人编写相关教程文档，以及平时的技术积累，供以后公司内部人员参考学习和使用。\r\n工作内容：使用vue-cli搭建前端单页面应用、内容编辑整合Markdown编辑器、使用Axios进行后台数据交互\r\n\r\n四、游戏资源管理系统（SpringBoot、MyBatisPlus、Vue） \r\n独立完成公司游戏资源管理系统后端及前端，实现文件储存判断上传至本地服务还是阿里云OSS对象储存', null, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 17:43:47', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('2', null, null, '627756022', '环境人像摄影教学', '很多模特都希望摄影师给自己拍的美美的，其实只要多多利用外在环境的光源或引导模特的肢体动作，并且在适当的时机按下快门，想要拍出一张唯美浪漫到爆表的作品，绝对不是一件难事。下面就告诉大家人像摄影要掌握哪些要领，才可以拍出好照片哦！\r\n\r\n夕阳中的剪影\r\n\r\n人像摄影教程 教你如何拍出唯美气氛 \r\n夕阳下的深情剪影（F8,1/1000s,100,焦距22mm）\r\n\r\n    常见的逆光拍摄效果有两种：一是剪影效果，二是轮廓光效果。剪影效果是将拍摄主体置于明亮的背景中，曝光时，以高光部位作为测光依据，以造成背景清晰且主体因曝光严重不足而形成黑影轮廓的一种艺术照片。透过对天空的点测光完成剪影的曝光，大光比、高反差强化了逆光光效，达到了勾勒被摄主体清晰廓型和强化主体的目的，具有奇妙的艺术造型效果。\r\n\r\n利用逆光下美丽的眩光\r\n\r\n人像摄影教程 教你如何拍出唯美气氛 \r\n顶着强烈的日光拍摄写真，将眩光收入画面（F9,1/40s,ISO100,焦距18mm）\r\n\r\n    在逆光下，人物的发丝会更明显，身体的边缘线也会呈现出来，人物的呈现也更为鲜明。此时，可以尝试更加大胆创新的拍法，那就是将太阳收入了画面，这样不但画面中有一个神秘的高光点，而且还可能出现一串魅力四射的眩光，使画面产生特殊气氛。\r\n\r\n高调影像表现清新气质\r\n\r\n人像摄影教程 教你如何拍出唯美气氛 \r\n少女的秀发被风吹起，神采奕奕（F2.8,1/200s,ISO100,焦距50mm）\r\n\r\n    什么是高调摄影？这实际是从黑白摄影中衍生的一个概念：以画幅中灰白比例的比重来区分照片的色调。黑、深色多的是低调片子，白、浅色多的是高调片子。摄影的高光调处理手法是选择明亮或白色的背景，而主体人物多为明亮或白色，刻意使主题明亮部分淹没在背景中，作品是以白到浅灰的色调层次占了画面的绝大部分，加上少量的深黑色调。\r\n\r\n低调影像充满意境\r\n\r\n人像摄影教程 教你如何拍出唯美气氛 \r\n模特儿轻靠在火车车厢旁展现慵懒姿态（F8,1/120s,ISO100,焦距28mm）\r\n\r\n    低调画面是以大面积的深色调与小面积的浅色调相对比形成的画面色调，是运用暗背景衬托暗主体的一种艺术表现形式。在低光调画面中，深灰至黑的色调层次占了画面的绝大部分，少量的白色往往是人物的肤色和服饰，在低调中格外明显与亮眼。关键是寻找颜色深沉或者光线较暗的背景，利用光线的反差也可以有效地营造低光调照片。在区域光环境中，将人物置于被光照亮的位置，利用相机的宽容度来加大人物和暗背景的反差，同样可以实现迷人的低调效果。\r\n\r\n长焦段突显主体特征\r\n\r\n人像摄影教程 教你如何拍出唯美气氛 \r\n麦田中神采自然的女孩（F2.8,1/640s,ISO100,焦距125mm）\r\n\r\n    长焦段镜头压缩了主体与背景、前景的位置关系，拉近了被摄主体与观者的距离。同时，长焦拍摄时的景深浅，会使前景和背景模糊，甚至完全虚化。因此，如果希望利用主体与前景、背景的虚实对比关系对主体进行特别的强调，往往需要透过长焦段镜头来拍摄。\r\n\r\n定格跳跃的姿态\r\n\r\n人像摄影教程 教你如何拍出唯美气氛 \r\n在海边飞身跃起的女孩被定格下生动瞬间（F3.5,1/5000s,ISO100,焦距22mm）\r\n\r\n    抓拍指在被摄主体不知晓的情况下，由拍摄者直接摄取人物活动的生动瞬间。摆抓结合即整个摄影过程中，被摄物体知道有人在为自己拍照，但并不告知确切的拍摄时间，被摄物体的心情放松，动作便会更显自然，拍摄者选择最佳角度和光线后，在适当时间按下快门。\r\n\r\n时尚的Cosplay造型\r\n\r\n人像摄影教程 教你如何拍出唯美气氛 \r\n时尚的Cosplay装扮与冷冰冰的工厂相互映衬（F3.5,1/200s,ISO100,焦距25mm）\r\n\r\n    近年来，Cosplay成为一种新时尚的潮流。之所以发展迅速，极大的程度上是因为来自日本漫画的影响。拍摄Cosplay要尽量使拍摄的效果符合原先模仿的对象。在拍摄的时候，为了达到所需画面效果，可从不同角度拍摄。在拍摄的过程中要善于模仿游戏原型人物的动作风格，不要过多受构图的限制。\r\n\r\n彩色与黑白的对话\r\n\r\n人像摄影教程 教你如何拍出唯美气氛 \r\n钢铁框架里孤独的女孩身影（F7.1,1/40s,ISO100,焦距18mm）\r\n\r\n    生活中经常看到一幅照片里同时存在黑白和彩色的元素，如果照片中黑白的元素作为背景存在，那么黑白中的彩色元素就会显得格外显眼，这种利用黑白背景衬托彩色元素的拍摄手法称为\"抽色\"。第一种方法是从摄影技法出发，选择黑、白、灰三色的背景，突显身着彩色服饰的模特儿；第二种方法是使用后制处理软体，将画面中人物以外的背景处理成黑白色调。相较之下，第一种方法的运用效果更加自然。', null, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 17:43:41', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('3', null, null, '627756022', 'JAVA开发', '一、单点登录系统\r\n1.     使用xxl-sso(开源中国)单点登录框架统一公司管理系统的登录入口，由用户发起登录请求去到认证中心校验登录权限后跳转至登录系统。\r\n2.     在子系统通过配置Spring拦截器拦截用户请求，进一步校验是否有权限登录此系统，否则注销登录驳回至登录界面。\r\n3.     在登录页面接入企业微信扫码登录\r\n\r\n二、游戏社区系统（SpringBoot、MyBatisPlus、Redis、Vue、H5、Element-UI）\r\n系统介绍：在积累了一定的用户量之后，通过 游戏内的社区功能连接用户与用户之间的交流 与探讨，提升用户在游戏内的归属感从而留住 用户。目前已上线至手Q、微信、安卓及IOS，累计进入用户量达100W+ \r\n工作内容：\r\n负责模块为用户成长体系，包含成就体系、称号体系、金币体系、评论、关卡点赞以及后台管理。\r\n1.	 为游戏客户端提供接口。使用SVN进行版本控制；\r\n2.	 使用Redis进行数据缓存和作为数据中间件，通过定时任务(Spring)定时将数据写入MySQL数据库； \r\n3.	 使用Flex弹性布局开发客户端内H5评论页面；\r\n4.	 使用v-charts进行数据统计图表展示；\r\n5.	 使用zixing 后端生成base64返回前端进行二维码展示；\r\n6.	 优化单台服务器上万用户同时在线访问的速度。\r\n\r\n三、知识库系统（SpringBoot、MyBatisPlus、Vue全家桶） \r\n系统介绍：为了方便公司各部门间工作的协调和快速上手工作，开发了一个公司内部知识体系的知识库系统，通过有经验的人编写相关教程文档，以及平时的技术积累，供以后公司内部人员参考学习和使用。\r\n工作内容：使用vue-cli搭建前端单页面应用、内容编辑整合Markdown编辑器、使用Axios进行后台数据交互\r\n\r\n四、游戏资源管理系统（SpringBoot、MyBatisPlus、Vue） \r\n独立完成公司游戏资源管理系统后端及前端，实现文件储存判断上传至本地服务还是阿里云OSS对象储存', null, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 17:43:47', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('4', null, null, '627756022', '正面刚了一天剪辑\r\nVlog终于快剪完了', '一、单点登录系统\r\n1.     使用xxl-sso(开源中国)单点登录框架统一公司管理系统的登录入口，由用户发起登录请求去到认证中心校验登录权限后跳转至登录系统。\r\n2.     在子系统通过配置Spring拦截器拦截用户请求，进一步校验是否有权限登录此系统，否则注销登录驳回至登录界面。\r\n3.     在登录页面接入企业微信扫码登录\r\n\r\n二、游戏社区系统（SpringBoot、MyBatisPlus、Redis、Vue、H5、Element-UI）\r\n系统介绍：在积累了一定的用户量之后，通过 游戏内的社区功能连接用户与用户之间的交流 与探讨，提升用户在游戏内的归属感从而留住 用户。目前已上线至手Q、微信、安卓及IOS，累计进入用户量达100W+ \r\n工作内容：\r\n负责模块为用户成长体系，包含成就体系、称号体系、金币体系、评论、关卡点赞以及后台管理。\r\n1.	 为游戏客户端提供接口。使用SVN进行版本控制；\r\n2.	 使用Redis进行数据缓存和作为数据中间件，通过定时任务(Spring)定时将数据写入MySQL数据库； \r\n3.	 使用Flex弹性布局开发客户端内H5评论页面；\r\n4.	 使用v-charts进行数据统计图表展示；\r\n5.	 使用zixing 后端生成base64返回前端进行二维码展示；\r\n6.	 优化单台服务器上万用户同时在线访问的速度。\r\n\r\n三、知识库系统（SpringBoot、MyBatisPlus、Vue全家桶） \r\n系统介绍：为了方便公司各部门间工作的协调和快速上手工作，开发了一个公司内部知识体系的知识库系统，通过有经验的人编写相关教程文档，以及平时的技术积累，供以后公司内部人员参考学习和使用。\r\n工作内容：使用vue-cli搭建前端单页面应用、内容编辑整合Markdown编辑器、使用Axios进行后台数据交互\r\n\r\n四、游戏资源管理系统（SpringBoot、MyBatisPlus、Vue） \r\n独立完成公司游戏资源管理系统后端及前端，实现文件储存判断上传至本地服务还是阿里云OSS对象储存', null, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 20:18:34', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('5', null, null, '627756022', '正面刚了一天剪辑\r\nVlog终于快剪完了', '一、单点登录系统\r\n1.     使用xxl-sso(开源中国)单点登录框架统一公司管理系统的登录入口，由用户发起登录请求去到认证中心校验登录权限后跳转至登录系统。\r\n2.     在子系统通过配置Spring拦截器拦截用户请求，进一步校验是否有权限登录此系统，否则注销登录驳回至登录界面。\r\n3.     在登录页面接入企业微信扫码登录\r\n\r\n二、游戏社区系统（SpringBoot、MyBatisPlus、Redis、Vue、H5、Element-UI）\r\n系统介绍：在积累了一定的用户量之后，通过 游戏内的社区功能连接用户与用户之间的交流 与探讨，提升用户在游戏内的归属感从而留住 用户。目前已上线至手Q、微信、安卓及IOS，累计进入用户量达100W+ \r\n工作内容：\r\n负责模块为用户成长体系，包含成就体系、称号体系、金币体系、评论、关卡点赞以及后台管理。\r\n1.	 为游戏客户端提供接口。使用SVN进行版本控制；\r\n2.	 使用Redis进行数据缓存和作为数据中间件，通过定时任务(Spring)定时将数据写入MySQL数据库； \r\n3.	 使用Flex弹性布局开发客户端内H5评论页面；\r\n4.	 使用v-charts进行数据统计图表展示；\r\n5.	 使用zixing 后端生成base64返回前端进行二维码展示；\r\n6.	 优化单台服务器上万用户同时在线访问的速度。\r\n\r\n三、知识库系统（SpringBoot、MyBatisPlus、Vue全家桶） \r\n系统介绍：为了方便公司各部门间工作的协调和快速上手工作，开发了一个公司内部知识体系的知识库系统，通过有经验的人编写相关教程文档，以及平时的技术积累，供以后公司内部人员参考学习和使用。\r\n工作内容：使用vue-cli搭建前端单页面应用、内容编辑整合Markdown编辑器、使用Axios进行后台数据交互\r\n\r\n四、游戏资源管理系统（SpringBoot、MyBatisPlus、Vue） \r\n独立完成公司游戏资源管理系统后端及前端，实现文件储存判断上传至本地服务还是阿里云OSS对象储存', null, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 20:18:36', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('6', null, null, '627756022', '人像三要正面刚了一天剪辑\r\nVlog终于快剪完了', '一、单点登录系统\r\n1.     使用xxl-sso(开源中国)单点登录框架统一公司管理系统的登录入口，由用户发起登录请求去到认证中心校验登录权限后跳转至登录系统。\r\n2.     在子系统通过配置Spring拦截器拦截用户请求，进一步校验是否有权限登录此系统，否则注销登录驳回至登录界面。\r\n3.     在登录页面接入企业微信扫码登录\r\n\r\n二、游戏社区系统（SpringBoot、MyBatisPlus、Redis、Vue、H5、Element-UI）\r\n系统介绍：在积累了一定的用户量之后，通过 游戏内的社区功能连接用户与用户之间的交流 与探讨，提升用户在游戏内的归属感从而留住 用户。目前已上线至手Q、微信、安卓及IOS，累计进入用户量达100W+ \r\n工作内容：\r\n负责模块为用户成长体系，包含成就体系、称号体系、金币体系、评论、关卡点赞以及后台管理。\r\n1.	 为游戏客户端提供接口。使用SVN进行版本控制；\r\n2.	 使用Redis进行数据缓存和作为数据中间件，通过定时任务(Spring)定时将数据写入MySQL数据库； \r\n3.	 使用Flex弹性布局开发客户端内H5评论页面；\r\n4.	 使用v-charts进行数据统计图表展示；\r\n5.	 使用zixing 后端生成base64返回前端进行二维码展示；\r\n6.	 优化单台服务器上万用户同时在线访问的速度。\r\n\r\n三、知识库系统（SpringBoot、MyBatisPlus、Vue全家桶） \r\n系统介绍：为了方便公司各部门间工作的协调和快速上手工作，开发了一个公司内部知识体系的知识库系统，通过有经验的人编写相关教程文档，以及平时的技术积累，供以后公司内部人员参考学习和使用。\r\n工作内容：使用vue-cli搭建前端单页面应用、内容编辑整合Markdown编辑器、使用Axios进行后台数据交互\r\n\r\n四、游戏资源管理系统（SpringBoot、MyBatisPlus、Vue） \r\n独立完成公司游戏资源管理系统后端及前端，实现文件储存判断上传至本地服务还是阿里云OSS对象储存', null, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 20:18:37', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('7', null, null, '627756022', '人像三要正面刚了一天剪辑\r\nVlog终于快剪完了', '一、单点登录系统\r\n1.     使用xxl-sso(开源中国)单点登录框架统一公司管理系统的登录入口，由用户发起登录请求去到认证中心校验登录权限后跳转至登录系统。\r\n2.     在子系统通过配置Spring拦截器拦截用户请求，进一步校验是否有权限登录此系统，否则注销登录驳回至登录界面。\r\n3.     在登录页面接入企业微信扫码登录\r\n\r\n二、游戏社区系统（SpringBoot、MyBatisPlus、Redis、Vue、H5、Element-UI）\r\n系统介绍：在积累了一定的用户量之后，通过 游戏内的社区功能连接用户与用户之间的交流 与探讨，提升用户在游戏内的归属感从而留住 用户。目前已上线至手Q、微信、安卓及IOS，累计进入用户量达100W+ \r\n工作内容：\r\n负责模块为用户成长体系，包含成就体系、称号体系、金币体系、评论、关卡点赞以及后台管理。\r\n1.	 为游戏客户端提供接口。使用SVN进行版本控制；\r\n2.	 使用Redis进行数据缓存和作为数据中间件，通过定时任务(Spring)定时将数据写入MySQL数据库； \r\n3.	 使用Flex弹性布局开发客户端内H5评论页面；\r\n4.	 使用v-charts进行数据统计图表展示；\r\n5.	 使用zixing 后端生成base64返回前端进行二维码展示；\r\n6.	 优化单台服务器上万用户同时在线访问的速度。\r\n\r\n三、知识库系统（SpringBoot、MyBatisPlus、Vue全家桶） \r\n系统介绍：为了方便公司各部门间工作的协调和快速上手工作，开发了一个公司内部知识体系的知识库系统，通过有经验的人编写相关教程文档，以及平时的技术积累，供以后公司内部人员参考学习和使用。\r\n工作内容：使用vue-cli搭建前端单页面应用、内容编辑整合Markdown编辑器、使用Axios进行后台数据交互\r\n\r\n四、游戏资源管理系统（SpringBoot、MyBatisPlus、Vue） \r\n独立完成公司游戏资源管理系统后端及前端，实现文件储存判断上传至本地服务还是阿里云OSS对象储存', null, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 20:18:39', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('8', null, null, '627756022', '人像三要素', '一、单点登录系统\r\n1.     使用xxl-sso(开源中国)单点登录框架统一公司管理系统的登录入口，由用户发起登录请求去到认证中心校验登录权限后跳转至登录系统。\r\n2.     在子系统通过配置Spring拦截器拦截用户请求，进一步校验是否有权限登录此系统，否则注销登录驳回至登录界面。\r\n3.     在登录页面接入企业微信扫码登录\r\n\r\n二、游戏社区系统（SpringBoot、MyBatisPlus、Redis、Vue、H5、Element-UI）\r\n系统介绍：在积累了一定的用户量之后，通过 游戏内的社区功能连接用户与用户之间的交流 与探讨，提升用户在游戏内的归属感从而留住 用户。目前已上线至手Q、微信、安卓及IOS，累计进入用户量达100W+ \r\n工作内容：\r\n负责模块为用户成长体系，包含成就体系、称号体系、金币体系、评论、关卡点赞以及后台管理。\r\n1.	 为游戏客户端提供接口。使用SVN进行版本控制；\r\n2.	 使用Redis进行数据缓存和作为数据中间件，通过定时任务(Spring)定时将数据写入MySQL数据库； \r\n3.	 使用Flex弹性布局开发客户端内H5评论页面；\r\n4.	 使用v-charts进行数据统计图表展示；\r\n5.	 使用zixing 后端生成base64返回前端进行二维码展示；\r\n6.	 优化单台服务器上万用户同时在线访问的速度。\r\n\r\n三、知识库系统（SpringBoot、MyBatisPlus、Vue全家桶） \r\n系统介绍：为了方便公司各部门间工作的协调和快速上手工作，开发了一个公司内部知识体系的知识库系统，通过有经验的人编写相关教程文档，以及平时的技术积累，供以后公司内部人员参考学习和使用。\r\n工作内容：使用vue-cli搭建前端单页面应用、内容编辑整合Markdown编辑器、使用Axios进行后台数据交互\r\n\r\n四、游戏资源管理系统（SpringBoot、MyBatisPlus、Vue） \r\n独立完成公司游戏资源管理系统后端及前端，实现文件储存判断上传至本地服务还是阿里云OSS对象储存', null, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 17:43:47', '2019-04-29 13:56:49', '2019-04-29 13:56:49');
INSERT INTO `article` VALUES ('9', null, null, '627756022', '人像三要素', '一、单点登录系统\r\n1.     使用xxl-sso(开源中国)单点登录框架统一公司管理系统的登录入口，由用户发起登录请求去到认证中心校验登录权限后跳转至登录系统。\r\n2.     在子系统通过配置Spring拦截器拦截用户请求，进一步校验是否有权限登录此系统，否则注销登录驳回至登录界面。\r\n3.     在登录页面接入企业微信扫码登录\r\n\r\n二、游戏社区系统（SpringBoot、MyBatisPlus、Redis、Vue、H5、Element-UI）\r\n系统介绍：在积累了一定的用户量之后，通过 游戏内的社区功能连接用户与用户之间的交流 与探讨，提升用户在游戏内的归属感从而留住 用户。目前已上线至手Q、微信、安卓及IOS，累计进入用户量达100W+ \r\n工作内容：\r\n负责模块为用户成长体系，包含成就体系、称号体系、金币体系、评论、关卡点赞以及后台管理。\r\n1.	 为游戏客户端提供接口。使用SVN进行版本控制；\r\n2.	 使用Redis进行数据缓存和作为数据中间件，通过定时任务(Spring)定时将数据写入MySQL数据库； \r\n3.	 使用Flex弹性布局开发客户端内H5评论页面；\r\n4.	 使用v-charts进行数据统计图表展示；\r\n5.	 使用zixing 后端生成base64返回前端进行二维码展示；\r\n6.	 优化单台服务器上万用户同时在线访问的速度。\r\n\r\n三、知识库系统（SpringBoot、MyBatisPlus、Vue全家桶） \r\n系统介绍：为了方便公司各部门间工作的协调和快速上手工作，开发了一个公司内部知识体系的知识库系统，通过有经验的人编写相关教程文档，以及平时的技术积累，供以后公司内部人员参考学习和使用。\r\n工作内容：使用vue-cli搭建前端单页面应用、内容编辑整合Markdown编辑器、使用Axios进行后台数据交互\r\n\r\n四、游戏资源管理系统（SpringBoot、MyBatisPlus、Vue） \r\n独立完成公司游戏资源管理系统后端及前端，实现文件储存判断上传至本地服务还是阿里云OSS对象储存', null, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556281490588&di=c0cd5b4280517144ef0e205daeb21921&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F22%2F20180422003021_jbusk.jpg', '2019-04-26 17:43:47', '2019-04-29 13:56:49', '2019-04-29 13:56:49');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `comment` varchar(500) NOT NULL COMMENT '评论内容',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `like` varchar(10) DEFAULT NULL COMMENT '点赞数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `tag_name` varchar(20) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `user_name` varchar(12) NOT NULL COMMENT '用户名',
  `user_email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `user_phone` char(11) DEFAULT NULL COMMENT '手机',
  `user_sex` tinyint(1) NOT NULL DEFAULT '1' COMMENT '性别【1.男2.女】',
  `user_address` varchar(255) DEFAULT NULL,
  `user_autograph` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('12', '627756022', '桑之落矣', 'y627756022@163.com', '1319220727', '1', '广东省深圳市宝安区', '君不见长江之水天上来');
