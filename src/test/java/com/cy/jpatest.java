package com.cy;

import com.cy.DrawingpaperRepository.DrawingpaperRepository;
import org.hibernate.engine.transaction.jta.platform.internal.SunOneJtaPlatform;
import org.hibernate.sql.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.net.SocketOption;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class jpatest {
    @Autowired
    private DrawingpaperRepository repository;
    @Test
    public void getDPPage(){
        PageRequest pageable = PageRequest.of(0,3);
        List<DrawingpaperRepository> DPList=repository.getDPPage(1, (Pageable) pageable);
        System.out.println(DPList);

    }
    @Test
    public void UpdateDP(){
        int row = repository.updataDP("阿尔法抽纸", 4);
        System.out.println(row);

    }
    @Test
    public void deleteDP(){
        int row = repository.deleteDP(2);
        System.out.println(row);
    }
    @Test
    public void save(){
        DP dp = new DP();
        dp.setId(2);
        dp.setName("西格玛抽纸");
        dp.setPrice(3.5);
        dp.setColor("灰色");
        repository.save(dp);
    }
    @Test
    public void findById(){
        Optional<DP> dp = repository.findById(4);
        System.out.println(dp.get());
    }

}
