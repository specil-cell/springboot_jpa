package com.cy.DrawingpaperRepository;

import com.cy.DP;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

/*JpaRepository<T,ID>
 -T:表示操作的实体类是谁（在实体类上配置了和表的映射关系)
 -ID：表示操作的实体类中对应那个主键的数据类型，和实体类的@ID属性修饰的数据类型一致
 */
public interface DrawingpaperRepository extends JpaRepository <DP,Integer>{
    @Query(value = "select * from drawingpaper where id= ?1",nativeQuery = true)
    //@Query表示增删改查操作的注解，nativeQuery参数表示开启原生SQL语句语法规则
    List <DrawingpaperRepository>getDPPage(Integer id, Pageable pageable);
    @Transactional
    @Modifying  //删除和修改操作必须添加此注解
    @Query("update drawingpaper d set d.name=?1 where d.id=?2")
    int updataDP(String color,Integer id);

    @Transactional
    @Modifying
    @Query("delete drawingpaper d where d.id=?1")
    int deleteDP(Integer id);



}
