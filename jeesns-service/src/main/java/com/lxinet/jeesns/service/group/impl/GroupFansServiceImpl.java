package com.lxinet.jeesns.service.group.impl;

import com.lxinet.jeesns.core.dto.ResultModel;
import com.lxinet.jeesns.core.model.Page;
import com.lxinet.jeesns.model.group.Group;
import com.lxinet.jeesns.model.group.GroupFans;
import com.lxinet.jeesns.model.member.Member;
import com.lxinet.jeesns.service.group.IGroupFansService;
import com.lxinet.jeesns.dao.group.IGroupFansDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zchuanzhao on 2016/12/26.
 */
@Service("groupFansService")
public class GroupFansServiceImpl implements IGroupFansService {
    @Resource
    private IGroupFansDao groupFansDao;

    @Override
    public ResultModel listByPage(Page page, Integer groupId) {
        List<GroupFans> list = groupFansDao.listByPage(page, groupId);
        ResultModel model = new ResultModel(0,page);
        model.setData(list);
        return model;
    }

    @Override
    public GroupFans findByMemberAndGroup(@Param("groupId") Integer groupId, @Param("memberId") Integer memberId) {
        return groupFansDao.findByMemberAndGroup(groupId,memberId);
    }

    /**
     * 关注
     * @param loginMember
     * @param groupId
     * @return
     */
    @Override
    public ResultModel save(Member loginMember, Integer groupId) {
        if(groupFansDao.findByMemberAndGroup(groupId,loginMember.getId()) == null){
            if(groupFansDao.save(groupId,loginMember.getId()) == 1){
                return new ResultModel(1,"关注成功");
            }
        }else {
            //已经关注了
            return new ResultModel(0,"关注成功");
        }
        return new ResultModel(-1,"关注失败");
    }

    /**
     * 取消关注
     * @param loginMember
     * @param groupId
     * @return
     */
    @Override
    public ResultModel delete(Member loginMember, Integer groupId) {
        if(groupFansDao.delete(groupId,loginMember.getId()) > 0){
            return new ResultModel(1,"取消关注成功");
        }
        return new ResultModel(-1,"取消关注失败");
    }


    @Override
    public ResultModel listByMember(Page page, Integer memberId) {
        List<Group> list = groupFansDao.listByMember(page, memberId);
        ResultModel model = new ResultModel(0,page);
        model.setData(list);
        return model;
    }

}
