package cn.attackme.busappointment.service;

import cn.attackme.busappointment.dao.StationMapper;
import cn.attackme.busappointment.model.Station;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StationService {

    @Resource
    private StationMapper stationMapper;

    public Station getStationById(Long id) {
        return stationMapper.selectStationById(id);
    }

    public Boolean postStation(Station station) {
        return stationMapper.postStation(station)==1;
    }

    public Boolean putStation(Station station) {
        return stationMapper.putStation(station) == 1;
    }

    public List<Station> getStations() {
        return stationMapper.getStations();
    }

    public List<Station> getStationsByArea(Boolean area) {
        return stationMapper.getStationsByArea(area);
    }

    public PageInfo<Station> getStationsByPage(int page, int size) {
        PageHelper.startPage(page, size);
        List<Station> stationList = stationMapper.getStations();
        PageInfo<Station> pageInfo = new PageInfo<>(stationList);
        return pageInfo;
    }

    public List<Station> getStationsByAreaAndPage(Boolean area, int page, int size) {
        PageHelper.startPage(page,size);
        List<Station> stationList = stationMapper.getStationsByArea(area);
        PageInfo<Station> pageInfo = new PageInfo<>(stationList);
        return pageInfo.getList();
    }
}
