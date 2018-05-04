package com.warframe.tmall.sso.service.impl;


import com.google.gson.Gson;
import com.warframe.tmall.common.exception.TmallException;
import com.warframe.tmall.common.jedis.JedisClient;
import com.warframe.tmall.common.utils.QiniuUtil;
import com.warframe.tmall.domain.dto.front.Member;
import com.warframe.tmall.domain.pojo.TbMember;
import com.warframe.tmall.repository.TbMemberMapper;
import com.warframe.tmall.sso.service.LoginService;
import com.warframe.tmall.sso.service.FrontMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FrontMemberServiceImpl implements FrontMemberService {

    @Autowired
    private LoginService loginService;
    @Autowired
    private TbMemberMapper tbMemberMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public String imageUpload(Long userId, String token, String imgData) {

        //过滤data:URL
        String base64 = QiniuUtil.base64Data(imgData);
        String imgPath = QiniuUtil.qiniuBase64Upload(base64);

        TbMember tbMember = tbMemberMapper.selectByPrimaryKey(userId);
        if (tbMember == null) {
            throw new TmallException("通过id获取用户失败");
        }
        tbMember.setFile(imgPath);
        if (tbMemberMapper.updateByPrimaryKey(tbMember) != 1) {
            throw new TmallException("更新用户头像失败");
        }

        //更新缓存
        Member member = loginService.getUserByToken(token);
        member.setFile(imgPath);
        jedisClient.set("SESSION:" + token, new Gson().toJson(member));
        return imgPath;
    }
}
