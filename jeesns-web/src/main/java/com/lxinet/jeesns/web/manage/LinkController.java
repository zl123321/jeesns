package com.lxinet.jeesns.web.manage;

import com.lxinet.jeesns.core.annotation.Before;
import com.lxinet.jeesns.core.dto.ResultModel;
import com.lxinet.jeesns.core.model.Page;
import com.lxinet.jeesns.interceptor.AdminLoginInterceptor;
import com.lxinet.jeesns.model.common.Link;
import com.lxinet.jeesns.service.common.ILinkService;
import com.lxinet.jeesns.web.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by zchuanzhao on 2017/10/13.
 */
@Controller
@RequestMapping("/${managePath}/link")
@Before(AdminLoginInterceptor.class)
public class LinkController extends BaseController{
    private static final String MANAGE_FTL_PATH = "/manage/link/";
    @Resource
    private ILinkService linkService;

    @RequestMapping("/list")
    public String list(Model model){
        Page page = new Page(request);
        ResultModel resultModel = linkService.listByPage(page);
        model.addAttribute("model", resultModel);
        return MANAGE_FTL_PATH + "list";
    }

    @RequestMapping("/add")
    public String add(){
        return MANAGE_FTL_PATH + "add";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(Link link){
        ResultModel resultModel = linkService.save(link);
        if(resultModel.getCode() == 0){
            resultModel.setCode(3);
        }
        return resultModel;
    }


    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Link link = linkService.findById(id);
        model.addAttribute("link",link);
        return MANAGE_FTL_PATH + "edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object update(Link link){
        if (link == null){
            return new ResultModel(-1,"参数错误");
        }
        ResultModel resultModel = linkService.update(link);
        if(resultModel.getCode() == 0){
            resultModel.setCode(3);
        }
        return resultModel;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Object delete(@PathVariable("id") Integer id){
        return linkService.delete(id);
    }

    @RequestMapping("/enable/{id}")
    @ResponseBody
    public Object enable(@PathVariable("id") Integer id){
        return linkService.enable(id);
    }


}
