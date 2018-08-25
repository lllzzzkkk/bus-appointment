package cn.attackme.busappointment.controller;

import cn.attackme.busappointment.model.Route;
import cn.attackme.busappointment.model.Routeext;
import cn.attackme.busappointment.model.Station;
import cn.attackme.busappointment.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    /**
     * 根据id查询线路
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Routeext getRouteById(@PathVariable("id") Long id){
        Routeext routeext = routeService.getRouteById(id);
        return routeext;
    }

    /**
     * 增加一条线路
     * @param routeext
     * @return
     */
    @PostMapping()
    public ResponseEntity<Void> postRoute(@RequestBody Routeext routeext){
        Route route = new Route();
        route.setDirection(routeext.getDirection());
        route.setDisabled(routeext.getDisabled());
        route.setName(routeext.getName());
        Boolean bool = routeService.postRoute(route);
        List<Station> stations = routeext.getStationList();
        Map<String,Object> stationsIds = new HashMap<>();
        stationsIds.put("routeId",route.getId());
        stationsIds.put("stationsIds",stations);
        Boolean bool2 = routeService.postStationList(stationsIds);
        if(bool && bool2){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * 更新线路
     * @param routeext
     * @return
     */
    @PutMapping()
    public ResponseEntity<Void> putRoute(@RequestBody Routeext routeext){
        Route route = new Route();
        route.setDirection(routeext.getDirection());
        route.setDisabled(routeext.getDisabled());
        route.setName(routeext.getName());
        route.setId(routeext.getId());
        Boolean bool = routeService.putRoute(route);
        List<Station> stations = routeext.getStationList();
        Map<String,Object> stationsIds = new HashMap<>();
        stationsIds.put("routeId",route.getId());
        stationsIds.put("stationIds",stations);
        Boolean bool2 = routeService.putStationList(stationsIds);
        if(bool && bool2){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
