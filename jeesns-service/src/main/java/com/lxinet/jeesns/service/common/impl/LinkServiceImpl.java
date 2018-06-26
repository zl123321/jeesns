package com.lxinet.jeesns.service.common.impl;

import com.lxinet.jeesns.core.dto.ResultModel;
import com.lxinet.jeesns.core.model.Page;
import com.lxinet.jeesns.dao.common.ILinkDao;
import com.lxinet.jeesns.model.common.Link;
import com.lxinet.jeesns.service.common.ILinkService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zchuanzhao on 2017-10-13.
 */
@Service("linkService")
public class LinkServiceImpl implements ILinkService {
    @Resource
    private ILinkDao linkDao;

    @Override
    public ResultModel save(Link link) {
        if (linkDao.save(link) == 1) {
            return new ResultModel(0, "保存成功");
        }
        return new ResultModel(-1, "保存失败");
    }

    @Override
    public ResultModel listByPage(Page page) {
        List<Link> list = linkDao.listByPage(page);
        ResultModel model = new ResultModel(0, page);
        model.setData(list);
        return model;
    }

    @Override
    public ResultModel allList() {
        List<Link> list = linkDao.allList();
        ResultModel model = new ResultModel(0);
        model.setData(list);
        return model;
    }

    @Override
    public ResultModel recommentList() {
        List<Link> list = linkDao.recommentList();
        ResultModel model = new ResultModel(0);
        model.setData(list);
        return model;
    }

    @Override
    public ResultModel update(Link link) {
        Link findLink = this.findById(link.getId());
        if (findLink == null){
            return new ResultModel(-1, "友情链接不存在");
        }
        if (linkDao.update(link) > 0) {
            return new ResultModel(0, "更新成功");
        }
        return new ResultModel(-1, "更新失败");
    }

    @Override
    public ResultModel delete(Integer id) {
        if (linkDao.delete(id) > 0) {
            return new ResultModel(1, "删除成功");
        }
        return new ResultModel(-1, "删除失败");
    }

    @Override
    public Link findById(Integer id) {
        return linkDao.findById(id);
    }

    @Override
    public ResultModel enable(Integer id) {
        if (linkDao.enable(id) == 1){
            return new ResultModel(1, "操作成功");
        }
        return new ResultModel(-1, "操作失败");
    }
}
