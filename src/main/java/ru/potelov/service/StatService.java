package ru.potelov.service;

import ru.potelov.dao.IStatDao;
import ru.potelov.dto.StatisticsDTO;
import ru.potelov.model.Statistics;
import ru.potelov.model.Territory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Stateless
public class StatService implements IStatService {

    @Inject
    private IStatDao iStatDao;

    public List<StatisticsDTO> getRegionDiseasesStats(Integer territoryId, Integer month) {

        if (territoryId == null) {
            territoryId = getDefaultTerritoryId();
            if (territoryId == null) {
                return Collections.emptyList();
            }
        }

        month = getDefaultMonth(territoryId, month);
        if (month == null) {
            return Collections.emptyList();
        }

        List<Statistics> statisticsList = iStatDao.getRegionDiseasesStat(territoryId, month);
        List<StatisticsDTO> statisticsDTOList = new ArrayList<>();

        for (Statistics list : statisticsList) {
            StatisticsDTO statisticsDTO = new StatisticsDTO();
            statisticsDTO.setTerritory(list.getHospital().getTerritory().getName());
            statisticsDTO.setHospital(list.getHospital().getName());
            statisticsDTO.setDisease(list.getDisease().getName());
            statisticsDTO.setPatients(list.getPatients());
            statisticsDTO.setIssued(list.getIssued());
            statisticsDTOList.add(statisticsDTO);
        }

        return statisticsDTOList;

    }

    private Integer getDefaultTerritoryId() {

        List<Territory> listTer = iStatDao.getTerritories();

        if (listTer.isEmpty()) {
            return null;
        }

        Collections.sort(listTer, new Comparator<Territory>() {
            @Override
            public int compare(Territory o1, Territory o2) {
                return o1.getName().trim().toLowerCase().compareTo(o2.getName().trim().toLowerCase());
            }
        });

        //listTer.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));   //Если использовать java 8

        int id = listTer.get(0).getId();
        return id;

    }

    private Integer getDefaultMonth(Integer territory, Integer month) {

        List<Statistics> listStat = iStatDao.getStatistics(territory);

        if (listStat.isEmpty()) {
            return null;
        }

        int date = listStat.get(0).getStatisticsPK().getDate();

        int year = (date / 10000);
        int tmpMonth = (date / 100) % 100;
        int modifMonth = month != null ? year * 10000 + (month * 100) : year * 10000 + (tmpMonth * 100);

        return modifMonth;

    }
}