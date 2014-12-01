package com.prudnikova.onlinebanking.service;

import com.prudnikova.onlinebanking.model.Stat;
import java.util.List;

public interface StatService {

    void createStat(Stat stat);

    Stat readStat(int statId);

    void updateStat(Stat stat);

    void deleteStat(Stat stat);

    List getAllStats();
}
