package com.sample.springboothelloSubway.service;

import com.sample.springboothelloSubway.dao.SubwayDao;
import com.sample.springboothelloSubway.domain.Subway;
import com.sample.springboothelloSubway.parser.ReadLineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SubwayService {

    private final ReadLineContext<Subway> subwayReadLineContext;

    private final SubwayDao subwayDao;

    public SubwayService(ReadLineContext<Subway>subwayReadLineContext, SubwayDao subwayDao) {
        this.subwayReadLineContext = subwayReadLineContext;
        this.subwayDao = subwayDao;
    }

    @Transactional
    public int insertSubwayData(String filename) {
        List<Subway> subwayList;
        try {
        	subwayList = subwayReadLineContext.readByLine(filename);
            System.out.println("파싱이 끝났습니다.");
            subwayList.stream()
                    .parallel()
                    .forEach(subway -> {
                        try {
                            this.subwayDao.add(subway); // db에 insert하는 구간
                        } catch (Exception e) {
                            System.out.printf("id:%d 레코드에 문제가 있습니다.\n",subway.getUSE_DT());
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!Optional.of(subwayList).isEmpty()) {
            return subwayList.size();
        } else {
            return 0;
        }
    }
}
