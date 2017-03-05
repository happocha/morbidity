package ru.potelov.dao;

import ru.potelov.model.Statistics;
import ru.potelov.model.Territory;

import java.util.List;

public interface IStatDao {

    List<Statistics> getRegionDiseasesStat(int territoryId, int month);

    List<Territory> getTerritories();

    List<Statistics> getStatistics(int territory);

}
