package cn.attackme.busappointment.controller;

import cn.attackme.busappointment.model.Station;
import cn.attackme.busappointment.service.StationService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationsController {

    @Autowired
    private StationService stationService;


//    @GetMapping()
//    public List<Station> getStations(@RequestParam(value = "area",required = false) Boolean area){
//        if(area == null){   //等于和equals的区别，为什么这里==可以，。equals不可以。
//            List<Station> stationList  = stationService.getStations();
//            return stationList;
//        }else{
//            List<Station> stationList = stationService.getStationsByArea(area);
//            return stationList;
//        }
//    }

    @GetMapping()
    public List<Station> getStations(@RequestParam(value = "area",required = false) Boolean area,
                                     @RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                     @RequestParam(value = "size",required = false,defaultValue = "2")int size){
        if(area == null){   //等于和equals的区别，为什么这里==可以，。equals不可以。
            PageInfo<Station> stationList  = stationService.getStationsByPage(page,size);
            return stationList.getList();
        }else {
            List<Station> stationList = stationService.getStationsByAreaAndPage(area,page,size);
            return stationList;
        }
    }
}
