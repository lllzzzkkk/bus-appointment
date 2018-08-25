package cn.attackme.busappointment.dao;

import cn.attackme.busappointment.model.Station;

import java.util.List;

public interface StationMapper {
    Station selectStationById(Long id);


    int postStation(Station station);

    int putStation(Station station);

    List<Station> getStations();

    List<Station> getStationsByArea(Boolean area);
}
