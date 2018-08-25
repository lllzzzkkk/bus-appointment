package cn.attackme.busappointment.controller;

import cn.attackme.busappointment.model.Routeext;
import cn.attackme.busappointment.service.RouteService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routes")
public class RoutesController {

    @Autowired
    private RouteService routeService;

//    @GetMapping()
//    public List<Routeext> getRoutes(@RequestParam(value = "direction",required = false) Boolean direction){
//        if(direction == null){
//            List<Routeext> routeextList = routeService.anoGetRoutes();
//            return routeextList;
//        }
//        else{
//            List<Routeext> routeextList = routeService.anoGetRoutesByDirection(direction);
//            return routeextList;
//        }
//    }

    @GetMapping()
    public PageInfo<Routeext> getRoutes(@RequestParam(value = "direction",required = false) Boolean direction,
                                        @RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                        @RequestParam(value = "size",required = false,defaultValue = "2")int size){
        if(direction == null){
            PageInfo<Routeext> routeextList = routeService.getRoutesByPage(page,size);
            return routeextList;
        }
        else{
            PageInfo<Routeext> routeextList = routeService.getRoutesByPageAndDirection(direction,page,size);
            return routeextList;
        }
    }
}
