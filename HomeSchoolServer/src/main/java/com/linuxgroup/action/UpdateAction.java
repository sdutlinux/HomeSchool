package com.linuxgroup.action;

import com.linuxgroup.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tan on 14-9-26.
 */
@Controller
@RequestMapping("/update")
public class UpdateAction {

    @Autowired
    private UpdateService updateService;

    /**
     * 获得最新版本号
     * @return 版本号
     */
    @RequestMapping(value = "/latestVersion", method = RequestMethod.GET)
    public @ResponseBody Integer getLatestVersonCode() {
        return updateService.getLatestVersonCode();
    }


    @RequestMapping(value = "/downloadPath", method = RequestMethod.GET)
    public @ResponseBody String getDownloadPath() {
        return updateService.getDownloadPath();
    }

    // set and get methods


    public UpdateService getUpdateService() {
        return updateService;
    }

    public void setUpdateService(UpdateService updateService) {
        this.updateService = updateService;
    }
}
