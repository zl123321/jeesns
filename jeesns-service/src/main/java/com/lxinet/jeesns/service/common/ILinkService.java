package com.lxinet.jeesns.service.common;

import com.lxinet.jeesns.core.dto.ResultModel;
import com.lxinet.jeesns.core.model.Page;
import com.lxinet.jeesns.model.common.Link;

/**
 * Created by zchuanzhao on 2017-10-13.
 */
public interface ILinkService {
   
    ResultModel save(Link link);
   
    ResultModel listByPage(Page page);

    ResultModel allList();

    ResultModel recommentList();

    ResultModel update(Link link);

    ResultModel delete(Integer id);

    Link findById(Integer id);

    ResultModel enable(Integer id);
}
