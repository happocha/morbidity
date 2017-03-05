package ru.potelov.service;

import ru.potelov.dto.StatisticsDTO;

import java.util.List;

public interface IStatService {

    List<StatisticsDTO> getRegionDiseasesStats(Integer territoryId, Integer month);

}
