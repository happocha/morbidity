package ru.potelov.dao;

import org.apache.deltaspike.core.api.config.ConfigProperty;
import ru.potelov.model.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Stateless
public class StatDaoImpl implements IStatDao {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigProperty(name = "territory.parentId")
    private Integer id;

    @Inject
    @ConfigProperty(name = "max.day")
    private Integer maxDay;

    public List<Statistics> getRegionDiseasesStat(int territoryId, int month) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Statistics> criteriaQuery = builder.createQuery(Statistics.class);
        Root<Statistics> root = criteriaQuery.from(Statistics.class);
        criteriaQuery.select(root)
                .where(
                        builder.and(
                                builder.between(root.get("statisticsPK").get("date"), month, month + maxDay),
                                builder.equal(root.join("hospital")
                                        .join("territory").get("parentId"), territoryId)
                        )
                );
        List<Statistics> statisticsList = em.createQuery(criteriaQuery).getResultList();
        return statisticsList;
    }

    public List<Territory> getTerritories() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Territory> criteriaQuery = builder.createQuery(Territory.class);
        Root<Territory> root = criteriaQuery.from(Territory.class);
        criteriaQuery.select(root).where(builder.equal(root.get("parentId"), id));
        List<Territory> territoryList = em.createQuery(criteriaQuery).getResultList();
        return territoryList;
    }

    public List<Statistics> getStatistics(int territory) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Statistics> criteriaQuery = builder.createQuery(Statistics.class);
        Root<Statistics> root = criteriaQuery.from(Statistics.class);
        root.fetch("disease");
        root.fetch("hospital");
        criteriaQuery.select(root)
                .where(builder.equal(root.join("hospital")
                        .join("territory").get("parentId"), territory))
                .orderBy(builder.desc(root.get("statisticsPK").get("date")));
        List<Statistics> statisticsList = em.createQuery(criteriaQuery).getResultList();
        return statisticsList;
    }
}