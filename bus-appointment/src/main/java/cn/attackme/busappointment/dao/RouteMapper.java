package cn.attackme.busappointment.dao;

import cn.attackme.busappointment.model.Route;
import cn.attackme.busappointment.model.Routeext;

import java.util.List;
import java.util.Map;

public interface RouteMapper {
    Routeext getRouteById(Long id);

    int postRoute(Route route);

    int postStationList(Map<String,Object> stationsIds);

    int putRoute(Route route);

    int putStationList(Map<String, Object> stationsIds);

    List<Routeext> getRoutes();

    List<Routeext> getRoutesByDirection(Boolean direction);

    List<Routeext> anoGetRoutesByDirection(Boolean direction);

    List<Routeext> anoGetRoutes();
}
