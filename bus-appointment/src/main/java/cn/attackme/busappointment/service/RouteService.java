package cn.attackme.busappointment.service;

import cn.attackme.busappointment.dao.RouteMapper;
import cn.attackme.busappointment.model.Route;
import cn.attackme.busappointment.model.Routeext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RouteService {

    @Resource
    private RouteMapper routeMapper;

    public Routeext getRouteById(Long id) {
        Routeext routeextList = routeMapper.getRouteById(id);
        return routeextList;
    }

    public Boolean postRoute(Route route) {
        return routeMapper.postRoute(route) == 1;
    }

    public Boolean postStationList(Map<String,Object> stationsIds) {
        return routeMapper.postStationList(stationsIds) >= 1;
    }

    public Boolean putRoute(Route route) {
        return routeMapper.putRoute(route) == 1;
    }

    public Boolean putStationList(Map<String, Object> stationsIds) {
        return routeMapper.putStationList(stationsIds)>=1;
    }

    public List<Routeext> getRoutes() {
        return routeMapper.getRoutes();
    }

    public List<Routeext> getRoutesByDirection(Boolean direction) {
        return routeMapper.getRoutesByDirection(direction);
    }

    public PageInfo<Routeext> getRoutesByPage(int page, int size) {
        PageHelper.startPage(page, size);
        List<Routeext> routeextList = routeMapper.getRoutes();
        PageInfo<Routeext> pageInfo = new PageInfo<>(routeextList);
        return pageInfo;
    }

    public PageInfo<Routeext> getRoutesByPageAndDirection(Boolean direction,int page, int size) {
        PageHelper.startPage(page, size);
        List<Routeext> routeextList = routeMapper.getRoutesByDirection(direction);
        PageInfo<Routeext> pageInfo = new PageInfo<>(routeextList);
        return pageInfo;
    }


    public List<Routeext> anoGetRoutes() {
        return routeMapper.anoGetRoutes();
    }

    public List<Routeext> anoGetRoutesByDirection(Boolean direction) {
        return routeMapper.anoGetRoutesByDirection(direction);
    }
}
