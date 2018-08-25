package cn.attackme.busappointment.controller;

import cn.attackme.busappointment.model.Station;
import cn.attackme.busappointment.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
   private StationService stationService;

    /**
     * 根据id获取站点
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Station getStation(@PathVariable("id") Long id){
        Station station = stationService.getStationById(id);
        return station;
     }

    /**
     * 增加一个站点
     * @param station
     * @return
     */
     @RequestMapping(method = RequestMethod.POST)
     public ResponseEntity<Void> postStation(@RequestBody Station station){
        Boolean bool = stationService.postStation(station);
        if(bool){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
     }

    /**
     * 更新一个站点
     * @param station
     * @return
     */
     @RequestMapping(method = RequestMethod.PUT)
     public ResponseEntity<Void> putStation(@RequestBody Station station){
         Boolean bool = stationService.putStation(station);
         if(bool){
             return ResponseEntity.ok().build();
         }
         return ResponseEntity.badRequest().build();
     }
}
